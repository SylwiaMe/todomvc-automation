import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AddAndViewTest {

    private static WebDriver driver;

    @BeforeAll
    static void launchBrowser() {
        driver = new FirefoxDriver();
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
    public void emptyToDo() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addNewTodo(" ");
        assertTrue(toDoPage.isToDoCountHidden());
        toDoPage.takeScreenshot(driver, "emptyToDo.png");

    }
    @Test
    public void characterLimitNoSpaces() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addToDoSpecifiedLength(20, "tttttttttt");
        assertTrue(toDoPage.retrieveToDoCount().contains("1 item left"));
        toDoPage.addToDoSpecifiedLength(100, "tttttttttt");
        assertTrue(toDoPage.retrieveToDoCount().contains("2 items left"));
        toDoPage.addToDoSpecifiedLength(5000, "tttttttttt");
        assertTrue(toDoPage.retrieveToDoCount().contains("3 items left"));
        toDoPage.takeScreenshot(driver, "char-limit.png");
    }

    @Test
    public void characterLimitWithSpaces() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.addToDoSpecifiedLength(100, "mop clean cook running konstantynopolitanczykowianeczka ");
        assertTrue(toDoPage.retrieveToDoCount().contains("1 item left"));
        toDoPage.addToDoSpecifiedLength(1000, "mop clean cook running ");
        assertTrue(toDoPage.retrieveToDoCount().contains("2 items left"));
        toDoPage.addToDoSpecifiedLength(5000, "mop clean cook running ");
        assertTrue(toDoPage.retrieveToDoCount().contains("3 items left"));
        toDoPage.takeScreenshot(driver, "charNoLimitSpaces.png");
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

    @Test
    public void checkEmojisRenderCorrectly() {
        String[] emojis = {"\uD83D\uDE17", "\uD83D\uDE03", "\uD83E\uDD2A"};
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        ArrayList<String> wronglyRenderedEmojis = toDoPage.findWronglyRenderedChars(emojis);
        if (!wronglyRenderedEmojis.isEmpty()) {
            System.out.println("Strings that failed: " + wronglyRenderedEmojis);
        }
        assertEquals(wronglyRenderedEmojis.size(),0);
        assertTrue(toDoPage.retrieveToDoCount().contains(emojis.length + " items left"));
    }

    @Test
    public void checkSpecialCharsRenderCorrectly() {
        String[] specialCharStrings = {">>>>", "<<<<", "&&&&", ";;;;", "!!!!", "[][]", "{}{}", "////", ",,,,", "::::", "....", "''''", "****", "^^^^", "$$$$", "££££", "++++", "----"};
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        ArrayList<String> wronglyRenderedStrings = toDoPage.findWronglyRenderedChars(specialCharStrings);
        if (!wronglyRenderedStrings.isEmpty()) {
            System.out.println("Strings that failed: " + wronglyRenderedStrings);
        }
        // test currently fails for several strings (see README.md)
        assertEquals(wronglyRenderedStrings.size(),0);
        assertTrue(toDoPage.retrieveToDoCount().contains(specialCharStrings.length + " items left"));
    }

    @Test
    public void checkAccentedCharsRenderCorrectly() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToReact();
        ToDoPage toDoPage = new ToDoPage(driver);
        String[] accentedCharStrings = {"àáâäǎæãåā", "èéêëěẽēėę", "ìíîïǐĩīıį", "òóôöǒœøõō", "ùúûüǔũūűů", "çćčċ", "ñńņň", "ßşșśš", "ğġ", "źžż", "ŵŵ", "řř", "țťþ", "ýŷÿ", "ďð", "ħħ", "ķķ", "łļľ"};
        ArrayList<String> wronglyRenderedStrings = toDoPage.findWronglyRenderedChars(accentedCharStrings);
        if (!wronglyRenderedStrings.isEmpty()) {
            System.out.println("Strings that failed: " + wronglyRenderedStrings);
        }
        assertEquals(wronglyRenderedStrings.size(),0);
        assertTrue(toDoPage.retrieveToDoCount().contains(accentedCharStrings.length + " items left"));
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}
