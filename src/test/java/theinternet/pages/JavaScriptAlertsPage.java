package theinternet.pages;

import com.frameworkium.core.htmlelements.element.Button;
import com.frameworkium.core.htmlelements.element.TextBlock;
import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class JavaScriptAlertsPage extends BasePage<JavaScriptAlertsPage> {

    @Visible
    @FindBy(css = "button[onclick='jsAlert()']")
    private Button jsAlertButton;

    @Visible
    @FindBy(css = "button[onclick='jsConfirm()']")
    private Button jsConfirmButton;

    @Visible
    @FindBy(css = "button[onclick='jsPrompt()']")
    private Button jsPromptButton;

    @FindBy(css = "p#result")
    private TextBlock resultArea;

    @Step("Click alert")
    public JavaScriptAlertsPage clickAlertButtonAndAccept() {
        jsAlertButton.click();

        driver.switchTo().alert().accept();

        wait.until(visibilityOf(resultArea));

        return this;
    }

    @Step("Click alert")
    public JavaScriptAlertsPage clickAlertButtonAndDismiss() {
        jsAlertButton.click();

        driver.switchTo().alert().dismiss();

        wait.until(visibilityOf(resultArea));

        return this;
    }

    @Step("Click confirm and confirm")
    public JavaScriptAlertsPage clickConfirmButtonAndAccept() {
        jsConfirmButton.click();

        driver.switchTo().alert().accept();

        wait.until(visibilityOf(resultArea));

        return this;
    }

    @Step("Click confirm and dismiss")
    public JavaScriptAlertsPage clickConfirmButtonAndDismiss() {
        jsConfirmButton.click();

        driver.switchTo().alert().dismiss();

        wait.until(visibilityOf(resultArea));

        return this;
    }

    @Step("Click prompt")
    public JavaScriptAlertsPage clickPromptButtonAndEnterPrompt(String textToEnter) {
        jsPromptButton.click();

        driver.switchTo().alert().sendKeys(textToEnter);
        driver.switchTo().alert().accept();

        return this;
    }

    @Step("Click prompt")
    public String getResultText() {
        return resultArea.getText();
    }
}
