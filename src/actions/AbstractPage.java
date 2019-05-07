package actions;

import interfaces.EditCustomerPageUI;
import interfaces.HomePageUI;
import interfaces.NewAccountPageUI;
import interfaces.NewCustomerPageUI;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;

import java.net.PortUnreachableException;
import java.nio.channels.SelectableChannel;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/*
Author: loc nguyen
Descript: common function v.0.1;
Time: 2/05/2019
 */
public class AbstractPage {

    public void openUrl (WebDriver driver, String baseUrl) {
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public String getTitle (WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentUrl (WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource (WebDriver driver) {
        return driver.getPageSource();
    }

    public void back (WebDriver driver) {
        driver.navigate().back();
    }

    public void clickToElement (WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        element.click();
    }

    public void sendKeyToElement (WebDriver driver, String locator, String value) {
        WebElement element = driver.findElement(By.xpath(locator));
        element.sendKeys(value);
    }

    public void selectItemInDropdown (WebDriver driver, String locator, String textItem) {
        WebElement element = driver.findElement(By.xpath(locator));
        Select select = new Select(element);
        select.selectByVisibleText(textItem);

    }

    public String getFirstItemSelected (WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    public String getAttributeValue (WebDriver driver, String locator, String attribute) {
        WebElement element = driver.findElement(By.xpath(locator));
        return element.getAttribute(attribute);
    }

    public String getTextElement (WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        return element.getText();
    }

    public int getSizeElement (WebDriver driver, String locator) {
        List<WebElement> listElement = driver.findElements(By.xpath(locator));
        return listElement.size();
    }

    public void clickToCheckBox (WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        if(!element.isSelected()) {
            element.click();
        }
    }

    public void uncheckToCheckBox (WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        if(element.isSelected()) {
            element.click();
        }
    }

    public boolean isControlDisplayed (WebDriver driver, String locator){
        WebElement element = driver.findElement(By.xpath(locator));
        return element.isDisplayed();
    }

    public boolean isControlSelected (WebDriver driver, String locator){
        WebElement element = driver.findElement(By.xpath(locator));
        return element.isSelected();
    }

    public boolean isControlEnabled (WebDriver driver, String locator){
        WebElement element = driver.findElement(By.xpath(locator));
        return element.isEnabled();
    }

    public void acceptAlert (WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void cancelAlert (WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public String getTextAlert (WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void sendKeyToAlert (WebDriver driver, String value ){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(value);
    }

    public void doubleClick (WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        Actions action = new Actions(driver);
        action.doubleClick(element);
    }

    public void hoverMouseToElement (WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
    }

    public void rightClickToElement (WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        Actions actions = new Actions(driver);
        actions.contextClick(element);
    }

    public void waitForControlPresence (WebDriver driver, String locator) {
        By by = By.xpath(locator);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForControlVisible (WebDriver driver, String locator) {
        By by = By.xpath(locator);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForControlClickAble (WebDriver driver, String locator) {
        By by = By.xpath(locator);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForAlertPresence (WebDriver driver, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public int randomNumber() {
        Random random = new Random();
        int number;
        number = random.nextInt();
        return number;
    }

    public NewCustomerPageObject openNewCustomerPage (WebDriver driver) {
        waitForControlVisible(driver, AbstractUI.NEW_CUSTOMER_PAGE_LINK);
        clickToElement(driver,AbstractUI.NEW_CUSTOMER_PAGE_LINK);
        return new NewCustomerPageObject(driver);
    }

    public NewAccountPageObject openNewAccountPage (WebDriver driver) {
        waitForControlVisible(driver, AbstractUI.NEW_ACCOUNT_PAGE_LINK);
        clickToElement(driver,AbstractUI.NEW_ACCOUNT_PAGE_LINK);
        return new NewAccountPageObject(driver);
    }

    public EditCustomerPageObject openEditCustomerPage (WebDriver driver) {
        waitForControlVisible(driver, AbstractUI.EDIT_CUSTOMER_PAGE_LINK);
        clickToElement(driver, AbstractUI.EDIT_CUSTOMER_PAGE_LINK);
        return new EditCustomerPageObject(driver);
    }

    public HomePageObject openHomePageObject (WebDriver driver) {
        waitForControlVisible(driver, AbstractUI.HOME_PAGE_LINK);
        clickToElement(driver, AbstractUI.HOME_PAGE_LINK);
        return new HomePageObject(driver);
    }


}
