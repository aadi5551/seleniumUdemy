package seleniumSection14;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksHandlingSingle {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.manage().window().maximize();
		
		WebElement footerDriver =driver.findElement(By.id("gf-BIG"));
		
		//footerDriver.findElements(By.tagName("a"))
		
		//Broken Links

		//Step1: Get all the Urls tied up to the links using selenium.
		//Java methods will call the URL's and get you the status code.
		//If statusCode>=400, Then that Url isnot working ->Link ties to url is broken
		
		String url= driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		
		HttpURLConnection conn= (HttpURLConnection)new URL(url).openConnection(); //connection with url get from above step.
		conn.setRequestMethod("HEAD");
		conn.connect();
		int responseCode= conn.getResponseCode();
		System.out.println(responseCode);
		
		
		
	}

}
