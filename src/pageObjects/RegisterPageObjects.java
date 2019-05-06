package pageObjects;

import actions.AbstractPage;
import interfaces.RegisterPageUI;
import org.openqa.selenium.WebDriver;

public class RegisterPageObjects extends AbstractPage {
    WebDriver driver;

    public RegisterPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void inputEmail (String email) {
        waitForControlVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX, email);
    }

    public void clickSubmitButton() {
        waitForControlVisible(driver,RegisterPageUI.LOGIN_BUTTON);
        clickToElement(driver,RegisterPageUI.LOGIN_BUTTON);
    }

    public String getUserIdInfo() {
        return getTextElement(driver,RegisterPageUI.USER_ID_TEXT);
    }

    public String getPasswordInfo() {
        return getTextElement(driver,RegisterPageUI.PASS_TEXT);
    }

    public LoginPageObject openLoginPage(String loginUrl) {
        openUrl(driver,loginUrl);
        return new LoginPageObject(driver);
    }

}
