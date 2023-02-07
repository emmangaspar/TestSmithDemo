package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectModels.LoginPageModel;
import pageObjectModels.TestSmithDemoMainPageModel;

public class HelperClass {
    public static String TestTag = System.setProperty("Tag", "UISmoke").toString();
    public static String BaseURL = System.getProperty("ApplicationBaseURL").toString();
    public static String Resolution = System.getenv("resolution").toString();
    public static String EnableHeadless = System.getenv("enableHeadless").toString();
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static ChromeOptions driverOptions;
    public static String GenerateRandomEmail(){
        int randomNumber = (int)(Math.random() * 999);
        String email = "testsmithrandomuser" + randomNumber + "@gmail.com";
        System.out.println(email);
        return email;
    }
    public enum userData {
        FIRSTNAME {
            public final String toString(){
                return "TestSmith";
            }
        },
        LASTNAME {
            public final String toString(){
                return "Demo";
            }
        },
        DATEOFBIRTH {
            public final String toString(){
                return "01/01/1990";
            }
        },
        ADDRESS {
            public final String toString(){
                return "5F 6781 Insular Life Building Ayala Avenue, corner Paseo de Roxas";
            }
        },
        POSTALCODE {
            public final String toString(){
                return "1226";
            }
        },
        COUNTRY {
            public final String toString(){
                return "Philippines (the)";
            }
        },
        CITY {
            public final String toString(){
                return "Makati City";
            }
        },
        STATE {
            public final String toString(){
                return "Metro Manila";
            }
        },
        PHONE {
            public final String toString(){
                return "0234858400";
            }
        },
        EMAIL {
            public final String toString(){
                return GenerateRandomEmail();
            }
        },
        PASSWORD {
            public final String toString(){
                return "Sampleuser12345!";
            }
        }
    }
    public enum updatedUserData {
        FIRSTNAME {
            public final String toString(){
                return "updatedfirstname";
            }
        },
        LASTNAME {
            public final String toString(){
                return "updatedlastname";
            }
        },
        ADDRESS {
            public final String toString(){
                return "5F 6781 Insular Life Building Ayala Avenue, corner Paseo de Roxas";
            }
        },
        POSTALCODE {
            public final String toString(){
                return "1226";
            }
        },
        COUNTRY {
            public final String toString(){
                return "PH";
            }
        },
        CITY {
            public final String toString(){
                return "Makati City";
            }
        },
        STATE {
            public final String toString(){
                return "Metro Manila";
            }
        },
        PHONE {
            public final String toString(){
                return "0123456789";
            }
        }
    }
    public enum paymentMethod {
        PAYMENT_METHOD {
            public final String toString(){
                return "Bank Transfer";
            }
        },
        ACCOUNT_NAME {
            public final String toString(){
                return userData.FIRSTNAME.toString() + " " + userData.LASTNAME.toString();
            }
        },
        ACCOUNT_NUMBER {
            public final String toString(){
                return "23232";
            }
        },
    }
    public enum message {
        SUBJECT {
            public final String toString(){
                return "Customer service";
            }
        },
        MESSAGE {
            public final String toString(){
                return "This is a sample message with over fifty characters in total that will be used for testing the https://practicesoftwaretesting.com/ contacts page.";
            }
        }
    }
}
