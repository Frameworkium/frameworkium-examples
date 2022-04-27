package theinternet.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.frameworkium.core.htmlelements.element.TextInput;

public class FormAuthenticationPage extends BasePage<FormAuthenticationPage> {

    @Visible
    @FindBy(css = "input#username")
    private TextInput usernameField;

    @Visible
    @FindBy(css = "input#password")
    private TextInput passwordField;

    @Visible
    @FindBy(css = "#login > button")
    private WebElement loginButton;

    @FindBy(css = "#flash")
    private WebElement errorMessage;

    @Step("Log in - {0}/{1}")
    public <T extends BasePage<T>> T login(
            String username, String password, Class<T> classOfExpectedPageObject) {

        usernameField.clear();
        usernameField.sendKeys(username);

        passwordField.clear();
        passwordField.sendKeys(password);

        loginButton.click();
        return PageFactory.newInstance(classOfExpectedPageObject);
    }

    public FormAuthenticationPage expectErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return this;
    }
}
