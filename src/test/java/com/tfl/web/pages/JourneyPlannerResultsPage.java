package com.tfl.web.pages;

import com.frameworkium.pages.internal.BasePage;
import com.frameworkium.pages.internal.Visible;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class JourneyPlannerResultsPage extends BasePage<JourneyPlannerResultsPage> {

    @Name("Page Title Area")
    @Visible
    @FindBy(css = "h1 span.hero-headline")
    private WebElement pageTitleArea;

    public String getTitleText() {

        return pageTitleArea.getText();
    }

}
