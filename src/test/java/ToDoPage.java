import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;

public class ToDoPage {

    protected WebDriver driver;
//    public final By toDoInputBoxBy = By.id("input-box");
public final By inputBoxBy = By.className("new-todo");

    public ToDoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToSite() throws InterruptedException {

        driver.get("https://todomvc.com/examples/react/dist/");
        Thread.sleep(5000);
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
