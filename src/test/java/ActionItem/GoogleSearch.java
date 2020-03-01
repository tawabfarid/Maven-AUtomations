package ActionItem;

import Reusable_library.Abstract_Class;
import Reusable_library.Reusable_Methods_Reports;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleSearch extends Abstract_Class {



    @Test(priority = 1)
    public void googleSearch() throws InterruptedException, IOException {

        //navigate to google.com
        logger.log(LogStatus.INFO,"Navigating to google home");
        driver.navigate().to("https://www.google.com");
        //enter brooklyn in your search field
        Reusable_Methods_Reports.type(driver,"//*[@name='q']","BMW",logger,"Search Field");
        //submit on google search
        Reusable_Methods_Reports.submit(driver,"//*[@name='btnK']",logger,"Search Button");
    }//end of test method 1

    @Test(priority = 2)
    public void googleSearchResult() throws IOException, InterruptedException {
        //capture the text into a string variable
        Thread.sleep(3000);
        String message = Reusable_Methods_Reports.captureText(driver,"//*[@id='mBMHK']",logger,"Search Result");
        String[] arraymessage = message.split(" ");
        //print out search number
        //System.out.println("My search number for " + cars[i] + " is " + arraymessage[1]);
        logger.log(LogStatus.INFO,"My search number for BMW is " + arraymessage[1]);
    }//end of test method 2


}//end of parent class



