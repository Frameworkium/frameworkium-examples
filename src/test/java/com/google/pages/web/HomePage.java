package com.google.pages.web;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class HomePage extends BasePage<HomePage> {

    @Visible
    @Name("Search Input Box")
    @FindBy(name = "q")
    private WebElement searchInputBox;

    @Name("Search Button")
    //This is not initially visible
    @FindBy(css = "button[value='Search']")
    private WebElement runSearchButton;

    @Step("Navigate to the homepage")
    public static HomePage open() {
        return PageFactory.newInstance(HomePage.class, "http://www.google.com");
    }

    @Step("Search for \"{0}\"")
    public HomePage setSearchBarText(String searchTerms) {
        searchInputBox.sendKeys(searchTerms);
        return this;
    }

    @Step("Click on search bar")
    public HomePage clickSearchBar() {
        searchInputBox.click();
        return this;
    }

    @Step("Click enter")
    public ResultsPage clickEnter() {
        searchInputBox.sendKeys("\n");
        return PageFactory.newInstance(ResultsPage.class);
    }

}
