import org.junit.Test;

public class JobOffersTest extends BaseTest {

    @Test
    public void validateElements() {
        jobOffers.validatePageElements();
    }

    @Test
    public void validateCookieInfo() {
        jobOffers.clickCookieInfoOkButton();
    }
}
