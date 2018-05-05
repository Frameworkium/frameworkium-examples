package theinternet.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;

public class SecureFileDownloadPage extends BasePage<SecureFileDownloadPage> {

    @Visible
    @Name("Heading")
    @FindBy(css = "div.example h3")
    private WebElement heading;

    @Visible
    @Name("First download link")
    @FindBy(css = "div.example a:first-of-type")
    private Link firstDownloadLink;

    public String getHeadingText() {
        return heading.getText();
    }

}
