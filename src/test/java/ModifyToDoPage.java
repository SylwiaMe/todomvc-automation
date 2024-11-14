import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Objects;

public class ModifyToDoPage {

    protected WebDriver driver;
    public final By toDoListBy = By.className("todo-list");
    public final By allFilterBy = By.linkText("All");
    public final By activeFilterBy = By.linkText("Active");
    public final By completedFilterBy = By.linkText("Completed");

    public ModifyToDoPage(WebDriver driver) {
        this.driver = driver;
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

    public List<WebElement> retrieveToDoElements() {
        WebElement toDoList = driver.findElement(toDoListBy);
        return toDoList.findElements(By.className("view"));
    }

    public Integer countVisibleToDos() {
        WebElement toDoList = driver.findElement(toDoListBy);
        List<WebElement> toDoItems = toDoList.findElements(By.className("view"));
        return toDoItems.size();
    }
}