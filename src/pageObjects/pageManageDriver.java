package pageObjects;

import org.openqa.selenium.WebDriver;

public class pageManageDriver {
    private HomePageObject homePageObject;
    private static RegisterPageObjects registerPageObjects;
    private LoginPageObject loginPageObject;



    public static RegisterPageObjects getRegisterPageObject(WebDriver driver, RegisterPageObjects registerPage) {
        if(registerPage == null) {
            registerPageObjects = new RegisterPageObjects(driver);
        }
        return registerPageObjects;
    }
}
