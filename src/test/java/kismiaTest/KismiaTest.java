package kismiaTest;

import kismia.LoginPage;
import kismia.MainPage;
import kismia.MessagePage;
import kismia.SettingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class KismiaTest {
    public WebDriver driver;


    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "/Users/alekseyyurevich/Downloads/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().window().fullscreen();

    }

    @Test
    public void loginUserTest() {
        driver.get("https://kismia.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("ZATROHITRU@DESOZ.COM", "12345678");


    }

    @Test(dependsOnMethods = "loginUserTest")
    public void changeBdayAndGenderTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openSittingPage();
        SettingPage settingPage = new SettingPage(driver);
        settingPage.goToPersonalData();
        settingPage.setBDay("1", "1", "1981");
        settingPage.changeGender();
        settingPage.clickSaveButton();
    }

    @Test(dependsOnMethods = "loginUserTest")
    public void sendMessageTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMessagePage();
        MessagePage messagePage = new MessagePage(driver);
        messagePage.startMessage();
        messagePage.writeMessage("Hello:)");


    }


    @AfterClass
    public void off() {
        driver.quit();

    }
}
