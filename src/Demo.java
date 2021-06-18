import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Selenium code
		
        System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://google.com"); //Hit url on he browser.
		/*
		 * String expectedUrl= "https://www.google.com/"; driver.getTitle(); //validate
		 * if your page title is correct.
		 * 
		 * String actualUrl= driver.getCurrentUrl(); // validate if you are landed on
		 * correct url. System.out.println(actualUrl);
		 * 
		 * if(expectedUrl.equals(actualUrl)) {
		 * 
		 * System.out.println("Test Case1 passed!! URL matched."); }else {
		 * 
		 * System.out.println("Test Case1 failed!! URL not matched. "); }
		 * 
		 * //System.out.println(driver.getPageSource());
		 * 
		 * 
		 * driver.get("https://yahoo.com");
		 * 
		 * driver.navigate().back();
		 * 
		 * //driver.navigate().refresh();
		 * 
		 * 
		 * 
		 * 
		 */
		
		driver.get("https://epluribusangqaweb.appskeeper.com/public/login");
		
		
		driver.close(); //closes the currently focussed window
	//	driver.quit(); //closes all the windows including cfild windows.
		
	}

}
