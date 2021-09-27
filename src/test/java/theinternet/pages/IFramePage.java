package theinternet.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class IFramePage extends BasePage<IFramePage> {

    @Visible
    @FindBy(css = "iframe#mce_0_ifr")
    private WebElement wysiwygIFrame;

    @Visible
    @FindBy(css = "button[aria-label='Bold']")
    private WebElement boldButton;

    // This is within the iframe so while it'll be physically visible when the
    // page loads, it WILL NOT be 'visible' to the driver (i.e. selenium will
    // not be able to 'see' it) until we switchTo it - see below
    @FindBy(id = "tinymce")
    private WebElement wysiwygTextBox;

    @Step("Clear text in editor")
    public void clearTextInEditor() {

        performActionInIFrame(() ->
                wysiwygTextBox.clear());
    }

    @Step("Enter text in editor")
    public void enterTextInEditor(String text) {

        performActionInIFrame(() ->
                wysiwygTextBox.sendKeys(text));
    }

    @Step("Get editor text")
    public String getTextInEditor() {

        switchToIFrame();

        // Perform actions within the iframe
        String text = wysiwygTextBox.getText();

        switchBackToMainPage();
        return text;
    }

    @Step("Enter Bold Text: \"{0}\"")
    public void enterBoldTextInEditor(String text) {

        // Click bold button (As it's NOT in the iframe)
        boldButton.click();

        performActionInIFrame(() -> wysiwygTextBox.sendKeys(text));

        // Unclick bold button (still not in the iframe!)
        boldButton.click();
    }

    private void performActionInIFrame(Runnable r) {

        switchToIFrame();

        // Perform actions within the iframe
        r.run();

        switchBackToMainPage();
    }

    private void switchToIFrame() {
        // Switch driver context to the iframe
        driver.switchTo().frame(wysiwygIFrame);
    }

    private void switchBackToMainPage() {
        // Switch back to the main page
        driver.switchTo().parentFrame();
    }

}
