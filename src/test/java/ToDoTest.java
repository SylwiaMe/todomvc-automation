import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoTest {

    private static WebDriver driver;

    @BeforeAll
    static void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void visitSite() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.takeScreenshot(driver, "todomvc.png");
    }

    @Test
    public void addEmoji() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addNewTodo("❤\uFE0F");
        assertTrue(toDoPage.retrieveToDoCount().contains("1 item left"));
        toDoPage.takeScreenshot(driver, "emoji.png");
    }
    @Test
    public void emptyToDo() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addNewTodo(" ");
        assertTrue(toDoPage.isToDoCountHidden());
        toDoPage.takeScreenshot(driver, "emptyToDo.png");

    }

    @Test
    public void addSpecialChars() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addNewTodo("&;/><");
        assertTrue(toDoPage.retrieveToDoCount().contains("1 item left"));
        toDoPage.takeScreenshot(driver, "special-chars.png");
    }

    @Test
    public void addAccentedChars() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addNewTodo("àâ");
        assertTrue(toDoPage.retrieveToDoCount().contains("1 item left"));
        toDoPage.takeScreenshot(driver, "accented-chars.png");
    }

    @Test
    public void checkToDoCount() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        for (int i = 1; i <= 100; i++) {
            toDoPage.addNewTodo("test" + i);
            String itemsWord = (i == 1) ? "item" : "items";
            String expectedItemsLeft = i + " " + itemsWord + " left";
            assertTrue(toDoPage.retrieveToDoCount().contains(expectedItemsLeft));
        }
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
