package bank_course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Private24 {
    private WebDriver driver;

    public Private24(WebDriver driver) {
        this.driver = driver;
    }

    private By usdCurse = By.xpath("//*[@class=\"section-content rate\"]");

    public List<WebElement> getPrivateCurse() {
        driver.get("https://www.privat24.ua/");
        driver.navigate().refresh();
        return driver.findElements(usdCurse);
    }

    public Double PrivateBuy() {
        String a = (getPrivateCurse().get(0).getText()).substring(0, 5);
        return Double.valueOf(a);
    }

    public Double PrivateSell() {
        String b = (getPrivateCurse().get(0).getText()).substring(9, 14);
        return Double.valueOf(b);

    }
}
