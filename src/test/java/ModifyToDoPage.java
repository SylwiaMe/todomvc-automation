import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Objects;

public class ModifyToDoPage {

    protected WebDriver driver;
    public final By toDoListBy = By.className("todo-list");

    public ModifyToDoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void editToDo(String currentText, String newText) throws Exception {
        Actions actions = new Actions(driver);
        WebElement toDoList = driver.findElement(toDoListBy);
        List<WebElement> toDoItems = toDoList.findElements(By.tagName("label"));
        System.out.println(toDoItems);
        for (WebElement toDoItem: toDoItems) {
            System.out.println(toDoItem.getText());
            if (Objects.equals(toDoItem.getText(), currentText)) {
                actions.doubleClick(toDoItem).perform();
                Thread.sleep(1200);
                WebElement editToDoInput = toDoList.findElement(By.tagName("input"));
                editToDoInput.sendKeys(newText + Keys.ENTER);
            }
        }
    }
}
