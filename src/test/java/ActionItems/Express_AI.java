package ActionItems;

import Day9_010822.Reusable_Actions;
import Reusable_Library.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class Express_AI extends Reusable_Actions_Loggers{
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;

    @BeforeSuite
    public void SetTheDriver() {
        driver = Reusable_Actions_Loggers.setDriver();//set driver
        //set the pat of the report once
        //reports = new ExtentReports("src/main/java/HTML_Report/Automation_Report.html",true);
    }//end of precondition

    @Test
    public void expressAi() throws IOException, BiffException, WriteException, InterruptedException {
        //logger = reports.startTest("Express Checkout End to End");
        //logger.log(LogStatus.INFO, "Navigating to Express");

        //Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/Express_Data.xls"));
        //WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/Express_Data.xls"));
        //WritableSheet writableSheet = writableFile.getSheet(0);
        //int rowCount = writableSheet.getRows();

        //all the test steps have to go inside for loop


        //for (int i = 1; i < rowCount; i++) {
        driver.manage().deleteAllCookies();// delete all cookies before navigating
            driver.navigate().to("https://www.express.com");//navigate to Express.com
            Reusable_Actions_Loggers.checkTitle(driver,"https://www.express.com",logger,"Men's & Women's Clothing");
            Reusable_Actions_Loggers.mouseHover(driver, "//*[text()='WOMEN']", logger, "Women");//hovering over women tab
            Thread.sleep(1000);
            Reusable_Actions_Loggers.clickMethod(driver, "//*[text()='Dresses']", logger, "Dresses");//clicking dresses
            Thread.sleep(5000);
            //scroll using Java Script Exec
            JavascriptExecutor Jse = (JavascriptExecutor) driver;
            Jse.executeScript("scroll(0,450)");// scrolling 450px down
            Thread.sleep(1000);
            Reusable_Actions_Loggers.clickByIndex(driver, "//*[@class='_3FdqXW3n1tBCmOFxYXZKu0']", 2, logger, "2nd Image"); //selecting third item
            Thread.sleep(2500);
            //get the content of the cell
            //column is hard coded and row is dynamic(i)
            //String errorMessage = writableSheet.getCell(15, i).getContents();
            //store and send it to the empty column in excel writable file
            //Label label = new Label(14, i, errorMessage);
            //writableSheet.addCell(label);
            //adding this label to the writable sheet
       // }//end of for loop

        //reports.endTest(logger);
       // writableFile.write();
       // writableFile.close();
    }//end of test


    //@AfterSuite
   // public void endSession() {

       // reports.flush();
       // driver.quit();
    //}//end of afterSuite
}//end of class
