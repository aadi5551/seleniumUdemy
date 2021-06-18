import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StaticDropdown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		/*
		 * driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
		 * driver.findElement(By.xpath("//input[@id='login1']")).
		 * sendKeys("aditya is smart");
		 * driver.findElement(By.xpath("//input[@id='password']")).
		 * sendKeys("aditya is smart");
		 * driver.findElement(By.xpath("//input[@id='login1']")).
		 * sendKeys("aditya is smart");
		 * driver.findElement(By.xpath("//input[@id='login1']")).
		 * sendKeys("aditya is smart");
		 * driver.findElement(By.cssSelector("input[title='Sign in']")).click();
		 * 
		 * String errText=
		 * driver.findElement(By.xpath("//div[@id='div_login_error']")).getText();
		 * System.out.println(errText);
		 */

		// Rahul Sheety Flight dropdown test ONLY for <Select> tags

		
		  WebElement staticDriver = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); 
		  Select dropdown= new Select(staticDriver);
		  
		  dropdown.selectByIndex(3); 
		  String selectedOption= dropdown.getFirstSelectedOption().getText();
		  System.out.println(selectedOption);
		  
		  
		  dropdown.selectByVisibleText("AED"); 
		  String selectedOption1= dropdown.getFirstSelectedOption().getText();
		  System.out.println(selectedOption1);
		  
		  dropdown.selectByValue("INR");
		  String selectedOption2= dropdown.getFirstSelectedOption().getText();
		  System.out.println(selectedOption2);
		 

		// Handle Passengers dropdown.
		
		  driver.findElement(By.id("divpaxinfo")).click(); Thread.sleep(2000);
		  
		  String beforeText= driver.findElement(By.id("divpaxinfo")).getText();
		  System.out.println(beforeText);
		  
		  int i=1; 
		  while(i<5) {
		  
		  driver.findElement(By.id("hrefIncAdt")).click();
		  //driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click(); 
		  i++;
		  
		  } 
		  Thread.sleep(2000);
		  
		  
		  driver.findElement(By.id("btnclosepaxoption")).click(); 
		  String afterText= driver.findElement(By.id("divpaxinfo")).getText();
		  System.out.println(afterText);
		  
		  Assert.assertEquals(afterText, "5 Adult");
		  
		/*
		 * if (beforeText==afterText) {
		 * 
		 * System.out.println("Test Case Passed!!"); }else {
		 * System.out.println("Test Case Failed!!"); }
		 */
		  
		 
		driver.close();

	}

}
