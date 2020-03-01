package Selenium12_02162020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class USPS {

    WebDriver driver;

        @BeforeMethod
        public void openBrowser(){
            //create a path to chrome
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            //set pre args using chromeOPTIONS
            ChromeOptions options = new ChromeOptions();
            // chrome options
            options.addArguments("start-maximized", "incognito");
            driver = new ChromeDriver(options);

            //initiate the implicit wait
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        }//end of before method

        @Test
        public void usps(){
            driver.navigate().to("https://www.usps.com/");

            //store your elements using List command to get the group count
            List<WebElement> linkCount= driver.findElements(By.xpath("//*[contains(@class,'lang-')]"));
            //print out the size to get the count
            System.out.println("My Link Count is "+ linkCount.size());
        }//end of test method
        @AfterMethod
        public void closeBrowser(){
            //drive.quit();

        }//end of after method
    }//end of java class
