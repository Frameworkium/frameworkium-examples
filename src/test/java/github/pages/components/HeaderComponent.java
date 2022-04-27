package github.pages.components;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.PageFactory;
import github.pages.*;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.frameworkium.core.htmlelements.element.*;

@FindBy(css = "header")
public class HeaderComponent extends HtmlElement {

    @Visible
    @FindBy(css = "a.header-logo-invertocat")
    private Link homeLink;

    @FindBy(name = "q")
    private TextInput searchBox;

    @Visible
    @FindBy(partialLinkText = "Explore")
    private Link exploreLink;

    @Visible
    @FindBy(partialLinkText = "Marketplace")
    private WebElement marketingLink;

    @Step("Go Home")
    public HomePage clickLogo() {
        homeLink.click();
        return PageFactory.newInstance(HomePage.class);
    }

    @Step("Go to the explore page")
    public ExplorePage clickExplore() {
        exploreLink.click();
        return PageFactory.newInstance(ExplorePage.class);
    }

    @Step("Search for the text \"{0}\"")
    public SearchResultsPage search(String searchText) {
        searchBox.sendKeys(searchText + Keys.ENTER);
        return PageFactory.newInstance(SearchResultsPage.class);
    }
}
