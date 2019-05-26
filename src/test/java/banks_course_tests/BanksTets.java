package banks_course_tests;

import banks_course.Oschad;
import banks_course.Private24;
import banks_course.UkrsibBank;
import banks_course.Universal;
import core.DriverEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

public class BanksTets {
    private WebDriver driver;
    private Private24 private24;
    private Oschad oschad;
    private Universal universal;
    private UkrsibBank ukrsibBank;


    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver = new EventFiringWebDriver(driver).register(new DriverEventListener());
        private24 = new Private24(driver);
        oschad = new Oschad(driver);
        universal = new Universal(driver);
        ukrsibBank = new UkrsibBank(driver);
    }

    @Test
    public void getBuyCourse() {
        ArrayList<Double> buyCourse = new ArrayList<Double>();
        driver.get("https://www.oschadbank.ua/ua");
        buyCourse.add(oschad.OschadBuy());
        driver.get("https://www.privat24.ua/");
        buyCourse.add(private24.PrivateBuy());
        driver.get("https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/");
        buyCourse.add(ukrsibBank.UkrsibBuy());
        driver.get("https://www.universalbank.com.ua/");
        buyCourse.add(universal.UniversalBuy());
        double average = (buyCourse.get(0) + buyCourse.get(1) + buyCourse.get(2) + buyCourse.get(3)) / buyCourse.size();
        System.out.println("Average buy course: " + average);
        Collections.sort(buyCourse);
        System.out.println("Bank with low course: " + buyCourse.get(0));
    }

    @Test
    public void getSellCourse() {
        ArrayList<Double> sellCourse = new ArrayList<Double>();
        driver.get("https://www.oschadbank.ua/ua");
        sellCourse.add(oschad.OschadSell());
        driver.get("https://www.privat24.ua/");
        sellCourse.add(private24.PrivateSell());
        driver.get("https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/");
        sellCourse.add(ukrsibBank.UkrsibSell());
        driver.get("https://www.universalbank.com.ua/");
        sellCourse.add(universal.UniversalSell());
        double average = (sellCourse.get(0) + sellCourse.get(1) + sellCourse.get(2) + sellCourse.get(3)) / sellCourse.size();
        System.out.println("Average sell course: " + average);
        Collections.sort(sellCourse);
        System.out.println("Bank with high course: " + sellCourse.get(3));

    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
