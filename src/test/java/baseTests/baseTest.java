package baseTests;

import Pages.HomePage;
import Pages.LoginPage;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class baseTest {
    private WebDriver driver;
    protected HomePage homePage;
    String BaseUrl = "https://katalon-demo-cura.herokuapp.com/";

    @BeforeSuite

    public void setup() {
        //sets your web driver from the location th resources folder
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BaseUrl);
        homePage = new HomePage(driver);
        driver.getTitle(); //Gets the title of the application
        System.out.println("Title name: " + driver.getTitle());

        String expectedTitle = "CURA Healthcare Service";
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website match");
    }
    @AfterMethod
    //creates reports for passed/failed tests
    public void captureScreenShot(ITestResult testResult) {  //this is a function

        if (testResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir")
                    + "/resources/Screenshots/Failed/" + testResult.getName() + "_Failed" + testResult.getEndMillis() + ".png");

            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // user.dir is a windows command
            // driver.quit(); //closed ths browser and ends the session
        }
        else  {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir")
                    + "/resources/Screenshots/Passed/" + testResult.getName() + "_Passed" + testResult.getEndMillis() + ".png");

            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // user.dir is a windows command
            // driver.quit(); //closed ths browser and ends the session
        }

    }

    @AfterMethod
    public void tearDown () {

        driver.quit(); //test
    }

}




