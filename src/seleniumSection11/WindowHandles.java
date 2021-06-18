package seleniumSection11;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");
		
		driver.manage().window().maximize();
		
		
		
		//Clickin on Link present to open new window
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
		
		//[parentId,childId,subChild] in string
		//getWndowHandles method gives the ID of the windows currently opened in the Set String form.
		Set<String> windows= driver.getWindowHandles();
		
		//Iterate to get IDs of windows in normal String from Set String using Iterator.
		Iterator<String> it= windows.iterator();
		String parentId= it.next();
		String childId= it.next();
		//String subChild= it.next();
		
		//Now control of selenium is switched to child Window
		driver.switchTo().window(childId);
		
		driver.findElement(By.cssSelector(".im-para.red")).getText();
		String str= driver.findElement(By.cssSelector(".im-para.red")).getText();
		String email= str.split("at")[1].trim().split(" ")[0];
		System.out.println(email);
		
		driver.switchTo().window(parentId);
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys("learning");
		
		
		
		
		
		
	}

}
