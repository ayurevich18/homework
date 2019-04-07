package linia_kino;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Showtimes {
    private WebDriver driver;

    public Showtimes(WebDriver driver) {
        this.driver = driver;
    }

    private By selectTime = By.xpath("//*[@id=\"content-inner\"]/div/ul/li/div[2]/div[1]/div[1]/ul/li[1]/a");

    public Seats selectPlace() {
        driver.findElement(selectTime).click();
        return new Seats(driver);
    }
}
