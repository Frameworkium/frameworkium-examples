package com.heroku.theinternet.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.when;

public class FileDownloadPage extends BasePage<FileDownloadPage> {

    @Visible
    @Name("Generic download link")
    @FindBy(css = "div.example a")
    private List<Link> allDownloadLinks;

    @Visible
    @Name("First download link")
    @FindBy(css = "div.example a:first-of-type")
    private Link firstDownloadLink;

    @Step("Get the size of the first downloadable file")
    public long getSizeOfFirstFile() {
        return getSizeOfFileAtURL(firstDownloadLink.getReference());
    }

    @Step("Return all download link names")
    public List<String> getDownloadableFileLinkNames() {

        return allDownloadLinks.stream()
                .map(Link::getText)
                .collect(Collectors.toList());
    }

    @Step("Get the size of the file {0}")
    public long getSizeOfFile(String linkText) {
        return getSizeOfFileAtURL(getURLOfFile(linkText));
    }

    @Step("Get the URL of the file {0}")
    private String getURLOfFile(String linkText) {
        return findLinkByText(linkText).getReference();
    }

    private Link findLinkByText(String desiredLinkText) {

        return allDownloadLinks.stream()
                .filter(link -> desiredLinkText.equals(link.getText()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                        "All downloads list doesn't contain " + desiredLinkText));
    }

    private long getSizeOfFileAtURL(String downloadURL) {

        InputStream inputStream = when()
                .get(downloadURL)
                .asInputStream();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            IOUtils.copy(inputStream, byteArrayOutputStream);
        } catch (IOException e) {
            logger.error("Failed to get size of the file at uri: " + downloadURL, e);
        }
        IOUtils.closeQuietly(byteArrayOutputStream);
        IOUtils.closeQuietly(inputStream);

        return byteArrayOutputStream.size();
    }

}
