package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.DriverUtil;

import java.time.Duration;
import java.util.List;

public class BaseScreen {
    TouchAction touchAction;

    public BaseScreen() {
        touchAction = new TouchAction(DriverUtil.getDefaultWebDriver());
       // PageFactory.initElements(DriverUtil.getDefaultWebDriver(), this);
        PageFactory.initElements(new AppiumFieldDecorator(DriverUtil.getDefaultWebDriver()),this);

    }

    protected void clickOnElement(By locator) {
        DriverUtil.getDefaultWebDriver().findElement(locator).click();
    }

    protected void clickOnElement(WebElement element) {
        element.click();
    }

    protected void swipeToElement(WebElement form, WebElement to) {
        touchAction
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(form))
                        .withDuration(Duration.ofSeconds(2)))
                .moveTo(ElementOption.element(to))
                .release()
                .perform();

    }
    protected void swipeToElement(By form, By to) {
        touchAction
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(DriverUtil.getDefaultWebDriver().findElement(form)))
                        .withDuration(Duration.ofSeconds(2)))
                .moveTo(ElementOption.element(DriverUtil.getDefaultWebDriver().findElement(to)))
                .release()
                .perform();

    }

//    protected void scrollIntoViewByText(String text) {
//        String script = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"%s\"))";
//        driver.findElement(MobileBy.
//                AndroidUIAutomator(String.format(script, text)));
//
//    }

    protected void clearAndSendKeys(WebElement webElement, String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }
    public void swipeDown() {
        touchAction.press(PointOption.point(300, 1000)).waitAction().moveTo(PointOption.point(300,50)).release().perform();
    }

    public  void swipeInvert() {
        touchAction.press(PointOption.point(300,50)).waitAction().moveTo(PointOption.point(300, 1000)).release().perform();
    }

    public void swipeDownNTimesElementIsVisible(WebElement webElement){
        int retry = 0;
        while (retry<5){
            try {
                clickOnElement(webElement);
                break;
            }catch (NoSuchElementException noSuchElementException){
                swipeDown();
                retry++;
            }
        }

    }
    public void dragFromTo(WebElement from, WebElement to){
        touchAction.longPress(ElementOption.element(from)).moveTo(ElementOption.element(to)).release().perform();
    }

    public void goToGoogle(){
        DriverUtil.getDefaultWebDriver().get("https://www.google.com/");
    }
}
