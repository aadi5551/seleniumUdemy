import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		

		System.out.println(driver.findElement(By.cssSelector("input[name*= 'SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[name*= 'SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[name*= 'SeniorCitizenDiscount']")).isSelected());
		
		//count the total number of checkboxes on the screen.	
		int chckoptions= driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		System.out.println(chckoptions);
		
		
		/*
		 * List<WebElement> chckOptions=
		 * driver.findElements(By.cssSelector("input[type='checkbox']"));
		 * 
		 * 
		 * for(WebElement chckOption : chckOptions) {
		 * 
		 * System.out.println(chckOption);
		 * 
		 * }
		 */
		 
		//driver.close();
	}

}
