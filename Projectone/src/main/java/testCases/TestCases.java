package testCases;



import org.openqa.selenium.WebElement;

import wrapper.GenericWrapper;

public class TestCases extends GenericWrapper {

	public void textBox() {

		invokeApp("chrome", "http://www.leafground.com/pages/Edit.html");

		enterById("email", "manoece18@gmail.com");

		enterByName("username", "gettext");

		enterByXpath("//input[@value='Append ']", "ajith");

		clearTextBoxName("username");

		textBoxEnabledOrNotByXPath("//input[@disabled='true']");
		
		closeAllBrowsers();
	}

	public void verifyText() {

		invokeApp("chrome", "http://www.leafground.com/pages/Alert.html");

		getTextByXpath("//button[text()='Alert Box']");

		verifyTextByXpath("//button[text()='Alert Box']", "Alert Box");

		verifyTextContainsByXpath("//button[text()='Confirm Box']", "Confirm");
		
		closeAllBrowsers();


	}

	public void verifyTitle() {

		invokeApp("chrome", "http://www.google.co.in");

		verifyTitle("Google");
		
		closeAllBrowsers();
	}

	public void dropDown() {

		invokeApp("chrome", "http://www.leafground.com/pages/Dropdown.html");

		selectIndexByXpath("//select[@id='dropdown1']", 1);

		selectValueByXPath("//select[@name='dropdown2']", "2");

		selectVisibileTextByXPath("//select[@id='dropdown3']", "UFT/QTP");
		
		closeAllBrowsers();


	}

	public void alerts() throws InterruptedException  {

		invokeApp("chrome", "http://www.leafground.com/pages/Alert.html");

		WebElement alert=driver.findElementByXPath("//button[text()='Alert Box']");

		alert.click();

		acceptAlert();

		WebElement alert1=driver.findElementByXPath("//button[text()='Confirm Box']");

		alert1.click();


		getAlertText();

		dismissAlert();
		
		closeAllBrowsers();

		
	}
	
	public void frame() {
		
		invokeApp("chrome", "http://www.leafground.com/pages/frame.html");
		
		switchToFrame(0);
		
		WebElement click=driver.findElementById("Click");
		
		click.click();
		
		driver.switchTo().defaultContent();
		
		switchToFrame(1);
		
	    switchToFrame("frame2");
	    
	    WebElement click1=driver.findElementById("Click1");
	    
	    click1.click();
	    
	    closeAllBrowsers();
	   
		
	}
	
	public void window() {
		
		invokeApp("chrome", "http://www.leafground.com/pages/Window.html");
		
		clickById("home");
		
		switchToLastWindow();
		
		clickByLink("Edit");
		
		closeBrowser();
		
		switchToParentWindow();
		
		clickByXpath("//button[text()='Open Multiple Windows']");
		
		closeAllBrowsers();
		
		
	}



	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		TestCases test=new TestCases();

		test.textBox();

		test.verifyText();

		test.verifyTitle();

		test.dropDown();

		test.alerts();
		
		test.frame();
		
		test.window();



	}

}
