import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ModifyToDoTest {

    private static WebDriver driver;

    @BeforeAll
    static void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void deleteToDo() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addNewTodo("homework");
        toDoPage.addNewTodo("laundry");
        toDoPage.addNewTodo("washing up");
        ModifyToDoPage modifyToDoPage = new ModifyToDoPage(driver);
        modifyToDoPage.deleteToDo("laundry");
        assertTrue(toDoPage.retrieveToDoCount().contains("2 items left"));
    }

    @Test
    public void editToDoText() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addNewTodo("homework");
        toDoPage.addNewTodo("laundry");
        toDoPage.addNewTodo("washing up");
        ModifyToDoPage modifyToDoPage = new ModifyToDoPage(driver);
        modifyToDoPage.editToDo("homework", " and sleep");
        modifyToDoPage.editToDo("laundry", " and netflix");
        modifyToDoPage.editToDo("washing up", " and xbox");
        toDoPage.takeScreenshot(driver, "edit-to-do.png");
    }


    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
