import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarAndRadioSelect {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		//driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("opcaity: 1")) {
			
			System.out.println("Its enabled");
			Assert.assertTrue(true);
			
			
		}else {
			System.out.println("Its disabled");
			//driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click(); //click on Round Trip
			Assert.assertFalse(false);
			
		}
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_txt_Todate")).isEnabled()); //check Round trip is enabled or not.
		//Radio button click
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click(); //click on Round Trip
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_txt_Todate")).isEnabled()); //check Round trip is enabled or not.
		
		
		//Calendar current date select
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
		
		
		
		//driver.close();
		
	}

}
