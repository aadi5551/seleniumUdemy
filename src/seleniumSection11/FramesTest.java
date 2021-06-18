package seleniumSection11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/droppable/");
		
		driver.manage().window().maximize();
		
		WebElement frameElement= driver.findElement(By.cssSelector(".demo-frame")); 
		
		driver.switchTo().frame(frameElement); // for getting frame by WebElement
		//driver.switchTo().frame(1); //for getting frame by its Index
		
		//driver.findElement(By.id("draggable")).click();
		
		Actions ac= new Actions(driver);
		
		WebElement dragElement= driver.findElement(By.id("draggable"));
		WebElement dropElement= driver.findElement(By.id("droppable"));
		
		ac.dragAndDrop(dragElement, dropElement).build().perform();
		
		//Very Important to write at end of Frmae.
		driver.switchTo().defaultContent(); //to comeout from Frame component.
		
		
		
		
	}

}
