package pageObjectModels;

import helper.HelperClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePageModel extends HelperClass {
    public ProfilePageModel(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    // Profile
    public final By FirstNameTextbox = new By.ById("first_name");
    public final By LastNameTextbox = new  By.ById("last_name");
    public final By EmailTextbox = new  By.ById("email");
    public final By PhoneTextbox = new By.ById("phone");
    public final By AddressTextbox = new By.ById("address");
    public final By PostcodeTextbox = new By.ById("postcode");
    public final By CityTextbox = new By.ById("city");
    public final By StateTextbox = new By.ById("state");
    public final By CountryTextbox = new By.ById("country");
    public final By UpdateProfileButton = By.cssSelector("button[data-test='update-profile-submit']");

    // Password
    public final By CurrentPasswordTextbox = new By.ById("current-password");
    public final By NewPasswordTextbox = new By.ById("new-password");
    public final By ConfirmNewPasswordTextbox = new By.ById("new-password-confirm");
    public final By ChangePasswordButton = By.cssSelector("button[data-test='change-password-submit']");

    public void updateFirstAndLastName(String firstname, String lastname){
        TestSmithDemoMainPageModel testSmithDemoMainPageModel = new TestSmithDemoMainPageModel(driver, wait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.FirstNameTextbox));
        testSmithDemoMainPageModel.setTextbox(this.FirstNameTextbox, firstname);
        testSmithDemoMainPageModel.setTextbox(this.LastNameTextbox, lastname);
    }
    public void updateAddressDetails(String address, String city, String state, String country, String postCode){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.AddressTextbox));
        driver.findElement(this.AddressTextbox).clear();
        driver.findElement(this.AddressTextbox).sendKeys(address);
        driver.findElement(this.CityTextbox).clear();
        driver.findElement(this.CityTextbox).sendKeys(city);
        driver.findElement(this.StateTextbox).clear();
        driver.findElement(this.StateTextbox).sendKeys(state);
        driver.findElement(this.CountryTextbox).clear();
        driver.findElement(this.CountryTextbox).sendKeys(country);
        driver.findElement(this.PostcodeTextbox).clear();
        driver.findElement(this.PostcodeTextbox).sendKeys(postCode);
    }
    public void updatePhoneNumber(String phoneNumber){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.PhoneTextbox));
        driver.findElement(this.PhoneTextbox).clear();
        driver.findElement(this.PhoneTextbox).sendKeys(phoneNumber);
    }
    public void clickUpdateProfileButton(){
        TestSmithDemoMainPageModel testSmithDemoMainPageModel = new TestSmithDemoMainPageModel(driver, wait);
        driver.findElement(this.UpdateProfileButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(testSmithDemoMainPageModel.SuccessStatusMessageLabel));
    }

}
