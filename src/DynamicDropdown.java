import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		//Thread.sleep(2000);
		//a[@value="MAA"]
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); //Click on From Dropdown
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@value='BLR']")).click(); //Selects From City
		
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click(); //Click on To Dropdown
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@value=\"MAA\"])[2]")).click(); //Selects To City
										//OR
		//driver.findElement(By.xpath("//div[@id=\"ctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@value=\"MAA\"]")).click(); //Selects To City
		System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getAttribute("value")); 
		System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getAttribute("value"));
		
		
		
		
		
		
		driver.close();
	}

}
