package pageObjects;

import actions.AbstractPage;
import interfaces.NewCustomerPageUI;
import org.openqa.selenium.WebDriver;

public class NewCustomerPageObject extends AbstractPage {
    WebDriver driver;

    public NewCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public NewAccountPageObject openNewAccountPage () {
        return super.openNewAccountPage(driver);
    }

    public void isDynamicErrorMessageDisplayed (String locator, String errorMessage) {
        waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_ERROR_MESSAGE, locator, errorMessage);
        isControlDisplayed(driver, NewCustomerPageUI.DYNAMIC_ERROR_MESSAGE,locator, errorMessage);
    }

    public void clickToDynamicTextBox (String locator) {
        waitForControlVisible(driver,NewCustomerPageUI.DYNAMIC_TEXT_BOX,locator);
        isControlDisplayed(driver,NewCustomerPageUI.DYNAMIC_TEXT_BOX,locator);
        clickToElement(driver,NewCustomerPageUI.DYNAMIC_TEXT_BOX,locator);

    }
}
