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

public class MouseOverListVerifyLinks {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\posta\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.farandhigh.com/");

		WebDriverWait wait = new WebDriverWait(driver, 10);



		//WebElement menu = driver.findElement(By.xpath("/html/body/div[2]/div/div/nav/div[2]/ul/li[3]/a"));
		WebElement menu = driver.findElement(By.xpath("//ul[@class='uk-navbar-nav uk-hidden-small']/descendant::li[3]"));
		wait.until(ExpectedConditions.visibilityOf(menu));
		Actions mouseOver = new Actions(driver);
		mouseOver.moveToElement(menu).build().perform();

		List<WebElement> countries = driver.findElements(By.xpath("//ul[@class='uk-nav uk-nav-navbar']/descendant::a"));

		for(int i = 0; i < countries.size(); i++) {
			//String listLinks = countries.get(i).getAttribute("hrf");
			//System.out.println(countries.get(i).getText() +": " + countries.get(i).getAttribute("href"));
			String links = countries.get(i).getAttribute("href");
			verifyLinkActive(links);
		}
		
				
	}
	
	public static void verifyLinkActive(String linkURL) {
		try {
			URL links = new URL(linkURL);
			HttpURLConnection httpURLConnect=(HttpURLConnection)links.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();
			if(httpURLConnect.getResponseCode()==200) {
				System.out.println(linkURL + " - " + httpURLConnect.getResponseMessage());
			}
			if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkURL + " - " + httpURLConnect.getResponseMessage() + " - " +HttpURLConnection.HTTP_NOT_FOUND);
			}
		}
		catch(Exception e) {
			
		}
		
	}
}

//driver.findElement(By.xpath("//ul[@class='uk-nav uk-nav-navbar']//a[contains(text(),'Tibet')]")).click();

