package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SignInPage {
    WebDriver driver;
    Actions actions;

    // Locators
    By signBtn = By.xpath("//button[text()='Sign In']");
    By signGoogle = By.xpath("//button[text()='Sign in with Google']");
    By clickAccount = By.xpath("//div[@data-email='cvsurendra2001@gmail.com']");
    By continueBtn = By.xpath("//span[text()='Continue']");
    By iframeLocator = By.xpath("//div[@role='dialog']");  // Adjust this as needed

    // Locators for elements inside iframe
    By yourName = By.xpath("//input[@placeholder='Your display name']");
    By fullName = By.id(":rl6:-form-item");
    By yourWebsite = By.xpath("//input[@placeholder='Your website']");
    By description = By.xpath("//label[text()='Description (Optional)']/following::input");
    By submitBtn = By.xpath("//button[text()='Submit']");

    // Constructor
    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    // Methods
    public void clickSignIn() {
        driver.findElement(signBtn).click();
    }

    public void clickSignInWithGoogle() {
        driver.findElement(signGoogle).click();
    }

    public void clickAccount() {
        driver.findElement(clickAccount).click();
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

    public void switchToIframe() {
        WebElement iframe = driver.findElement(iframeLocator);
        driver.switchTo().frame(iframe);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void enterYourName(String name) {
        scrollToElement(driver.findElement(yourName));
        driver.findElement(yourName).sendKeys(name);
    }

    public void enterFullName(String name) {
        scrollToElement(driver.findElement(fullName));
        driver.findElement(fullName).sendKeys(name);
    }

    public void enterYourWebsite(String website) {
        scrollToElement(driver.findElement(yourWebsite));
        driver.findElement(yourWebsite).sendKeys(website);
    }

    public void enterDescription(String desc) {
        scrollToElement(driver.findElement(description));
        driver.findElement(description).sendKeys(desc);
    }

    public void clickSubmit() {
        scrollToElement(driver.findElement(submitBtn));
        driver.findElement(submitBtn).click();
    }

    // Scroll to element method
    private void scrollToElement(WebElement element) {
        actions.moveToElement(element).perform();
    }
}
