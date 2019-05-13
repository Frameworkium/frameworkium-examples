package TheInternetDoc.tests;

import TheInternetDoc.pages.*;
import com.frameworkium.core.ui.tests.BaseUITest;
import com.google.common.truth.Truth8;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.util.stream.Stream;

import static com.google.common.truth.Truth.assertThat;
import static theinternet.util.Constants.Users.Credentials.INVALIDLOGIN;
import static theinternet.util.Constants.Users.Credentials.VALIDLOGIN;

@Feature("The Internet")
public class TheInternetExampleDocTests extends BaseUITest {

    @TmsLink("INT-8")
    @Story("User Login")
    @Test(description = "Form Authentication")
    @Description("Invalid login and assert error message then valid login and assert success message")
    public void form_authentication() {

        // Navigate to the form authentication page
        FormAuthenticationPage formAuthentication = HomePage.open()
                .then()
                .clickFormAuthenticationLink();

        // Log in with the bad password and expect to land where we are
        assertThat(formAuthentication
                .login(INVALIDLOGIN.getUserName(), INVALIDLOGIN.getPassword(), FormAuthenticationPage.class)
                .expectErrorMessage()).isTrue();

        // Log in with the username password provided
        FormAuthenticationSuccessPage successPage = formAuthentication
                .login(VALIDLOGIN.getUserName(), VALIDLOGIN.getPassword(), FormAuthenticationSuccessPage.class);

        // Confirm that we're on the success page
        assertThat(successPage.getSource()).contains("Welcome to the Secure Area");
    }

    @TmsLink("INT-2")
    @Story("Check Checkboxes")
    @Test(description = "Checkboxes")
    public void check_boxes() {

        // Navigate to the checkboxes page
        Stream<Boolean> checkboxesStatus = HomePage.open()
                .clickCheckboxesLink()

                // Set all checkboxes to checked via alternative method
                .checkAllCheckboxes()
                .getAllCheckboxCheckedStatus();

        // Assert that all checkboxes are checked
        Truth8.assertThat(checkboxesStatus)
                .named("check status of checkboxes")
                .doesNotContain(false);
    }

    @TmsLink("INT-5")
    @Test(description = "Dynamic loading")
    public void dynamic_loading() {

        // Navigate to the dynamic loading hidden element page
        DynamicLoadingExamplePage dynamicLoadingExamplePage = HomePage.open().then()
                .clickDynamicLoading().then()
                .clickExample1();

        // Click start and wait for element to be displayed
        dynamicLoadingExamplePage.clickStart().then().waitForElementToBeDisplayed();

        // Assert that the element is indeed displayed
        assertThat(dynamicLoadingExamplePage.isElementDisplayed())
                .named("element visibility")
                .isTrue();

        // Navigate to the dynamic loading element not yet rendered page
        DynamicLoadingExamplePage dynamicLoadingPage =
                HomePage.open().then().clickDynamicLoading().then().clickExample2();

        // Click start and wait for element to be displayed
        dynamicLoadingPage.clickStart().then().waitForElementToBeDisplayed();

        // Assert that the element is indeed present
        assertThat(dynamicLoadingPage.isElementDisplayed()).named("element presence").isTrue();
    }
}
