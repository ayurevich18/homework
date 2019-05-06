package kismia;

import base_page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By loginInput = By.cssSelector("form>div>[name='email']");
    private By passInput = By.cssSelector("form>div>[name='password']");
    private By loginButton = By.cssSelector("form.home-page-form.js_signInForm > a");

    public void loginUser(String name, String password) {
        textInput(loginInput, name);
        textInput(passInput, password);
        jsClick(loginButton);
    }
}
