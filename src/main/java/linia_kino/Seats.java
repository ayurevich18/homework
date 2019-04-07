package linia_kino;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Seats {
    private WebDriver driver;

    public Seats(WebDriver driver) {
        this.driver = driver;
    }

    private By emptySeat = By.xpath("//*[@class=\"seat seat-color1\"]");
    private By ocuppiedSeat = By.xpath("//*[@class=\"seat seat-occupied\"]");
//    private By closeButton=By.xpath("/html/body/div[4]/table/tbody/tr/td/div/div");
//    private By iframe=By.cssSelector("iframe");


    public void closeAlert() {
        WebElement iframeElem = driver.findElement(By.cssSelector("iframe"));
        driver.switchTo().frame(iframeElem);
        WebElement element = driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td/div/div"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public List<WebElement> getEmptySeats() {


        return driver.findElements(emptySeat);

    }

    public List<WebElement> getOcuppiedSeats() {


        return driver.findElements(ocuppiedSeat);

    }

    public void dispalyOnConsole() {
        int emptySeats = getEmptySeats().size();
        int occupied = getOcuppiedSeats().size();
        int sum = emptySeats + occupied;
        double percentageEmptySeats = emptySeats * 100/sum;
        double percentageOcuppied = occupied * 100/sum;
        System.out.println("All seats in space: " + sum);
        System.out.println("Qty occupied seats: " + occupied);
        System.out.println("Qty empty seats: " + emptySeats);
        System.out.println("Percentage empty seats: " + Math.ceil(percentageEmptySeats) + "%");
        System.out.println("Percentage ocuppied seats: " + Math.ceil(percentageOcuppied) + "%");
    }
}
