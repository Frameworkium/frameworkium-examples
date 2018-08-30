package theinternet.tests;

import com.frameworkium.core.ui.tests.BaseUITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import theinternet.pages.CheckboxesPage;
import theinternet.pages.WelcomePage;

import static com.google.common.truth.Truth.assertThat;

@Features("The Internet")
public class TheInternetExampleTests2 extends BaseUITest {

    @TestCaseId("HEROKU-2")
    @Stories("Check Checkboxes")
    @Test(description = "Checkboxes")
    public void checkBoxes() {

        // Navigate to the checkboxes page
        CheckboxesPage checkboxesPage = WelcomePage.open().then().clickCheckboxesLink();

        // Set all checkboxes to checked via alternative method
        checkboxesPage.checkAllCheckboxes();

        // Assert that all checkboxes are checked
        assertThat(checkboxesPage.getAllCheckboxCheckedStatus())
                .named("check status of checkboxes")
               .doesNotContain(false);
    }
}
