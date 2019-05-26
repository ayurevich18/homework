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


    public Double UkrsibBuy() {
        String a = getCourse("Покупка.+[0-6]").get(0);
        return Double.valueOf(a.substring(a.indexOf(">") + 1));
    }

    public Double UkrsibSell() {
        String b = getCourse("Продажа.+[0-6]").get(0);
        return Double.valueOf(b.substring(b.indexOf(">") + 1));
    }

    private String getPageSourseUkrBank() {
        String q = driver.getPageSource();
        return q;
    }

    private List<String> getCourse(String patterns) {
        String a = getPageSourseUkrBank();

        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(a);
        List<String> course = new LinkedList<String>();
        while (matcher.find()) {
            course.add(a.substring(matcher.start(), matcher.end()));

        }
        return course;

    }


}

