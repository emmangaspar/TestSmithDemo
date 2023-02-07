package pageObjectModels;

import helper.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CheckoutCartPageModel extends HelperClass {
    public CheckoutCartPageModel(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    // Cart
    public final By CartTable = By.cssSelector("table.table.table-hover");
    public final By ProceedToCheckoutButton = By.cssSelector("button[data-test='proceed-1']");

    // Sign In
    public final By SignInProceedToCheckoutButton = By.cssSelector("button[data-test='proceed-2']");
    public final By CheckoutNoteLabel = By.cssSelector("div[class='wizard-steps horizontal'] p");

    // Billing Address
    public final By AddressTextbox = By.cssSelector("input#address");
    public final By CityTextbox = By.cssSelector("input#city");
    public final By StateTextbox = By.cssSelector("input#state");
    public final By CountryTextbox = By.cssSelector("input#country");
    public final By PostCodeTextbox = By.cssSelector("input#postcode");
    public final By BillingProceedToCheckoutButton = By.cssSelector("button[data-test='proceed-3']");

    // Payment
    public final By PaymentTypeCombobox = By.cssSelector("select#payment-method");
    public final By AccountNameTextbox = By.cssSelector("input#account-name");
    public final By AccountNumberTextbox = By.cssSelector("input#account-number");
    public final By ConfirmButton = By.cssSelector("button[data-test='finish']");
    public final By PaymentSuccessMessageLabel = By.cssSelector("div.alert.alert-success");

    public void clickProceedToCheckoutButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.ProceedToCheckoutButton));
        driver.findElement(this.ProceedToCheckoutButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(this.CartTable));
    }
    public void clickSignInProceedToCheckoutButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.SignInProceedToCheckoutButton));
        driver.findElement(this.SignInProceedToCheckoutButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(this.CheckoutNoteLabel));
    }

    // Sending keys for Billing Address
    public void setBillingAddress(String address, String city, String state, String country, String postCode){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.AddressTextbox));
        driver.findElement(this.AddressTextbox).sendKeys(address);
        driver.findElement(this.CityTextbox).sendKeys(city);
        driver.findElement(this.StateTextbox).sendKeys(state);
        driver.findElement(this.CountryTextbox).sendKeys(country);
        driver.findElement(this.PostCodeTextbox).sendKeys(postCode);
    }
    public void clickBillingProceedToCheckoutButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.AddressTextbox));
        driver.findElement(this.BillingProceedToCheckoutButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(this.AddressTextbox));
    }

    public void setPaymentInfoAndConfirm(String paymentType, String accountName, String accountNumber){
        TestSmithDemoMainPageModel testSmithDemoMainPageModel = new TestSmithDemoMainPageModel(driver, wait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.PaymentTypeCombobox));
        driver.findElement(this.PaymentTypeCombobox).sendKeys(paymentType);
        driver.findElement(this.AccountNameTextbox).sendKeys(accountName);
        driver.findElement(this.AccountNumberTextbox).sendKeys(accountNumber);
        driver.findElement(this.ConfirmButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(testSmithDemoMainPageModel.SuccessStatusMessageLabel));
    }
}
