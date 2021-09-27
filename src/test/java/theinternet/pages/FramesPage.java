package theinternet.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FramesPage extends BasePage<FramesPage> {

    @Visible
    @FindBy(linkText = "iFrame")
    private WebElement iFrameLink;

    @Step("Click iFrame link")
    public IFramePage clickIFrameLink() {
        iFrameLink.click();
        return PageFactory.newInstance(IFramePage.class);
    }

}
