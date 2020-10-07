package udemy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SliderWithLength {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\posta\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/slider/");

		//WebDriverWait wait = new WebDriverWait(driver, 10);	
		
		driver.switchTo().frame(0); //the slider is inside a frame and so need to switch to the frame index 0
		
		WebElement sliderPath = driver.findElement(By.id("slider"));
		int sliderPathMid = sliderPath.getSize().width/2; //finding the mid-path of the slider.
		
		
		WebElement slider = driver.findElement(By.xpath("//div[@id ='slider']/span"));
		
		//wait.until(ExpectedConditions.visibilityOf(slider));
		
		new Actions(driver).dragAndDropBy(slider, sliderPathMid, 0).perform();
		
		driver.close();

	}

}
