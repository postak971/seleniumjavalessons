package udemy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecuter {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_intro_inner_html");
		driver.switchTo().frame("iframeResult");
		System.out.println(driver.getTitle());
		
		//WebDriverWait wait = new WebDriverWait(driver,10);
		
		WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Click Me!')]"));
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Click Me!')]"))).click();
		
		//JavascriptExecutor is an interface and can not be instantiated. So, it has to be typcasted with the driver.
				
		//((JavascriptExecutor)driver).executeScript("document.getElementById(\"demo\").innerHTML = \"Hello JavaScript!\"");
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("document.getElementById(\"demo\").innerHTML = \"Hello JavaScript!\"");
		
		//Highlighting the element.
		
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		
		Thread.sleep(2000);
		driver.close();
		
		

	}

}
