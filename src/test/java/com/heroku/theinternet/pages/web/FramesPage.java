package com.heroku.theinternet.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;

import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import com.frameworkium.core.ui.annotations.Visible;

public class FramesPage extends BasePage<FramesPage> {

    @Visible
    @Name("iFrame Link")
    @FindBy(linkText = "iFrame")
    private WebElement iFrameLink;

    
    @Step("Click iFrame link")
    public IFramePage clickIFrameLink() {
        iFrameLink.click();
        return PageFactory.newInstance(IFramePage.class);
    }

}
