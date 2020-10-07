package udemy;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingCalendars {

	static int targetDay = 0,
			targetMonth= 0,
			targetYear=0;
	static int currentDay = 0,
			currentMonth = 0, 
			currentYear = 0;

	static int jumpMonthsBy = 0;
	static boolean increment = true;

	//Get current date/month/year

	public static void getCurrentDateMonthAndYear() {
		Calendar cal = Calendar.getInstance();
		currentDay = cal.get(Calendar.DAY_OF_MONTH);
		currentMonth = cal.get(Calendar.MONTH)+1;
		currentYear = cal.get(Calendar.YEAR);


	}
	//Get target date/month/year
	public static void getTargetDateMonthAndYear(String dateString) {
		int firstIndex = dateString.indexOf("/");
		int lastIndex = dateString.lastIndexOf("/");

		String day = dateString.substring(0, firstIndex);
		targetDay = Integer.parseInt(day);

		String month = dateString.substring(firstIndex +1, lastIndex);
		targetMonth = Integer.parseInt(month);

		String year = dateString.substring(lastIndex + 1, dateString.length());
		targetYear = Integer.parseInt(year);	

	}

	//Get jump month
	public static void calculateNumOfMonthsToJump() {
		if((targetMonth-currentMonth) > 0){
			jumpMonthsBy = targetMonth-currentMonth;
		}
		else{
			jumpMonthsBy = currentMonth-targetMonth;
			increment = false;
		}

	}	
	public static void main(String[] args) throws InterruptedException {
		String dateToSet = "14/08/2020";
		//call method to get the current date, month and year
		getCurrentDateMonthAndYear();
		System.out.println("Current date/month/year: " + currentDay + "/"+ currentMonth + "/"+ currentYear);

		getTargetDateMonthAndYear(dateToSet);
		System.out.println("Target date/month/year: " + targetDay + "/"+ targetMonth + "/"+ targetYear);

		calculateNumOfMonthsToJump();
		System.out.println("Jump months by: " + jumpMonthsBy);
		System.out.println(increment);
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\posta\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		WebElement frame = driver.findElement(By.xpath("//div[@id='content']//iframe"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
				
		System.out.println(driver.getTitle());
		
			
		WebElement datepicker = driver.findElement(By.id("datepicker"));
		wait.until(ExpectedConditions.visibilityOf(datepicker)).click();
		for(int i = 0; i < jumpMonthsBy; i++) {
			if(increment) { //if increment is true, click on forward arrow
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click(); //
				
			}else
			{//else click on the backward arrow to previous months.
				driver.findElement(By.xpath("//*[contains(text() ,'Prev')]")).click();
			}
		}
		driver.findElement(By.linkText(Integer.toString(targetDay))).click();		
	}
}



