package com.heroku.theinternet.pages.web;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;

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
