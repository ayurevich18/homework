package trello;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BrowserFactory {
    @Test
    public void login() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login("aleksej.yurevich@gmail.com", "12345678q");
        Assert.assertTrue(!driver.findElements(By.cssSelector(".mod-add")).isEmpty(), "Board page not opened");
    }
}
