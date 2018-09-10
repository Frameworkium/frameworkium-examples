package theinternet.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class FileUploadSuccessPage extends BasePage<FileUploadSuccessPage> {

    @Visible
    @Name("Uploaded Files")
    @FindBy(css = "div#uploaded-files")
    private WebElement uploadedFiles;

    @Step("Get uploaded files list")
    public String getUploadedFiles() {
        return uploadedFiles.getText();
    }

}
