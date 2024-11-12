import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeTest {

    private static WebDriver driver;

    @BeforeAll
    static void launchBrowser() {
        driver = new ChromeDriver();
    }

    @Test
    public void viewReactFramework() {
        driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
