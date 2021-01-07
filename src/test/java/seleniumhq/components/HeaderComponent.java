package seleniumhq.components;

import com.frameworkium.core.ui.pages.PageFactory;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import seleniumhq.pages.SeleniumDownloadPage;

@FindBy(id = "header")
public class HeaderComponent extends HtmlElement {

    @FindBy(css = "#navbar > a:nth-child(3)")
    private Link downloadLink;

    public SeleniumDownloadPage clickDownloadLink() {
        downloadLink.click();
        return PageFactory.newInstance(SeleniumDownloadPage.class);
    }

}
