package testSuit;
import base.Base;
import org.testng.annotations.Test;
import zwiftPOM.EventsPage;
import zwiftPOM.HomePage;

public class ZwiftSmokeTest extends Base {
    HomePage homePage = new HomePage();
    EventsPage eventsPage = new EventsPage();

    @Test
    public void validateHomePage() {
        homePage.goToHomePage();
        homePage.verifyHomePageTitle();
        homePage.validateSighInAccountBtn();
    }
    @Test
    public void validateEventsResults() throws InterruptedException {
        homePage.goToHomePage();
        homePage.goToEventsPage();
        eventsPage.verifyEventsPageTitle();


        eventsPage.filterEvents("Running", "B", "Morning");
        Thread.sleep(3000);
        eventsPage.validateWhetherEventsHaveChange("RUNNING");
        Thread.sleep(5000);
        eventsPage.filterEvents("Cycling", "A", "Evening");
        Thread.sleep(3000);
        eventsPage.validateWhetherEventsHaveChange("CYCLING");
        Thread.sleep(4000);
        eventsPage.filterEvents("Running", "B", "Evening");
        eventsPage.validateWhetherEventsHaveChange("RUNNING");


    }

}
