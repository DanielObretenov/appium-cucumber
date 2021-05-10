package screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DragScreen extends ViewsScreen{
    @FindBy(className = "android.view.View")
    List<WebElement> dragElements;

    public void dragElement(Integer from, Integer to){

        dragFromTo(dragElements.get(from-1),dragElements.get(to-1));
    }


}
