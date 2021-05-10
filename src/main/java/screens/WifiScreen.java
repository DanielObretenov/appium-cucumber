package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WifiScreen extends PreferencesScreen {
    @FindBy(id = "android:id/checkbox")
    WebElement wifiCheckbox;
    @FindBy(xpath = "(//android.widget.RelativeLayout)[2]")
    WebElement openSettings;
    @FindBy(className = "android.widget.EditText")
    WebElement inputSettingsLocator;
    @FindBy(id = "android:id/button1")
    WebElement okButtonSettings;



    public void checkWifiOption() {
        clickOnElement(wifiCheckbox);
    }

    public void clickOnSettings() {
        clickOnElement(openSettings);
    }

    public void enterWifiSettings(String settings) {
        clearAndSendKeys(inputSettingsLocator, settings);
        clickOnElement(okButtonSettings);

    }
}
