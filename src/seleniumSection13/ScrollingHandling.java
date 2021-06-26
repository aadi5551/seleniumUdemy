package seleniumSection13;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollingHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//Window will scroll by 500. (x,y) should be entered by hit and trial method.
		JavascriptExecutor jsScrolling = (JavascriptExecutor)driver;
		jsScrolling.executeScript("window.scrollBy(0,500)"); //it accepts 2 arguments but 2nd one is optional.
		Thread.sleep(3000);
		//Scrolling in table view.
		jsScrolling.executeScript("document.querySelector(\"div.tableFixHead\").scrollTop=500");
		
		//Now calculation Sum of Amount column.
		List<WebElement> amt = driver.findElements(By.cssSelector("div[class='tableFixHead'] td:nth-child(4)"));
		int Sum=0;
		for(int i=0; i<amt.size();i++) {
			
			String amtReach = amt.get(i).getText();
			int amtOfEachRow = Integer.parseInt(amtReach);
			System.out.println(amtOfEachRow);
			Sum=Sum+amtOfEachRow;
			
		}
		System.out.println("Total Sum is:"+Sum);
		 driver.findElement(By.cssSelector("div[class='totalAmount']")).getText();
		 String expectedSumString= driver.findElement(By.cssSelector("div[class='totalAmount']")).getText().split(":")[1].trim();
		 int expectedSum= Integer.parseInt(expectedSumString);
		 
		
		  if(Sum==expectedSum) {
		  
		  System.out.println("Test case passed!!. Sum are matched.");
		  
		  }else {
		  
		  System.out.println("Test case failed!!. Sum are not matched"); }
		 
		 
		 //OR
		 
		 //Use TestNG assertion
		// Assert.assertEquals(Sum, expectedSum);

		
		
		
		
	}

}
