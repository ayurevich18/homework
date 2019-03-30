import loginpage.LoginPage;
import loginpage.MainPage;
import loginpage.MessagePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class FaceBookGetMessage {
    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private MessagePage messagePage;
    private String email="*******";
    private String pass="*******";

    @BeforeSuite
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "/Users/yurevycho/Downloads/chromedriver");
        driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");
        loginPage= new LoginPage(driver);
        mainPage= new MainPage(driver);
        messagePage= new MessagePage(driver);

    }
   @Test
    public void getLastMessage(){
        MainPage mainPage=loginPage.loginUser(email,pass);
        mainPage.clickMessageButton();
        messagePage.getMessage();

   }

   @AfterSuite
    public void tearDown(){
        driver.quit();
   }
}
