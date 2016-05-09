package com.heroku.theinternet.pages.web;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;

import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import com.frameworkium.core.ui.annotations.Visible;

public class JQueryUIPage extends BasePage<JQueryUIPage> {

    @Visible
    @Name("Menu link")
    @FindBy(linkText = "Menu")
    private Link menuLink;

    @Step("Click menu")
    public JQueryUIMenuPage clickMenuLink() {
        menuLink.click();

        return PageFactory.newInstance(JQueryUIMenuPage.class);
    }
}
