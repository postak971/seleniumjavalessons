package udemy;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseOverTest {	
	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void setEnviroment() {	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\posta\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void clickTibet() {
		driver.get("https://www.farandhigh.com/");
		wait = new WebDriverWait(driver, 10);
		//WebElement menu = driver.findElement(By.xpath("/html/body/div[2]/div/div/nav/div[2]/ul/li[3]/a"));
		WebElement menu = driver.findElement(By.xpath("//ul[@class='uk-navbar-nav uk-hidden-small']/descendant::li[3]"));
		wait.until(ExpectedConditions.visibilityOf(menu));
		Actions mouseOver = new Actions(driver);
		mouseOver.moveToElement(menu).build().perform();

		driver.findElement(By.xpath("//ul[@class='uk-nav uk-nav-navbar']//a[contains(text(),'Tibet')]")).click();
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();

	}
}
