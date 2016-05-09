package com.google.pages.web;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.util.List;
import java.util.stream.Collectors;

public class ResultsPage extends BasePage<ResultsPage> {

    @Name("Search result titles")
    @Visible
    @FindBy(css = ".rc .r a")
    private List<WebElement> resultTitles;

    @Step("Get search result titles")
    public List<String> getResultTitles() {

        return resultTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
