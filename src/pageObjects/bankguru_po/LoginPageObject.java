package pageObjects.bankguru_po;

import actions.AbstractPage;
import interfaces.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends AbstractPage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoginUrl() {

        return getCurrentUrl(driver);
    }

    public RegisterPageObjects clickHereLink() {
        waitForControlVisible(driver, LoginPageUI.HERE_LINK);
        clickToElement(driver,LoginPageUI.HERE_LINK);
        return new RegisterPageObjects(driver);
    }

    public void inputEmail(String email) {
        waitForControlVisible(driver,LoginPageUI.LOGIN_BUTTON);
        sendKeyToElement(driver,LoginPageUI.USER_ID_TEXT,email);
    }

    public void inputPassword(String password) {
        waitForControlVisible(driver,LoginPageUI.LOGIN_BUTTON);
        sendKeyToElement(driver,LoginPageUI.PASS_TEXTBOX,password);
    }

    public HomePageObject clickLoginButton() {
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
        return new HomePageObject(driver);
    }

}
