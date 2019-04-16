package bank_course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Universal {


    private WebDriver driver;

    public Universal(WebDriver driver) {
        this.driver = driver;
    }

    private By usdCurse = By.xpath("//*[@class='p-b-xs-2 p-y-1-sm']");

    public List<WebElement> getUniversalCurse() {
        WebDriverWait wait = new WebDriverWait(driver, 4);
        driver.get("https://www.universalbank.com.ua/");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(usdCurse));
        return driver.findElements(usdCurse);
    }

    public double universalBuy() {
        String a = getUniversalCurse().get(4).getText();
        return Double.valueOf(a);
    }

    public double universalSell() {
        String b = getUniversalCurse().get(5).getText();
        return Double.valueOf(b);
    }

}