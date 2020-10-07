package udemy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZohoLogin {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.zoho.com/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".zh-login"))).click();;
		//driver.findElement(By.xpath("//a[@class='zh-login']")).click();
		

		driver.findElement(By.id("login_id")).sendKeys("travelfarandhigh@gmail.com");

		//driver.findElement(By.xpath("//form[@id='login']//button[@id='nextbtn']")).click();
		driver.findElement(By.cssSelector("button.btn:nth-child(6)")).click();

		driver.findElement(By.id("password")).sendKeys("Americandreams@2021");
		
		//driver.findElement(By.xpath("//form[@id='login']//button[@id='nextbtn']")).click();
		driver.findElement(By.cssSelector("button.btn:nth-child(6)")).click();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());

	}

}
