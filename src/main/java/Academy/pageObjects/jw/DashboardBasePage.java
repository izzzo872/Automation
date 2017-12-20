package Academy.pageObjects.jw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by toppa on 12/19/17.
 */
public class DashboardBasePage {

    /**** COMMON NAVBAR ITEMS ****/

    /*MANAGE*/

    @FindBy (linkText = "videos")
    private WebElement videos;

    @FindBy (linkText = "livestreams")
    private WebElement livestreams;

    @FindBy (linkText = "curated playlists")
    private WebElement curatedPlaylists;

    @FindBy (linkText = "recommendations")
    private WebElement recommendations;

    @FindBy (linkText = "tags")
    private WebElement tags;

    /*PUBLISH*/

    @FindBy (css = "a[href='/#/players/list'")
    private WebElement players;

    @FindBy (linkText = "showcase")
    private WebElement showcase;

    @FindBy (linkText = "tools")
    private WebElement tools;

    /*MONETIZE*/

    @FindBy (linkText = "ad schedules")
    private WebElement adSchedules;

    @FindBy (linkText = "overview")
    private WebElement overview;

    @FindBy (linkText = "content")
    private WebElement content;

    private WebDriver driver;

    public DashboardBasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickOnPlayersLink(){
        waitForElementToBeVisible(players);
        players.click();
    }

    public void waitForElementToBeVisible(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public boolean isAlertPresent(){
        try{
            Alert alert = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
            if(alert!=null){
                System.out.println("Alert is present");
                driver.switchTo().alert().accept();
                return true;
            }else{
                throw new Throwable();
            }
        }
        catch (Throwable e) {
            System.err.println("Alert isn't present!!");
            return false;
        }

    }
}