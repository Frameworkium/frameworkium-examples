package theinternet.tests;

import com.frameworkium.core.ui.tests.BaseUITest;
import com.google.common.truth.Truth8;
import io.qameta.allure.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import theinternet.pages.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.truth.Truth.assertThat;

@Feature("The Internet")
@Test
public class TheInternetExampleTests extends BaseUITest {

    @TmsLink("INT-1")
    @Story("Basic Auth Login")
    public void basic_auth() {

        String pageSource = WelcomePage.open().then()
                .navigateToBasicAuth("admin", "admin")
                .getSource();

        assertThat(pageSource).contains(
                "Congratulations! You must have the proper credentials.");
    }

    @TmsLink("INT-2")
    @Story("Check Checkboxes")
    public void check_boxes() {

        // Navigate to the checkboxes page
        Stream<Boolean> checkboxesStatus =
                WelcomePage.open()
                        .clickCheckboxesLink()
                        .checkAllCheckboxes()
                        .getAllCheckboxCheckedStatus();

        // Assert that all checkboxes are checked
        Truth8.assertThat(checkboxesStatus)
                .doesNotContain(false);
    }

    @TmsLink("INT-3")
    public void drag_and_drop() {

        // Navigate to the checkboxes page
        List<String> headings = WelcomePage.open().then()
                .clickDragAndDropLink()
                .dragAontoB()
                .getListOfHeadings();

        // Assert on the order of the headings
        assertThat(headings)
                .containsExactly("B", "A")
                .inOrder();
    }

    @TmsLink("INT-4")
    public void dropdown() {

        // Navigate to the checkboxes page
        DropdownPage dropdownPage = WelcomePage.open().then().clickDropdownLink();

        // Drag A onto B
        dropdownPage.selectFromDropdown("Option 1");

        // Assert selected
        assertThat(dropdownPage.getSelectedOptionText())
                .isEqualTo("Option 1");
    }

    @TmsLink("INT-5")
    public void dynamic_loading() {

        // Navigate to the dynamic loading hidden element page
        DynamicLoadingExamplePage dynamicLoadingExamplePage =
                WelcomePage.open().then().clickDynamicLoading().then().clickExample1();

        // Click start and wait for element to be displayed
        dynamicLoadingExamplePage.clickStart().then().waitForElementToBeDisplayed();

        // Assert that the element is indeed displayed
        assertThat(dynamicLoadingExamplePage.isElementDisplayed())
                .isTrue();

        // Navigate to the dynamic loading element not yet rendered page
        DynamicLoadingExamplePage dynamicLoadingPage =
                WelcomePage.open().then().clickDynamicLoading().then().clickExample2();

        // Click start and wait for element to be displayed
        dynamicLoadingPage.clickStart().then().waitForElementToBeDisplayed();

        // Assert that the element is indeed present
        assertThat(dynamicLoadingPage.isElementDisplayed()).isTrue();
    }

    @TmsLink("INT-6")
    public void file_download() {

        // Navigate to the download page
        FileDownloadPage downloadPage = WelcomePage.open().then().clickFileDownloadLink();

        // Confirm that the some-file.txt file in the list (as other people might be using it!)
        Truth8.assertThat(downloadPage.getDownloadableFileLinkNames())
                .contains("some-file.txt");
    }

    @TmsLink("INT-7")
    public void file_upload() {

        // Navigate to the upload page
        FileUploadPage fileUploadPage = WelcomePage.open().then().clickFileUploadLink();

        // Pick a local file we're going to upload
        String fileName = "FirefoxGrid.yaml";

        // Upload the file and confirm we land on the success page
        FileUploadSuccessPage successPage = fileUploadPage.uploadFile(fileName);

        // Confirm that the uploaded files list contains our filename
        assertThat(successPage.getUploadedFiles()).contains(fileName);
    }

