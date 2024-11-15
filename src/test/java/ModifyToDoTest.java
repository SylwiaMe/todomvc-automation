import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ModifyToDoTest {

    private static WebDriver driver;

    @BeforeAll
    static void launchBrowser() {
        driver = new FirefoxDriver();
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

    //Filtering: when viewing completed to dos (none), when there
    // are still active todos displays "X items left" even though no
    // to do elements are on screen

    @Test
    public void filterByCompleted() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addNewTodo("homework");
        toDoPage.addNewTodo("laundry");
        ModifyToDoPage modifyToDoPage = new ModifyToDoPage(driver);
        modifyToDoPage.filterByCompleted();
        assertEquals(0, modifyToDoPage.countVisibleToDos());
        modifyToDoPage.disableFilter();
        toDoPage.markAllAsComplete();
        assertEquals(2, modifyToDoPage.countVisibleToDos());
        modifyToDoPage.filterByCompleted();
        assertEquals(2, modifyToDoPage.countVisibleToDos());
    }

    @Test
    public void filterByActive() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addNewTodo("homework");
        toDoPage.addNewTodo("laundry");
        ModifyToDoPage modifyToDoPage = new ModifyToDoPage(driver);
        assertEquals(2, modifyToDoPage.countVisibleToDos());
        modifyToDoPage.filterByActive();
        assertEquals(2, modifyToDoPage.countVisibleToDos());
        toDoPage.markAllAsComplete();
        assertEquals(0, modifyToDoPage.countVisibleToDos());
        modifyToDoPage.disableFilter();
        assertEquals(2, modifyToDoPage.countVisibleToDos());
    }

    @Test
    public void checkEmojisRenderCorrectly() throws Exception {
        String[] emojis = {"\uD83D\uDE17", "\uD83D\uDE03", "\uD83E\uDD2A"};
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        for (String emoji: emojis) {
            toDoPage.addNewTodo(emoji);
        }
        toDoPage.takeScreenshot(driver, "rendered-emojis.png");
        ModifyToDoPage modifyToDoPage = new ModifyToDoPage(driver);
        List<WebElement> toDoItems = modifyToDoPage.retrieveToDoElements();
        for (int i = 0; i < toDoItems.size(); i++){
            WebElement toDoLabel = toDoItems.get(i).findElement(By.tagName("label"));
            assertEquals(toDoLabel.getText(), emojis[i]);
        }
    }

    @Test
    public void checkSpecialCharsRenderCorrectly() throws Exception {
        String[] specialCharStrings = {">>>>", "<<<<", "&&&&", ";;;;", "!!!!", "[][]", "{}{}", "////", ",,,,", "::::", "....", "''''", "****", "^^^^", "$$$$", "££££", "++++", "----"};
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        for (String specialCharString: specialCharStrings) {
            toDoPage.addNewTodo(specialCharString);
        }
        toDoPage.takeScreenshot(driver, "render-special-chars.png");
        ModifyToDoPage modifyToDoPage = new ModifyToDoPage(driver);
        List<WebElement> toDoItems = modifyToDoPage.retrieveToDoElements();
        for (int i = 0; i < toDoItems.size(); i++){
            WebElement toDoLabel = toDoItems.get(i).findElement(By.tagName("label"));
            System.out.println("Input: (" + specialCharStrings[i] + ") Output: (" + toDoLabel.getText() + ")");
        }
    }

    @Test
    public void checkAccentedCharsRenderCorrectly() throws Exception {
        String[] accentedCharStrings = {"àáâäǎæãåā", "èéêëěẽēėę", "ìíîïǐĩīıį", "òóôöǒœøõō", "ùúûüǔũūűů", "çćčċ", "ñńņň", "ßşșśš", "ğġ", "źžż", "ŵŵ", "řř", "țťþ", "ýŷÿ", "ďð", "ħħ", "ķķ", "łļľ"};
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        for (String accentedCharString: accentedCharStrings) {
            toDoPage.addNewTodo(accentedCharString);
        }
        toDoPage.takeScreenshot(driver, "render-accented-chars.png");
        ModifyToDoPage modifyToDoPage = new ModifyToDoPage(driver);
        List<WebElement> toDoItems = modifyToDoPage.retrieveToDoElements();
        for (int i = 0; i < toDoItems.size(); i++){
            WebElement toDoLabel = toDoItems.get(i).findElement(By.tagName("label"));
            System.out.println("Input: (" + accentedCharStrings[i] + ") Output: (" + toDoLabel.getText() + ")");
            assertEquals(toDoLabel.getText(), accentedCharStrings[i]);
        }
    }

    @Test
    public void markIndividualItemAsComplete() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addNewTodo("homework");
        toDoPage.addNewTodo("laundry");
        ModifyToDoPage modifyToDoPage = new ModifyToDoPage(driver);
        modifyToDoPage.markItemAsComplete("laundry");
        assertEquals(modifyToDoPage.countVisibleToDos(), 2);
        assertTrue(toDoPage.retrieveToDoCount().contains("1 item left"));
        modifyToDoPage.filterByCompleted();
        assertEquals(modifyToDoPage.countVisibleToDos(), 1);
        modifyToDoPage.disableFilter();
        modifyToDoPage.markItemAsComplete("homework");
        assertTrue(toDoPage.retrieveToDoCount().contains("0 items left"));
        modifyToDoPage.filterByCompleted();
        assertEquals(modifyToDoPage.countVisibleToDos(), 2);
    }

    @Test
    public void markOneItemThenAllAsComplete() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addNewTodo("homework");
        toDoPage.addNewTodo("laundry");
        ModifyToDoPage modifyToDoPage = new ModifyToDoPage(driver);
        modifyToDoPage.markItemAsComplete("laundry");
        assertEquals(modifyToDoPage.countVisibleToDos(), 2);
        assertTrue(toDoPage.retrieveToDoCount().contains("1 item left"));
        toDoPage.markAllAsComplete();
        assertEquals(modifyToDoPage.countVisibleToDos(), 2);
        assertTrue(toDoPage.retrieveToDoCount().contains("0 items left"));
        modifyToDoPage.filterByCompleted();
        assertEquals(modifyToDoPage.countVisibleToDos(), 2);
        assertTrue(toDoPage.retrieveToDoCount().contains("0 items left"));
    }


    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
