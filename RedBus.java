package test.codes;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.redbus.in/");
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
     // Type FROM and TO City  
        
        driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Chennai");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='src']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='dest']")).sendKeys(Keys.ENTER);
        
     // Date   
        
        driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
        driver.findElement(By.xpath("//td[text()='16']")).click();
        
     // Click search
        
        driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
        String text = driver.findElement(By.xpath("//span[@class='w-60 d-block d-found']")).getText(); 
        System.out.println(text);
        
    //Click Sleeper and clear intercept error      
		
        WebElement sleeperCheck = driver.findElement(By.xpath("//label[@for='bt_SLEEPER']"));
        
        WebElement sleeperCheckBox = driver.findElement(By.xpath("//ul[@class='list-chkbox']/li[2]"));
        driver.executeScript("arguments[0].scrollIntoView();", sleeperCheckBox);
        driver.executeScript("arguments[0].click();", sleeperCheck);
        
     // Close Primo notification 
       
        driver.findElement(By.xpath("//div[@class='close-primo']/i")).click();
    
    // Click on view seats
        
        driver.findElement(By.xpath("//div[text()='View Seats']")).click();
        
    // view the price
        
        String startPrice = driver.findElement(By.xpath("//span[@class='f-19 f-bold'][1]")).getText();
        System.out.println("Tickets starting price " + startPrice);
        
    // No of Seats available
        
        String Seats = driver.findElement(By.xpath("//div[@class='seat-left m-top-30']")).getText();
        
        System.out.println(Seats);
	}

}
