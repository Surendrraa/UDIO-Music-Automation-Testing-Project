package stepdefin;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages1.SignInPage;

public class SignInSteps {
    WebDriver driver;
    SignInPage signInPage;

    @BeforeClass
    public void setup() throws InterruptedException {
    	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://www.udio.com/");
        signInPage = new SignInPage(driver);
    }

    @DataProvider(name = "signInData")
    public Object[][] signInDataProvider() {
        return new Object[][] {
            {"CV Surendra", "Surendra", "https://surendrraa.github.io/C-V-Surendra-Portfolio/", "This is a description."}
        };
    }

    @Test(dataProvider = "signInData")
    public void signInTest(String displayName, String fullName, String website, String description) throws InterruptedException {
        signInPage.clickSignIn();
        signInPage.clickSignInWithGoogle();
        signInPage.clickAccount();
        signInPage.clickContinue();
        // Switch to the iframe that appears after clicking Continue
        Thread.sleep(5000);
        signInPage.switchToIframe();
        signInPage.enterYourName(displayName);
        signInPage.enterFullName(fullName);
        signInPage.enterYourWebsite(website);
        signInPage.enterDescription(description);
        signInPage.clickSubmit();
        // Switch back to the default content
        signInPage.switchToDefaultContent();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
