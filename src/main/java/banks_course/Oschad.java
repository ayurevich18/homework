package banks_course;

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


    public Double OschadBuy() {
        String a = getCurse("(data-buy.+)").get(0);
        return Double.valueOf(a.substring(a.indexOf("=") + 2, a.indexOf(">") - 2));

    }

    public Double OschadSell() {
        String a = getCurse("(data-sell.+)").get(0);
        return Double.valueOf(a.substring(a.indexOf("=") + 2, a.indexOf(">") - 2));

    }

    private String getPageSoursOschad() {
        String q = driver.getPageSource();
        return q;
    }

    private List<String> getCurse(String patterns) {

        String a = getPageSoursOschad();

        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(a);
        List<String> course = new LinkedList<String>();
        while (matcher.find()) {
            course.add(a.substring(matcher.start(), matcher.end()));

        }
        return course;

    }
}
