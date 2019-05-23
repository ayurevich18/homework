package bank_course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UkrsibBank {
    private WebDriver driver;

    public UkrsibBank(WebDriver driver) {
        this.driver = driver;
    }

   public List<String> getSellCourse() {
       String a = getPageSourseUkrBank();

       Pattern pattern = Pattern.compile("Продажа.+[0-6]");
       Matcher matcher = pattern.matcher(a);
       List<String> course = new LinkedList<String>();
       while (matcher.find()) {
           course.add(a.substring(matcher.start(), matcher.end()));

       }
       return course;

   }

    public List<String> getBuyCourse() {
        String a = getPageSourseUkrBank();

        Pattern pattern = Pattern.compile("Покупка.+[0-6]");
        Matcher matcher = pattern.matcher(a);
        List<String> course = new LinkedList<String>();
        while (matcher.find()) {
            course.add(a.substring(matcher.start(), matcher.end()));

        }
        return course;

    }

    public Double UkrsibBuy() {
        String a = getBuyCourse().get(0);
        return Double.valueOf(a.substring(a.indexOf(">")+1));
    }

    public Double UkrsibSell() {
        String b = getSellCourse().get(0);
        return Double.valueOf(b.substring(b.indexOf(">")+1));
    }

    public String getPageSourseUkrBank(){
        String q=driver.getPageSource();
        return q;
    }


}

