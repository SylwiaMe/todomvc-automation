import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToDoPage {

    protected WebDriver driver;
//    public final By toDoInputBoxBy = By.id("input-box");

    public ToDoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToSite() {
        driver.get("https://todomvc.com/");
    }
}
