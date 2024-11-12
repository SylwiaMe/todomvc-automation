import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToDoTest {

    private static WebDriver driver;

    @BeforeAll
    static void launchBrowser() {

        driver = new ChromeDriver();
    }

    @Test
    public void visitSite() throws Exception {
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.navigateToSite();

        toDoPage.takeScreenshot(driver, "todomvc.png");
    }
    @Test
    public void addEmoji() throws Exception {
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.navigateToSite();

        toDoPage.addNewTodo("shower");
        toDoPage.addNewTodo("dishes");
        toDoPage.addNewTodo("35 books");
        toDoPage.addNewTodo("1");
        toDoPage.addNewTodo("ä");
        Thread.sleep(3000);
        toDoPage.takeScreenshot(driver, "emoji.png");
    }



    @AfterAll
    static void closeBrowser() {

        driver.quit();
    }
}
