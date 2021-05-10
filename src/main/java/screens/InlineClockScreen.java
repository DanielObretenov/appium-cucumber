package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DriverUtil;

public class InlineClockScreen extends DateWidgetsScreen {
    private int currentHour;
    private int currentMinute;
    private final String timeLocator = "//*[@content-desc='%s']";


    public void setTime(String time) {
        splitTime(time);
        setClockHour();
        setClockMinuteBySwiping();
    }

    private void setClockHour() {
        clickOnElement(By.xpath(String.format(timeLocator,currentHour)));
    }

    private void setClockMinuteBySwiping() {
        swipeToElement(By.xpath(getStringTimeLocator(currentMinute)), By.xpath(getStringTimeLocator(45)));
    }


    public void splitTime(String time) {
        try {
            currentHour = Integer.parseInt(time.split(":")[0]);
            currentMinute = Integer.parseInt(time.split(":")[1]);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

    }
    private String getStringTimeLocator(int number){
        return String.format(timeLocator,number);
    }
}
