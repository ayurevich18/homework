import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import linia_kino.FilmViewFilm;
import linia_kino.MainFilmsPage;
import linia_kino.Seats;
import linia_kino.Showtimes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class LiniaKinoTest {
    private WebDriver driver;
    private MainFilmsPage mainFilmsPage;
    private FilmViewFilm filmViewFilm;
    private Seats seats;
    private Showtimes showtimes;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://liniakino.com/");
        mainFilmsPage = new MainFilmsPage(driver);
        filmViewFilm = new FilmViewFilm(driver);
        seats = new Seats(driver);
        showtimes = new Showtimes(driver);

    }

    @Test
    public void get() {
        mainFilmsPage.clickOnFilm();
        filmViewFilm.goToPage();
        showtimes.selectPlace();
        seats.closeAlert();
        seats.dispalyOnConsole();
    }


    @AfterTest
    public void ex() {
        driver.quit();
    }
}