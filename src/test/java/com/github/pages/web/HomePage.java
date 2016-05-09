package com.github.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;

import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import com.frameworkium.core.ui.annotations.Visible;
import com.github.pages.web.components.HeaderComponent;

public class HomePage extends BasePage<HomePage> {

    @Name("Header")
    @Visible
    private HeaderComponent header;

    @Name("Marketing Sign-Up Banner")
    @Visible
    @FindBy(css = "div.homepage-hero-intro")
    private WebElement homepageHeroIntro;

    @Step("Navigate to the Github homepage")
    public static HomePage open() {
        return PageFactory.newInstance(HomePage.class, "https://github.com");
    }

    public HeaderComponent theHeader() {
        return header;
    }
}
