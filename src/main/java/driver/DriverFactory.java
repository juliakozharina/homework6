package driver;

import enam.Browser;
import exceptions.DriverNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    
    private static Logger logger = LogManager.getLogger(DriverFactory.class);
    private static WebDriver driver;

    public static WebDriver create(String driverName, List<String> options) throws DriverNotSupportedException {
        switch (driverName) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                logger.info("Инициализирован ChromeDriver");
                if (options.size() > 0) {
                    for (String option : options) {
                        chromeOptions.addArguments(option);
                    }
                }
                return new ChromeDriver(chromeOptions);
            default:
                throw new DriverNotSupportedException(driverName);
        }
        
//        return driver;
    }

    public static String setDriverName() {
        String browserType = System.getProperty("browser").toUpperCase(Locale.ROOT);
        String driverName = null;
        for (Browser name : Browser.values()) {
            if (name.name().equals(browserType)) {
                driverName = browserType;
            }
        }
        return driverName;
    }

    public static void setDriver(WebDriver driver) {
        DriverFactory.driver = driver;
    }

    public static void setImplicitlyWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    public void init() throws DriverNotSupportedException {
        switch (setDriverName()) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                break;
            default:
                throw new DriverNotSupportedException(setDriverName());
        }
    }
}
