package angularjs.tests;

import angularjs.pages.HomePage;
import com.frameworkium.core.ui.tests.BaseUITest;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class DocumentationTest extends BaseUITest {

    @Test(description =
            "Tests the AngularJS developer documentation and search function")
    public void documentationTest() {

        String searchTerm = "Bootstrap";

        String guideTitle = HomePage
                .open()
                .clickDevelopMenu()
                .clickDeveloperGuideLink()
                .clickSearchBar()
                .setSearchBar(searchTerm)
                .clickLinkWithTitle(searchTerm)
                .getGuideTitle(searchTerm);

        assertThat(guideTitle)
                .isEqualTo(searchTerm);
    }

}
