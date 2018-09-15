package seleniumhq.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import org.openqa.selenium.support.CacheLookup;
import seleniumhq.components.HeaderComponent;

public class HomePage extends BasePage<HomePage> {

    @CacheLookup
    @Visible
    private HeaderComponent header;

    public static HomePage open() {
        return PageFactory.newInstance(
                HomePage.class,
                "https://www.seleniumhq.org/");
    }

    public HeaderComponent getHeader() {
        return header;
    }
}
