package actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AbstractTest {
    WebDriver driver;

    public WebDriver runMultiBrowser(String browserName) {
        if(browserName.equals("chrome")){
            WebDriverManager.chromedriver().version("74.0").setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equals("chrome_headless")) {
            WebDriverManager.chromedriver().version("74.0").setup();
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
}
