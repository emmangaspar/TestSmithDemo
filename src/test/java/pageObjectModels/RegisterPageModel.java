package pageObjectModels;

import helper.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RegisterPageModel extends HelperClass {
    public RegisterPageModel(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    // Customer Registration
    public final By FirstnameTextbox = By.cssSelector("input#first_name");
    public final By LastnameTextbox = By.cssSelector("input#last_name");
    public final By DateOfBirthCombobox = By.cssSelector("input#dob");
    public final By AddressTextbox = By.cssSelector("input#address");
    public final By PostcodeTextbox = By.cssSelector("input#postcode");
    public final By CityTextbox = By.cssSelector("input#city");

    public final By StateTextbox = By.cssSelector("input#state");
    public final By CountryCombobox = By.cssSelector("select#country");
    public final By PhoneTextbox = By.cssSelector("input#phone");
    public final By EmailTextbox = By.cssSelector("input#email");
    public final By PasswordTextbox = By.cssSelector("input#password");
    public final By RegisterButton = By.cssSelector("button[type='submit']");
    public String registerRandomUser(){
        String email = userData.EMAIL.toString();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.EmailTextbox));
        driver.findElement(this.FirstnameTextbox).sendKeys(userData.FIRSTNAME.toString());
        driver.findElement(this.LastnameTextbox).sendKeys(userData.LASTNAME.toString());
        driver.findElement(this.DateOfBirthCombobox).sendKeys(userData.DATEOFBIRTH.toString());
        driver.findElement(this.AddressTextbox).sendKeys(userData.ADDRESS.toString());
        driver.findElement(this.PostcodeTextbox).sendKeys(userData.POSTALCODE.toString());
        driver.findElement(this.CityTextbox).sendKeys(userData.CITY.toString());
        driver.findElement(this.StateTextbox).sendKeys(userData.STATE.toString());
        driver.findElement(this.CountryCombobox).sendKeys(userData.COUNTRY.toString());
        driver.findElement(this.PhoneTextbox).sendKeys(userData.PHONE.toString());
        driver.findElement(this.EmailTextbox).sendKeys(email);
        driver.findElement(this.EmailTextbox).sendKeys(Keys.TAB);
        driver.findElement(this.PasswordTextbox).sendKeys(userData.PASSWORD.toString());
        wait.until(ExpectedConditions.textToBePresentInElementValue(this.EmailTextbox, email));
        driver.findElement(this.RegisterButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(this.RegisterButton));
        System.out.println("Email Address: " + email);
        System.out.println("Password: " + userData.PASSWORD.toString());
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        return email;
    }
}
