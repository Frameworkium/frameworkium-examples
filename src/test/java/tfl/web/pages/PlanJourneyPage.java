package tfl.web.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.frameworkium.core.ui.ExtraExpectedConditions.notPresentOrInvisible;
import static com.frameworkium.core.ui.ExtraExpectedConditions.sizeGreaterThan;

public class PlanJourneyPage extends BasePage<PlanJourneyPage> {

    @Visible
    @FindBy(css = "input#InputFrom")
    private WebElement fromField;

    @FindBy(css = "#search-filter-form-0 div.tt-dataset-stop-points-search div.tt-suggestion")
    private List<WebElement> fromSuggestions;

    @Visible
    @FindBy(css = "input#InputTo")
    private WebElement toField;

    @FindBy(css = "#search-filter-form-1 div.tt-dataset-stop-points-search div.tt-suggestion")
    private List<WebElement> toSuggestions;

    @Visible
    @FindBy(css = "input.plan-journey-button")
    private WebElement planJourneyButton;


    @Step("Plan journey from {0} to {1}")
    public JourneyPlannerResultsPage planJourney(String from, String to) {

        fromField.sendKeys(from);
        clickFirstSuggestion(fromSuggestions);
        toField.sendKeys(to);
        clickFirstSuggestion(toSuggestions);
        planJourneyButton.click();
        return PageFactory.newInstance(JourneyPlannerResultsPage.class);
    }

    private void clickFirstSuggestion(List<WebElement> suggestions) {

        wait.until(sizeGreaterThan(suggestions, 0));
        suggestions.get(0).click();
        wait.until(notPresentOrInvisible(suggestions));
    }

}
