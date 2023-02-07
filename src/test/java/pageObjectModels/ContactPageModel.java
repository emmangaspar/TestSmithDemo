package pageObjectModels;

import helper.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPageModel extends HelperClass {
    public ContactPageModel(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    public final By SubjectCombobox = By.cssSelector("select#subject");
    public final By MessageTextArea = By.cssSelector("textarea#message");
    public final By SendButton = By.cssSelector("input[value='Send']");

    public void setMessage(String subject, String message){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.SubjectCombobox));
        driver.findElement(this.SubjectCombobox).sendKeys(subject);
        driver.findElement(this.MessageTextArea).sendKeys(message);
        driver.findElement(this.SendButton).click();
    }
}
