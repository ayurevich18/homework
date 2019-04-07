package bank_course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Private24  {
    private WebDriver driver;
    public Private24(WebDriver driver){
        this.driver=driver;
    }
    private By usdCurse=By.xpath("//*[@class=\"section-content rate\"]");

    public List<WebElement> getPrivateCurse(){
        driver.get("https://www.privat24.ua/");
        driver.navigate().refresh();
        return driver.findElements(usdCurse);
    }

    public void displayPrivatecurese(){
        String a=getPrivateCurse().get(0).getText();
        String b=a.substring(0,5);
        String c=a.substring(9,14);

        System.out.println(a);
        System.out.println("Buy course: "+b);
        System.out.println("Sell course: "+c);


       Double buyCourse=Double.valueOf(b);
        Double sellCourse=Double.valueOf(c);
        System.out.println(buyCourse);
        System.out.println(sellCourse);



    }
}
