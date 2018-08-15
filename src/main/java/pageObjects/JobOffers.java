package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;


public class JobOffers {
    @FindBy(className = "salary-banner-main")
    private WebElement topBanner;

    @FindBy(css = "div.cookie-information")
    private WebElement cookieInfo;

    @FindBy(css = "button.cookie-hide")
    private WebElement cookieOkButton;

    @FindBy(css = "footer")
    private WebElement footer;

    private WebDriver driver;
    private WebDriverWait wait;

    public JobOffers(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(cookieInfo));
    }

    public void validatePageElements() {
        assertTrue("Cookie information is not displayed", cookieInfo.isDisplayed());
        assertTrue("Footer is not displayed", footer.isDisplayed());
    }

    public void clickCookieInfoOkButton() {
        cookieOkButton.click();

        int height = Integer.parseInt(((JavascriptExecutor)driver).executeScript("return window.innerHeight").toString());
        wait.until(driver1 -> cookieInfo.getLocation().y >= height);
    }
}
