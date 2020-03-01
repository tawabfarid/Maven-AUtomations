package StepDefinitions;

import Reusable_library.Reusable_Methods;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class GoogleTestCases {
    //declare webdriver outside since it will be used on all methods
    WebDriver driver;



    @Given("^I navigate to Google home$")
    public void navigate() {
        //create a path to chrome
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        //set pre agrs using chromeOPTIONS
        ChromeOptions options = new ChromeOptions();
        //chrome options
        options.addArguments("start-maximized", "incognito");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://www.google.com");
    }//end of given method

    @When("^I verify the expected the title as Google$")
    public void verifyTitle(){
        Reusable_Methods.verifyPageTitle(driver,"Google");
    }//end of when

    @When("^I type Cars (.*) in google search field$")
    public void typeonSearch(String cars) throws IOException {
        Reusable_Methods.type(driver,"//*[@name='q']",cars,"Search");
    }//end of 2nd when

    @And("^I submit or click on google search$")
    public void clickonSearch(){
        Reusable_Methods.submit(driver,"//*[@name='q']","Search Field");
    }//end of and

    @Then("^I capture and extract the search number$")
    public void getSearchNumber(){
        String message= Reusable_Methods.captureText(driver,"//*[@id='mBMHK']","Search Result");
        String[] arrayMsg=message.split("");
        System.out.println("My Search number for car is " + arrayMsg[1]);
    }//end of then




}//end of java class
