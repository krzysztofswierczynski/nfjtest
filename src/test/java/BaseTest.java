import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.JobOffers;

public class BaseTest {
    public WebDriver driver;
    protected JobOffers jobOffers;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://nofluffjobs.com/");
        jobOffers = new JobOffers(driver);
        jobOffers.waitForPageToLoad();
    }

    @After
    public void cleanup() {
        driver.quit();
    }
}
