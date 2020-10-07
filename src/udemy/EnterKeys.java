package udemy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EnterKeys {
	WebDriver driver;

	@BeforeTest
	public void startEnvironment() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\posta\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testEnterkey() {

		driver.get("https://www.google.com/");		
		driver.findElement(By.name("q")).sendKeys("far & high");		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}


