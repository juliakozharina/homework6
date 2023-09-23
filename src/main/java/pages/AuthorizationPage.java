package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends BasePage {

    @FindBy(xpath = "(//input[@required])[1]")
    private WebElement LOGIN;

    @FindBy(xpath = "(//input[@required])[2]")
    private WebElement PASSWORD;

    @FindBy (xpath = "//button[@class=\"sc-9a4spb-0 gYNtqF sc-11ptd2v-2-Component cElCrZ\"]")
    private WebElement submitButton;

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLOGIN() {
        return LOGIN;
    }

    public WebElement getPASSWORD() {
        return PASSWORD;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void enterLogin(String LOGIN){
        getLOGIN().clear();
        getLOGIN().sendKeys(LOGIN);
    }

    public void enterPassword(String PASSWORD){
        getPASSWORD().clear();
        getPASSWORD().sendKeys(PASSWORD);

    }

    public void authorize() {
        getSubmitButton().click();
    }
}
