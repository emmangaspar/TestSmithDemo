package tests;
import helper.HelperClass;
import hooks.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjectModels.*;

public class TestSmithDemoTests extends BaseTest {

    @Test
    public void create_New_Random_User_CRUD(){
        // Instance of classes needed for the test method
        TestSmithDemoMainPageModel testSmithDemoMainPageModel = new TestSmithDemoMainPageModel(driver, wait);
        RegisterPageModel registerPageModel = new RegisterPageModel(driver, wait);
        LoginPageModel loginPageModel = new LoginPageModel(driver, wait);
        MyAccountPageModel myAccountPageModel = new MyAccountPageModel(driver, wait);
        ProfilePageModel profilePageModel = new ProfilePageModel(driver, wait);
        String password = userData.PASSWORD.toString();

        // Navigation to Login Page > Register Page
        testSmithDemoMainPageModel.navigateTo("nav-sign-in");
        loginPageModel.clickRegisterAccountLink();

        // Registration of randomized person
        String email = registerPageModel.registerRandomUser();

        // Retrieving and verifying created random user
        loginPageModel.login(email, password);
        myAccountPageModel.myAccountNavigation("nav-profile");

        // Update first name and last name of the signed in employee
        profilePageModel.updateFirstAndLastName(updatedUserData.FIRSTNAME.toString(), updatedUserData.LASTNAME.toString());

        // Update address details
        profilePageModel.updateAddressDetails(updatedUserData.ADDRESS.toString(), updatedUserData.CITY.toString(), updatedUserData.STATE.toString(), updatedUserData.COUNTRY.toString(), updatedUserData.POSTALCODE.toString());

        // Update Phone Number
        profilePageModel.updatePhoneNumber(updatedUserData.PHONE.toString());

        // Click Update Profile Button to Save
        profilePageModel.clickUpdateProfileButton();

        // Skipping Delete since the user is unable to delete his/her account

    }
    @Test
    public void purchase_An_Item_And_Checkout_As_User(){
        // Instance of classes needed for the test method
        TestSmithDemoMainPageModel testSmithDemoMainPageModel = new TestSmithDemoMainPageModel(driver, wait);
        LoginPageModel loginPageModel = new LoginPageModel(driver, wait);
        RegisterPageModel registerPageModel = new RegisterPageModel(driver, wait);
        CategoryToolsPageModel categoryToolsPageModel = new CategoryToolsPageModel(driver, wait);
        ProductPageModel productPageModel = new ProductPageModel(driver, wait);
        CheckoutCartPageModel checkoutCartPageModel = new CheckoutCartPageModel(driver, wait);
        String password = userData.PASSWORD.toString();

        // Navigation to Login Page > Register Page
        testSmithDemoMainPageModel.navigateTo("nav-sign-in");
        loginPageModel.clickRegisterAccountLink();

        // Registration of randomized person
        String email = registerPageModel.registerRandomUser();

        // login as created user
        loginPageModel.login(email, password);

        // Navigate to Categories > Hand Tools
        testSmithDemoMainPageModel.navigateTo("nav-categories");
        testSmithDemoMainPageModel.selectCategoriesSubMenu("nav-hand-tools");

        // Selecting a tool item to add to cart
        categoryToolsPageModel.selectACategoryItem("product-6");
        productPageModel.addSelectedItemToCart(3);

        // Navigating to Car via Navigation
        testSmithDemoMainPageModel.navigateTo("nav-cart");

        // Proceed to Checkout and Payment
        checkoutCartPageModel.clickProceedToCheckoutButton();
        checkoutCartPageModel.clickSignInProceedToCheckoutButton();
        checkoutCartPageModel.setBillingAddress(userData.ADDRESS.toString(), userData.CITY.toString(), userData.STATE.toString(), "PH", userData.POSTALCODE.toString());
        checkoutCartPageModel.clickBillingProceedToCheckoutButton();
        checkoutCartPageModel.setPaymentInfoAndConfirm(paymentMethod.PAYMENT_METHOD.toString(),paymentMethod.ACCOUNT_NAME.toString(), paymentMethod.ACCOUNT_NUMBER.toString());
    }
    @Test
    public void send_a_new_Message_As_User(){
        // Instance of classes needed for the test method
        TestSmithDemoMainPageModel testSmithDemoMainPageModel = new TestSmithDemoMainPageModel(driver, wait);
        LoginPageModel loginPageModel = new LoginPageModel(driver, wait);
        RegisterPageModel registerPageModel = new RegisterPageModel(driver, wait);
        MyAccountPageModel myAccountPageModel = new MyAccountPageModel(driver, wait);
        ContactPageModel contactPageModel = new ContactPageModel(driver, wait);
        MessagesPageModel messagesPageModel = new MessagesPageModel(driver, wait);
        String password = userData.PASSWORD.toString();

        // Navigation to Login Page > Register Page
        testSmithDemoMainPageModel.navigateTo("nav-sign-in");
        loginPageModel.clickRegisterAccountLink();

        // Registration of randomized person
        String email = registerPageModel.registerRandomUser();

        // login as created user
        loginPageModel.login(email, password);

        // Navigate to Messages > Contacts
        myAccountPageModel.myAccountNavigation("nav-messages");
        messagesPageModel.clickContactFormLink();

        // Sending a sample Email
        contactPageModel.setMessage(message.SUBJECT.toString(), message.MESSAGE.toString());
    }
}
