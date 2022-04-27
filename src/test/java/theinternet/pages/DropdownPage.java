package theinternet.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import com.frameworkium.core.htmlelements.element.Select;

public class DropdownPage extends BasePage<DropdownPage> {

    @Visible
    @FindBy(css = "select#dropdown")
    private Select dropdown;

    @Step("Select option {0} from dropdown")
    public DropdownPage selectFromDropdown(String option) {
        dropdown.selectByVisibleText(option);
        return this;
    }

    @Step("Return the selected option")
    public String getSelectedOptionText() {
        return dropdown.getFirstSelectedOption().getText();
    }
}
