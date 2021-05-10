package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import screens.HomeScreen;
import screens.PreferencesScreen;
import screens.WifiScreen;


public class WifiTests  {
    HomeScreen homeScreen = new HomeScreen();
    PreferencesScreen preferencesScreen = new PreferencesScreen();
    WifiScreen wifiScreen = new WifiScreen();


    @When("I enable the wifi option")
    public void enableWifi() {
        homeScreen.navigateToPreferencesScreen();
        preferencesScreen.navigateToWifiScreen();
        wifiScreen.checkWifiOption();
        wifiScreen.clickOnSettings();

    }

    @And("I enter wifi setting {string}")
    public void enterWifiSettings(String setting) {
        wifiScreen.enterWifiSettings(setting);

    }

    @Then("I should have connected to wifi")
    public void verifyWifi() {

    }

}
