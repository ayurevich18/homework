package test_imdb;

import imdb.com.Imdb;
import loginpage.LoginPage;
import loginpage.MainPage;
import loginpage.MessagePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImdbTest {
    private WebDriver driver;
    private Imdb imdb;



    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/yurevycho/Downloads/chromedriver");
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.imdb.com/title/tt0111161/");
        imdb=new Imdb(driver);


    }
    @Test
    public void getFilmDetail(){
        imdb.displayFilmInfo();


    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

