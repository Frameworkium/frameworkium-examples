package seleniumhq.components;

import com.frameworkium.core.ui.UITestLifecycle;
import com.frameworkium.core.ui.pages.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import seleniumhq.pages.SeleniumDownloadPage;

@FindBy(className = "navbar")
public class HeaderComponent extends HtmlElement {

    @FindBy(css = "#main_navbar [href='/downloads']")
    private Link downloadLink;

    public SeleniumDownloadPage clickDownloadLink() {
        UITestLifecycle.get().getWait().until(ExpectedConditions.elementToBeClickable(downloadLink));
        downloadLink.click();
        return PageFactory.newInstance(SeleniumDownloadPage.class);
    }

}
