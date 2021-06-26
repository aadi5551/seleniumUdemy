package seleniumSection14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaxWindowAndDeleteCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("sessionKey");
		
		//click on any link
		// session expired as cookie is deleted.
		//Login page- verify login url.
		
	//	driver.get("https://www.google.com");
	}

}
