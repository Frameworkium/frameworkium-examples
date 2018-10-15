package calcapp.tests;

import calcapp.pages.app.CalculatorPage;
import com.frameworkium.core.ui.pages.PageFactory;
import com.frameworkium.core.ui.tests.BaseUITest;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class CalculatorAppTest extends BaseUITest {

    /**
     * Example test for https://appium.s3.amazonaws.com/TestApp7.1.app.zip
     */
    @Test(description = "Test sum computation", enabled = false)
    @TmsLink("CALC-1")
    public void testIOSApp() {

        String result = PageFactory
                .newInstance(CalculatorPage.class)
                .computeSum(1, 2).then()
                .getResult();

        assertThat(result).isEqualTo("3");
    }
}
