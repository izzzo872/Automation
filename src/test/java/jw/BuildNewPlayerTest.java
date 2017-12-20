package jw;

import Academy.pageObjects.jw.DashboardBasePage;
import Academy.pageObjects.jw.LoginPage;
import Academy.pageObjects.jw.PlayerBuilderPage;
import Academy.pageObjects.jw.PlayersListPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

/**
 * Created by toppa on 12/19/17.
 */
public class BuildNewPlayerTest {

        private LoginPage loginPage;
        private DashboardBasePage dashboardPage;
        private PlayersListPage playersListPage;
        private PlayerBuilderPage playerBuilderPage;
        private String user = "aizaztoppa78@gmail.com";
        private String pw = "Garnett21*";
        private WebDriver driver;
        private String testPlayerName = "TESTING PLAYER";
        private String testaspectRatio = "16:9";

        @BeforeTest()
        public void initSetup(){
            System.setProperty("webdriver.chrome.driver","/Users/toppa/Desktop/chromedriver");
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.get("https://dashboard.jwplayer.com/");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            loginPage = new LoginPage(driver);
            dashboardPage = new DashboardBasePage(driver);
            playersListPage = new PlayersListPage(driver);
            playerBuilderPage = new PlayerBuilderPage(driver);

        }

        @Test()
        public void editExistingPlayerTest(){
            SoftAssert softAssert = new SoftAssert();
            loginPage.login(user,pw);
            dashboardPage.clickOnPlayersLink();
            playersListPage.clickOnExamplePlayerName();
            playerBuilderPage.editPlayerName(testPlayerName);
            playerBuilderPage.selectDesiredAspectRatio(testaspectRatio);
            playerBuilderPage.clickOnSaveButton();
            playerBuilderPage.clickOnCloseButton();
            playerBuilderPage.isAlertPresent();
            softAssert.assertTrue(playersListPage.verifyPlayerNameIsSaved(testPlayerName),
                    String.format("player name did NOT match, Expected '%s' but found '%s'",testPlayerName,
                        playersListPage.getPlayerNameText()));
            softAssert.assertTrue(playersListPage.verifyPlayerSizeIsSaved(testaspectRatio),
                    String.format("aspect ratio did NOT match, Expected '%s' but found '%s'",testaspectRatio,
                        playersListPage.getPlayerAspectRatioText()));

            softAssert.assertAll();
        }

    }