package banks_course;

import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Universal {
    private WebDriver driver;

    public Universal(WebDriver driver) {
        this.driver = driver;
    }

    public Double UniversalBuy() {
        String a = getCourse("[0-9].\\.[0-9].").get(1);
        return Double.valueOf(a);
    }

    public Double UniversalSell() {
        String b = getCourse("[0-9].\\.[0-9].").get(2);
        return Double.valueOf(b);
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
