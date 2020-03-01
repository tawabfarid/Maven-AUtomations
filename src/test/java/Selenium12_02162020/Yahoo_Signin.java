package Selenium12_02162020;

import Reusable_library.Abstract_Class;
import Reusable_library.Reusable_Methods;
import Reusable_library.Reusable_Methods_Reports;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Yahoo_Signin extends Abstract_Class {

    @Test
    public void Yahoo_Signin_Validation() throws InterruptedException, IOException {
        driver.navigate().to("https://yahoo.com/");

        //click on yahoo sign in
        Reusable_Methods_Reports.click(driver,"//*[text()='Sign in']",logger,"Sign in");

        //verify that stay signed in checkbox is selected
        Thread.sleep(4000);
        Boolean checkbox = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if(checkbox == true){
            System.out.println("Stay Signed in checkbox is selected");
            logger.log(LogStatus.PASS,"Stay Signed in checkbox is selected");
        } else {
            System.out.println("Stay Signed in checkbox is not selected");
            logger.log(LogStatus.FAIL,"Stay Signed in checkbox is not selected");
        }//end of if else for checkbox

        //verify if create account button is there then click on it
        Boolean createAcc = driver.findElement(By.xpath("//*[text()='Create an account']")).isEnabled();
        if(createAcc == true){
            driver.findElement(By.xpath("//*[text()='Create an account']")).click();
            System.out.println("Create Account was enable");
            logger.log(LogStatus.PASS,"Create Account was enable");
        } else {
            System.out.println("Create account is not enabled");
            logger.log(LogStatus.FAIL,"Create Account is not enable");
        }//end of if else for checkbox

        Reusable_Methods_Reports.click(driver,"//*[text()='Create an account']",logger,"Search Result");

    }//end of test method

    @AfterMethod
    public void closeBrowser(){
        //driver.quit();
    }//end of after method



}//end of java class