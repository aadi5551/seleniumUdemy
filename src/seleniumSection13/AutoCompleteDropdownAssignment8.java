package seleniumSection13;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutoCompleteDropdownAssignment8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Adding Implicit Wait Globally
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.manage().window().maximize();

		Actions ac = new Actions(driver);
		
		driver.findElement(By.cssSelector("input[id='autocomplete']")).sendKeys("ind");


		// My Solution
		List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("ul[id='ui-id-1'] li div"));
		int sizeOfDropdownOptions = driver.findElements(By.cssSelector("ul[id='ui-id-1'] li div")).size();
		System.out.println(sizeOfDropdownOptions);;
		
		for (WebElement dropdownOption : dropdownOptions) {

			String dropdowntext = dropdownOption.getText();
			//System.out.println(dropdowntext);

			if (dropdowntext.equalsIgnoreCase("India")) {

				ac.moveToElement(dropdownOption).click().build().perform();
				 //dropdownOption.click();
				// if option gets matches with desired text i.e. India, click on that option to
				// select. break; //

			}

		}

		//String autoSuggestDropdownText = driver.findElement(By.cssSelector("input[id='autocomplete']")).getText(); // Not works Use below Line
		String autoSuggestDropdownText = driver.findElement(By.cssSelector("input[id='autocomplete']")).getAttribute("value"); //This line will work.
		
		System.out.println(autoSuggestDropdownText);

	}

}
