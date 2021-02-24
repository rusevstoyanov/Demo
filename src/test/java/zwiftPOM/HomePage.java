package zwiftPOM;
import base.Base;
import commons.Library;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends Base {
    By eventsBtn = By.xpath("//div[@class=\"znv-d-none znv-d-lg-flex\"]//a[@href='/events']");
    By sightInAcountBtn = By.xpath("//div/div/a/span[text()=\"Sign In\"]");

    public void goToHomePage() {
        driver.get("https://zwift.com");
    }

    public void verifyHomePageTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "The at Home Cycling & Running Virtual Training App - Zwift");
    }

    public void validateSighInAccountBtn() {
        boolean createAccount = Lib.waitForElement(sightInAcountBtn).isDisplayed();
        Assert.assertTrue(createAccount);
    }

    public void goToEventsPage() {
        Library.waitForElement(eventsBtn).click();
    }


}
