import loginpage_facebook.LoginPage;
import loginpage_facebook.MainPage;
import loginpage_facebook.MessagePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class FaceBookGetMessage {
    private WebDriver driver;
    private LoginPage loginPage;
    private MessagePage messagePage;


    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "/Users/yurevycho/Downloads/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");
        loginPage = new LoginPage(driver);
        messagePage = new MessagePage(driver);

    }

    @Test
    public void getLastMessage() {
        MainPage mainPage = loginPage.loginUser("********", "********");
        mainPage.clickMessageButton();
        messagePage.getMessage();

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
