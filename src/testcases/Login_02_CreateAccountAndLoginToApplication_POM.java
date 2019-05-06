package testcases;

import actions.AbstractTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObjects;
import pageObjects.pageManageDriver;


import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Login_02_CreateAccountAndLoginToApplication_POM extends AbstractTest {
    WebDriver driver;
    private String loginUrl, email, userId, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass (String browserName) {
        driver = runMultiBrowser(browserName);
        Random r = new Random();
        email = "automation" + r.nextInt(5) +"@yopmail.com";
    }

    @Test
    public void TC_01_CreateAnAccount () {
        loginPageObject = new LoginPageObject(driver);

        loginUrl = loginPageObject.getLoginUrl();

        RegisterPageObjects registerPageObjects = loginPageObject.clickHereLink();
        registerPageObjects.inputEmail(email);
        registerPageObjects.clickSubmitButton();
        userId = registerPageObjects.getUserIdInfo();
        password = registerPageObjects.getPasswordInfo();
    }

    @Test
    public void TC_02_LoginWithAboveInformation () {
        registerPageObjects = pageManageDriver.getRegisterPageObject(driver,registerPageObjects);
        loginPageObject = registerPageObjects.openLoginPage(loginUrl);

        loginPageObject.inputEmail(userId);
        loginPageObject.inputPassword(password);

        HomePageObject homePageObject = loginPageObject.clickLoginButton();
        homePageObject.isWelcomeMessageDisplay();

    }

    private LoginPageObject loginPageObject;
    private RegisterPageObjects registerPageObjects;
    private HomePageObject homePageObject;
}
