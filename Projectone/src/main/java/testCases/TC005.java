package testCases;

import org.junit.Test;

import wrapper.GenericWrapper;

public class TC005 extends GenericWrapper {
	
	/*
	 * @Test public void check() {
	 * 
	 * invokeApp("chrome", "http://www.leafground.com/pages/Edit.html");
	 * 
	 * textBoxEnabledOrNotByXPath("//input[@disabled='true']");
	 * 
	 * 
	 * }
	 */
	@Test
	public void windows() {
		
		invokeApp("chrome", "http://www.leafground.com/pages/Window.html");
		
		clickById("home");
		
		switchToLastWindow();
		
		clickByLink("Edit");
		
		closeBrowser();
		
		
	}
	
	public void alert() {
		
		
	}

}
