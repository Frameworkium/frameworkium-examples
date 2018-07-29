package tables.wikipedia.tests;

import com.frameworkium.core.ui.tests.BaseUITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tables.wikipedia.pages.EnglishCountiesPage;

import static com.google.common.truth.Truth.assertThat;

public class EnglishCountiesTest extends BaseUITest {

    @TestCaseId("WIKI-2")
    @Test(description = "Playing with English Counties data")
    public final void exploring_english_counties_data() {

        EnglishCountiesPage page = EnglishCountiesPage.open();

        assertThat(page.populationOf("Cornwall")).isAtLeast(550_000);
        // at least two counties have population densities of more than 3000
        assertThat(page.densities()
                .filter(density -> density > 3000)
                .limit(2)
                .count())
                .isEqualTo(2L);
    }
}
