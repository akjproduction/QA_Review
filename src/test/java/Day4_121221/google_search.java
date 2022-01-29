package Day4_121221;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class google_search {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.name("q")).sendKeys(new CharSequence[]{"cars"});
        driver.findElement(By.name("btnK")).submit();


    }//end of main method

}//end of public class
