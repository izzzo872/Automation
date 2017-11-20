package Academy.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by toppa on 11/20/17.
 */
public class BaseTest {


    public static WebDriver driver = null;
    public Properties prop;


    @BeforeSuite
    public void initDriver() throws IOException{
        driver = initializeDriver();
    }

    @AfterSuite
    public void tearDownTest(){
        BaseTest.driver.quit();
    }

    public WebDriver initializeDriver() throws IOException
    {
        prop = new Properties();
        FileInputStream fis=new FileInputStream("/Users/toppa/Project/src/main/java/Academy/resources/_config.properties");

        prop.load(fis);
        String browserName = prop.getProperty("browser");
        System.out.println(browserName);

        if(browserName.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "/Users/toppa/Desktop/chromedriver");
            driver = new ChromeDriver();
        }
        else if (browserName.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "/Users/toppa/Desktop/geckodriver");
            driver = new FirefoxDriver();

        }
        else if (browserName.equals("IE"))
        {
            //	IE code
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }
}
