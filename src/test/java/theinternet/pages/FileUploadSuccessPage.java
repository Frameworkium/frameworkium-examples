package theinternet.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadSuccessPage extends BasePage<FileUploadSuccessPage> {

    @Visible
    @FindBy(css = "div#uploaded-files")
    private WebElement uploadedFiles;

    @Step("Get uploaded files list")
    public String getUploadedFiles() {
        return uploadedFiles.getText();
    }

}
