package kismia;

import base_page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage extends BasePage {
    public WebDriver driver;
    public MainPage (WebDriver driver){
        super(driver);
    }

    private By dropdown=By.cssSelector("div.new-header-right > ul");
    private By sittingButton=By.cssSelector("a[href='/profile/settings']");
    private By messagesButton=By.cssSelector("div.new-header-center > ul > li:nth-child(2) > a");



    public void openSittingPage() {
        otherClick(dropdown);
        otherClick(sittingButton);
    }

    public void openMessagePage(){
        clickOn(messagesButton);
    }




}
