package driver;

import enam.Browser;
import exceptions.DriverNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public WebDriver create(String driverName, List<String> options) throws DriverNotSupportedException {
        switch (driverName) {
            case "CHROME":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (options.size() > 0) {
                    for (String option : options) {
                        chromeOptions.addArguments(option);
                    }
                }
            default:
                throw new DriverNotSupportedException(driverName);
        }
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

    public void setImplicitlyWait(WebDriver driver) {
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
