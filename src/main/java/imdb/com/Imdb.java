package imdb.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Imdb {
    private WebDriver driver;
    public Imdb(WebDriver driver){
        this.driver=driver;
    }

    private By filmName=By.xpath("//h1/text()[1]");
    private By yearStart=By.xpath("//*[@id='titleYear']/a");
    private By movieLength=By.xpath("//*[@id='titleDetails']//time"); //in sec
    private By rateFilm=By.xpath("//*[@itemprop='ratingValue']"); //9.3
    private By rateFilm1=By.xpath("//*[@itemprop='bestRating']");//10
    private By Genre=By.xpath("//*[@class='subtext']/a[1]");
    private By posterUrl=By.xpath("//*[@alt='Побег из Шоушенка Poster']");
    private By videoUrl=By.xpath("//*[@alt='Trailer']"); //src
    private By directorname=By.xpath("//*[@id='title-overview-widget']/div[2]/div[1]/div[2]/a"); //xz kak napisat xpath
    private By actors=By.xpath("//tbody//td[2]/a"); //5 actors display
    private By metascore =By.xpath("//*[@class='titleReviewBar ']//div[1]/span");
    private By qtyReviews=By.xpath("//*[@class='subText']/a"); //use 2(users) //3 critics //sum





}
