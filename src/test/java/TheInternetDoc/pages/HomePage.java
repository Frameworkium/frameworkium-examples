package TheInternetDoc.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;
import theinternet.pages.DynamicLoadingPage;
import theinternet.pages.FormAuthenticationPage;
import theinternet.pages.*;

public class HomePage extends BasePage<HomePage> {

    @Visible
    @Name("Checkboxes link")
    @FindBy(linkText = "Checkboxes")
    private Link checkboxesLink;

    @Name("Dynamic Loading link")
    @FindBy(linkText = "Dynamic Loading")
    private Link dynamicLoadingLink;

    @Name("Form Authentication Link")
    @FindBy(linkText = "Form Authentication")
    private Link formAuthenticationLink;

    @Step("Navigate to https://the-internet.herokuapp.com")
    public static HomePage open() {
        return PageFactory.newInstance(
                HomePage.class, "https://the-internet.herokuapp.com");
    }

    @Step("Click the Checkboxes link")
    public CheckboxesPage clickCheckboxesLink() {
        checkboxesLink.click();
        return PageFactory.newInstance(CheckboxesPage.class);
    }

    @Step("Click the Dynamic Loading link")
    public DynamicLoadingPage clickDynamicLoading() {
        dynamicLoadingLink.click();
        return PageFactory.newInstance(DynamicLoadingPage.class);
    }

    @Step("Click the Form authentication link")
    public UserAuthenticationPage clickFormAuthenticationLink() {
        formAuthenticationLink.click();
        return PageFactory.newInstance(UserAuthenticationPage.class);
    }
}