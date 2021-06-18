package seleniumSection9;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		//Explicit Wait
	//	WebDriverWait wait=new WebDriverWait(driver,5);

		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.findElement(By.cssSelector("div[id='start'] button")).click(); //click on Start button
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		//wait.until(arg0)
		
		 
		
		// Waiting 30 seconds for an element to be present on the page, checking
		   // for its presence once every 5 seconds.
		  

		   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		    
			   public WebElement apply(WebDriver driver) {
		       
				   if(driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed()) {
					   
					 return driver.findElement(By.cssSelector("div[id='finish'] h4"));
				   }else
				   {
					   return null;
					   
				   }
				   
		     }
		   });
		   System.out.println(driver.findElement(By.cssSelector("div[id='finish'] h4")).getText());
		   
		//driver.close();
	}

}
