package theinternet.tests;

import com.frameworkium.core.ui.tests.BaseUITest;
import theinternet.pages.*;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;

import static com.google.common.truth.Truth.assertThat;

@Features("The Internet")
public class TheInternetExampleTests extends BaseUITest {

    @TestCaseId("HEROKU-1")
    @Stories("Basic Auth Login")
    @Test(description = "Basic Auth")
    public void basicAuth() {

        // Navigate to the heroku site's welcome page
        WelcomePage welcomePage = WelcomePage.open();

        // Click the form authentication link
        FormAuthenticationPage formAuthenticationPage = welcomePage.clickFormAuthenticationLink();

        // Log in with the username password provided
        FormAuthenticationSuccessPage successPage = formAuthenticationPage
                .login("tomsmith", "SuperSecretPassword!", FormAuthenticationSuccessPage.class);

        // Confirm that we're on the success page
        assertThat(successPage.getSource()).contains("Welcome to the Secure Area");

    }

    //Test 2 - Form Authentication Failure
    // Navigate to the heroku site's welcome page
    // Click the form authentication link
    // Log in with an incorrect password (but a valid username)
    // Confirm that 'Your password is invalid!' is displayed

}
