package theinternet.pages;

import com.frameworkium.core.htmlelements.annotations.Timeout;
import com.frameworkium.core.htmlelements.element.Button;
import com.frameworkium.core.htmlelements.element.TextBlock;
import com.frameworkium.core.ui.annotations.Invisible;
import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;


import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class DynamicLoadingExamplePage extends BasePage<DynamicLoadingExamplePage> {

    @Visible
    @FindBy(css = "#start button")
    private Button startButton;

    @Invisible  // make sure it's not there
    @Timeout(0) // used to speed up the wait for Invisible TypifiedElements
    @FindBy(id = "finish")
    private TextBlock dynamicElement;

    @Step("Click Start")
    public DynamicLoadingExamplePage clickStart() {
        startButton.click();
        wait.until(visibilityOf(dynamicElement.getWrappedElement()));
        return this;
    }

    @Step("Wait for the hidden element to be displayed")
    public DynamicLoadingExamplePage waitForElementToBeDisplayed() {
        wait.until(visibilityOf(dynamicElement.getWrappedElement()));
        return this;
    }

    public boolean isElementDisplayed() {
        return dynamicElement.isDisplayed();
    }

    public boolean isElementPresent() {
        try {
            return dynamicElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
