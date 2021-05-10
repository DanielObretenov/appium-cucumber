package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreferencesScreen extends HomeScreen {
    @FindBy(xpath = "//android.widget.TextView[@index='2']")
    WebElement PreferenceDetailsButton;



    public void navigateToWifiScreen() {
        clickOnElement(PreferenceDetailsButton);
    }
}
