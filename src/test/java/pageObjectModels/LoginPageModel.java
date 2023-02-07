package pageObjectModels;

import org.openqa.selenium.By;

public class LoginPage {
    // Login Panel
    public final By TestSmithDemoLogo = By.cssSelector("svg[xmlns='http://www.w3.org/2000/svg']");
    public final By YourEmailTextbox = By.cssSelector("input[data-test='email']");
    public final By YourPassword = By.cssSelector("input#password");
    public final By LoginButton = By.cssSelector("input[data-test='login-submit']");
    public final By RegisterYourAccountLink = By.cssSelector("a[data-test='register-link']");
    public final By ForgotYourPasswordLink = By.cssSelector("a[data-test='forgot-password-link']");

    // Footer
    public final By GitHubRepoLink = By.cssSelector("a[href='https://github.com/testsmith-io/practice-software-testing']");
    public final By BarnImagesLink = By.cssSelector("a[href='https://unsplash.com/@barnimages']");
    public final By UnsplashLink = By.cssSelector("a[href='https://unsplash.com/photos/t5YUoHW6zRo']");
}
