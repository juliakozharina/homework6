package test;


import driver.WebDriverOptions;
import help.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestHW {
    WebDriverOptions webDriverOptions = new WebDriverOptions();
    Step step = new Step();

    private String LOGIN = System.getProperty("juliako13@mail.ru");
    private String PASSWORD = System.getProperty("1234Qwerty12345&");

    @BeforeClass
    public static void setupDriver(){
        WebDriverOptions.driverLoad();
    }

    @Before
    public void setWebDriverFactory(){
        webDriverOptions.create();
    }

    @After
    public void closeWebDriverFactory(){
        WebDriverOptions.quit();
    }

    @Test
    public void someTest()throws InterruptedException{
        step.openMainPage();
        step.openAuthorizationForm();
        step.fillTheAuthorizationForm(LOGIN,PASSWORD);
        step.submitAuthorizationForm();
        step.fillProfileFields()
                .enterNAME_FIELD("Юлия")
                .enterLATIN_NAME_FIELD("Julia")
                .enterLATIN_SURNAME_FIELD("Иванова")
                .enterLATIN_SURNAME_FIELD("Ivanova")
                .enterBLOG_NAME_FIELD("Julia")
                .enterDATE_OF_BIRTH_FIELD("01.01.1990")
                .selectCOUNTRYRussia()
                .selectCITYMoscow()
                .selectRemoteWork()
                .saveChangesOnTheProfilePage();

  //      WebDriverOptions.getDriver().quit();
        webDriverOptions.create();


        step.openMainPage();
        step.openAuthorizationForm();
        step.fillTheAuthorizationForm(LOGIN,PASSWORD);
        step.submitAuthorizationForm();
        step.openProfilePage();
    }
}
