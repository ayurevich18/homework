package kismia;

import base_page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SettingPage extends BasePage {
    public SettingPage(WebDriver driver) {
        super(driver);
    }

    private By personalDate = By.cssSelector("div.settings-nav > div:nth-child(2)");
    private By saveButton = By.cssSelector("[class='button-FR settings__button button--flat-green js_save']");
    private By changeGender = By.cssSelector("input[value=f]");
    private By days = By.cssSelector("#day");
    private By months = By.cssSelector("#month");
    private By years = By.cssSelector("#year");

    public void goToPersonalData() {
        clickOn(personalDate);
    }

    public void setBDay(String day, String month, String year) throws InterruptedException {
        Thread.sleep(3000);
        selectDefaultDropDown(day, days);
        selectDefaultDropDown(month, months);
        selectDefaultDropDown(year, years);
    }

    public void changeGender() {
        WebElement gender = finds(changeGender).get(0);
        gender.click();

    }

    public void clickSaveButton() {
        WebElement save = finds(saveButton).get(0);
        save.click();
    }

}
