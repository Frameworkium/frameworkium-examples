package com.angularjs.pages.web;

import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.annotations.Visible;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class DeveloperGuidePage extends BasePage<DeveloperGuidePage> {

    @Name("Developer guide search")
    @Visible
    @FindBy(css = "input[name='as_q']")
    private WebElement searchField;

    @Name("Bootstrap search item")
    @FindBy(linkText = "Bootstrap")
    private WebElement bootstrapSearchItem;

    @Name("Guide article title")
    @FindBy(css = "h1")
    private WebElement guideTitle;

    public DeveloperGuidePage searchDeveloperGuide(String inputText) {
        searchField.sendKeys(inputText);
        return this;
    }

    public void clickBootstrapSearchItem() {
        bootstrapSearchItem.click();
        waitForAngularRequestsToFinish();
    }

    public String getGuideTitle() {
        return guideTitle.getText();
    }

}