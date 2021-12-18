package tfl.web.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage<HomePage> {

    @Visible
    @FindBy(css = "li.plan-journey a")
    private WebElement planJourneyLink;

    @Step("Navigate to the TFL homepage")
    public static HomePage open() {
        // alternative to PageFactory that creates a page object instance with URL
        return new HomePage().get("https://tfl.gov.uk");
    }

    @Step("Go to the plan journey page")
    public PlanJourneyPage clickPlanJourneyLink() {
        planJourneyLink.click();
        return PageFactory.newInstance(PlanJourneyPage.class);
    }

}
