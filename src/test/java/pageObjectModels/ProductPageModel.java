package pageObjectModels;

import helper.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPageModel extends HelperClass {
    public ProductPageModel(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    public final By DecreaseQuantityButton = By.cssSelector("button#btn-decrease-quantity");
    public final By IncreaseQuantityButton = By.cssSelector("button#btn-increase-quantity");
    public final By QuantityTextbox = By.cssSelector("input[data-test='quantity']");
    public final By AddToCartButton = By.cssSelector("button#btn-add-to-cart");
    public final By AddToFavouritesButton = By.cssSelector("button#btn-add-to-favorites");

    public void addSelectedItemToCart(int quantity){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.QuantityTextbox));
        driver.findElement(this.QuantityTextbox).clear();
        driver.findElement(this.QuantityTextbox).sendKeys(String.valueOf(quantity));
        driver.findElement(this.AddToCartButton).click();
    }
}
