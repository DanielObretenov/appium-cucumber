package screens;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class HomeScreen extends BaseScreen {
    @FindBy(xpath = "//android.widget.TextView[@text='Preference']")
    MobileElement preferenceScreenButton;
    @FindBy(xpath = "//android.widget.TextView[@text='Views']")
    MobileElement viewsScreenButton;


    public void navigateToPreferencesScreen() {
        clickOnElement(preferenceScreenButton);
    }

    public void navigateToViewsScreen() {
        clickOnElement(viewsScreenButton);
    }
}
