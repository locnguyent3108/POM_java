package pageObjects.bankguru_po;

import actions.AbstractPage;
import interfaces.HomePageUI;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends AbstractPage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isWelcomeMessageDisplay () {
        waitForControlVisible(driver, HomePageUI.WELCOME_MESSAGE);
        return isControlDisplayed(driver,HomePageUI.WELCOME_MESSAGE);
    }

    public NewCustomerPageObject openNewCustomerPage () {
        return super.openNewCustomerPage(driver);
    }
}
