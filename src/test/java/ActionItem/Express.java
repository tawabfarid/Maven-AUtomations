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
//import org.openqa.selenium.JavascriptExecutor;
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
//public class Express {
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
//
//        //Step 1 define path of readable file
//        readable = Workbook.getWorkbook(new File("src/main/resources/Express.xls"));
//        //Step 2 define the worksheet for the data
//        readableSheet = readable.getSheet(0);
//        //Step 3 get count of all non empty rows in your excel sheet
//        rowCount = readableSheet.getRows();
//        //step 4 create a duplicate excel to write back
//        writable = Workbook.createWorkbook(new File("src/main/resources/Express_Results.xls"), readable);
//        //Step 5 define the writeable work sheet to read the data
//        wSheet = writable.getSheet(0);
//
//        // create a path to chrome
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver80.exe");
//        //set pre args using Chromeoptions
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("incognito","start-maximized");
//        driver = new ChromeDriver(options);
//
//
//    }//end of driver annotation
//
//    @Test(priority = 1)
//    public void testCase() throws InterruptedException, WriteException, IOException {
//        for (int i = 1; i < rowCount; i++) {
//            String size = wSheet.getCell(0, i).getContents();
//            String quantity = wSheet.getCell(1, i).getContents();
//            String firstName = wSheet.getCell(2, i).getContents();
//            String lastName = wSheet.getCell(3, i).getContents();
//            String email = wSheet.getCell(4, i).getContents();
//            String phoneNumber = wSheet.getCell(5, i).getContents();
//            String address = wSheet.getCell(6, i).getContents();
//            String zipCode = wSheet.getCell(7, i).getContents();
//            String city = wSheet.getCell(8, i).getContents();
//            String state = wSheet.getCell(9, i).getContents();
//            String cardNumber = wSheet.getCell(10, i).getContents();
//            String expMonth = wSheet.getCell(11, i).getContents();
//            String expYear = wSheet.getCell(12, i).getContents();
//            String cvv = wSheet.getCell(13, i).getContents();
//
//
//            //navigate to webpage
//            Thread.sleep(2000);
//            driver.navigate().to("https://www.express.com/");
//            Thread.sleep(4000);
//            //verify title
//            Reusable_Methods.verifyPageTitle(driver, "Men’s and Women’s Clothing");
//            Thread.sleep(2000);
//            Reusable_Methods.mouseHover(driver, "//*[@class='_399XX MegaMenu_primaryNav__label__1s3d1']", "Women");
//            Thread.sleep(2000);
//            Reusable_Methods.click(driver, "//*[@href= '/womens-clothing/dresses/cat550007']", "Dresses");
//            Thread.sleep(3000);
//            // Scroll down
//            JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
//            scrollDown.executeScript("scroll(0,500)");
//            //Choose 1st dress
//            Reusable_Methods.click(driver, "//*[@class='swatch-images active']", "Skirt");
//            Thread.sleep(2000);
//            //select size
//            Reusable_Methods.click(driver, "//*[text()='" + size + "']", "size");
//            Thread.sleep(2000);
//            //add dress to cart
//            Reusable_Methods.click(driver, "//*[text()='Add to Bag']", "Add to Bag");
//            Thread.sleep(2000);
//            // click on view bag
//            Reusable_Methods.click(driver, "//*[text() ='View Bag']", "view bag");
//            Thread.sleep(4000);
//            //drop down change item
//            Reusable_Methods.dropDownSelect(driver, "//*[@id='qdd-0-quantity']","Qty", "Quantity");
//            Thread.sleep(2000);
//            // checkout menu
//            Reusable_Methods.click(driver, "//*[text()='Checkout']", "Checkout");
//            Thread.sleep(2000);
//            //check out as guest
//            Reusable_Methods.click(driver, "//*[text()='Continue as Guest']", "Continue as Guest");
//            Thread.sleep(2000);
//            //First name and last name
//            Reusable_Methods.type(driver, "//*[@name='firstname']", "Ben", "First Name");
//            Thread.sleep(1000);
//            Reusable_Methods.type(driver, "//*[@name='lastname']", "Dover", "Last Name");
//            Thread.sleep(1000);
//            //Enter and Confirm Email
//            Reusable_Methods.type(driver, "//*[@name='email']", "bendover@gmail.com", "Email");
//            Thread.sleep(1000);
//            Reusable_Methods.type(driver, "//*[@name='confirmEmail']", "bendover@gmail.com", "Enter Email Again");
//            Thread.sleep(1000);
//            //enter phone number
//            Reusable_Methods.type(driver, "//*[@name='phone']", "8005557777", "Phone Number");
//            Thread.sleep(1000);
//            //hitting continue
//            Reusable_Methods.click(driver, "//*[text()='Continue']", "Continue");
//            Thread.sleep(1500);
//            //select shipping method
//            Reusable_Methods.click(driver, "//*[text()='Continue']", "Continue");
//            Thread.sleep(1000);
//            //Complete Address
//            Reusable_Methods.type(driver, "//*[@name='shipping.line1']", "42 Big Walkway", "Address 1");
//            Thread.sleep(1000);
//            Reusable_Methods.type(driver, "//*[@name='shipping.postalCode']", "11111", "Postal Code");
//            Thread.sleep(1000);
//            Reusable_Methods.type(driver, "//*[@name='shipping.city']", "Brooklyn", "City");
//            Thread.sleep(1000);
//            Reusable_Methods.dropDownSelect(driver, "//*[@name='shipping.state']", "New York", "State");
//            Thread.sleep(1000);
//            //Click on Continue
//            Reusable_Methods.click(driver, "//*[text()='Continue']", "Continue");
//            Thread.sleep(1000);
//            //enter card number
//            Reusable_Methods.type(driver, "//*[@id='creditCardNumberInput']", "1234567890987654", "Credit Card");
//            Thread.sleep(1000);
//            //enter card details
//            Reusable_Methods.dropDownSelect(driver, "//*[@name='expMonth']", "11", "Exp Month");
//            Thread.sleep(1000);
//            Reusable_Methods.dropDownSelect(driver, "//*[@name='expYear']", "30", "Exp Year");
//            Thread.sleep(1000);
//            //Enter CRV
//            Reusable_Methods.type(driver, "//*[@name='cvv']", "619", "CVV Card");
//            Thread.sleep(1000);
//            //Place order
//            Reusable_Methods.click(driver, "//*[text()='Place Order']", "Place Order");
//            Thread.sleep(2000);
//            //error message
//            String err = driver.findElement(By.xpath("//*[@id ='rvn-note-NaN']")).getText();
//            Label errorMess = new Label(14, i, err);
//            wSheet.addCell(errorMess);
//        }// end of for loop
//    }//end of test annotation
//
//        @AfterMethod
//        public void closeDriver() throws IOException, WriteException {
//            writable.write();
//            writable.close();
//            readable.close();
//            driver.quit();
//        }//end of after method
//}// end of public class