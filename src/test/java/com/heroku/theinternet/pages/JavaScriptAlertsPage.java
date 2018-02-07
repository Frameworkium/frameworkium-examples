package com.heroku.theinternet.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class JavaScriptAlertsPage extends BasePage<JavaScriptAlertsPage> {

    @Visible
    @Name("JS Alert button")
    @FindBy(css = "button[onclick='jsAlert()']")
    private Button jsAlertButton;

    @Visible
    @Name("JS Confirm button")
    @FindBy(css = "button[onclick='jsConfirm()']")
    private Button jsConfirmButton;

    @Visible
    @Name("JS Prompt button")
    @FindBy(css = "button[onclick='jsPrompt()']")
    private Button jsPromptButton;

    @Name("Result area")
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