    @TmsLink("INT-8")
    public void form_authentication() {

        // Navigate to the form authentication page
        final String username = "tomsmith";
        FormAuthenticationPage formAuthenticationPage = WelcomePage
                .open().then()
                .clickFormAuthenticationLink()
                // Log in with the bad password and expect to land where we are
                .login(username, "BadBadPassword", FormAuthenticationPage.class)
                .expectErrorMessage();

        // Log in with the username password provided
        FormAuthenticationSuccessPage successPage = formAuthenticationPage
                .login(username, "SuperSecretPassword!", FormAuthenticationSuccessPage.class);

        // Confirm that we're on the success page
        assertThat(successPage.getSource()).contains("Welcome to the Secure Area");
    }

    @TmsLink("INT-15")
    public void iframe_test() {

        //Navigate to the frames page
        FramesPage framesPage = WelcomePage.open().then().clickFramesLink();

        //Browse to iframes page
        IFramePage iframePage = framesPage.clickIFrameLink();

        //Clear text
        iframePage.clearTextInEditor();

        //Enter some text in the editor
        String text = "hello";
        iframePage.enterTextInEditor(text);

        //Assert that it entered it correctly
        assertThat(iframePage.getTextInEditor()).isEqualTo(text);

        //Enter some bold text in the editor
        iframePage.enterBoldTextInEditor(" some more text");
    }

    @TmsLink("INT-9")
    public void hovers() {

        // Navigate to the hovers page
        HoversPage hoversPage = WelcomePage.open().then().clickHoversLink();

        // Confirm that the caption under the first figure contains expected text
        assertThat(hoversPage.getFirstFigureCaption()).contains("name: user1");
    }

    @TmsLink("INT-11")
    public void javascript_alerts() {

        // Navigate to the javascript alerts page
        JavaScriptAlertsPage javascriptAlerts =
                WelcomePage.open().then().clickJavascriptAlertsLink();

        javascriptAlerts.clickAlertButtonAndAccept();
        assertThat(javascriptAlerts.getResultText())
                .isEqualTo("You successfuly clicked an alert");

        javascriptAlerts.clickAlertButtonAndDismiss();
        assertThat(javascriptAlerts.getResultText())
                .isEqualTo("You successfuly clicked an alert");

        javascriptAlerts.clickConfirmButtonAndAccept();
        assertThat(javascriptAlerts.getResultText())
                .isEqualTo("You clicked: Ok");

        javascriptAlerts.clickConfirmButtonAndDismiss();
        assertThat(javascriptAlerts.getResultText())
                .isEqualTo("You clicked: Cancel");

        String textToEnter = "Blah blah blah";
        javascriptAlerts.clickPromptButtonAndEnterPrompt(textToEnter);
        assertThat(javascriptAlerts.getResultText())
                .isEqualTo("You entered: " + textToEnter);
    }

    @TmsLink("INT-12")
    public void key_presses() {

        //Navigate to the key presses page
        KeyPressesPage keyPressesPage = WelcomePage
                .open()
                .clickKeyPressesLink()
                .enterKeyPress(Keys.ENTER);

        assertThat(keyPressesPage.getResultText())
                .isEqualTo("You entered: " + Keys.ENTER.name());
    }

    @TmsLink("INT-14")
    @Test(description = "Table Manipulation & Validation")
    public void sort_data_table() {

        // Navigate to the sortable data tables page
        SortableDataTablesPage sortableDataTablesPage =
                WelcomePage.open().then().clickSortableDataTablesLink();

        // Assert that Table 1 contains "http://www.jdoe.com" in the web site column
        assertThat(sortableDataTablesPage
                .getTable1ColumnContents("Web Site")
                .anyMatch(url -> Objects.equals(url, "http://www.jdoe.com")))
                .isTrue();

        List<String> lastNameColumn = sortableDataTablesPage
                // Sort Table 2 by last name column
                .sortTable2ByColumnName("Last Name")
                .getTable2ColumnContents("Last Name")
                .collect(Collectors.toList());

        // Confirm that "Bach" is then the first surname in table 2
        assertThat(lastNameColumn.get(0)).isEqualTo("Bach");

        // Confirm that the column is then ordered by the last name
        assertThat(lastNameColumn).isInOrder();
    }
}
