package udemy;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetCSSValueofElement {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\posta\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.farandhigh.com/");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		System.out.println(" Font size is: " + driver.findElement(By.linkText("Journeys of a lifetime")).getCssValue("font-size"));
		System.out.println(" Font color is: " + driver.findElement(By.linkText("Journeys of a lifetime")).getCssValue("font-color"));
		



		//WebElement menu = driver.findElement(By.xpath("/html/body/div[2]/div/div/nav/div[2]/ul/li[3]/a"));
		
		
		driver.close();		
	}
	
	
}
