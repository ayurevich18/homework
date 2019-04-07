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

    private By AllFilms = By.xpath("//*[@class=\"movie\"]"); //*[@class="movie"]  //*[@id="content-inner"]//a/img

    public List<WebElement> getAllFilms() {
        return driver.findElements(AllFilms);
    }

    public void clickOnFilm() {
        for (int i = 0; i < getAllFilms().size(); i++) {
            System.out.println(getAllFilms().get(i).getText());
            if (getAllFilms().get(i).getText().equals("Дамбо")) {
                getAllFilms().get(i).click();
            }
        }
    }


}
