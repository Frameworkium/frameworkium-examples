package tfl.web.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JourneyPlannerResultsPage extends BasePage<JourneyPlannerResultsPage> {

    @Visible
    @FindBy(css = ".journey-planner-results")
    private WebElement resultsViewport;

    @Visible
    @FindBy(css = "h1 span.hero-headline")
    private WebElement pageTitleArea;

    public String getTitleText() {

        return pageTitleArea.getText();
    }

}
