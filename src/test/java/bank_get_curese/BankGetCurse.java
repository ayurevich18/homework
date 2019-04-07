package bank_get_curese;

import bank_course.Oschad;
import bank_course.Private24;
import bank_course.UkrsibBank;
import bank_course.Universal;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BankGetCurse {
    private WebDriver driver;
    private Private24 private24;
    private Oschad oschad;
    private Universal universal;
    private UkrsibBank ukrsibBank;


    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        private24=new Private24(driver);
        oschad=new Oschad(driver);
        universal=new Universal(driver);
        ukrsibBank=new UkrsibBank(driver);
    }

    @Test
    public  void getPrivat24()  {
        private24.displayPrivatecurese();
    }

    @Test
    public void getOschad(){
        driver.get("https://www.oschadbank.ua/ua");
        oschad.curseOschad();

    }

    @Test
    public void get(){
        universal.displayUniversalCurese();

    }

    @Test
    public void getUkrsib(){
        ukrsibBank.displayUkrsibCurese();

    }





    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
