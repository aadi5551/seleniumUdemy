import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		
		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("autosuggest")).sendKeys("IN"); //click on AutoSuggest dropdown
		Thread.sleep(3000);
		
		//This is to get list of all the options present in dropdown after searching
		List<WebElement> options= driver.findElements(By.cssSelector("li[class='ui-menu-item'] a[class='ui-corner-all']")); //Parent to Child relationship using cssSelector
		
		//This is iterate over list of options getting to match with desired string.
		for(WebElement option : options) {
			
			if(option.getText().equalsIgnoreCase("India")) {
				
				option.click(); //if option gets matches with desired text i.e. India, click on that option to select.
				break;
			}
		}
		
		//System.out.println(options);
		
		//driver.close();
	}

}
