package pageObjects.bankguru_po;

import org.openqa.selenium.WebDriver;

public class PageManageDriver {
    private static HomePageObject homePageObject;
    private static RegisterPageObjects registerPageObjects;
    private static LoginPageObject loginPageObject;
    private static NewCustomerPageObject newCustomerPageObject;
    private static NewAccountPageObject newAccountPageObject;
    private static EditCustomerPageObject editCustomerPageObject;


    public static RegisterPageObjects getRegisterPageObject(WebDriver driver, RegisterPageObjects registerPage) {
        if(registerPage == null) {
            registerPageObjects = new RegisterPageObjects(driver);
        }
        return registerPageObjects;
    }

    public static LoginPageObject loginPageObject(WebDriver driver) {
        if(loginPageObject == null) {
            loginPageObject = new LoginPageObject(driver);
        }
        return loginPageObject;
    }

    public static HomePageObject homePageObject(WebDriver driver) {
        if(homePageObject == null) {
            homePageObject = new HomePageObject(driver);
        }
        return homePageObject;
    }

    public static RegisterPageObjects registerPageObjects(WebDriver driver) {
        if(registerPageObjects == null) {
            registerPageObjects = new RegisterPageObjects(driver);
        }
        return registerPageObjects;
    }

    public static NewCustomerPageObject newCustomerPageObject(WebDriver driver) {
        if(newCustomerPageObject == null) {
            newCustomerPageObject = new NewCustomerPageObject(driver);
        }
        return newCustomerPageObject;
    }

    public static NewAccountPageObject newAccountPageObject (WebDriver driver) {
        if(newAccountPageObject == null) {
            newAccountPageObject = new NewAccountPageObject(driver);
        }
        return newAccountPageObject;
    }

    public static EditCustomerPageObject editCustomerPageObject (WebDriver driver) {
        if(editCustomerPageObject == null) {
            editCustomerPageObject = new EditCustomerPageObject(driver);
        }
        return editCustomerPageObject;
    }






}   
