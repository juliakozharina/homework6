package pages;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class BasePage {

    WebDriver driver;
    private WebDriverWait wait;
    private org.apache.logging.log4j.Logger logger;

    public BasePage(WebDriver driver) {
        this.driver = this.driver;
        wait = new WebDriverWait(this.driver, 10);
        logger = LogManager.getLogger(Logger.class);

    }
}
