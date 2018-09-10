package theinternet.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.element.StreamTable;
import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

public class SortableDataTablesPage extends BasePage<SortableDataTablesPage> {

    @Visible
    @Name("Heading")
    @FindBy(css = "div.example h3")
    private WebElement heading;

    @Visible
    @Name("Table 1")
    @CacheLookup
    @FindBy(id = "table1")
    private StreamTable table1;

    @Visible
    @Name("Table 2")
    @CacheLookup
    @FindBy(id = "table2")
    private StreamTable table2;

    @Step("Get table 1 column {0} contents")
    public Stream<String> getTable1ColumnContents(String colHeader) {
        return getColumnContents(table1, colHeader);
    }

    @Step("Get table 2 column {0} contents")
    public Stream<String> getTable2ColumnContents(String colHeader) {
        return getColumnContents(table2, colHeader);
    }

    @Step("Sort table 2 by column with header {0}")
    public SortableDataTablesPage sortTable2ByColumnName(String colHeader) {
        sortTableByColumnName(table2, colHeader);
        return this;
    }

    @Step("Sort table {0} by column name {1}")
    private SortableDataTablesPage sortTableByColumnName(StreamTable table, String colHeader) {
        table.getHeading(colHeader)
                .orElseThrow(NoSuchElementException::new)
                .click();
        return this;
    }

    @Step("Get column contents of column {1} in table {0}")
    private Stream<String> getColumnContents(StreamTable table, String colHeader) {
        return table.getColumn(colHeader).map(WebElement::getText);
    }

}
