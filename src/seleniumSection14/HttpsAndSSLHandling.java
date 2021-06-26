package seleniumSection14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HttpsAndSSLHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		//SSL Certification
		//Desired capabilities
		//General Chrome profile.
		DesiredCapabilities ch=DesiredCapabilities.chrome();
		ch.acceptInsecureCerts();
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		//Belongs to your local browser
		ChromeOptions co=new ChromeOptions();
		co.merge(ch);
		
		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver(co);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.manage().window().maximize();
		
		
		
		
	}

}
