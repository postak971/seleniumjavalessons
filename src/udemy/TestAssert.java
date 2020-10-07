package udemy;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestAssert {
	
	@Test
	public void validateTitle() {
	
	String actualResult = "yahoo.com";
	String expectedResult = "google.com";
	
	SoftAssert softAssert = new SoftAssert();
	
	
	softAssert.assertEquals(actualResult, expectedResult);	
	
	softAssert.assertAll();
	
	
	}
	}
