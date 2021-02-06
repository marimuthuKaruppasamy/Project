package wrapper;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectWrapper extends GenericWrapper {
	
	
	@BeforeMethod
	public void openBrowser() {
		
		invokeApp("chrome", "https://www.irctc.co.in/nget/train-search");
	}
	
	@AfterMethod
	public void closeAllBrowser() {
		
		closeAllBrowsers();
		
	}

}
