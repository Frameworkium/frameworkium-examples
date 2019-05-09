package TheInternetDoc.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class UserAuthenticationPage extends BasePage<UserAuthenticationPage> {

    @Visible
    @Name("Username field")
    @FindBy(id = "username")
    private TextInput usernameField;

    @Visible
    @Name("Password field")
    @FindBy(id = "password")
    private TextInput passwordField;

    @Visible
    @Name("Login button")
    @FindBy(css = "#login > button")
    private WebElement loginButton;

    @Name("Error message")
    @FindBy(css = "#flash")
    private WebElement errorMessage;

    @Step("Log in - {0}/{1}")
    public UserAuthenticationSuccessPage goodLogin(
            String username, String password) {

        usernameField.clear();
        usernameField.sendKeys(username);

        passwordField.clear();
        passwordField.sendKeys(password);

        loginButton.click();
        return PageFactory.newInstance(UserAuthenticationSuccessPage.class);
    }

    public UserAuthenticationPage badLogin(
            String username, String password) {

        usernameField.clear();
        usernameField.sendKeys(username);

        passwordField.clear();
        passwordField.sendKeys(password);

        loginButton.click();
        return PageFactory.newInstance(UserAuthenticationPage.class);
    }

    public UserAuthenticationPage expectErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return this;
    }
}
