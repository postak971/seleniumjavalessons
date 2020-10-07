package udemy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Table {

	public static void main(String[] args) {
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\posta\\Drivers\\geckodriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\posta\\Drivers\\chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
		
		
		List <WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		System.out.println("Total rows: " + rows.size());
		List <WebElement> cols = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td"));
		System.out.println("Total columns: " + cols.size());
		
		for(int i = 1; i < rows.size(); i ++) {
			for(int j = 1; j < cols.size(); j++){
				System.out.print(driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[" + i +"]/td[" + j +"]")).getText() + " ");
				
			}
			
			System.out.println();
		}
		
		

	}

}
