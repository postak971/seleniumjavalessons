import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkippingTest {
	
	@Test
	
	public void skipTest() 
	{
	
		throw new SkipException("Skipped the test.");
	}

}
