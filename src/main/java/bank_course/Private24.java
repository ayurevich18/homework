package bank_course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Private24 {
    private WebDriver driver;

    public Private24(WebDriver driver) {
        this.driver = driver;
    }

    private By usdCurse = By.xpath("//*[@class='section-content rate']");

    public List<WebElement> getPrivateCurse() {
        WebDriverWait wait = new WebDriverWait(driver, 4);
        driver.get("https://www.privat24.ua/");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(usdCurse));
        return driver.findElements(usdCurse);
    }

    public double privateBuy() {
        String a = (getPrivateCurse().get(0).getText()).substring(0, 5);
        return Double.valueOf(a);
    }

    public double privateSell() {
        String b = (getPrivateCurse().get(0).getText()).substring(9, 14);
        return Double.valueOf(b);

    }


}
