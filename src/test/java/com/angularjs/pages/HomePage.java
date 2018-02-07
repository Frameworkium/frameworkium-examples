package com.angularjs.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class HomePage extends BasePage<HomePage> {

    @Name("Develop navigation bar item")
    @Visible
    @FindBy(xpath = "//a[text()='Develop']")
    private WebElement developDropdown;

    @Name("Developer Guide menu item")
    @FindBy(xpath = "//a[text()='Developer Guide']")
    private WebElement developerGuideMenuItem;

    @Step("Open home page")
    public static HomePage open() {
        return PageFactory.newInstance(HomePage.class, "https://angularjs.org/");
    }

    @Step("Click developer guide drop down menu")
    public HomePage clickDevelopMenu() {
        developDropdown.click();
        return this;
    }

    @Step("Click developer guide link")
    public DeveloperGuidePage clickDeveloperGuideLink() {
        developerGuideMenuItem.click();
        return PageFactory.newInstance(DeveloperGuidePage.class);
    }

}
