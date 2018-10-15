package seleniumhq.components;

import com.frameworkium.core.ui.pages.PageFactory;
import seleniumhq.pages.SeleniumDownloadPage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@FindBy(id = "header")
public class HeaderComponent extends HtmlElement {

    @FindBy(css = "#menu_download > a")
    private Link downloadLink;

    public SeleniumDownloadPage clickDownloadLink() {
        downloadLink.click();
        return PageFactory.newInstance(SeleniumDownloadPage.class);
    }

}
