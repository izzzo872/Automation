package Academy.pageObjects.jw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

/**
 * Created by toppa on 12/19/17.
 */
public class PlayersListPage extends DashboardBasePage {

    @FindBy (linkText = "Create New Player")
    private WebElement createNewPlayerBtn;

    @FindBy (linkText = "16:9 example player")
    private WebElement sixteenNineExamplePlayer;

    @FindBy (linkText = "640x360 example player")
    private WebElement sixfourtyByThreeSixtyExamplePlayer;

    @FindBy (id = "plyr_search")
    private WebElement searchPlayersField;

    @FindBy (css = "a[ng-if*='player.version']")
    private WebElement tablePlayerName;

    @FindBy (css = "td[class='ng-binding']")
    private WebElement tablePlayerAspectioRatio;


    public PlayersListPage(WebDriver driver){
        super(driver);
    }

    public void clickOnExamplePlayerName(){             // going to click on very top one for this test
        System.out.println("clicking on example player");
        tablePlayerName.click();
    }

    public String getPlayerNameText(){
        return tablePlayerName.getText();
    }

    public String getPlayerAspectRatioText(){
        return tablePlayerAspectioRatio.getText();
    }

    public boolean verifyPlayerNameIsSaved(String expectedPlayerName){
        System.out.println("verifying playerName is saved");
        return expectedPlayerName.equals(tablePlayerName.getText());
    }

    public boolean verifyPlayerSizeIsSaved(String expectedPlayerSize){
        System.out.println("verifying playerSize is saved");
        return expectedPlayerSize.equals(tablePlayerAspectioRatio.getText());
    }
}
