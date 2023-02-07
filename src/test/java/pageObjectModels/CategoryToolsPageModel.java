package pageObjectModels;

import helper.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryToolsPageModel extends HelperClass {
    public CategoryToolsPageModel(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    // Dynamic Category Tools example product string: "product-6"
    public final By DynamicCategoryItemButton(String option) { return By.cssSelector("div.container a[data-test="+option+"]");}

    /**
     * Parameters for selecting an item:
     * product-1
     * product-2
     * product-3
     * etc.
     * */
    public void selectACategoryItem(String option){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.DynamicCategoryItemButton(option)));
        driver.findElement(this.DynamicCategoryItemButton(option)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(this.DynamicCategoryItemButton(option)));
    }
}
