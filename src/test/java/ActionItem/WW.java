//package ActionItem;
//
//import Reusable_library.Reusable_Methods;
//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.read.biff.BiffException;
//import jxl.write.Label;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//import jxl.write.WriteException;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.io.File;
//import java.io.IOException;
//
//public class WW {
//
//    WebDriver driver;
//    Workbook readable;
//    Sheet readableSheet;
//    int rowCount;
//    WritableWorkbook writable;
//    WritableSheet wSheet;
//
//    @BeforeMethod
//    public void openBrowser() throws IOException, BiffException {
//
//        //create a path for readable file in excel
//        readable = Workbook.getWorkbook(new File("src\\main\\resources\\WW_datadriven.xls"));
//        //define the work sheet for the data
//        readableSheet = readable.getSheet(0);
//        //get all non empty row count in excel
//        rowCount = readableSheet.getRows();
//        //create a duplicate excel to input data
//        writable = Workbook.createWorkbook(new File("src\\main\\resources\\WW_datadriven_Results.xls"),readable);
//        //define A WRITEbook to read data
//        wSheet = writable.getSheet(0);
//
//        //create a path to chrome
//        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
//        //set pre args using chromeOPTIONS
//        ChromeOptions options = new ChromeOptions();
//        //chrome options
//        options.addArguments("start-maximized", "incognito");
//        driver = new ChromeDriver(options);
//    }//annotation method to define your browser
//
//    @Test(priority = 1)
//    public void testCase() throws IOException, BiffException, InterruptedException, WriteException {
//        for (int i = 1; i < rowCount; i++) {
//            //get data from coulum from 1
//            String Zipcode = wSheet.getCell(0, i).getContents();
//            //navigate
//            driver.navigate().to("https://www.weightwatchers.com/us/");
//            Thread.sleep(3000);
//            //verify the title matches "weight loss program,RECIPES & HELP  | WEIGHT watchers
//            Reusable_Methods.verifyPageTitle(driver, "Find a studio & Meeting Near you ");
//            //clicking on find a meeting
//            Reusable_Methods.click(driver, "//*[@class='find-a-meeting']", "Find a Studio");
//            Thread.sleep(3500);
//            Reusable_Methods.click(driver, "//*[@class='bx-close-xsvg']", "Pop-up Modal");
//            Reusable_Methods.type(driver, "//*[@id='meetingSearch']", Zipcode, "Zip Code");
//            Reusable_Methods.click(driver, "//*[@spice='SEARCH_BUTTON']", "Search Enter");
//            Thread.sleep(5500);
//            //capturing the studio name
//            String studioInfo = Reusable_Methods.captureText(driver, "//*[@class='location__container']", "Location Name");
//            //capture distance
//            //String locationDistance = Reusable_Methods.captureTextByIndex(driver,"//*[@class='location__distance']",0,"Distance");
//            //capture the address
//            //String address = Reusable_Methods.captureTextByIndex(driver,"//*[@class='location__address']",0,"Address");
//            //capture the zipcode
//            //String cityZip = Reusable_Methods.captureTextByIndex(driver,"//*[@class='location__city-state-zip']",0,"City State Zip");
//            //adding it back to excel location column
//            Label label1 = new Label(1, i, studioInfo);
//            wSheet.addCell(label1);
//            //click on location address to go to op hour page
//            Reusable_Methods.click(driver, "//*[@class='location__container']", 0, "Studio Name Link");
//            Thread.sleep(4000);
//            String operationHour = Reusable_Methods.captureText(driver, "//*[contains(@class,'hours-list--currentday')]", "Op Hour");
//            Label label2 = new Label(2, i, operationHour);
//            wSheet.addCell(label2);
//        }//end of the loop
//    }//end of test case
//
//    @AfterMethod
//    public void closeDriver() throws IOException, WriteException {
//        writable.write();
//        writable.close();
//        readable.close();
//        driver.quit();
//    }//end of after method
//
//
//}//end of java class
//
//
