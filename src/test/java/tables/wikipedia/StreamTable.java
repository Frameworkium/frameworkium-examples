package tables.wikipedia;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamTable extends HtmlElement {

    @FindBy(css = "thead > tr > th")
    private List<WebElement> headerCells;

    @FindBy(css = "tbody > tr")
    private List<WebElement> rows;

    public Stream<WebElement> getHeadings() {
        return headerCells.stream()
                .filter(WebElement::isDisplayed);
    }

    public Stream<Stream<WebElement>> getRows() {
        return rows.stream()
                .map(el -> el.findElements(By.cssSelector("td")).stream());
    }

    /**
     * @param index 0-based index
     * @return the row specified by the index
     */
    public Optional<List<WebElement>> getRow(int index) {
        return getRowList().skip(index).findFirst();
    }

    public Stream<List<WebElement>> getRowList() {
        return getRows()
                .map(row -> row.collect(toList()))
                .filter(row -> !row.isEmpty());
    }

    /**
     * Returns the column given a index of header.
     *
     * @param index of the column to return
     * @return the column which matches the {@code index}
     */
    public Stream<WebElement> getColumn(int index) {
        return getRowList()
                .map(row -> row.get(index));
    }

    /**
     * Returns column given a String that matches a header.
     * +--+-------------+-------------+
     * |  | headerText |             |
     * +--+-------------+-------------+
     * |  |      |      |             |
     * |  |   return    |             |
     * |  |      |      |             |
     * |  |      ˅      |             |
     * +--+-------------+-------------+
     *
     * @param headerText the String to match the header
     * @return the column which matches the {@code headerText}
     */
    public Stream<WebElement> getColumn(String headerText) {
        return getColumn(getHeaderIndex(element -> Objects.equals(element.getText(), headerText)));
    }

    /**
     * Returns column given a predicate that matches a header.
     * +--+-------------+-------------+
     * |  | headerMatch |             |
     * +--+-------------+-------------+
     * |  |      |      |             |
     * |  |   return    |             |
     * |  |      |      |             |
     * |  |      ˅      |             |
     * +--+-------------+-------------+
     *
     * @param headerMatcher the predicate to test the range we want to return
     * @return the column or range which matches the {@code headerMatcher}
     */
    public Stream<WebElement> getColumn(Predicate<WebElement> headerMatcher) {
        return getColumn(getHeaderIndex(headerMatcher));
    }

    /**
     * {@link #getCellsByLookup(Predicate, Predicate, Predicate)}
     *
     * @param targetColHeaderText the String to match the header containing the return value
     * @param lookupColHeaderText the String to match the header where we want to lookup using {@code lookupCellText}
     * @param lookupCellText         the String to match the to look up for a match in the lookupColHeaderText
     * @return all WebElements from targetColHeaderText which matches {@code lookupCellText} in lookupColHeaderText
     */
    public Stream<WebElement> getCellsByLookup(
            String targetColHeaderText, String lookupColHeaderText, String lookupCellText) {
        return getCellsByLookup(
                element -> element.getText().trim().equals(targetColHeaderText),
                element -> element.getText().trim().equals(lookupColHeaderText),
                element -> element.getText().trim().equals(lookupCellText));
    }

    /**
     * <p>Returns WebElements from target cells given a lookup match limited by {@code limit}.</p>
     * +--+--------+---------+
     * |  | lookup |  target |
     * +--+--------+---------+
     * |  |    |   |         |
     * |  | match---->return |
     * |  |    |   |         |
     * |  | match---->return |
     * +--+--------+---------+
     *
     * @param targetColumnHeader the predicate to test the range containing the return value
     * @param lookupColumnHeader the predicate to test the range where we want to lookup
     * @param lookupMatcher      the predicate to test the to look up for a match in the lookupRange
     * @return WebElements in the targetRange which matches {@code lookupMatcher} in lookupRange
     */

    private Stream<WebElement> getCellsByLookup(
            Predicate<WebElement> targetColumnHeader,
            Predicate<WebElement> lookupColumnHeader,
            Predicate<WebElement> lookupMatcher) {

        int lookupColumnIndex = getHeaderIndex(lookupColumnHeader);
        int targetColumnIndex = getHeaderIndex(targetColumnHeader);

        return getRowList()
                .filter(row -> lookupMatcher.test(row.get(lookupColumnIndex)))
                .map(row -> row.get(targetColumnIndex));
    }

    /**
     * Returns index of a header matching the {@code headerPredicate}.
     *
     * @param headerPredicate the predicate to test the headers cells
     * @return index of the matching header
     */
    private int getHeaderIndex(Predicate<WebElement> headerPredicate) {
        List<WebElement> headings = getHeadings().collect(toList());
        return IntStream.range(0, headings.size())
                .filter(i -> headerPredicate.test(headings.get(i)))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                        String.format(
                                "Table header %s not found",
                                headerPredicate)));
    }

}
