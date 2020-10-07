package udemy;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(udemy.TestListner.class)
public class Base {

	public static WebDriver driver;

	public void initialization() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	public  void takeScreenShot() throws IOException{
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.PNG'").format(new Date());
		String filepath = "C:\\Users\\posta\\eclipse-workspace\\SeleniumUdemy\\src\\screenshots\\";
		File dest = new File(filepath + filename);
		FileUtils.copyFile(scr, dest);				
	}

}



