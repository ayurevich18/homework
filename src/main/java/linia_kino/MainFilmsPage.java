package linia_kino;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainFilmsPage {
    private WebDriver driver;

    public MainFilmsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By AllFilms =By.xpath("//*[@id=\"content-inner\"]//a/img"); //*[@class="movie"]

    public List<WebElement> getAllFilms(){
        return driver.findElements(AllFilms);
    }
}
