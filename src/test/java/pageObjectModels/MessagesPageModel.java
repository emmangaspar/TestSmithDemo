package pageObjectModels;

import helper.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagesPageModel extends HelperClass {
    public MessagesPageModel(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    // Messages
    public By ContactFormLink = By.cssSelector("a[routerlink='/contact']");

    public void clickContactFormLink(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.ContactFormLink));
        driver.findElement(this.ContactFormLink).click();
    }
}
