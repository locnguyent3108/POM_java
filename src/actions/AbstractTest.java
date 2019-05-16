package actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AbstractTest {
    WebDriver driver;
    protected final Log log;

    public AbstractTest() {
        log = LogFactory.getLog(getClass());
    }

    public WebDriver runMultiBrowser(String browserName, String browserVersion) {
        if(browserName.equals("chrome")){
            WebDriverManager.chromedriver().version(browserVersion).setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().version(browserVersion).setup();
            driver = new FirefoxDriver();
        } else if (browserName.equals("chrome_headless")) {
            WebDriverManager.chromedriver().version(browserVersion).setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            options.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(options);
        } else{
            System.out.println("Can not init browser");
        }
        driver.get("http://demo.guru99.com/v4");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return  driver;
    }

    private boolean checkPassed (boolean condition) {
        boolean pass = true;
        //verify
        try{
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;
        }
        return pass;
    }

    protected boolean verifyTrue (boolean condition) {
        return checkPassed(condition);
    }

    private boolean checkFailed (boolean condition) {
        boolean pass = false;

        try {
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = true;
        }
        return pass;

    }

    protected boolean verifyFalse (boolean condition) {
        return checkFailed(condition);
    }

    private boolean checkEquals (Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            pass = false;
        }
        return pass;
    }

    protected boolean verifyEqual (Object actual, Object expect) {
        return checkEquals(actual, expect);
    }

//    protected void closeBrowser(WebDriver driver) {
//        try {
//            String osName = System.setProperty("os.name").toLowerCase();
//            String cmd = "";
//            driver.quit();
//            if (driver.toString().toLowerCase().contains("chrome")){
//                if (osName.toLowerCase().contains("mac")) {
//                    cmd = "pkill chromedriver";
//                } else {
//                    cmd = "taskkill /F /FI  \"IMAGE eq chromedriver*\"";
//                }
//                Process process = Runtime.getRuntime().exec(cmd);
//                process.waitFor();
//            }
//
//        }catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

}
