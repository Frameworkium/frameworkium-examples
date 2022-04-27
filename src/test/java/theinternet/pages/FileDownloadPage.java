package theinternet.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import com.frameworkium.core.htmlelements.element.Link;

import java.util.List;
import java.util.stream.Stream;

public class FileDownloadPage extends BasePage<FileDownloadPage> {

    @Visible
    @FindBy(css = "div.example a")
    private List<Link> allDownloadLinks;

    @Step("Return all download link names")
    public Stream<String> getDownloadableFileLinkNames() {
        return allDownloadLinks.stream()
                .map(Link::getText);
    }

}
