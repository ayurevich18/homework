package trello.com;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BrowserFactory {
    private By emailFld = By.cssSelector("#user");
    private By passwordFld = By.cssSelector("#password");
    private By loginBth = By.cssSelector("#login");


    public void open(){
        driver.get("https://trello.com/login");
    }

    public void login(String email, String password){
        driver.findElement(emailFld).clear();
        driver.findElement(emailFld).sendKeys(email);
        driver.findElement(passwordFld).clear();
        driver.findElement(passwordFld).sendKeys(password);
        driver.findElement(loginBth).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("https://trello.com/aleksey899/boards"));
    }

}
