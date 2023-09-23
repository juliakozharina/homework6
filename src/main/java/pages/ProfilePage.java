package pages;

import driver.WebDriverOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
    private Logger logger = LogManager.getLogger(ProfilePage.class);

    @FindBy(xpath = "//input[@name=\"fname\"]")
    private WebElement NAME_FIELD;

    @FindBy(xpath = "//input[@name=\"fname_latin\"]")
    private WebElement LATIN_NAME_FIELD;

    @FindBy(xpath = "//input[@name=\"lname\"]")
    private WebElement SURNAME_FIELD;

    @FindBy(xpath = "//input[@name=\"lname_latin\"]")
    private WebElement LATIN_SURNAME_FIELD;

    @FindBy(xpath = "//input[@name=\"blog_name\"]")
    private WebElement BLOG_NAME_FIELD;

    @FindBy(xpath = "//input[@name=\"date_of_birth\"]")
    private WebElement DATE_OF_BIRTH_FIELD;

    @FindBy(xpath = "(//div[@class=\"input input_full lk-cv-block__input lk-cv-block__input_fake lk-cv-block__input_select-fake js-custom-select-presentation\"])[1]")
    private WebElement COUNTRY;

    @FindBy(xpath = "(//div[@class=\"input input_full lk-cv-block__input lk-cv-block__input_fake lk-cv-block__input_select-fake js-custom-select-presentation\"])[2]")
    private WebElement CITY;

    @FindBy(xpath = "(//span[@class=\"checkbox__label lk-cv-block__text lk-cv-block__text_work-schedule\"])[1]")
    private WebElement FULL_DAY_CHECKBOX;

    @FindBy(xpath = "(//span[@class=\"checkbox__label lk-cv-block__text lk-cv-block__text_work-schedule\"])[3]")
    private WebElement REMOTE_CHECKBOX;

    @FindBy(xpath = "//button[@title=\"Сохранить и продолжить\"]")
    private WebElement saveChanges;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

//    public ProfilePage() {
//        super();
//    }

    public WebElement getNAME_FIELD() {
        return NAME_FIELD;
    }

    public WebElement getLATIN_NAME_FIELD() {
        return LATIN_NAME_FIELD;
    }

    public WebElement getSURNAME_FIELD() {
        return SURNAME_FIELD;
    }

    public WebElement getLATIN_SURNAME_FIELD() {
        return LATIN_SURNAME_FIELD;
    }

    public WebElement getBLOG_NAME_FIELD() {
        return BLOG_NAME_FIELD;
    }

    public WebElement getDATE_OF_BIRTH_FIELD() {
        return DATE_OF_BIRTH_FIELD;
    }

    public WebElement getCOUNTRY() {
        return COUNTRY;
    }

    public WebElement getCITY() {
        return CITY;
    }


    public WebElement getFULL_DAY_CHECKBOX() {
        return FULL_DAY_CHECKBOX;
    }

    public WebElement getREMOTE_CHECKBOX() {
        return REMOTE_CHECKBOX;
    }

    public WebElement getSaveChanges() {
        return saveChanges;
    }

    public ProfilePage enterNAME_FIELD(String NAME_FIELD){
        getNAME_FIELD().clear();
        getNAME_FIELD().sendKeys(NAME_FIELD);
        return this;
    }

    public ProfilePage enterLATIN_NAME_FIELD(String LATIN_NAME_FIELD){
        getLATIN_NAME_FIELD().clear();
        getLATIN_NAME_FIELD().sendKeys(LATIN_NAME_FIELD);
        return this;
    }

    public ProfilePage enterSURNAME_FIELD(String SURNAME_FIELD){
        getSURNAME_FIELD().clear();
        getSURNAME_FIELD().sendKeys(SURNAME_FIELD);
        return this;
    }

    public ProfilePage enterLATIN_SURNAME_FIELD(String LATIN_SURNAME_FIELD){
        getLATIN_SURNAME_FIELD().clear();
        getLATIN_SURNAME_FIELD().sendKeys(LATIN_SURNAME_FIELD);
        return this;
    }

    public ProfilePage enterBLOG_NAME_FIELD(String BLOG_NAME_FIELD){
        getBLOG_NAME_FIELD().clear();
        getBLOG_NAME_FIELD().sendKeys(BLOG_NAME_FIELD);
        return this;
    }

    public ProfilePage enterDATE_OF_BIRTH_FIELD(String DATE_OF_BIRTH_FIELD) {
        getDATE_OF_BIRTH_FIELD().clear();
        getDATE_OF_BIRTH_FIELD().sendKeys(DATE_OF_BIRTH_FIELD);
        return this;
    }

    public ProfilePage selectCOUNTRYRussia() {
        String selectCOUNTRYRussia = "document.querySelector(\"[name='country']\").click(); " +
                "+ document.querySelector(\"[title='Россия']\").click();";
        ((JavascriptExecutor) WebDriverOptions.getDriver()).executeScript(selectCOUNTRYRussia);
        return this;
    }

    public ProfilePage selectCITYMoscow() throws InterruptedException {
        Thread.sleep(500);
        String selectCITYMoscow = "document.querySelector(\"[name='city']\").click(); " +
                "+ document.querySelector(\"[title='Москва']\").click();";
        ((JavascriptExecutor) WebDriverOptions.getDriver()).executeScript(selectCITYMoscow);
        return this;
    }

    public ProfilePage selectRemoteWork() {
        String script = "document.querySelector(\"[value='remote']\").click();";
        ((JavascriptExecutor) WebDriverOptions.getDriver()).executeScript(script);
        return this;
    }

    public void saveChangesOnTheProfilePage() {
        getSaveChanges().click();
    }

    public String getValueTextField(WebElement webElement){
        return webElement.getAttribute("value");
    }

    public String getInnerTextTextField(WebElement webElement){
        return webElement.getAttribute("innerText");
    }

    public String getValueCheckField(WebElement webElement){
        return webElement.getAttribute("checked");
    }
}
