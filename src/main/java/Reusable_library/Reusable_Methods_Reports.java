package Reusable_library;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Reusable_Methods_Reports {

    static int timeout = 7;

    //create methods for different user actions

    //********************************************************************
    //method for navigating to a site
    public static WebDriver navigate(WebDriver driver, String url) throws IOException {
        //define the path of the chrome driver
        System.setProperty("webdriver.chrome.driver","src/Resource/chromedriver.exe");

        //quit all open chrome browsers
        Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f /t");

        //seeting up the chromeoptions
        ChromeOptions options = new ChromeOptions();
        //add the precondition arguments
        options.addArguments("start-maximized","incognito","disable-infobars");

        //define the chrome web driver
        driver = new ChromeDriver(options);

        //navigate to usps.com
        driver.navigate().to(url);

        return driver;
    }//end of navigate method

    //********************************************************************
    //method to click on an element
    public static void click(WebDriver driver, String locator, ExtentTest logger, String elementName){
        //for explicit use WebDriverWait command
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            //Thread.sleep(1500);
            System.out.println("Clicking on element " + elementName);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).click();
            // driver.findElement(By.xpath(locator)).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element - " + elementName + e);
        }
    }//end of click method

    //method to submit on an element
    public static void submit(WebDriver driver, String locator, ExtentTest loggger,String elementName){
        //for explicit use WebDriverWait command
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            //Thread.sleep(1500);
            System.out.println("Clicking on element " + elementName);
            loggger.log(LogStatus.INFO,"Clicking on element " + elementName);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).submit();
            // driver.findElement(By.xpath(locator)).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element - " + elementName + e);
            loggger.log(LogStatus.FAIL,"Unable to click on element - " + elementName + e);
        }
    }//end of click method

    //********************************************************************
    //method to click using mouse Actions on an element
    public static void clickByMouse(WebDriver driver, String locator, String elementName){
        Actions mouseAction = new Actions(driver);
        try{
            Thread.sleep(1500);
            System.out.println("Clicking on element " + elementName);
            WebElement element = driver.findElement(By.xpath(locator));
            mouseAction.moveToElement(element).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to click on element - " + elementName + e);
        }
    }//end of mouse click method

    //********************************************************************
    //method to click on an element by index number
    public static void clickByIndex(WebDriver driver, String locator, int indexNum, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            //Thread.sleep(1500);
            System.out.println("Clicking on element " + elementName + " by index number " + indexNum);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator))).get(indexNum).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element - " + elementName + " by index number... " + e);
        }
    }//end of click on element by index number method

    //********************************************************************
    //method to move to element using mouse Actions
    public static void mouseHover(WebDriver driver, String locator, String elementName){
        Actions mouseAction = new Actions(driver);
        try{
            Thread.sleep(1500);
            System.out.println("Hovering on element " + elementName);
            WebElement element = driver.findElement(By.xpath(locator));
            mouseAction.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover on element - " + elementName + e);
        }
    }//end of hover method

    //********************************************************************
    //method to enter a keyword on an element
    public static void type(WebDriver driver, String locator, String userValue, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            //Thread.sleep(1500);
            System.out.println("Entering " + userValue + " on element " + elementName);
            logger.log(LogStatus.INFO,"Entering " + userValue + " on element " + elementName);
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            input.clear();
            input.sendKeys(userValue);
        } catch (Exception e) {
            System.out.println("Unable to enter keyword on element - " + elementName + e);
            logger.log(LogStatus.FAIL,"Unable to enter keyword on element - " + elementName + e);
        }
    }//end of send keys method

    //********************************************************************
    //method to enter a keyword on an element by index number
    public static void typeByIndex(WebDriver driver, String locator, String userValue, int indexNum, String elementName){
        try{
            Thread.sleep(1500);
            System.out.println("Entering " + userValue + " on element " + elementName + " by index number " + indexNum);
            WebElement input = driver.findElements(By.xpath(locator)).get(indexNum);
            input.clear();
            input.sendKeys(userValue);
        } catch (Exception e) {
            System.out.println("Unable to enter keyword on element - " + elementName + " by index number... " + e);
        }
    }//end of send keys by index number method

    //********************************************************************
    //method to enter a keyword on an element using mouse movement
    public static void typeUsingMouse(WebDriver driver, String locator, String userValue, String elementName){
        Actions mouseAction = new Actions(driver);
        try{
            Thread.sleep(1500);
            System.out.println("Entering " + userValue + " on element " + elementName);
            WebElement input = driver.findElement(By.xpath(locator));
            mouseAction.moveToElement(input).click().sendKeys(Keys.CLEAR);
            mouseAction.moveToElement(input).click().sendKeys(userValue);
        } catch (Exception e) {
            System.out.println("Unable to enter keyword on element - " + elementName + e);
        }
    }//end of send keys method

    //********************************************************************
    //method to switch tab
    public static void switchTab(WebDriver driver, int tabNumber) throws InterruptedException {
        System.out.println("Switching to tab " + tabNumber);
        //define window handle for tabs
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        //switch to specific tab
        driver.switchTo().window(tabs.get(tabNumber));
    }//end of switch to tab method

    //********************************************************************
    //method to select an element by visible text using select command
    public static void dropDownSelect(WebDriver driver, String locator, String dropdownValue, String elementName){
        try{
            Thread.sleep(1500);
            System.out.println("Selecting " + dropdownValue + " from drop down " + elementName);
            WebElement element = driver.findElement(By.xpath(locator));
            Select select = new Select(element);
            select.selectByVisibleText(dropdownValue);
        } catch (Exception e) {
            System.out.println("Unable to select value from drop down - " + elementName + " - " + e);
        }
    }//end of select method

    //********************************************************************
    //method to compare two text... Expected vs Actual
    public static void verifyText(WebDriver driver, String locator, String expectedText, String elementName){
        try{
            Thread.sleep(1500);
            System.out.println("Verify text expected text on " + elementName);
            WebElement element = driver.findElement(By.xpath(locator));
            String actualtext = element.getText();
            if(expectedText.equals(actualtext)){
                System.out.println("Text verification matches for " + elementName);
            } else {
                System.out.println("Expected doesn't match actual and actual text is " + actualtext);
            }
        } catch (Exception e) {
            System.out.println("Unable to get text value from " + elementName + " - " + e);
        }
    }//end of verifytext method

    //********************************************************************
    //method to capture and return text from a webElement
    public static String captureText(WebDriver driver, String locator, ExtentTest logger, String elementName) throws IOException, InterruptedException {
        String textElement = null;
        try{
            Thread.sleep(3000);
            System.out.println("Capture text from " + elementName);
            logger.log(LogStatus.INFO,"Capture text from " + elementName);
            WebElement element = driver.findElement(By.xpath(locator));
            textElement = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to get text value from " + elementName + " - " + e);
            logger.log(LogStatus.FAIL,"Unable to get text value from " + elementName + " - " + e);
            getScreenshot(driver,logger,elementName);
        }
        return textElement;
    }//end of capture text method

    //method to capture and return text from a webElement
    public static String captureTextByIndex(WebDriver driver, String locator, int indexNum, String elementName){
        String textElement = null;
        try{
            Thread.sleep(1500);
            System.out.println("Capture text from " + elementName);
            WebElement element = driver.findElements(By.xpath(locator)).get(indexNum);
            textElement = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to get text value from " + elementName + " - " + e);
        }
        return textElement;
    }//end of capture text method

    //********************************************************************
    //method to compare expected vs actual title
    public static void verifyPageTitle(WebDriver driver, String expectedTitle){
        try{
            Thread.sleep(1500);
            System.out.println("Verifying page expected title on");
            String actualTitle = driver.getTitle();
            if(actualTitle.contains(expectedTitle)){
                System.out.println("Title matches for - " + expectedTitle);
            } else {
                System.out.println("Expected doesn't match actual and actual title is " + actualTitle);
            }
        } catch (Exception e) {
            System.out.println("Unable to get page title - " + e);
        }
    }//end of comparing expected vs actual title method

    public static String dateInHour(String dateFormat,int numberOfHour){
        SimpleDateFormat simpDate = new SimpleDateFormat(dateFormat);
        Date date = new Date();
        date.setHours(date.getHours() + numberOfHour);
        String hour = simpDate.format((date)).toString();
        //System.out.println(hour);
        return  hour;
    }

    public static void getScreenshot(WebDriver driver, ExtentTest logger, String screenshotName) throws IOException, InterruptedException {
        String path = "src\\main\\java\\Extent_Reports\\Screenshots\\";
        String fileName = screenshotName + ".png";
        Thread.sleep(1000);
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //Now you can do whatever you need to do with, for example copy somewhere
        FileUtils.copyFile(sourceFile, new File(path + fileName));
        //String imgPath = directory + fileName;
        String image = logger.addScreenCapture("Screenshots\\" + fileName);
        logger.log(LogStatus.FAIL, "", image);
    }//end of get screenshot method



}//end of parent class
