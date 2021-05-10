package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class ViewsScreen extends HomeScreen {
    @FindBy(xpath = "//android.widget.TextView[@text='Date Widgets']")
    WebElement dateWidgetScreenButton;
    @FindBy(xpath = "//android.widget.TextView[@text='WebView']")
    WebElement WebViewButton;
    @FindBy(xpath = "//android.widget.TextView[@text='Drag and Drop']")
    WebElement DragAndDropButton;


    public void navigateToDataWidgetsScreen() {

        clickOnElement(dateWidgetScreenButton);
    }
    public void scrollToAGivenElement(){
        swipeDownNTimesElementIsVisible(WebViewButton);
    }

    public void navigateToDragScreen() {
        clickOnElement(DragAndDropButton);
    }
}
