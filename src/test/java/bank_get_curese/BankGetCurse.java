package bank_get_curese;

import bank_course.Oschad;
import bank_course.Private24;
import bank_course.UkrsibBank;
import bank_course.Universal;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class BankGetCurse {
    private WebDriver driver;
    private Private24 private24;
    private Oschad oschad;
    private Universal universal;
    private UkrsibBank ukrsibBank;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        private24 = new Private24(driver);
        oschad = new Oschad(driver);
        universal = new Universal(driver);
        ukrsibBank = new UkrsibBank(driver);
    }

    @Test
    public void getBuyCourse() {
        ArrayList<Double> buyCourse = new ArrayList();
        driver.get("https://www.oschadbank.ua/ua");
        buyCourse.add(oschad.oschadBuy());
        buyCourse.add(private24.privateBuy());
        buyCourse.add(ukrsibBank.ukrsibBuy());
        buyCourse.add(universal.universalBuy());
        double average = (buyCourse.get(0) + buyCourse.get(1) + buyCourse.get(2) + buyCourse.get(3)) / buyCourse.size();
        System.out.println("Average buy course: " + average);
        Collections.sort(buyCourse);
        System.out.println("Bank with low course: " + buyCourse.get(0));
    }

    @Test
    public void getSellCourse() {
        ArrayList<Double> sellCourse = new ArrayList();
        driver.get("https://www.oschadbank.ua/ua");
        sellCourse.add(oschad.oschadSell());
        sellCourse.add(private24.privateSell());
        sellCourse.add(ukrsibBank.ukrsibSell());
        sellCourse.add(universal.universalSell());
        double average = (sellCourse.get(0) + sellCourse.get(1) + sellCourse.get(2) + sellCourse.get(3)) / sellCourse.size();
        System.out.println("Average sell course: " + average);
        Collections.sort(sellCourse);
        System.out.println("Bank with high course: " + sellCourse.get(3));

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
