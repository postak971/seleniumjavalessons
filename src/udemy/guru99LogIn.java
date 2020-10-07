package udemy;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(udemy.TestListner.class)
public class guru99LogIn extends Base{	
	
	@BeforeTest
	public void setUp() {
		initialization();//calling initialization method from the Base Class
	}
	@Test(priority = 1)
	public void doLogin() throws InterruptedException, IOException {
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.name("userName")).sendKeys("mngr266684");
		driver.findElement(By.name("password")).sendKeys("AjAgEh");//incorrect pw to fail the test.
		driver.findElement(By.name("login")).click();	
		
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "http://newtours.demoaut.com/mercuryreservation.php";
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualURL, expectedURL);
		softAssert.assertAll();		
		
	}
	@Test(priority = 2)
	public void passTest() {
		 System.out.println("This method to pass the test");	
		 Assert.assertTrue(true);
	}
	@AfterTest
	
	
	public void tearDown() {
		driver.quit();
		
	}

}
