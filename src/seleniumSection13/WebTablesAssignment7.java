package seleniumSection13;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablesAssignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.manage().window().maximize();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");// scroll the window

		List<WebElement> allRowsData = driver.findElements(By.cssSelector("div[class='left-align'] #product tbody tr"));
		int totalRows = allRowsData.size();
		List<WebElement> allColsData = driver.findElements(By.cssSelector("div[class='left-align'] #product tbody tr th"));
		int totalCols = allColsData.size();

		System.out.println(totalRows + "   " + totalCols);

		List<WebElement> rowTwoElements = driver.findElements(By.cssSelector("div[class='left-align'] tr:nth-child(3)"));

		String rowText = rowTwoElements.get(0).getText();
		System.out.print(rowText);

	}

}
