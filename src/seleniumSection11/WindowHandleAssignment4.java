package seleniumSection11;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleAssignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
		driver.findElement(By.xpath("//div[@id='content']/div /a")).click();
		
		Set<String> win= driver.getWindowHandles();
		
		Iterator<String> it= win.iterator();
		
		String parentId= it.next();
		String childId= it.next();
		
		driver.switchTo().window(childId);
		
		String txtChild= driver.findElement(By.cssSelector("div[class='example']")).getText();
		
		System.out.println(txtChild); //printing child class text in console
		
		driver.switchTo().window(parentId);
		
		String txtParent= driver.findElement(By.cssSelector("div[class='example'] h3")).getText();
		System.out.println(txtParent);
		
		
	}

}
