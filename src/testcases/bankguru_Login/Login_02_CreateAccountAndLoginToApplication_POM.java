package testcases.bankguru_Login;

import actions.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.bankguru.*;
import pageObjects.bankguru_po.*;


import java.util.Random;

public class Login_02_CreateAccountAndLoginToApplication_POM extends AbstractTest {
    WebDriver driver;
    private String loginUrl, email, userId, password;


    @Parameters({"browser","version"})
    @BeforeClass
    public void beforeClass (String browserName, String browserVersion) {
        driver = runMultiBrowser(browserName, browserVersion);
        Random r = new Random();
        email = "automation" + r.nextInt(5) +"@yopmail.com";
    }

    @Test
    public void TC_01_CreateAnAccount () {
        log.info("---- Login 01 - Step 01: get URL");
        loginPageObject = new LoginPageObject(driver);

        loginUrl = loginPageObject.getLoginUrl();

        RegisterPageObjects registerPageObjects = loginPageObject.clickHereLink();
        registerPageObjects.inputEmail(email);
        registerPageObjects.clickSubmitButton();

        log.info("-----Login 01 - Step 02: get URL");
        userId = registerPageObjects.getUserIdInfo();
        password = registerPageObjects.getPasswordInfo();
    }

    @Test
    public void TC_02_LoginWithAboveInformation () {
        log.info("---Login 02 - Step 01: open login page");
        registerPageObjects = PageManageDriver.getRegisterPageObject(driver,registerPageObjects);
        loginPageObject = registerPageObjects.openLoginPage(loginUrl);

        log.info("----Login 02 -Step 02: input username/password");
        loginPageObject.inputEmail(userId);
        loginPageObject.inputPassword(password);

        homePageObject = loginPageObject.clickLoginButton();
        homePageObject.isWelcomeMessageDisplay();

        //Step 04 - Open New Customer Page -> return new customer page
        newCustomerPageObject =  homePageObject.openNewCustomerPage();
        newCustomerPageObject.clickToDynamicTextBox("name");
        newCustomerPageObject.clickToDynamicTextBox("city");
        newCustomerPageObject.clickToDynamicTextBox("state");

        //verify error message
        verifyTrue(newCustomerPageObject.isDynamicErrorMessageDisplayed("nae", "Customer name must not be blank"));
        verifyTrue(newCustomerPageObject.isDynamicErrorMessageDisplayed("city", "City Field must not be blank"));
       // newCustomerPageObject.isDynamicErrorMessageDisplayed("state", "State must not be blank");

        newCustomerPageObject.inputToDynamicTextBox("name","abcd");
        //Step 05 - Open New Account Page -> return New Account page
        newAccountPageObject = newCustomerPageObject.openNewAccountPage();

        //Step 06 - open Edit Customer Page -> return Edit customer page
        editCustomerPage = newAccountPageObject.openEditCustomerPage();

        //Step 07 - open homepage -> return home Page
        homePageObject = editCustomerPage.openHomePage();
    }

    @AfterClass
    public void afterTest() {
        driver.quit();
    }

    private LoginPageObject loginPageObject;
    private RegisterPageObjects registerPageObjects;
    private HomePageObject homePageObject;
    private NewCustomerPageObject newCustomerPageObject;
    private NewAccountPageObject newAccountPageObject;
    private EditCustomerPageObject editCustomerPage;
}
