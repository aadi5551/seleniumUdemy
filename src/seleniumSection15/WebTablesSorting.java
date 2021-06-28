package seleniumSection15;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTablesSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();

		// driver.get("https://www.spicejet.com/");
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Click on column
		driver.findElement(By.xpath("//th[@role='columnheader'][1]")).click();
		//Capture all webelements into Lists
		int sizeOfTable= driver.findElements(By.xpath("//tr/td[1]")).size();
		List<WebElement>tableElements=driver.findElements(By.xpath("//tr/td[1]"));
		
		//Capture  text of all webelements into new list by Apply .getText() to get actual text. (Original list)
		List<String> originalList=tableElements.stream().map(scan->scan.getText()).collect(Collectors.toList());
		
		//Sort in the original List of Step above i.e. step 3 -> prepare new list as sorted List.
		List<String> sortedList=originalList.stream().sorted().collect(Collectors.toList());
		
		//compare original list vs sorted list. (after clicking on the column)
		Assert.assertTrue(sortedList.equals(originalList));
		
		
		//*****************************XXXXXXXXXXXXXXXXXXXXXX***********************************//
		
		////Get the price of the particular item.
		
		//scan the item name column with getText() ->If Beans then print price of Beans.
		
		List<String> priceOfItem =tableElements.stream().filter(scan->scan.getText().contains("Beans"))
		.map(scan->getPriceItem(scan)).collect(Collectors.toList());
		
		priceOfItem.stream().forEach(scan->System.out.println(scan));
		
	}

	private static String getPriceItem(WebElement scan) {
		// TODO Auto-generated method stub
		
		String priceValue= scan.findElement(By.xpath("following-sibling :: td[1]")).getText();
		
		return priceValue;
	}

}
