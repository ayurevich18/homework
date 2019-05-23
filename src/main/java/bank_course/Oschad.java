package bank_course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Oschad {
    private WebDriver driver;

    public Oschad(WebDriver driver) {
        this.driver = driver;
    }


    public List<String> getCurseBuy() {

        String a = getPageSoursOschad();

        Pattern pattern = Pattern.compile("(data-buy.+)");
        Matcher matcher = pattern.matcher(a);
        List<String> course = new LinkedList<String>();
        while (matcher.find()) {
            course.add(a.substring(matcher.start(), matcher.end()));

        }
        return course;

    }

    public List<String> getCurseSell() {

        String a = getPageSoursOschad();

        Pattern pattern = Pattern.compile("(data-sell.+)");
        Matcher matcher = pattern.matcher(a);
        List<String> course = new LinkedList<String>();
        while (matcher.find()) {
            course.add(a.substring(matcher.start(), matcher.end()));

        }
        return course;

    }


    public Double OschadBuy() {
        String a = getCurseBuy().get(0);
        return Double.valueOf(a.substring(a.indexOf("=") + 2, a.indexOf(">") - 2));

    }

    public Double OschadSell() {
        String a = getCurseSell().get(0);
        return Double.valueOf(a.substring(a.indexOf("=") + 2, a.indexOf(">") - 2));

    }

    public String getPageSoursOschad() {
        String q = driver.getPageSource();
        return q;
    }
}
