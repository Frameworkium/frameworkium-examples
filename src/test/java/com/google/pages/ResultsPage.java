package com.google.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.util.List;
import java.util.stream.Collectors;

public class ResultsPage extends BasePage<ResultsPage> {

    @Visible
    @Name("Search results stats")
    @FindBy(id = "resultStats")
    private TextBlock resultStats;

    @Name("Search result titles")
    @FindBy(css = "h3.r > a")
    private List<Link> resultTitles;

    /**
     * Uses a stream to lazily iterate through links. We expect the first result
     * to be the one we want, using a Stream means we won't have to build an
     * entire list which is relatively expensive.
     */
    @Step("Get search result titles")
    public List<String> getResultTitles() {

        return resultTitles.stream()
                .map(Link::getText)
                .collect(Collectors.toList());
    }

}
