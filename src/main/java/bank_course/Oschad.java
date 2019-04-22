package bank_course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Oschad {
    private WebDriver driver;

    public Oschad(WebDriver driver) {
        this.driver = driver;
    }


    private By buyUsd = By.xpath("//*[@class='buy-USD']");
    private By sellUsd = By.xpath("//*[@class='sell-USD']");

    public String getCurseBuy() {
        WebDriverWait wait = new WebDriverWait(driver, 4);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(buyUsd));
        return driver.findElement(buyUsd).getText();

    }

    public String getCurseSell() {
        WebDriverWait wait = new WebDriverWait(driver, 4);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(sellUsd));
        return driver.findElement(sellUsd).getText();

    }

    public double oschadBuy() {
        return Double.valueOf(getCurseBuy());

    }

    public double oschadSell() {
        return Double.valueOf(getCurseSell());

    }
}
