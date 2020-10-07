package udemy;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshot {
	WebDriver driver;

	@BeforeTest
	public void setUpEnviron() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
	}		

	@Test
	public void takeScreenShot() throws IOException{
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_intro_inner_html");
		driver.switchTo().frame("iframeResult");
		System.out.println("iframe title: " + driver.getTitle());

		JavascriptExecutor js =((JavascriptExecutor)driver); //typecasting 
		js.executeScript("document.getElementById(\"demo\").innerHTML = \"Hello JavaScript!\""); //clicks on the button

		WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Click Me!')]"));
		//wait.until(ExpectedConditions.visibilityOfElementLocated("//button[contains(text(),'Click Me!')]"));

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element); //Highlights the button

		//Taking screenshot

		driver.switchTo().defaultContent();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("C:\\Users\\posta\\eclipse-workspace\\SeleniumUdemy\\src\\screenshots\\error1.jpg"));
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}


}






