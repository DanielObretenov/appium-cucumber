package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import screens.DateWidgetsScreen;
import screens.HomeScreen;
import screens.InlineClockScreen;
import screens.ViewsScreen;

public class ClockTests {

    HomeScreen homeScreen = new HomeScreen();
    ViewsScreen viewsScreen = new ViewsScreen();
    DateWidgetsScreen dateWidgetsScreen = new DateWidgetsScreen();
    InlineClockScreen inlineClockScreen = new InlineClockScreen();

    @Given("I am on the clock screen")
    public void iAmOnTheClockScreen() {
        homeScreen.navigateToViewsScreen();
        viewsScreen.navigateToDataWidgetsScreen();
        dateWidgetsScreen.navigateToInlineClock();
    }

    @When("I set the clock to {string}")
    public void iSetTheClockTo(String time) {
        inlineClockScreen.setTime(time);
    }

    @Then("I should see the new time set")
    public void iShouldSeeTheNewTimeSet() {
    }


}
