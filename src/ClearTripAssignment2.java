import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ClearTripAssignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.cleartrip.com/");
		// driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.manage().window().maximize();
		Thread.sleep(3000);

		Select selectAdult = new Select(driver.findElement(By.xpath("//div[@class='mb-4'] //select[@class=\"bc-neutral-100 bg-transparent\"]")));

		selectAdult.selectByIndex(4);		

		Select selectChild = new Select(driver.findElement(By.xpath("//div[@class='col flex flex-middle']/div[3]/select")));
		selectChild.selectByIndex(3);

		driver.findElement(By.cssSelector(".flex.flex-middle.p-relative.homeCalender")).click();
		driver.findElement(By.xpath("//div[@aria-selected=\"true\"]")).click();

		driver.findElement(By.xpath("//div[@class='mb-4'] //a")).click();
		driver.findElement(By.cssSelector("[placeholder=\"Airline name\"]")).sendKeys("Air India");

		driver.findElement(By.xpath("//div[@class='mb-4'] //button")).click();

		String errText = driver.findElement(By.xpath("//div[@class='col-24']/div/span")).getText();
		// OR
		// String errText= driver.findElement(By.xpath("//span[text()=\"Select Departure
		// and Arrival airports/cities.\"]")).getText();
		System.out.println(errText);

		driver.close();
	}

}
