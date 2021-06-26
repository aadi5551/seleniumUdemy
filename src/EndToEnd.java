import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EndToEnd {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://www.spicejet.com/");
		//driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0"));
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); //Click on From Location Dropdown
		driver.findElement(By.xpath("//a[@value='DEL']")).click(); //Click on Origin location City
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@value='GOP'])[2]")).click(); //Click on Destination location city
								//OR
		//driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GOP']")).click();
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click(); //click on current Date in From Date
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("opacity: 0.5"))
		{
			System.out.println("TO Date is Disabled");
			Assert.assertTrue(true);
			
			
		}else {
			System.out.println("TO Date is Enabled");
			Assert.assertTrue(false);
		}
		
		driver.findElement(By.id("divpaxinfo")).click();
		
		Select noOfPerson= new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		//driver.findElement(By.id("ctl00_mainContent_ddl_Adult")).click();
		noOfPerson.selectByIndex(4); //Selecting Adults as 5
		
		
		Select selectCurrency= new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		selectCurrency.selectByValue("USD"); //selecting Currency whose Value is INR.
		
		//System.out.println(driver.findElements(By.id("discount-checkbox")).get(0));
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click(); //clicking on Search button
		
		//driver.close();
	}

}
