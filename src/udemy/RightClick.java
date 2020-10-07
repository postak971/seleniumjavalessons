package udemy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RightClick {

	WebDriver driver;

	@BeforeTest
	
	public void startBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\posta\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test

	public void testRightClick() {
		driver.get("http://deluxe-menu.com/popup-mode-sample.html");
		WebElement img = driver.findElement(By.xpath("//p[contains(text(),'Click the image to show the menu')]"));
		Actions action = new Actions(driver);
		action.contextClick(img).perform(); //Right click
		WebElement s1 = driver.findElement(By.xpath("//td[@id='dm2m1i1tdT']")); // find and Mouse over the option Product Info
		action.moveToElement(s1).build().perform();
		//Thread.sleep(2000);
		WebElement s2 = driver.findElement(By.xpath("//td[@id='dm2m2i1tdT']"));// find and Mouse over to the option Installation

		action.moveToElement(s2).build().perform(); 
		//Thread.sleep(2000);
		WebElement s3 = driver.findElement(By.xpath("//td[@id='dm2m3i1tdT']"));//find and click How To Set Up
		s3.click();
		driver.close();
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
