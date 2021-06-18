package seleniumSection12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		driver.manage().window().maximize();

		WebElement selectedChckBoxExample = driver.findElement(By.id("checkbox-example"));

		selectedChckBoxExample.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]/input")).click();
		String chckLabelText = selectedChckBoxExample.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[1]")).getText();

		System.out.println(chckLabelText);

		WebElement dropdownElement = driver.findElement(By.id("dropdown-class-example"));
		
		Select dropdown= new Select(dropdownElement);
		
		dropdown.selectByVisibleText(chckLabelText);
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(chckLabelText);
		
		driver.findElement(By.id("alertbtn")).click();
		
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		
		if(alertText.contains(chckLabelText)) {
			
			System.out.println("Yes the required text "+chckLabelText+" is present in the alert text.");
			
		}else {
			

			System.out.println("No the required text "+chckLabelText+" is not present in the alert text.");
		}
		
		
		
		// driver.close();
	}

}
