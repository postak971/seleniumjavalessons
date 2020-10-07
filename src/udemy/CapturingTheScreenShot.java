package udemy;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CapturingTheScreenShot {

	
		public static void main(String[] args) throws IOException {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\posta\\Drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.farandhigh.com/");
			
			Date d = new Date();		//Timestamp on filename
			String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Code to copy the screenshot in the desired location
			FileUtils.copyFile(scrFile, new File("C:\\Users\\posta\\Pictures\\" + fileName));
	}

}
