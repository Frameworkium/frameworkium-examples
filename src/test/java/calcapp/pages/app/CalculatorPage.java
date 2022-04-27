package calcapp.pages.app;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import com.frameworkium.core.htmlelements.element.*;

import java.util.List;

public class CalculatorPage extends BasePage<CalculatorPage> {

    @FindBy(className = "UIATextField")
    private List<TextInput> fields;

    @Visible
    @FindBy(className = "UIAButton")
    private Button computeSumButton;

    @FindBy(className = "UIAStaticText")
    private TextBlock resultLabel;

    @Step("Compute sum of {0} and {1}.")
    public CalculatorPage computeSum(Integer a, Integer b) {
        fields.get(0).sendKeys(a.toString());
        fields.get(1).sendKeys(b.toString());
        computeSumButton.click();
        return this;
    }

    @Step("Get the result.")
    public String getResult() {
        return resultLabel.getText();
    }
}
