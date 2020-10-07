package udemy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Resizable {

	public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\posta\\Drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://jqueryui.com/resizable/");

			//WebDriverWait wait = new WebDriverWait(driver, 10);	
			
			driver.switchTo().frame(0); //the slider is inside a frame and so need to switch to the frame index 0
			
			WebElement resizableBox = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
			
			//wait.until(ExpectedConditions.visibilityOf(slider));
			Actions action = new Actions(driver);
			action.dragAndDropBy(resizableBox, 150, 150).perform();			
			
			//Thread.sleep(3000);
			//driver.close();
	}

}
