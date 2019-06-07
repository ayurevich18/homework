package imdb.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Imdb {
    private WebDriver driver;

    public Imdb(WebDriver driver) {
        this.driver = driver;
    }

    private By filmName = By.xpath("//*[@class='title_wrapper']/h1");
    private By yearStart = By.xpath("//*[@id='titleYear']/a");
    private By movieLength = By.xpath("//*[@id='titleDetails']//time");
    private By rateFilm = By.xpath("//*[@itemprop='ratingValue']");
    private By rateFilm1 = By.xpath("//*[@itemprop='bestRating']");
    private By genre = By.xpath("//*[@class='subtext']/a[1]");
    private By posterUrl = By.xpath("//*[@class='poster']//img");
    private By videoUrl = By.xpath("//*[@alt='Trailer']");
    private By directorname = By.cssSelector(".credit_summary_item:nth-child(2)>a");
    private By actors = By.xpath("//tbody//td[2]/a");
    private By metascore = By.xpath("//*[@class='titleReviewBar ']//div[1]/span");
    private By qtyReviews = By.xpath("//*[@class='subText']/a"); //use 2(users) //3 critics //sum
    private By nameLikeFilm = By.xpath("//*[@id='title_recs']//img");

    public void displayFilmName() {

        System.out.println("Film name: " + driver.findElement(filmName).getText());

    }

    public void displayYear() {

        System.out.println("Release date: " + driver.findElement(yearStart).getText());

    }


    public void displayMovieLength() {

        int time = Integer.parseInt((driver.findElement(movieLength).getText()).substring(0, 3));
        int timeInSec = time * 60;

        System.out.println("Length film in min: " + time);
        System.out.println("Length film in sec: " + timeInSec);

    }

    public void displayFilmRate() {

        System.out.println("Film rate: " + driver.findElement(rateFilm).getText() + "/" + driver.findElement(rateFilm1).getText());

    }

    public void displayGenre() {

        System.out.println("Film genre: " + driver.findElement(genre).getText());

    }

    public void displayPosterUrl() {
        System.out.println("Poster Url: " + driver.findElement(posterUrl).getAttribute("src"));

    }

    public void displayVideoUrl() {
        System.out.println("Video Url: " + driver.findElement(videoUrl).getAttribute("src"));

    }

    public void displayDirectorName() {
        System.out.println("Director name is: " + driver.findElement(directorname).getText());
    }

    public List<WebElement> getActors() {
        return driver.findElements(actors);
    }

    public void displayActors() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Actors: " + getActors().get(i).getText());
        }
    }

    public void displayMetaRate() {
        System.out.println("Meta rate: " + driver.findElement(metascore).getText());

    }


    public List<WebElement> getReviews() {
        return driver.findElements(qtyReviews);
    }

    public void displayReviews() {
        String a = (getReviews().get(1).getText());
        int userReviews = Integer.parseInt(a.substring(0, 1) + a.substring(2, 5));
        System.out.println("User reviews: " + userReviews);
        int critic = Integer.parseInt((getReviews().get(2).getText().substring(0, 3)));
        System.out.println("Critic reviews: " + critic);
        int sumReviews = userReviews + critic;
        System.out.println("Sum all reviews: " + sumReviews);
    }

    public List<WebElement> getLikefilms() {
        return driver.findElements(nameLikeFilm);
    }

    public void displayLikeFilms() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Like films: " + getLikefilms().get(i).getAttribute("title"));
        }

    }

    public void displayFilmInfo() {
        displayFilmName();
        displayYear();
        displayMovieLength();
        displayFilmRate();
        displayGenre();
        displayPosterUrl();
        displayVideoUrl();
        displayDirectorName();
        displayActors();
        displayMetaRate();
        displayReviews();
        displayLikeFilms();
    }

}
