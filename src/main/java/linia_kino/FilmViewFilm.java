package linia_kino;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilmViewFilm {
    private WebDriver driver;

    public FilmViewFilm(WebDriver driver) {
        this.driver = driver;
    }

    private By buyButton = By.xpath("//*[@class='button inline']");

    public Showtimes goToPageShowtimes() {
        driver.findElement(buyButton).click();
        return new Showtimes(driver);
    }


}
