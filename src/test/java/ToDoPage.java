import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.time.Duration;

public class ToDoPage {

    protected WebDriver driver;
//    public final By toDoInputBoxBy = By.id("input-box");
public final By inputBoxBy = By.className("new-todo");

    public ToDoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToSite() {

        driver.get("https://todomvc.com/examples/react/dist/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    // adding new 'todo item'
    public void addNewTodo(String newToDo) {

        WebElement inputContainer = driver.findElement(inputBoxBy);
        inputContainer.sendKeys(newToDo + Keys.ENTER);

    }
    public void takeScreenshot  (WebDriver webdriver, String desiredPath) throws Exception{
        TakesScreenshot screenshot = ((TakesScreenshot)webdriver);
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(desiredPath);
        FileUtils.copyFile(screenshotFile, targetFile);
    }
}
