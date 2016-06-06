package com.tfl.web.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class JourneyPlannerResultsPage extends BasePage<JourneyPlannerResultsPage> {

    @Visible
    @Name("Page Title Area")
    @FindBy(css = "h1 span.hero-headline")
    private WebElement pageTitleArea;

    public String getTitleText() {

        return pageTitleArea.getText();
    }

}
