package seleniumhq.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Link;
import seleniumhq.components.HeaderComponent;

public class SeleniumDownloadPage extends BasePage<SeleniumDownloadPage> {

    @Visible
    private HeaderComponent header;

    @Visible
    @FindBy(css = "#mainContent > p:nth-child(5) > a")
    private Link latestDownloadLink;

    public static SeleniumDownloadPage open() {
        return PageFactory.newInstance(
                SeleniumDownloadPage.class,
                "https://www.seleniumhq.org/download/");
    }

    public String getLatestVersion() {
        return latestDownloadLink.getText();
    }
}
