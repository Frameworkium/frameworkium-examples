package com.calcapp.pages.app;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;

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
