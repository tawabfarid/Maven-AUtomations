package Reusable_library;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.UUID;

public class Abstract_Class {

    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    @Parameters ("browser")

    @BeforeSuite
    public void openBrowser(String browser) {
        //define the path where you want to save the Extent Report
        reports = new ExtentReports("src\\main\\java\\Extent_Reports\\Automation" + UUID.randomUUID() + ".html", true);
        if (browser.equalsIgnoreCase("Chrome")) {
            //create a path to chrome
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            //set pre agrs using chromeOPTIONS
            ChromeOptions options = new ChromeOptions();
            //chrome options
            options.addArguments("start-maximized", "incognito");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver", "src//main/resou");
           driver=new FirefoxDriver();
            driver.manage();
        }


    }//end of before suite

    //before method will be used to capture the test name and start the report
    @BeforeMethod
    public void getTestName(Method methodName) {
        logger = reports.startTest(methodName.getName());
    }//end of before method

    //after method will end your test report
    @AfterMethod
    public void endReport() {
        reports.endTest(logger);
    }//end of after method

    @AfterSuite
    public void quitSession() {
        //write all your logs back to the report
        reports.flush();
        //quit driver if you need to
        //driver.quit();
    }//end of after suite
}

