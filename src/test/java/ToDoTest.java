import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToDoTest {

    private static WebDriver driver;

    @BeforeAll
    static void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
        toDoPage.addNewTodo("test");
        assertTrue(toDoPage.retrieveToDoCount().contains("1 item left"));
        toDoPage.addNewTodo("testt");
        assertTrue(toDoPage.retrieveToDoCount().contains("2 items left"));
        toDoPage.addNewTodo("testtt");
        assertTrue(toDoPage.retrieveToDoCount().contains("3 items left"));
        toDoPage.addNewTodo("testttt");
        assertTrue(toDoPage.retrieveToDoCount().contains("4 items left"));
        toDoPage.addNewTodo("testtttt");
        assertTrue(toDoPage.retrieveToDoCount().contains("5 items left"));
        toDoPage.addNewTodo("testttttt");
        assertTrue(toDoPage.retrieveToDoCount().contains("6 items left"));
        toDoPage.addNewTodo("testtttttt");
        assertTrue(toDoPage.retrieveToDoCount().contains("7 items left"));
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
