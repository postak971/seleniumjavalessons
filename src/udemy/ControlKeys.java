package udemy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ControlKeys {
	WebDriver driver;
	
	@BeforeTest
	public void startUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\posta\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://accounts.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
		
	public void copyPaste() throws InterruptedException {		

		WebElement element = driver.findElement(By.id("identifierId"));
		Thread.sleep(3000);
		element.sendKeys("jptjpt@gmail.com");


		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='xkfVF']")).click(); //local an area and click

		Actions action = new Actions(driver); 

		action.keyDown(Keys.CONTROL).sendKeys(Keys.chord("a")).keyUp(Keys.CONTROL).perform(); //control + a

		action.keyDown(Keys.CONTROL).sendKeys(Keys.chord("c")).keyUp(Keys.CONTROL).perform(); //control + c

		driver.findElement(By.id("identifierId")).click(); //move to the place where you want to paste

		action.keyDown(Keys.CONTROL).sendKeys(Keys.chord("v")).keyUp(Keys.CONTROL).perform(); //control + v
		
	}
	@AfterTest
	public void closeBrowser() {

		driver.close();
	}
}


