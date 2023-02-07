package hooks;

import helper.HelperClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest extends HelperClass {

    @BeforeEach
    public void InitializeTest(){
        WebDriverManager.chromedriver().setup();
        driverOptions = new ChromeOptions();
        driverOptions.addArguments(HelperClass.EnableHeadless);
        driverOptions.addArguments(HelperClass.Resolution);
        driver = new ChromeDriver(driverOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Opening browser
        driver.get(HelperClass.BaseURL);
    }
    @AfterEach
    public void EndTest(){
        // Closing app
        driver.quit();
    }
}
