package seleniumSection12;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LinkCountInPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		
		//1/ Give me the count of links on the page.
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2. Give me the count of links in the footer section of the page.
		
		//Limiting the scope of the Main driver to sub-Driver
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		//3. Give the Link counts of first column of footer section of the page.
		
		WebElement footerColumnLink= footerDriver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]"));
		
		System.out.println(footerColumnLink.findElements(By.tagName("a")).size());
		
		//4. Click on each link in the column and check if the Window is opening or not (Check link is working or not)
		
		int countOfLink= footerColumnLink.findElements(By.tagName("a")).size();
		
		for(int i=1; i<countOfLink;i++) {
			
			String clickOnLink= Keys.chord(Keys.CONTROL,Keys.ENTER); //It clicks on any Link by pressing Ctrl button so that that link opens in new tab.
			
			//footerColumnLink.findElements(By.tagName("a")).get(i).click();
			//Here we tell selenium to click on which link.
			footerColumnLink.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			
		}
		
		//5. Now goto each Child window opened and getText() of each window and print in console.
		Set<String> windows=driver.getWindowHandles();
		
		Iterator<String> it=windows.iterator();
		//String parentId= it.next();
		int i=1;
		//while(countOfLink>0) {
			while(it.hasNext()) {
			
					
			String titleChild = driver.switchTo().window(it.next()).getTitle();
			System.out.println("Window "+i+" title is: "+titleChild);
			i++;
		}
		//driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());
		
			
			
			
		
		//driver.close();
	}

}
