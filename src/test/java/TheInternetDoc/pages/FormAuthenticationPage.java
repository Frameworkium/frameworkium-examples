package TheInternetDoc.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class FormAuthenticationPage extends BasePage<FormAuthenticationPage> {

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
    private Button loginButton;

    @Name("Error message")
    @FindBy(css = "#flash")
    private WebElement errorMessage;

    @Step("Click login button")
    private void clickLogin(){
        loginButton.click();
    }

    @Step("Enter login details - {0} | {1} ")
    public <T extends BasePage<T>> T login(String username, String password, Class<T> classOfExpectedPageObject){

        usernameField.clear();
        usernameField.sendKeys(username);

        passwordField.clear();
        passwordField.sendKeys(password);

        clickLogin();
        return PageFactory.newInstance(classOfExpectedPageObject);
    }

    @Step("Check for error message")
    public boolean expectErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}