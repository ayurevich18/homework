package loginpage_facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    private By loginInput = By.id("email");
    private By passInput = By.id("pass");
    private By loginButton = By.xpath("//*[@id=\"u_0_2\"]");


    public LoginPage typeEmail(String email) {
        WebElement element = driver.findElement(loginInput);
        element.clear();
        element.sendKeys(email);
        return this;
    }

    public LoginPage typePassword(String pass) {
        WebElement element = driver.findElement(passInput);
        element.clear();
        element.sendKeys(pass);
        return this;
    }


    public MainPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new MainPage(driver);
    }

    public MainPage loginUser(String email, String pass) {
        typeEmail(email);
        typePassword(pass);
        clickLoginButton();
        return new MainPage(driver);
    }
}
