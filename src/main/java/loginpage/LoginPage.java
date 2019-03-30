package loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver){this.driver = driver;}



    private By loginInput=By.xpath("//*[@id=\"email\"]");
    private By passInput=By.xpath("//*[@id=\"pass\"]");
    private By loginButton=By.xpath("//*[@id=\"u_0_2\"]");



   public LoginPage typeEmail(String email){
       driver.findElement(loginInput).clear();
       driver.findElement(loginInput).sendKeys(email);
       return this;
   }

   public LoginPage typePassword(String pass){
       driver.findElement(passInput).clear();
       driver.findElement(passInput).sendKeys(pass);
       return this;
   }


   public MainPage clickLoginButton(){
       driver.findElement(loginButton).click();
       return new MainPage(driver);
   }

   public MainPage loginUser(String email, String pass){
       this.typeEmail(email);
       this.typePassword(pass);
       this.clickLoginButton();
       return new MainPage(driver);
   }
}
