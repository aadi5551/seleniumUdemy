package seleniumSection12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.path2usa.com/travel-companions");

		driver.manage().window().maximize();
		//June 14
		String expectedDate= "11";
		String expectedMonth= "October";
		driver.findElement(By.id("travel_date")).click();
		
		 while(!driver.findElement(By.cssSelector("div[class='datepicker-days'] [class='datepicker-switch']")).getText().contains(expectedMonth)) 
		 {
			 
			 driver.findElement(By.cssSelector("div[class='datepicker-days'] th[class='next']")).click();
			 
		 }
		
		
		
		List<WebElement> dateLists = driver.findElements(By.className("day"));
		//Grab common attribute//Put into list and iterate.
		
		int count= driver.findElements(By.className("day")).size();
		
		for(int i=0;i<count;i++) {
			
			String actualDate= driver.findElements(By.className("day")).get(i).getText();
			
			if(actualDate.equalsIgnoreCase(expectedDate)) {
				
				
				driver.findElements(By.className("day")).get(i).click();
				break;	
			}
		}
		
		
		

	}

}
