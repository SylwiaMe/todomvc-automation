import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ModifyAndClearTest {

    private static WebDriver driver;

    @BeforeAll
    static void launchBrowser() {
        driver = new FirefoxDriver();
        // cannot use chrome driver for special char/emoji tests
        // chrome driver doesn't allow special char/emoji for text input
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void deleteToDo() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addNewTodo("homework");
        toDoPage.addNewTodo("laundry");
        toDoPage.addNewTodo("washing up");
        toDoPage.deleteToDo("laundry");
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
        toDoPage.editToDo("homework", " and sleep");
        toDoPage.editToDo("laundry", " and netflix");
        toDoPage.editToDo("washing up", " and xbox");
        toDoPage.takeScreenshot(driver, "edit-to-do.png");
    }

    @Test
    public void filterByCompleted() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addNewTodo("homework");
        toDoPage.addNewTodo("laundry");
        toDoPage.filterByCompleted();
        assertEquals(0, toDoPage.countVisibleToDos());
        toDoPage.disableFilter();
        toDoPage.markAllAsComplete();
        assertEquals(2, toDoPage.countVisibleToDos());
        toDoPage.filterByCompleted();
        assertEquals(2, toDoPage.countVisibleToDos());
    }

    @Test
    public void filterByActive() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addNewTodo("homework");
        toDoPage.addNewTodo("laundry");
        assertEquals(2, toDoPage.countVisibleToDos());
        toDoPage.filterByActive();
        assertEquals(2, toDoPage.countVisibleToDos());
        toDoPage.markAllAsComplete();
        assertEquals(0, toDoPage.countVisibleToDos());
        toDoPage.disableFilter();
        assertEquals(2, toDoPage.countVisibleToDos());
    }

    @Test
    public void markIndividualItemAsComplete() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addNewTodo("homework");
        toDoPage.addNewTodo("laundry");
        toDoPage.markItemAsComplete("laundry");
        assertEquals(toDoPage.countVisibleToDos(), 2);
        assertTrue(toDoPage.retrieveToDoCount().contains("1 item left"));
        toDoPage.filterByCompleted();
        assertEquals(toDoPage.countVisibleToDos(), 1);
        toDoPage.disableFilter();
        toDoPage.markItemAsComplete("homework");
        assertTrue(toDoPage.retrieveToDoCount().contains("0 items left"));
        toDoPage.filterByCompleted();
        assertEquals(toDoPage.countVisibleToDos(), 2);
    }

    @Test
    public void markOneItemThenAllAsComplete() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addNewTodo("homework");
        toDoPage.addNewTodo("laundry");
        toDoPage.markItemAsComplete("laundry");
        assertEquals(toDoPage.countVisibleToDos(), 2);
        assertTrue(toDoPage.retrieveToDoCount().contains("1 item left"));
        toDoPage.markAllAsComplete();
        assertEquals(toDoPage.countVisibleToDos(), 2);
        assertTrue(toDoPage.retrieveToDoCount().contains("0 items left"));
        toDoPage.filterByCompleted();
        assertEquals(toDoPage.countVisibleToDos(), 2);
        assertTrue(toDoPage.retrieveToDoCount().contains("0 items left"));
    }

    @Test
    public void markAllComplete() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addNewTodo("Task1");
        toDoPage.addNewTodo("Task2");
        toDoPage.addNewTodo("Task3");
        assertTrue(toDoPage.retrieveToDoCount().contains("3 items left"));
        toDoPage.markAllAsComplete();
        assertTrue(toDoPage.retrieveToDoCount().contains("0 items left"));
        toDoPage.markAllAsComplete();
        assertTrue(toDoPage.retrieveToDoCount().contains("3 items left"));
        toDoPage.takeScreenshot(driver, "markAllComplete.png");
    }

    @Test
    public void clearCompletedToDos() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addNewTodo("Task1");
        toDoPage.addNewTodo("Task2");
        toDoPage.addNewTodo("Task3");
        assertTrue(toDoPage.retrieveToDoCount().contains("3 items left"));
        toDoPage.markAllAsComplete();
        toDoPage.pressClearCompleted();
        assertEquals(toDoPage.countVisibleToDos(),0);
        toDoPage.takeScreenshot(driver, "clearCompleted.png");
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
