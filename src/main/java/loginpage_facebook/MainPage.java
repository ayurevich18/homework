package loginpage_facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By messageButton = By.xpath("//*[@id=\"navItem_217974574879787\"]/a/div");

    public MessagePage clickMessageButton() {
        driver.findElement(messageButton).click();
        return new MessagePage(driver);
    }


}
