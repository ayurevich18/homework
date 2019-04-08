package bank_course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Universal {


    private WebDriver driver;

    public Universal(WebDriver driver) {
        this.driver = driver;
    }

    private By usdCurse = By.xpath("//*[@class=\"p-b-xs-2 p-y-1-sm\"]");

    public List<WebElement> getUniversalCurse() {
        driver.get("https://www.universalbank.com.ua/");

        return driver.findElements(usdCurse);
    }

    public Double UniversalBuy() {
        String a = getUniversalCurse().get(4).getText();
        return Double.valueOf(a);
    }

    public Double UniversalSell() {
        String b = getUniversalCurse().get(5).getText();
        return Double.valueOf(b);
    }

}