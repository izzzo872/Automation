package Academy.Tests.nba;

import Academy.Tests.BaseTest;
import Academy.pageObjects.nba.NbaBasePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



/**
 * Created by toppa on 11/6/17.
 */
public class NbaHomePageTest extends BaseTest{
    NbaBasePage homePage = null;

    @BeforeMethod
    public void launchBrowser(){
        homePage = PageFactory.initElements(driver,NbaBasePage.class);

    }

    @AfterMethod
    public void closerDriver(){
        driver.quit();
    }

    @Test
    public void testNewsLink() {
        SoftAssert a = new SoftAssert();
        a.assertTrue(homePage.isElementPresent(homePage.getNews()),
                "Expected 'News' link to be present within Nav");
        homePage.clickOnElement(homePage.getNews());
        a.assertTrue(driver.getTitle().contains("News"),
                "Expected user to be directed to the 'News' page upon click");

        a.assertAll();
    }

    @Test
    public void testScheduleLink() {
        SoftAssert a = new SoftAssert();
        a.assertTrue(homePage.isElementPresent(homePage.getSchedule()),
                "Expected 'Schedule' link to be present within Nav");
        homePage.clickOnElement(homePage.getNews());
        a.assertTrue(driver.getTitle().contains("Schedule"),
                "Expected user to be directed to the 'Schedule' page upon click");

        a.assertAll();
    }

}
