package stepdefin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages1.SongCreatePage;

public class SongCreateSteps {
    WebDriver driver;
    SongCreatePage songCreatePage;

    @BeforeClass
    public void setup() throws InterruptedException {
    	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://www.udio.com/");
        songCreatePage = new SongCreatePage(driver);
    }

    @DataProvider(name = "songCreateData")
    public Object[][] songCreateDataProvider() {
        return new Object[][] {
            {"Love song", "When I see you smile,My heart starts to race.In your eyes, I find,My favorite place.With you, stars align,In your arms, I'm fine.Through storm, through tear,I'll be forever near.You're my heart's song,In your laugh, I'm strong.Hand in hand, we stride,Love's eternal ride.In your arms, my home,With you, not alone."}
        };
    }

    @Test(dataProvider = "songCreateData")
    public void createSongTest(String searchTerm, String lyrics) {
        songCreatePage.enterSearchTerm(searchTerm);
        songCreatePage.clickCustom();
        songCreatePage.enterOwnLyrics(lyrics);
        songCreatePage.clickCreate();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}

