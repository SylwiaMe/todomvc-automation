import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ToDoPage {

    protected WebDriver driver;

    public final By toDoListBy = By.className("todo-list");
    public final By inputBoxBy = By.className("new-todo");
    public final By toDoCountBy = By.className("todo-count");
    public final By allFilterBy = By.linkText("All");
    public final By activeFilterBy = By.linkText("Active");
    public final By completedFilterBy = By.linkText("Completed");
    public final By toggleAllBy = By.cssSelector("input[type=checkbox]");
    public final By clearCompletedBy = By.className("clear-completed");

    public ToDoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addNewTodo(String newToDo) {
        WebElement inputContainer = driver.findElement(inputBoxBy);
        inputContainer.sendKeys(newToDo + Keys.ENTER);
    }

    public void addToDoSpecifiedLength(Integer specifiedInputLength, String inputToRepeat) {
        WebElement inputContainer = driver.findElement(inputBoxBy);
        StringBuilder finalInputString = new StringBuilder(inputToRepeat);
        while (finalInputString.length() < specifiedInputLength) {
            finalInputString.append(inputToRepeat);
        }
        int charactersLeftToAdd = specifiedInputLength - finalInputString.length();
        if (charactersLeftToAdd > 0) {
            finalInputString.append(inputToRepeat, 0, charactersLeftToAdd);
        }
        inputContainer.sendKeys(finalInputString.toString() + Keys.ENTER);
    }

    public Boolean isToDoCountHidden() {
        List<WebElement> toDoCountElements = driver.findElements(toDoCountBy);
        return toDoCountElements.isEmpty();
    }

    public String retrieveToDoCount() {
        WebElement toDoCount = driver.findElement(toDoCountBy);
        return toDoCount.getText();
    }

    public List<WebElement> retrieveToDoElements() {
        WebElement toDoList = driver.findElement(toDoListBy);
        return toDoList.findElements(By.className("view"));
    }

    public Integer countVisibleToDos() {
        WebElement toDoList = driver.findElement(toDoListBy);
        List<WebElement> toDoItems = toDoList.findElements(By.className("view"));
        return toDoItems.size();
    }

    public void takeScreenshot(WebDriver webdriver, String desiredPath) throws Exception{
        TakesScreenshot screenshot = ((TakesScreenshot)webdriver);
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(desiredPath);
        FileUtils.copyFile(screenshotFile, targetFile);
    }

    public void deleteToDo(String itemToDelete) {
        Actions actions = new Actions(driver);
        WebElement toDoList = driver.findElement(toDoListBy);
        List<WebElement> toDoItems = toDoList.findElements(By.className("view"));
        for (WebElement toDoItem: toDoItems) {
            WebElement toDoLabel = toDoItem.findElement(By.tagName("label"));
            if (Objects.equals(toDoLabel.getText(), itemToDelete)) {
                actions.moveToElement(toDoItem).perform();
                toDoItem.findElement(By.className("destroy")).click();
            }
        }
    }

    public void editToDo(String currentText, String newText) throws Exception {
        Actions actions = new Actions(driver);
        WebElement toDoList = driver.findElement(toDoListBy);
        List<WebElement> toDoItems = toDoList.findElements(By.className("view"));
        for (WebElement toDoItem: toDoItems) {
            WebElement toDoLabel = toDoItem.findElement(By.tagName("label"));
            if (Objects.equals(toDoLabel.getText(), currentText)) {
                actions.doubleClick(toDoItem).perform();
                toDoItem.findElement(By.tagName("input")).sendKeys(newText + Keys.ENTER);
            }
        }
    }

    public void disableFilter() {
        WebElement filterByAllBtn = driver.findElement(allFilterBy);
        filterByAllBtn.click();
    }

    public void filterByActive() {
        WebElement filterByActiveBtn = driver.findElement(activeFilterBy);
        filterByActiveBtn.click();
    }

    public void filterByCompleted() {
        WebElement filterByCompletedBtn = driver.findElement(completedFilterBy);
        filterByCompletedBtn.click();
    }

    public void markItemAsComplete(String itemToDelete) {
        ToDoPage toDoPage = new ToDoPage(driver);
        List<WebElement> toDoItems = toDoPage.retrieveToDoElements();
        for (WebElement toDoItem: toDoItems) {
            WebElement toDoLabel = toDoItem.findElement(By.tagName("label"));
            if (Objects.equals(toDoLabel.getText(), itemToDelete)) {
                toDoItem.findElement(By.cssSelector("input[type=checkbox]")).click();
            }
        }
    }

    public void pressClearCompleted(){
        WebElement clearCompletedButton = driver.findElement(clearCompletedBy);
        clearCompletedButton.click();
    }

    public void markAllAsComplete() {
        WebElement markAllButton = driver.findElement(toggleAllBy);
        markAllButton.click();
    }

    public ArrayList<String> findWronglyRenderedChars(String[] inputs) {
        ToDoPage toDoPage = new ToDoPage(driver);
        for (String input: inputs) {
            toDoPage.addNewTodo(input);
        }
        List<WebElement> toDoItems = toDoPage.retrieveToDoElements();
        ArrayList<String> wronglyRenderedChars = new ArrayList<String>();
        for (int i = 0; i < toDoItems.size(); i++) {
            WebElement toDoLabel = toDoItems.get(i).findElement(By.tagName("label"));
            String renderedToDoText = toDoLabel.getText();
            if (!Objects.equals(renderedToDoText, inputs[i])) {
                wronglyRenderedChars.add("Input: " + inputs[i] + ", Output: " + renderedToDoText);
            }
        }
        return wronglyRenderedChars;
    }
}
