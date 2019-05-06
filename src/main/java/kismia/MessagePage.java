package kismia;

import base_page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MessagePage extends BasePage {


    public MessagePage(WebDriver driver) {
        super(driver);
    }

    private By suitable = By.cssSelector("div.new-aside > ul > li:nth-child(1) > a");
    private By moreButton = By.cssSelector(" div.grid__card-content > div>div");
    private By writeMessageButton = By.cssSelector(" div.grid__card-content > div > div > ul > li:nth-child(1) > a");
    private By messageInput = By.cssSelector("#form-compose > textarea");
    private By sendMessageButton = By.cssSelector("#form-compose > div.chat-controls-buttons > label > button");


    public void startMessage() {
        clickOn(suitable);
        clickOn(moreButton);
        clickOn(writeMessageButton);
    }

    public void writeMessage(String texts) {
        textInput(messageInput, texts);
        clickOn(sendMessageButton);
    }


}
