package angularjs.tests;

import angularjs.pages.HomePage;
import com.frameworkium.core.ui.tests.BaseUITest;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class DocumentationTest extends BaseUITest {

    private static String SEARCH_TERM = "Bootstrap";

    @Test(description =
            "Tests the AngularJS developer documentation and search function")
    public void documentationTest() {
        String guideTitle = HomePage
                .open()
                .clickDevelopMenu()
                .clickDeveloperGuideLink()
                .clickSearchBar()
                .setSearchBar(SEARCH_TERM)
                .clickLinkWithTitle(SEARCH_TERM)
                .getGuideTitle(SEARCH_TERM);

        assertThat(guideTitle)
                .isEqualTo(SEARCH_TERM);
    }

}
