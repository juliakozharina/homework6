package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverOptions {

    public static final Logger logger = LogManager.getLogger();

    protected  WebDriver driver;
    protected  WebDriverWait wait;
    protected  Actions action;

    public static WebDriver getDriver() {
        return driver;
    }

    public  Actions getAction() {
        return action;
    }

    public  WebDriverWait getWait() {
        return wait;
    }

    public static void driverLoad(){
        WebDriverManager.chromedriver().setup();
        logger.debug("driver is load");
    }

    public void create() {
        ChromeOptions options = new ChromeOptions().setHeadless(false);
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        action = new Actions(driver);
        logger.debug("driver is created");
    }

    public void quit(){
        if (driver != null) {
            driver.quit();
        }
        logger.debug("driver is closed");
    }
}
