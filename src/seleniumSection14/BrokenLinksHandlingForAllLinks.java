package seleniumSection14;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinksHandlingForAllLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.manage().window().maximize();
		
		List<WebElement> links=driver.findElements(By.cssSelector("li[class=\"gf-li\"] a"));
		SoftAssert sa= new SoftAssert();
		
		for(WebElement link : links) {
			
			//String url= driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
				//OR
			String url= link.getAttribute("href");
			
			HttpURLConnection conn= (HttpURLConnection)new URL(url).openConnection(); //connection with url get from above step.
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode= conn.getResponseCode();
			System.out.println(responseCode);
			String failedText= link.getText();
			//Soft Assertion
			sa.assertTrue(responseCode<400, failedText+ " Text is broken/failed with code: "+responseCode);
			
			
			/*
			 * if(responseCode>400) {
			 * 
			 * String failedText= link.getText(); System.out.println(failedText+
			 * " Text is broken/failed with code: "+responseCode ); //Hard Assertion which
			 * stop execution when script fails. Assert.assertTrue(false);
			 * 
			 * }
			 */
			 
		}
		//if there is any failure in above soft assert, below line will fail script otherwise pass the script.
		sa.assertAll();
		
		
		
		
		
		
		
		
		
		
		
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
