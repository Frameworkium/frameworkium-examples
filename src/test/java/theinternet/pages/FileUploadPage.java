package theinternet.pages;

import com.frameworkium.core.htmlelements.element.FileInput;
import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FileUploadPage extends BasePage<FileUploadPage> {

    @Visible
    @FindBy(css = "input#file-upload")
    private FileInput chooseFileInput;

    @Visible
    @FindBy(css = "input#file-submit")
    private WebElement uploadButton;

    @Step("Upload a file by choosing file and then clicking upload")
    public FileUploadSuccessPage uploadFile(String filePath) {
        chooseFileInput.setFileToUpload(filePath);
        uploadButton.click();
        return PageFactory.newInstance(FileUploadSuccessPage.class);
    }

}
