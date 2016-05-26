package com.heroku.theinternet.pages.web;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class FormAuthenticationSuccessPage extends BasePage<FormAuthenticationSuccessPage> {

    @Visible
    @Name("Logout button")
    @FindBy(css = "a[href='/logout']")
    private WebElement logoutButton;

    @Step("Log out")
    public void logout() {
        logoutButton.click();
    }

}
