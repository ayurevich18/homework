package bank_course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Oschad {
    private WebDriver driver;
    public Oschad (WebDriver driver){
        this.driver=driver;
    }
    private By buyUsd=By.xpath("//*[@class=\"buy-USD\"]");
    private By sellUsd=By.xpath("//*[@class=\"sell-USD\"]");

    public String getCurseBuy(){

        return driver.findElement(buyUsd).getText();

    }

    public String getCurseSell(){

        return driver.findElement(sellUsd).getText();

    }
     public void curseOschad(){
         Double uBuy=Double.valueOf(getCurseBuy());
         Double sBuy=Double.valueOf(getCurseSell());
         System.out.println("Buy course: "+uBuy);
         System.out.println("Sell course: "+sBuy);
     }
}
