package theinternet.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Simple test of the HTML5 Drag and Drop functionality.
 * <p>
 * Not currently natively supported by Selenium, see:
 * <p>
 * https://github.com/seleniumhq/selenium-google-code-issue-archive/issues/3604
 */
public class DragAndDropPage extends BasePage<DragAndDropPage> {

    private static final String JQUERY_JS_URI = "https://code.jquery.com/jquery-1.12.4.min.js";

    @Visible
    @FindBy(id = "column-a")
    private WebElement boxA;

    @Visible
    @FindBy(id = "column-b")
    private WebElement boxB;

    @FindBy(css = "header")
    private List<WebElement> boxes;

    // Acts as a cache to prevent multiple fetches of the same libraries from the Internet
    private static String jQueryJS = "";
    // Local minified copy of the script
    // https://gist.githubusercontent.com/rcorreia/2362544/
    private static String dragDropHelperJS = "!function(t){t.fn.simulateDragDrop=function(a)" +
            "{return this.each(function(){new t.simulateDragDrop(this,a)})}," +
            "t.simulateDragDrop=function(t,a){this.options=a,this.simulateEvent(t,a)}," +
            "t.extend(t.simulateDragDrop.prototype,{simulateEvent:function(a,e){var " +
            "n=\"dragstart\",r=this.createEvent(n);this.dispatchEvent(a,n,r)," +
            "n=\"drop\";var i=this.createEvent(n,{});i.dataTransfer=r.dataTransfer," +
            "this.dispatchEvent(t(e.dropTarget)[0],n,i),n=\"dragend\";" +
            "var s=this.createEvent(n,{});s.dataTransfer=r.dataTransfer,this." +
            "dispatchEvent(a,n,s)},createEvent:function(t){var a=document." +
            "createEvent(\"CustomEvent\");return a.initCustomEvent(t,!0,!0,null)," +
            "a.dataTransfer={data:{},setData:function(t,a){this.data[t]=a}," +
            "getData:function(t){return this.data[t]}},a},dispatchEvent:" +
            "function(t,a,e){t.dispatchEvent?t.dispatchEvent(e):t.fireEvent&&t.fireEvent(\"on\"+a,e)}})}(jQuery);";

    /**
     * Fetches Javascript used to be able to simulate Drag and Drop.
     *
     * @return a String containing the Javascript for JQuery (if not already
     * present on the page) and code for simulating drag and drop.
     */
    private String javascriptToSimulateDragDrop() {
        if (jQueryJS.isEmpty()) {
            var isJQueryAvailable = (Boolean) executeJS("return typeof $ !== 'undefined';");
            if (!isJQueryAvailable) {
                logger.debug("about to get jQuery");
                jQueryJS = RestAssured.get(JQUERY_JS_URI).asString();
                logger.debug("got jQuery");
            }
        }

        return jQueryJS + dragDropHelperJS;
    }

    /**
     * @param from the JQuery selector for the element to initially click and
     *             then drag
     * @param to   the JQuery selector for the target element where the from
     *             element will be dropped
     */
    private void simulateDragAndDrop(String from, String to) {
        executeJS(javascriptToSimulateDragDrop());
        executeJS("$('" + from + "').simulateDragDrop({ dropTarget: '" + to + "'});");
    }

    @Step("Drag A onto B")
    public DragAndDropPage dragAontoB() {
        simulateDragAndDrop("#column-a", "#column-b");
        return this;
    }

    @Step("Get order of headers")
    public List<String> getListOfHeadings() {
        return boxes.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
