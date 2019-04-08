package bank_course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UkrsibBank {
    private WebDriver driver;

    public UkrsibBank(WebDriver driver) {
        this.driver = driver;
    }

    private By usdCurse = By.xpath("//tr[1]/td[child::span[contains(text(), *)]]");

    public List<WebElement> getUkrsibCurse() {
        driver.get("https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/");
        return driver.findElements(usdCurse);
    }

    public Double UkrsibBuy() {
        String a = getUkrsibCurse().get(0).getText();
        return Double.valueOf(a);
    }

    public Double UkrsibSell() {
        String b = getUkrsibCurse().get(1).getText();
        return Double.valueOf(b);
    }


}

