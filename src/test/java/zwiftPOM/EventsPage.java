package zwiftPOM;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class EventsPage extends Base {

    By sportsDropDown = By.xpath("(//select[@class='filter-selector'])[1]");
    By intensitiesDropDown = By.xpath("(//select[@class='filter-selector'])[2]");
    By startTimesDropDown = By.xpath("(//select[@class='filter-selector'])[3]");
    By allEvents = By.xpath("//span[@class='map-sport-type']");
    By noEventsText = By.xpath("//div[@class='header-title']");


    public void verifyEventsPageTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Zwift | Events on Zwift");
    }

    public void sportsDropDownBtn(String choceSports) {
        Select select = new Select(Lib.waitForElement(sportsDropDown));
        select.selectByVisibleText(choceSports);
    }

    public void intensitiesDropDownBtn(String choiceIntensitice) {
        Select select = new Select(Lib.waitForElement(intensitiesDropDown));
        select.selectByVisibleText(choiceIntensitice);
    }

    public void startTimesDropDownBtn(String choiceStartTime) {
        Select select = new Select(Lib.waitForElement(startTimesDropDown));
        select.selectByVisibleText(choiceStartTime);
    }

    public void filterEvents(String choceSports, String choiceIntensitice, String choiceStartTime) {

        sportsDropDownBtn(choceSports);
        intensitiesDropDownBtn(choiceIntensitice);
        startTimesDropDownBtn(choiceStartTime);
    }

    public void validateWhetherEventsHaveChange(String EventType) {
        List<WebElement> allElements = driver.findElements(allEvents);
        if (allElements.size() > 0) {
            for (WebElement e : allElements) {
                Assert.assertEquals(e.getText(), EventType);
            }
        } else {
            Assert.assertEquals(Lib.waitForElement(noEventsText).getText(), "Event series completed.");
        }
    }


}
