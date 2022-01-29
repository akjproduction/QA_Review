package ActionItems;

import Day2_120521.LinearArray;
import Day9_010822.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Hulu_AI {
    WebDriver driver;

    @BeforeSuite
    public void SetTheDriver() {
        driver = Reusable_Actions.setDriver();//set driver
        driver.navigate().to("https://www.hulu.com");//navigate to Hulu.com
    }//end of precondition

    @Test
    public void registerHulu() throws InterruptedException {
        ArrayList<String> email = new ArrayList<>(); //Arraylist for email
        email.add("triagehulutest1.5@gmail.com");//email A
        email.add("triagehulutest2.5@gmail.com");//email B
        ArrayList<String> password = new ArrayList<>();//Arraylist for password
        password.add("trailPass1231");//password A
        password.add("trailPass3213");//password B
        ArrayList<String> name = new ArrayList<>();//Arraylist for name
        name.add("Triage Hulutestaa");//name A
        name.add("Triage Hulutestbb");//name B
        ArrayList<String> birthMonth = new ArrayList<>();//Arraylist for birth month
        birthMonth.add("January");//month A
        birthMonth.add("December");//month B
        ArrayList<Integer> birthDay = new ArrayList<>();//Arraylist for birth day
        birthDay.add(1);//day A
        birthDay.add(31);//day B
        ArrayList<Integer> birthYear = new ArrayList<>();//Arraylist for birth year
        birthYear.add(1990);//year A
        birthYear.add(1995);//year B
        ArrayList<String> gender = new ArrayList<>();//Arraylist for gender
        gender.add("Male");//gender A
        gender.add("Female");//gender B

        //Starting Web Automation
        for (int i = 0; i < 2; i++) {
        driver.manage().deleteAllCookies();// delete all cookies before navigating
        Reusable_Actions.checkTitle(driver, "https://www.hulu.com", "Stream TV and Movies");//Check if Title Contains Stream TV and Movies
        Thread.sleep(1000);//delay for 1 sec
        JavascriptExecutor Jse = (JavascriptExecutor) driver;//scroll using Java Script Exec
        Jse.executeScript("scroll(0,1500)");// scrolling 1500px down
        Thread.sleep(2000);//delay for 2 sec
        Reusable_Actions.clickMethod(driver, "//*[@aria-label='Get Hulu plan']", "Select Most Popular 30 Day Trial Button");//Clicking on 30day trial - most popular tab
        Thread.sleep(1000);//delay for 1 sec

            Reusable_Actions.sendKeysMethod(driver, "//*[@id='email']", email.get(i), "Email field");//entering email
            Reusable_Actions.sendKeysMethod(driver, "//*[@type='password']", password.get(i), "Password field");//entering password
            Reusable_Actions.sendKeysMethod(driver, "//*[@id='firstName']", name.get(i), "Name field");//entering name
            Reusable_Actions.clickMethod(driver, "//*[@class='field field__month']", "Month");//clicking month
            Reusable_Actions.clickMethod(driver, "//*[text()='" + birthMonth.get(i) + "']", "Birth Month");//selecting month
            Reusable_Actions.clickMethod(driver, "//*[@class='field field__day']", "Day");//clicking day
            Reusable_Actions.clickMethod(driver, "//*[text()='" + birthDay.get(i) + "']", "Day");//selecting day
            Reusable_Actions.clickMethod(driver, "//*[@class='field field__year']", "Year");//clicking year
            Reusable_Actions.clickMethod(driver, "//*[text()='" + birthYear.get(i) + "']", "Year");//selecting year
            Reusable_Actions.clickMethod(driver, "//*[@class='field gender']", "Gender");//clicking gender
            Reusable_Actions.clickMethod(driver, "//*[text()='" + gender.get(i) + "']", "Gender");//selecting gender

            Thread.sleep(1000);//delay for 1 sec
            Reusable_Actions.clickMethod(driver, "//*[text()='CONTINUE'][2]", "Continue Button");//clicking on continue
            Thread.sleep(5000);//delay for 5 sec
            String paymentText = Reusable_Actions.getTextMethod(driver, "//*[@class='ledger__content']", "Capture Text A");//capturing payment info
            String result = Reusable_Actions.getTextMethod(driver, "//*[@class='panel large'][2]", "Capture Text B");
            System.out.println("My Hulu Account Billing info: \n" + paymentText + result);//printing result
        }//end of loop
    }//end of test 1

    @Test(dependsOnMethods = "registerHulu")
    public void huluPostRegristration() {
        driver.manage().deleteAllCookies();// delete all cookies before navigating
        driver.navigate().to("https://www.hulu.com");//Navigate to Hulu.com
        Reusable_Actions.clickMethod(driver, "//*[text()='Log In']", "Log In");//Click on login
        Reusable_Actions.sendKeysMethod(driver, "//*[@id='email_id']", "triagehulutest@gmail.com", "Email");//Entering email
        Reusable_Actions.sendKeysMethod(driver, "//*[@id='password_id']", "trailPass123", "Password");//Entering password
        Reusable_Actions.clickMethod(driver, "//*[text()='LOG IN']", "Log In");//Clicking on Login
        String verifyUserName = Reusable_Actions.getTextMethod(driver, "//*[@data-automationid='navigation_login_button']", "User Name");//Verifying user name from home page
        System.out.println("My user name is: \n" + verifyUserName);//printing user name

    }//end of test 2

    @AfterSuite
    public void endSession() {
        driver.quit();
    }//end of afterSuite

}//end of class
