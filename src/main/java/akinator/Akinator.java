package akinator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;


import java.util.Scanner;


public class Akinator {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/yurevycho/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        WebDriverWait forOne = new WebDriverWait(driver, 10);


        //start game
        driver.get("http://ru.akinator.com/");

        forOne.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn-play']")));
        driver.findElement(By.xpath("//*[@class='btn-play']")).click();
        int count = 0;
        do {
            if (count > 0) {
                System.out.println(count);

                forOne.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='col-md-12 overlayed']/img")));
            }
            List<WebElement> a = driver.findElements(By.xpath("//*[@class='bubble-propose-container']"));
            if (a.size() > 0) {
                if (a.get(0).isDisplayed()) {
                    System.out.print("Я ДУМАЮ ЭТО " + a.get(0).getText());
                    driver.quit();
                    break;
                }
            }
            count++;


            forOne.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='question-text']")));

            System.out.println(driver.findElement(By.xpath("//*[@class='question-text']")).getText());

            forOne.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='database-selection selector dialog-box']//li")));

            List<WebElement> answer = driver.findElements(By.xpath("//*[@class='database-selection selector dialog-box']//li"));
            for (int i = 0; i < answer.size(); i++) {
                System.out.print(i + 1 + " - ");
                System.out.println(answer.get(i).getText());

            }
            System.out.print(" ");
            System.out.println("Введите ответ и нажмите Enter");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            System.out.println("Вы ввели: " + number);
            switch (number) {
                case 1:
                    answer.get(0).click();
                    break;
                case 2:
                    answer.get(1).click();
                    break;
                case 3:
                    answer.get(2).click();
                    break;
                case 4:
                    answer.get(3).click();
                    break;
                case 5:
                    answer.get(4).click();
                    break;
            }



        } while (driver.findElement(By.xpath("//*[@class='question-text']")).isDisplayed());


    }


}
