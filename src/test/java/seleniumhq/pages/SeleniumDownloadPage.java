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
    @FindBy(css = "body > div.split-section.container.dark-background > div.right > p:nth-child(1) > a")
    private Link latestDownloadLink;

    public static SeleniumDownloadPage open() {
        return PageFactory.newInstance(
                SeleniumDownloadPage.class,
                "https://selenium.dev/downloads/");
    }

    public String getLatestVersion() {
        return latestDownloadLink.getText();
    }
}
