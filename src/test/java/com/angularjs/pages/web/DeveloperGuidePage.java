package com.angularjs.pages.web;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.Arrays;

public class DeveloperGuidePage extends BasePage<DeveloperGuidePage> {

    @Name("Developer guide search")
    @Visible
    @FindBy(css = "input[name='as_q']")
    private TextInput searchField;

    @Name("Bootstrap search item")
    @FindBy(linkText = "Bootstrap")
    private Link bootstrapSearchItem;

    @Name("Guide article title")
    @FindBy(css = ".main-grid h1")
    private WebElement guideTitle;

    @Name("Loading")
    @FindBy(id= "loading")
    private WebElement loading;

    public DeveloperGuidePage searchDeveloperGuide(String inputText) {
        searchField.sendKeys(inputText);
        return this;
    }

    public DeveloperGuidePage clickBootstrapSearchItem() {
        bootstrapSearchItem.click();
        waitForJavascriptFrameworkToFinish();
        wait.until(ExpectedConditions.invisibilityOfAllElements(Arrays.asList(loading)));
        return this;
    }

    public String getGuideTitle(String expectedText) {
        // required to ensure test is more robust i.e. this can't return ""
        wait.until(ExpectedConditions.textToBePresentInElement(guideTitle, expectedText));
        return guideTitle.getText();
    }

}
