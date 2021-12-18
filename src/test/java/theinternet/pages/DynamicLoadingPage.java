package theinternet.pages;

import com.frameworkium.core.htmlelements.element.Link;
import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;


public class DynamicLoadingPage extends BasePage<DynamicLoadingPage> {

    @Visible
    @FindBy(linkText = "Example 1: Element on page that is hidden")
    private Link example1Link;

    @FindBy(linkText = "Example 2: Element rendered after the fact")
    private Link example2Link;

    @Step("Click the 'Example 1: Element on page that is hidden' link")
    public DynamicLoadingExamplePage clickExample1() {
        example1Link.click();
        return PageFactory.newInstance(DynamicLoadingExamplePage.class);
    }

    @Step("Click the 'Example 2: Element rendered after the fact' link")
    public DynamicLoadingExamplePage clickExample2() {
        example2Link.click();
        return PageFactory.newInstance(DynamicLoadingExamplePage.class);
    }
}
