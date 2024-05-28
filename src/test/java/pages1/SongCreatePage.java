package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import stepdefin.SignInSteps;

public class SongCreatePage extends SignInSteps{
    WebDriver driver;

    // Locators
    By search_bar = By.xpath("//input[@type='prompt']");
    By custom = By.xpath("//div[text()='Write your own lyrics']");
    By own_lyrics = By.xpath("//textarea[@placeholder='Write custom lyrics here']");
    By create_btn = By.xpath("//button[text()='Create']");

    // Constructor
    public SongCreatePage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void enterSearchTerm(String searchTerm) {
        driver.findElement(search_bar).sendKeys(searchTerm);
    }

    public void clickCustom() {
        driver.findElement(custom).click();
    }

    public void enterOwnLyrics(String lyrics) {
        driver.findElement(own_lyrics).sendKeys(lyrics);
    }

    public void clickCreate() {
        driver.findElement(create_btn).click();
    }
}
