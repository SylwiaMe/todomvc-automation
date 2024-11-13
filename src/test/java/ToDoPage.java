import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class ToDoPage {

    protected WebDriver driver;
    public final By inputBoxBy = By.className("new-todo");
    public final By toDoCountBy = By.className("todo-count");

    public ToDoPage(WebDriver driver) {
        this.driver = driver;
    }

    // adding new 'todo item'
    public void addNewTodo(String newToDo) {
        WebElement inputContainer = driver.findElement(inputBoxBy);
        inputContainer.sendKeys(newToDo + Keys.ENTER);
    }
    public Boolean isToDoCountHidden() {
        List<WebElement> toDoCountElements = driver.findElements(toDoCountBy);
        return toDoCountElements.isEmpty();
    }

    public String retrieveToDoCount() {
        WebElement toDoCount = driver.findElement(toDoCountBy);
        return toDoCount.getText();
    }

    public void takeScreenshot  (WebDriver webdriver, String desiredPath) throws Exception{
        TakesScreenshot screenshot = ((TakesScreenshot)webdriver);
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(desiredPath);
        FileUtils.copyFile(screenshotFile, targetFile);
    }
}
