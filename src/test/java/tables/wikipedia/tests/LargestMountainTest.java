package tables.wikipedia.tests;

import com.frameworkium.core.ui.tests.BaseUITest;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import tables.wikipedia.pages.HighestMountainPage;

import static com.google.common.truth.Truth.assertThat;

public class LargestMountainTest extends BaseUITest {

    @TmsLink("WIKI-1")
    @Test(description = "Playing with data inside highest mountain table")
    public final void exploring_the_highest_mountain_table() {

        var page = HighestMountainPage.open();

        assertThat(page.getRankByName("Mount Everest")).isEqualTo("1");
        assertThat(page.getFirstAscentByName("Annapurna I")).isEqualTo("1950");
        assertThat(page.mountainsHigherThan(8000)).isEqualTo(14L);
    }
}
