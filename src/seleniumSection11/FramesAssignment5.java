package seleniumSection11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAssignment5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://the-internet.herokuapp.com/");
		
		driver.manage().window().maximize();
		
		//Clicking on Nested Frames Link
		driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click(); 
		
		
		//Switching in Top Frame portion
		WebElement outerFrame= driver.findElement(By.name("frame-top"));
		driver.switchTo().frame(outerFrame);
		
		//Switching to 2nd Frame using index i.e. 1.
		driver.switchTo().frame(1);
		
		//Printing Text on the Middle frame.
		System.out.println(driver.findElement(By.id("content")).getText());
		
		//Switching to normal Window and comeout from Frame.
		driver.switchTo().defaultContent();
		
	
		
		
	}

}
