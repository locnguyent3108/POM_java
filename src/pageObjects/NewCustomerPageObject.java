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
}
