import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		
		//driver.get("https://www.spicejet.com/");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		String name= "Aditya";
		driver.findElement(By.id("name")).sendKeys(name); //Enter name is Name box.
		driver.findElement(By.id("alertbtn")).click(); //click on Alert button
		Thread.sleep(2000); //wait for 2 seconds
		String alertTextOnAlert= driver.switchTo().alert().getText(); //getting the text on pop-up/
		System.out.println(alertTextOnAlert); //printing the text of Pop-up
		driver.switchTo().alert().accept(); //click on OK button and accept that pop-up.
		
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("confirmbtn")).click(); //Click on Confirm button.
		String alertTextOnConfirm= driver.switchTo().alert().getText(); 
		System.out.println(alertTextOnConfirm);
		driver.switchTo().alert().dismiss();
		
		
		
		
		driver.close();
	}

}
