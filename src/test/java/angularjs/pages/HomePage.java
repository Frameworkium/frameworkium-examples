package angularjs.pages;

import com.frameworkium.core.ui.UITestLifecycle;
import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage<HomePage> {

    @Visible
    @FindBy(xpath = "//a[text()='Develop']")
    private WebElement developDropdown;

    @FindBy(xpath = "//a[text()='Developer Guide']")
    private WebElement developerGuideMenuItem;

    @Step("Open home page")
    public static HomePage open() {
        UITestLifecycle.get().getWebDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        return PageFactory.newInstance(HomePage.class, "https://angularjs.org/");
    }

    @Step("Click developer guide drop down menu")
    public HomePage clickDevelopMenu() {
        developDropdown.click();
        return this;
    }

    @Step("Click developer guide link")
    public DeveloperGuidePage clickDeveloperGuideLink() {
        developerGuideMenuItem.click();
        return PageFactory.newInstance(DeveloperGuidePage.class);
    }

}
