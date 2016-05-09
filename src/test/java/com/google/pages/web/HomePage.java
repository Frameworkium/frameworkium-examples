package com.google.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;

import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import com.frameworkium.core.ui.annotations.Visible;

public class HomePage extends BasePage<HomePage> {

    @Name("Search Input Box")
    @Visible
    @FindBy(css = "input#lst-ib")
    private WebElement searchInputBox;
    
    @Name("Search Button")
    //This is not initially visible
    @FindBy(css = "button[value='Search']")
    private WebElement runSearchButton;

    @Step("Navigate to the homepage")
    public static HomePage open() {
        return PageFactory.newInstance(HomePage.class, "http://www.google.com");
    }

    @Step("Search for '{0}'")
    public ResultsPage runSearch(String searchTerms) {
        searchInputBox.sendKeys(searchTerms);
        runSearchButton.click();
        return PageFactory.newInstance(ResultsPage.class);
    }
}
