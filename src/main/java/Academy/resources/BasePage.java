package Academy.resources;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by toppa on 11/6/17.
 */
public class BasePage {

    protected WebDriver driver;

    public  BasePage(WebDriver driver) {
        driver = getDriver();
        this.driver = driver;
    }

    public WebDriver getDriver() {
        try{
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream("/Users/toppa/Project/src/main/java/Academy/resources/_config.properties");
            prop.load(fis);
            String browserName = prop.getProperty("browser");
            System.out.println(browserName);
            if(browserName.equals("chrome")){
                System.setProperty("webdriver.chrome.driver","/Users/toppa/Desktop/chromedriver");
                driver = new ChromeDriver();

            } else if(browserName.equals("firefox")){
                System.setProperty("webdriver.gecko.driver","/Users/toppa/Desktop/geckodriver");
                driver = new FirefoxDriver();

            } else if(browserName.equals("IE")){
                driver = new InternetExplorerDriver();
            }

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }catch (IOException e){}
        PageFactory.initElements(this.driver,this.getClass());
        return driver;
    }
}