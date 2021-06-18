import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AssertDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[name*= 'SeniorCitizenDiscount']")).isSelected()); //checks for validation; expects False. Otherwise execution fail.
		Assert.assertFalse(false, "Test case fail!!");
		//System.out.println(driver.findElement(By.cssSelector("input[name*= 'SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[name*= 'SeniorCitizenDiscount']")).click();
		//System.out.println(driver.findElement(By.cssSelector("input[name*= 'SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[name*= 'SeniorCitizenDiscount']")).isSelected()); //checks for validation; expects True. Otherwise execution fail.
		
		//count the total number of checkboxes on the screen.	
		int chckoptions= driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		System.out.println(chckoptions);
		
		
		
		//driver.close();
		
	}

}
