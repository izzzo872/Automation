package Academy.pageObjects.jw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by toppa on 12/19/17.
 */
public class LoginPage {

    @FindBy (id = "email")
    private WebElement emailField;

    @FindBy (css = "input[name='password']")
    private WebElement passwordField;

    @FindBy (id = "submit_login")
    private WebElement signInBtn;

    @FindBy (linkText = "Sign up")
    private WebElement signUpLink;

    @FindBy (linkText = "Forgot password?")
    private WebElement forgotPasswordLink;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void login(String user, String password){
        System.out.println("logging into account");
        emailField.sendKeys(user);
        passwordField.sendKeys(password);
        signInBtn.click();
    }





}
