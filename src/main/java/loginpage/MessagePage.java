package loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MessagePage{

    private WebDriver driver;

    public MessagePage(WebDriver driver){this.driver = driver;}
    //*[@id="js_b"]/div/ul/li[1]
    //private By autor=By.xpath("//*[@id=\"js_a1\"]/div/div/ul/li[1]/a/div/div[2]/div/div[2]/div/div[1]/span");
    private By message=By.xpath("//*/li[1]/div/a/div/div[2]/div[2]/span/span[2]");
//    private By messageLable=By.xpath("//*[@id=\"js_a1\"]/div/div/ul/li");

    public void getMessage(){

       // System.out.println(driver.findElement(autor).getText());
      System.out.println(driver.findElement(message).getText());
    }



}
