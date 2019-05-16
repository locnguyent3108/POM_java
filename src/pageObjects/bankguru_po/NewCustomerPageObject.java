package pageObjects.bankguru_po;

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

    public boolean isDynamicErrorMessageDisplayed (String locator, String errorMessage) {
        waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_ERROR_MESSAGE, locator, errorMessage);
        return isControlDisplayed(driver, NewCustomerPageUI.DYNAMIC_ERROR_MESSAGE,locator, errorMessage);
    }

    public void clickToDynamicTextBox (String locator) {
        waitForControlVisible(driver,NewCustomerPageUI.DYNAMIC_TEXT_BOX,locator);
        isControlDisplayed(driver,NewCustomerPageUI.DYNAMIC_TEXT_BOX,locator);
        clickToElement(driver,NewCustomerPageUI.DYNAMIC_TEXT_BOX,locator);
    }

    public void inputToDynamicTextBox(String locator, String inputValue) {
        waitForControlVisible(driver,NewCustomerPageUI.DYNAMIC_TEXT_BOX,locator);
        isControlDisplayed(driver,NewCustomerPageUI.DYNAMIC_TEXT_BOX,locator);
        sendKeyToElement(driver,NewCustomerPageUI.DYNAMIC_TEXT_BOX,inputValue,locator);
    }
}
