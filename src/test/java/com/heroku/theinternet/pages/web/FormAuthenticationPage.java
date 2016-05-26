package com.heroku.theinternet.pages.web;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class FormAuthenticationPage extends BasePage<FormAuthenticationPage> {

    @Visible
    @Name("Username field")
    @FindBy(css = "input#username")
    private TextInput usernameField;

    @Visible
    @Name("Password field")
    @FindBy(css = "input#password")
    private TextInput passwordField;

    @Visible
    @Name("Login button")
    @FindBy(xpath = "//button[contains(.,'Login')]")
    private WebElement loginButton;

    @Step("Log in - {0}/{1}")
    public <T extends BasePage<T>> T login(
            String username, String password, Class<T> classOfExpectedPageObject) {

        usernameField.clear();
        usernameField.sendKeys(username);

        passwordField.clear();
        passwordField.sendKeys(password);

        loginButton.click();
        return PageFactory.newInstance(classOfExpectedPageObject);
    }

}
