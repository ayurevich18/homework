package loginpage_facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MessagePage {

    private WebDriver driver;

    public MessagePage(WebDriver driver) {
        this.driver = driver;
    }

    private By message = By.xpath("//*/li[1]/div/a/div/div[2]/div[2]/span/span[2]");

    public void getMessage() {

        System.out.println(driver.findElement(message).getText());
    }
}
