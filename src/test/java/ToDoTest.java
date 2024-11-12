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
        HomePage homePage = new HomePage(driver);
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
        toDoPage.addNewTodo("❤️");
        toDoPage.takeScreenshot(driver, "emoji.png");
    }



    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
