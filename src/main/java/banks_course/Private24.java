package banks_course;

import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Private24 {
    private WebDriver driver;

    public Private24(WebDriver driver) {
        this.driver = driver;
    }


    public Double PrivateBuy() {
        String a = getCourse("rate\">\\d.{25}").get(0);
        return Double.valueOf(a.substring(a.indexOf("<") - 6, a.indexOf("<")));
    }

    public Double PrivateSell() {
        String b = getCourse("rate\">\\d.{25}").get(0);
        return Double.valueOf(b.substring(b.indexOf(">") + 1, b.indexOf("&")));

    }

    private String getPageSoursePrivateBank() {
        String q = driver.getPageSource();
        return q;
    }

    private List<String> getCourse(String patterns) {
        String a = getPageSoursePrivateBank();

        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(a);
        List<String> course = new LinkedList<String>();
        while (matcher.find()) {
            course.add(a.substring(matcher.start(), matcher.end()));

        }
        return course;

    }
}
