package pageObjects.bankguru_po;

import actions.AbstractPage;
import org.openqa.selenium.WebDriver;

public class NewAccountPageObject extends AbstractPage {
    WebDriver driver;

    public NewAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public EditCustomerPageObject openEditCustomerPage () {
        return super.openEditCustomerPage(driver);
    }
}
