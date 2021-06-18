import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxAssignment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		
		//driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected()); //Checks that checkbox is selected or not. Expects True.
		Thread.sleep(3000);
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		//int chckSize= driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		//System.out.println("Total number of checkboxes on page is "+chckSize);
		
		System.out.println(driver.findElements(By.cssSelector("input[type*='checkbox']")).size());
		
		
		driver.close();
	}

}
