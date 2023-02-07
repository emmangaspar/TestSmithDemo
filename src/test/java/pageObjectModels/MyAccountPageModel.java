package pageObjectModels;

import helper.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyAccountPageModel extends HelperClass {
    public MyAccountPageModel(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    // My Account
    public By DynamicNavigationLink(String option){ return By.cssSelector("a[data-test="+option+"]");}

    /**
     * Parameters for navigation:
     * Favorites - nav-favorites
     * Profile - nav-profile
     * Invoices - nav-invoices
     * Messages - nav-messages
     * */
    public void myAccountNavigation(String option){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.DynamicNavigationLink(option)));
        driver.findElement(this.DynamicNavigationLink(option)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(this.DynamicNavigationLink(option)));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
}
