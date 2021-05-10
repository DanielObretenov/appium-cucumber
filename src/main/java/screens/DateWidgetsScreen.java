package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DateWidgetsScreen extends ViewsScreen {
//    private String attribute = "text(\"2. Inline\")";

    @FindBy(xpath = "//android.widget.TextView[@text='2. Inline']")
    WebElement preferenceScreenButton;




    public void navigateToInlineClock() {
//        ((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(attribute).click();
        clickOnElement(preferenceScreenButton);
    }
}
