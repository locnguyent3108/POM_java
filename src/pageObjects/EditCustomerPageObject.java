package pageObjects;

import actions.AbstractPage;
import interfaces.EditCustomerPageUI;
import org.openqa.selenium.WebDriver;

public class EditCustomerPageObject extends AbstractPage {
    WebDriver driver;

    public EditCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public HomePageObject openHomePage () {
        return super.openHomePageObject(driver);
    }
}
