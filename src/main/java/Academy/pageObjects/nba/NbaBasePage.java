package Academy.pageObjects.nba;

import Academy.resources.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by toppa on 11/6/17.
 */
public class NbaBasePage extends BasePage{

    /******************
    *
    *  NAV ITEMS
    ******************/

    @FindBy (css = "a[href='/scores']")
    private WebElement scores;

    @FindBy (css = "a[href='/schedule']")
    private WebElement schedule;

    @FindBy (css = "a[href='/news']")
    private WebElement news;

    @FindBy (css = "a[href='/video']")
    private WebElement video;

    @FindBy (css = "a[href='/standings']")
    private WebElement standings;

    @FindBy (css = "a[href='/stats']")
    private WebElement stats;

    @FindBy (css = "a[href='/players']")
    private WebElement players;

    @FindBy (css = "a[href='/teams']")
    private WebElement teams;


    public NbaBasePage(WebDriver driver) {
       super(driver);
       getDriver().get("http://www.nba.com");
    }

    public WebElement getScores() {
        return scores;
    }

    public WebElement getSchedule() {
        return schedule;
    }

    public WebElement getNews() {
        return news;
    }

    public WebElement getVideo() {
        return video;
    }

    public WebElement getStandings() {
        return standings;
    }

    public WebElement getStats() {
        return stats;
    }

    public WebElement getPlayers() {
        return players;
    }

    public WebElement getTeams() {
        return teams;
    }

    public void clickOnElement(WebElement ele){
        ele.click();
    }

    public boolean isElementPresent(WebElement ele){
        return ele.isDisplayed();
    }
}