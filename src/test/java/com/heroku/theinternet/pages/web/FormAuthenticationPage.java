package com.heroku.theinternet.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;

import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import com.frameworkium.core.ui.annotations.Visible;

public class FormAuthenticationPage extends BasePage<FormAuthenticationPage> {

    @Visible
    @Name("Username field")
    @FindBy(css = "input#username")
    private WebElement usernameField;

    @Visible
    @Name("Password field")
    @FindBy(css = "input#password")
    private WebElement passwordField;

    @Visible
    @Name("Login button")
    @FindBy(xpath = "//button[contains(.,'Login')]")
    private WebElement loginButton;

    @Step("Log in - {0}/{1}")
    public <T extends BasePage<T>> T login(String username, String password, Class<T> pageObjectClass) {

        usernameField.clear();
        usernameField.sendKeys(username);

        passwordField.clear();
        passwordField.sendKeys(password);

        loginButton.click();
        return PageFactory.newInstance(pageObjectClass);
    }


}
