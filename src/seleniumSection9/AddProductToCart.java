package seleniumSection9;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductToCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();

		// driver.get("https://www.spicejet.com/");
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		driver.manage().window().maximize();
		Thread.sleep(3000);

		String[] listOfProducts = { "Cucumber", "Brocolli", "Beetroot", "Apple" };
		
		addToCart(driver, listOfProducts);
		
		}
		public static void addToCart(WebDriver driver, String[] listOfProducts) {
			
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		int itemCount = 0;
		for (int i = 0; i < products.size(); i++) {

			String[] productName = products.get(i).getText().split("-"); // getting name of product

			String updatedName = productName[0].trim();
			List desiredProduct = Arrays.asList(listOfProducts); // converting Array into ArrayList.

			if (desiredProduct.contains(updatedName)) {

				//driver.findElements(By.xpath("//button[text()=\"ADD TO CART\"]")).get(i).click(); // Click on Add to Cart
									//OR
				driver.findElements(By.cssSelector("div[class='product-action'] button")).get(i).click(); // Click on Add to Cart																				// Cart
				// break; // not to use break when iterate Arrayt List i.e. multiple items. use
				// only when there is only one item.
			//	Thread.sleep(5000); //This program also gets run successfully when we give this thread.sleep but it is not good practice.
				itemCount++;
				if (itemCount == listOfProducts.length) {

					break;
				}
			} else {

				System.out.println("This is not matching with desired result having name as " + updatedName);
			}

		}
	}

}
