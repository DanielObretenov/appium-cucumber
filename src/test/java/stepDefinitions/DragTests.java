package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import screens.*;

public class DragTests {
    HomeScreen homeScreen = new HomeScreen();
    ViewsScreen viewsScreen = new ViewsScreen();
    DragScreen dragScreen = new DragScreen();
    @Given("I am on the dragging page")
    public void navigateToDraggingPage() {
        homeScreen.goToGoogle();

        homeScreen.navigateToViewsScreen();
        viewsScreen.navigateToDragScreen();
    }

    @When("I drag from {int} to {int}")
    public void dragFromTo(Integer from, Integer to) {
        dragScreen.dragElement(from,to);
    }

    @Then("The element should be dragged")
    public void verifyElementIsDragged() {
    }
}
