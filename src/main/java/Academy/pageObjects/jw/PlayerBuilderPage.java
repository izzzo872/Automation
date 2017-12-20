package Academy.pageObjects.jw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by toppa on 12/19/17.
 */
public class PlayerBuilderPage extends PlayersListPage {

    @FindBy (id = "player-name")
    private WebElement playerNameField;

    @FindBy (xpath = "//jw-dropdown[@dropdown-items='aspectRatios']/div")
    private WebElement aspectRatioDropdown;

    @FindBy (xpath = "//jw-dropdown[@dropdown-items='aspectRatios']//a")
    private List<WebElement> aspectRatioDropdownValues;

    @FindBy (css = "button[type='submit']")
    private WebElement saveBtn;

    @FindBy (css = "button[ng-click='close()']")
    private WebElement closeBtn;


    public PlayerBuilderPage(WebDriver driver){
        super(driver);
    }

    public void editPlayerName(String desiredText){
        System.out.println("entering player name");
        waitForElementToBeVisible(playerNameField);
        playerNameField.click();
        playerNameField.clear();
        playerNameField.sendKeys(desiredText);
    }

    public void selectDesiredAspectRatio(String aspectRatio){
        waitForElementToBeVisible(aspectRatioDropdown);
        aspectRatioDropdown.click();
        System.out.println("setting desired aspect ratio");
        for(WebElement ele : aspectRatioDropdownValues){
            if(aspectRatio.equals(ele.getText())){
                ele.click();
            }
        }
    }

    public void clickOnSaveButton(){
        System.out.println("clicking save button");
        waitForElementToBeVisible(saveBtn);
        saveBtn.click();
    }

    public void clickOnCloseButton(){
        System.out.println("clicking close button");
        waitForElementToBeVisible(closeBtn);
        closeBtn.click();
    }
}