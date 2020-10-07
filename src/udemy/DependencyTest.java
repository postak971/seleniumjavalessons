package udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest {
	
  @Test(priority = 1)
  public void doLogin() {
	  System.out.println("Log in by user.");
	  Assert.fail("user not registered");//forcefully failing the test
  }
  
  @Test(priority = 0)
  public void doRegister() {
	  System.out.println("Registering the user");
  }
  @Test(dependsOnMethods="doLogin",alwaysRun=true)//alwaysRun=true enforces the test to run even if the test it's dependent on fails.
  public void doSomething() {
	  System.out.println("Doing something");
  }
  
}
