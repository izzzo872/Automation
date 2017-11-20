package Academy.Tests;

import Academy.pageObjects.nba.NbaBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

/**
 * Created by toppa on 11/6/17.
 */
public class NbaHomePageTest{

    WebDriver driver;
    NbaBasePage homePage = null;

    @BeforeTest
    public void launchBrowser(){
        homePage = new NbaBasePage(driver);

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
