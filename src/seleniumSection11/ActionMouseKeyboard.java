package seleniumSection11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionMouseKeyboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();

		//driver.get("https://www.amazon.com/");
		driver.get("https://jqueryui.com/droppable/");// for Drag and Drop only.
		
		driver.manage().window().maximize();
		
		Actions ac= new Actions(driver);
		WebElement move= driver.findElement(By.id("nav-link-accountList"));
		
		//driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))
		
		//Entering text into search box in Uppercase by press and hold Shift button of keyboard and selecting the whole text by Double click.
		WebElement searchBox= driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
		ac.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
	
		//Moves to specific element
		ac.moveToElement(move).contextClick().build().perform();
		
		//DragandDrop Concept
		//Discussed after Frames lecture.
		/*
		 * WebElement frameEleement= driver.findElement(By.cssSelector(".demo-frame"));
		 * 
		 * driver.switchTo().frame(frameEleement);
		 * 
		 * WebElement dragElement= driver.findElement(By.id("draggable")); 
		 * WebElement dropElement= driver.findElement(By.id("droppable"));
		 * 
		 * ac.dragAndDrop(dragElement, dropElement).build().perform();
		 * 
		 */
	}

}
