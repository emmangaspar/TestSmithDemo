package pageObjectModels;

import helper.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSmithDemoPageModel extends HelperClass {
    public TestSmithDemoPageModel(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    // Header
    public final By TestSmithDemoHeaderButton = By.cssSelector("a[title='Practice Software Testing - Toolshop']");
    //public final By NavigationButton = By.cssSelector("button[aria-controls='navbarSupportedContent']");

    // Navigation
    public final By DynamicNavigationLink(String option) { return By.cssSelector("div#navbarSupportedContent a[data-test="+option+"]"); }

    public final By HomeLink = By.cssSelector("div#navbarSupportedContent a[data-test='nav-home']");
    public final By CategoriesLink = By.cssSelector("div#navbarSupportedContent a[data-test='nav-categories']");
    public final By HandToolsLink = By.cssSelector("div#navbarSupportedContent a[data-test='nav-hand-tools']");
    public final By PowerToolsLink = By.cssSelector("div#navbarSupportedContent a[data-test='nav-power-tools']");
    public final By SpecialToolsLink = By.cssSelector("div#navbarSupportedContent a[data-test='nav-special-tools']");
    public final By RentalsLink = By.cssSelector("div#navbarSupportedContent a[data-test='nav-rentals']");
    public final By ContactLink = By.cssSelector("div#navbarSupportedContent a[data-test='nav-contact']");
    public final By SignInLink = By.cssSelector("div#navbarSupportedContent a[data-test='nav-sign-in']");

    // Body
    public final By SortCombobox = By.cssSelector("select[data-test='sort']");
    public final By PriceRangeSlider = By.cssSelector("ngx-slider[aria-label='ngx-slider'] span[class='ngx-slider-span ngx-slider-bar-wrapper ngx-slider-left-out-selection']");
    public final By SearchTextbox = By.cssSelector("input[data-test='search-query']");
    public final By SearchResetButton = By.cssSelector("button[data-test='search-reset']");
    public final By SearchButton = By.cssSelector("button[data-test='search-submit']");

    //public final By PriceRangeSlider(int index){return By.cssSelector("button[aria-controls='navbarSupportedContent']")};

    // By category
    public final By DynamicCategoryCheckbox(int index){ return By.cssSelector("input[class='icheck'][value=${index.toString()}]");}

    // Hand Tools
    public final By HammerCheckbox = By.cssSelector("input[class='icheck'][value='3']");
    public final By HandSawCheckbox = By.cssSelector("input[class='icheck'][value='4']");
    public final By WrenchCheckbox = By.cssSelector("input[class='icheck'][value='5']");
    public final By ScrewdriverCheckbox = By.cssSelector("input[class='icheck'][value='6']");
    public final By PliersCheckbox = By.cssSelector("input[class='icheck'][value='7']");

    // Power Tools
    public final By GrinderCheckbox = By.cssSelector("input[class='icheck'][value='8']");
    public final By SanderCheckbox = By.cssSelector("input[class='icheck'][value='9']");
    public final By SawCheckbox = By.cssSelector("input[class='icheck'][value='10']");
    public final By DrillCheckbox = By.cssSelector("input[class='icheck'][value='11']");

    // Other
    public final By BrandnameOneCheckbox = By.cssSelector("input[class='icheck'][value='12']");
    public final By BrandnameTwoCheckbox = By.cssSelector("input[class='icheck'][value='13']");

    /**
     * Parameters for navigation:
     * Home - nav-home
     * Categories - nav-categories
     * Contact - nav-contact
     * Sign in - nav-sign-in
     * */
    public void navigateTo(String option){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.DynamicNavigationLink(option)));
        driver.findElement(this.DynamicNavigationLink(option));
    }
}
