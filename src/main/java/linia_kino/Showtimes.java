package linia_kino;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Showtimes {
    private WebDriver driver;

    public Showtimes(WebDriver driver) {
        this.driver = driver;
    }

    private By selectTime = By.xpath("//div[@class='showtime']/div[1]/div[1]//a");

    public Seats selectPlace() {
        driver.findElement(selectTime).click();
        return new Seats(driver);
    }
}
