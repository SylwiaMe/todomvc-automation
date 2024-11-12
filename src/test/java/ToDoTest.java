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
    public void visitSite() {
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.navigateToSite();
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
