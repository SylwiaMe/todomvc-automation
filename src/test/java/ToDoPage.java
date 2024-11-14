import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class ToDoPage {

    protected WebDriver driver;

    public final By inputBoxBy = By.className("new-todo");
    public final By toDoCountBy = By.className("todo-count");
    public final By toggleAllBy = By.cssSelector("input[type=checkbox]");

    public ToDoPage(WebDriver driver) {
        this.driver = driver;
    }

    // method that adds a new ToDo item
    public void addNewTodo(String newToDo) {
        WebElement inputContainer = driver.findElement(inputBoxBy);
        inputContainer.sendKeys(newToDo + Keys.ENTER);
    }

    public void addToDoSpecifiedLength(Integer length, String input) {
        WebElement inputContainer = driver.findElement(inputBoxBy);
        for (int counter = 0; counter < (double) (length / 10); counter++) {
            inputContainer.sendKeys(input);
        }
        inputContainer.sendKeys(Keys.ENTER);
    }
    public void addToDoSpecifiedLengthWithSpaces(Integer length, String input) {
        WebElement inputContainer = driver.findElement(inputBoxBy);
        int loopLimit = (int) Math.ceil((double) length / input.length());
        for (int counter = 0; counter < loopLimit; counter++ ) {
            inputContainer.sendKeys(input);
        }
        inputContainer.sendKeys(Keys.ENTER);
    }

    public Boolean isToDoCountHidden() {
        List<WebElement> toDoCountElements = driver.findElements(toDoCountBy);
        return toDoCountElements.isEmpty();
    }
    // method that marks all ToDos as complete
    public void markAllAsComplete() {
        WebElement markAllButton = driver.findElement(toggleAllBy);
        markAllButton.click();
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
