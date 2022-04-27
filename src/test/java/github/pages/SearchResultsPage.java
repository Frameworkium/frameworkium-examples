package github.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import github.pages.components.HeaderComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import com.frameworkium.core.htmlelements.element.Link;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends BasePage<SearchResultsPage> {

    @Visible
    private HeaderComponent header;

    @Visible(checkAtMost = 1)
    @FindBy(css = "h3 > a")
    private List<Link> repoLinks;

    public HeaderComponent theHeader() {
        return header;
    }

    @Step("Navigate to the Github homepage")
    public static SearchResultsPage open() {
        return PageFactory.newInstance(
                SearchResultsPage.class, "https://github.com");
    }

    @Step("Get the list of code repository names")
    public List<String> getRepoNames() {

        return repoLinks.stream()
                .map(Link::getText)
                .collect(Collectors.toList());
    }
}
