package udemy;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.ITestContext ;	


public class TestListner extends Base implements ITestListener{

	public void onFinish(ITestContext Result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext Result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		
		
	}

	public void onTestFailure(ITestResult Result) {		
	try {
		takeScreenShot();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	System.out.println("The name of the test that failed: " + Result.getName());
	}

	public void onTestSkipped(ITestResult Result) {
		System.out.println("The name of the test that skipped: " + Result.getName());
		
	}

	public void onTestStart(ITestResult Result) {
		// TODO Auto-generated method stub
		System.out.println(Result.getName()+" test case started");	
		
	}

	public void onTestSuccess(ITestResult Result) {
	    System.out.println("The name of the testcase passed is :"+Result.getName());	
		
	}

	
}
