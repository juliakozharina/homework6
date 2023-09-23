package pages;

import driver.WebDriverOptions;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    private String path = "/";

    private org.apache.logging.log4j.Logger logger;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        wait = new WebDriverWait(this.driver, 10);
        logger = LogManager.getLogger(Logger.class);
//
        PageFactory.initElements(driver,this);

    }
}
