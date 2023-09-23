package pages;

import driver.WebDriverOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageMain {
    private static final String baseUrl = "https://otus.ru/";

    @FindBy(xpath = "//div[@class=\"sc-r03h0s-5 bYKNcH\"]")
    private WebElement loginButton;

    @FindBy (xpath = "(//input[@required])[1]")
    private WebElement userName;

    @FindBy (xpath = "(//input[@required])[2]")
    private WebElement myProfile;

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getMyProfile() {
        return myProfile;
    }

    public void open(){
        WebDriverOptions.getDriver().get(baseUrl);
    }

    public void openAuthorizationPage() {
        getLoginButton().click();
    }

    public void openProfilePage() {
        WebDriverOptions.getWait().until(ExpectedConditions.visibilityOf(getUserName()));
        WebDriverOptions.getAction().moveToElement(getUserName()).perform();
        getMyProfile().click();
    }
}
