package github.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import github.pages.components.HeaderComponent;
import io.qameta.allure.Step;

public class ExplorePage extends BasePage<ExplorePage> {

    @Visible
    private HeaderComponent header;

    @Step("Navigate to the Github homepage")
    public static ExplorePage open() {
        return PageFactory.newInstance(
                ExplorePage.class, "https://github.com/explore");
    }

    public HeaderComponent theHeader() {
        return header;
    }
}
