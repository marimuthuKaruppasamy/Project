package wrapper;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrapper implements Wrappers {

	public static RemoteWebDriver driver;

	public void invokeApp(String browser, String url) {

		try {

			if(browser.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

				driver=new ChromeDriver();
			}

			else if(browser.equalsIgnoreCase("firefox")) {

				System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");

				driver=new FirefoxDriver();

			}

			else if(browser.equalsIgnoreCase("ie")) {

				System.setProperty("webdriver.ie.driver", "./drivers/IEdriverServer.exe");
				driver = new InternetExplorerDriver();


			}

			driver.manage().window().maximize();

			driver.get(url);


			System.out.println("The browser"+browser+"is lanched successfully with url"+url);

		}
		catch(SessionNotCreatedException e) {

			System.err.println("TheBrowser"+browser+"is not lanched due to session created error");
		}

		catch(WebDriverException e) {

			System.err.println("The browser"+browser+"is not lanched for unknown error");
		}
		finally {
			takeSnap();
		}




	}

	public void enterById(String idValue, String data) {

		try {

			driver.findElementById(idValue).sendKeys(data);

			System.out.println("Enter element with id"+idValue+"data"+data+ "is successfully");

		}
		catch(NoSuchElementException e) {

			System.err.println("Element not not present in the dom");
		}
		catch(WebDriverException e) {

			System.err.println("it is an unknown error");


		}
		catch(Exception e) {

			System.err.println("it is an unknown error");
		}

		finally {

			takeSnap();

		}

	}

	public void enterByName(String nameValue, String data) {


		try {

			driver.findElementByName(nameValue).sendKeys(data);

			System.out.println("Enter element with id"+nameValue+"data"+data+ "is successfully");

		}
		catch(NoSuchElementException e) {

			System.err.println("Element not not present in the dom");
		}
		catch(WebDriverException e) {

			System.err.println("it is an unknown error");


		}
		catch(Exception e) {

			System.err.println("it is an unknown error");
		}

		finally {

			takeSnap();

		}

	}

	public void enterByXpath(String xpathValue, String data) {


		try {

			driver.findElementByXPath(xpathValue).sendKeys(data);

			System.out.println("Enter element with id"+xpathValue+"data"+data+ "is successfully");

		}
		catch(NoSuchElementException e) {

			System.err.println("Element not not present in the dom");
		}
		catch(WebDriverException e) {

			System.err.println("it is an webdriver unknown error");


		}
		catch(Exception e) {

			System.err.println("it is an unknown error");
		}

		finally {

			takeSnap();

		}

	}

	public void verifyTitle(String title) {
		String actualTitle;

		try {

			actualTitle=driver.getTitle();

			if(actualTitle.equalsIgnoreCase(title)) {

				System.out.println("title"+title+"is matched with"+actualTitle);
			}
			else {

				System.err.println("title"+title+"is  not matched with"+actualTitle);

			}
		}
		catch(WebDriverException e){


			System.err.println("it is  web driveran unknown error");

		}
		catch(Exception e) {

			System.err.println("it is an unknown error");
		}
		finally {

			takeSnap();
		}

	}

	public void verifyTextById(String id, String text) {
		String actualText;

		try {

			actualText=driver.findElementById(id).getText();

			if(actualText.equalsIgnoreCase(text)) {

				System.out.println("The Text"+text+"is matched"+actualText);
			}
			else {

				System.out.println("The Text"+text+"is not matched"+actualText);
			}

		}
		catch(WebDriverException e) {

			System.err.println("it is unknown error handle webdriver");
		}

		catch(Exception e) {

			System.err.println("it is unknown error handled by super exception");
		}
		finally {

			takeSnap();
		}


	}

	public void verifyTextByXpath(String xpath, String text) {


		String actualText;

		try {

			actualText=driver.findElementByXPath(xpath).getText();

			if(actualText.equalsIgnoreCase(text)) {

				System.out.println("The Text"+text+"is matched"+actualText);
			}
			else {

				System.err.println("The Text"+text+"is not matched"+actualText);
			}

		}
		catch(WebDriverException e) {

			System.err.println("it is unknown error handle webdriver");
		}

		catch(Exception e) {

			System.err.println("it is unknown error handled by super exception");
		}
		finally {

			takeSnap();
		}



	}

	public void verifyTextContainsByXpath(String xpath, String text) {


		String actualText;

		try {

			actualText=driver.findElementByXPath(xpath).getText();

			if(actualText.contains(text)) {

				System.out.println("The Text"+text+"is matched"+actualText);
			}
			else {

				System.err.println("The Text"+text+"is not matched"+actualText);
			}

		}
		catch(WebDriverException e) {

			System.err.println("it is unknown error handle webdriver");
		}

		catch(Exception e) {

			System.err.println("it is unknown error handled by super exception");
		}
		finally {

			takeSnap();
		}


	}

	public void clickById(String id) {


		try {

			driver.findElementById(id).click();

			System.out.println("The element"+id+"successfully click");
		}
		catch(ElementClickInterceptedException e) {

			System.err.println("TheElement"+id+"not clicked");
		}
		catch(WebDriverException e) {

			System.err.println("it is unknown error it is handled by webdriver exception");
		}
		catch(Exception e) {

			System.err.println("it is unknown error handled by super exception");
		}

		finally {

			takeSnap();
		}

	}

	public void clickByClassName(String classVal) {



		try {

			driver.findElementByClassName(classVal).click();

			System.out.println("The element"+classVal+"successfully click");
		}
		catch(ElementClickInterceptedException e) {

			System.err.println("TheElement"+classVal+"not clicked");
		}
		catch(WebDriverException e) {

			System.err.println("it is unknown error it is handled by webdriver exception");
		}
		catch(Exception e) {

			System.err.println("it is unknown error handled by super exception");
		}

		finally {

			takeSnap();
		}

	}

	public void clickByName(String name) {


		try {

			driver.findElementByName(name).click();

			System.out.println("The element"+name+"successfully click");
		}
		catch(ElementClickInterceptedException e) {

			System.err.println("TheElement"+name+"not clicked");
		}
		catch(WebDriverException e) {

			System.err.println("it is unknown error it is handled by webdriver exception");
		}
		catch(Exception e) {

			System.err.println("it is unknown error handled by super exception");
		}

		finally {

			takeSnap();
		}


	}

	public void clickByLink(String name) {

		try {

			driver.findElementByLinkText(name).click();

			System.out.println("The elemnent"+name+"is clicked ");
		}
		catch(ElementNotVisibleException e) {

			System.err.println("Element is not visible in the dom");


		}
		catch(WebDriverException e) {

			System.err.println("it is unknown exception handled by webdriver");
		}

		catch(Exception e) {

			System.err.println("it is unknown error handled by super exceptions");
		}
		finally {

			takeSnap();
		}




	}

	public void clickByLinkNoSnap(String name) {


		try {

			driver.findElementByLinkText(name).click();

			System.out.println("The elemnent"+name+"is clicked ");
		}
		catch(ElementNotVisibleException e) {

			System.err.println("Element is not visible in the dom");


		}
		catch(WebDriverException e) {

			System.err.println("it is unknown exception handled by webdriver");
		}

		catch(Exception e) {

			System.err.println("it is unknown error handled by super exceptions");
		}

	}

	public void clickByXpath(String xpathVal) {
		try {

			driver.findElementByXPath(xpathVal).click();

			System.out.println("The element"+xpathVal+"successfully click");
		}
		catch(ElementClickInterceptedException e) {

			System.err.println("TheElement"+xpathVal+"not clicked");
		}
		catch(WebDriverException e) {

			System.err.println("it is unknown error it is handled by webdriver exception");
		}
		catch(Exception e) {

			System.err.println("it is unknown error handled by super exception");
		}

		finally {

			takeSnap();
		}



	}

	public void clickByXpathNoSnap(String xpathVal) {

		try {

			driver.findElementByXPath(xpathVal).click();

			System.out.println("The element"+xpathVal+"successfully click");
		}
		catch(ElementClickInterceptedException e) {

			System.err.println("TheElement"+xpathVal+"not clicked");
		}
		catch(WebDriverException e) {

			System.err.println("it is unknown error it is handled by webdriver exception");
		}
		catch(Exception e) {

			System.err.println("it is unknown error handled by super exception");
		}


	}

	public String getTextById(String idVal) {
		String text;

		try {
			text=driver.findElementById(idVal).getText();

			System.out.println(text);


		}
		catch(WebDriverException e) {

			System.err.println("it is unknown error");
		}

		return null;
	}

	public String getTextByXpath(String xpathVal) {

		String text;


		try {
			text=driver.findElementByXPath(xpathVal).getText();

			System.out.println(text);


		}
		catch(WebDriverException e) {

			System.err.println("it is unknown error");
		}
		return null;
	}

	public void selectVisibileTextById(String id, String value) {


		try {

			    
			WebElement abc=driver.findElementById(id);
			Select sel=new Select(abc);

			sel.selectByVisibleText(value);

			System.out.println("The element"+id+"is selected"+value);
		}

		catch(ElementNotSelectableException e) {

			System.err.println("The Element"+id+"is not selected");
		}
		catch(WebDriverException e) {

			System.err.println("it is not selected it is handled by webdriver");
		}
		catch(Exception e) {

			System.err.println("it is unknown error handled by super exception");
		}

		finally {

			takeSnap();
		}

	}

	public void selectIndexById(String id, int value) {


		try {

			Select sel=new Select(driver.findElementById(id));

			sel.selectByIndex(value);

			System.out.println("The element"+id+"is selected"+value);
		}

		catch(ElementNotSelectableException e) {

			System.err.println("The Element"+id+"is not selected");
		}
		catch(WebDriverException e) {

			System.err.println("it is not selected it is handled by webdriver");
		}
		catch(Exception e) {

			System.err.println("it is unknown error handled by super exception");
		}

		finally {

			takeSnap();
		}


	}

	public void switchToParentWindow() {

		Set<String> parentWindow;
		try {

			parentWindow= driver.getWindowHandles();
			
			
			for(String actualWindow1 : parentWindow) {
				
				driver.switchTo().window(actualWindow1);
				
				break;
			}

			

			System.out.println("TheParentWindow"+parentWindow+"switchto sucessfully");
		}
		catch(NoSuchWindowException e) {

			System.err.println("No such window Exception");

		}

		catch(WebDriverException e) {

			System.err.println("it is unknown error handled by webdriver");
		}

		catch(Exception e) {

			System.err.println("it is known error handled by super exception");
		}

	}

	public void switchToLastWindow() {




		Set<String> allWindows;
		try {



			allWindows=driver.getWindowHandles();

			for(String LastWindow:allWindows) {

				driver.switchTo().window(LastWindow);
			}

			System.out.println("The window is switchto sucessfully");
		}
		catch(NoSuchWindowException e) {

			System.err.println("no such window exception");
		}
		catch(WebDriverException e) {

			System.err.println("it is unknown error it is handled by webdriver");
		}

		catch(Exception e) {

			System.err.println("it is unknown error it is handled by super exception");
		}

		finally {

			takeSnap();
		}


	}

	public void acceptAlert() {


		try {

			driver.switchTo().alert().accept();
			
			System.out.println("The alert is  accepted sucessfully");
		}

		catch(UnhandledAlertException e) {

			System.err.println(" unhandled alert exception ");
		}

		catch(WebDriverException e) {

			System.err.println("it is unknown error it is handled by webdriver");
		}

		catch(Exception e) {

			System.err.println("it is unknown error handled by super exception");
		}

		finally {

			takeSnap();
		}

	}

	public void dismissAlert() {

		try {

			driver.switchTo().alert().dismiss();
			
			System.out.println("alert is dismissed");
		}

		catch(UnhandledAlertException e) {

			System.err.println(" unhandled alert exception ");
		}

		catch(WebDriverException e) {

			System.err.println("it is unknown error it is handled by webdriver");
		}

		catch(Exception e) {

			System.err.println("it is unknown error handled by super exception");
		}

		finally {

			takeSnap();
		}


	}

	public String getAlertText() {
		

		String alert;


		try {

			alert=driver.switchTo().alert().getText();

			System.out.println(alert);
			
		}
		catch(WebDriverException e) {

			System.err.println("web driver execption");
		}


		return null;
	}

	public void takeSnap() {

		try {
			TakesScreenshot screenShot=driver;

			File	source=screenShot.getScreenshotAs(OutputType.FILE);

			File file=new File("GenericWrapper.png");

			FileHandler.copy(source, file);

			System.out.println("store screenshot for genericwrapper.png in the project level");
		}

		catch(IOException e) {

			System.err.println("it is an io exception");
		}
		catch(Exception e) {

			System.err.println("it is unknown error handled by super exception");
		}

	}

	public void closeBrowser() {


		try {

			driver.close();

			System.out.println("closing for webdriver focusing current window");
		}
		catch(WebDriverException e){

			System.err.println("it is due to unknown error handled by webdriver");

		}
		catch(Exception e){

			System.err.println("it is due to unknown error handled by super exception");
		}

	}

	public void closeAllBrowsers() {


		try {

			driver.quit();

			System.out.println("closing for webdriver focusing all window");
		}
		catch(WebDriverException e){

			System.err.println("it is due to unknown error handled by webdriver");

		}
		catch(Exception e){

			System.err.println("it is due to unknown error handled by super exception");
		}

	}

	public void switchToFrame(String data) {



		try {
			driver.switchTo().frame(data);

			System.out.println("Sucessfully switch to frame id or name"+data);
		} catch (NoSuchFrameException e) {

			System.err.println("dont match the frame the id or name"+data);

		}
		catch (WebDriverException e) {
			System.err.println("it is due to unknown error handled by webdriver");
		}
		catch(Exception e) {

			System.err.println("it is due to unknown error handled by super exception");
		}
		finally {
			takeSnap();
		}

	}

	public void switchToFrameWebElement(String xpath) {


		WebElement webElement;
		try {

			webElement=driver.findElementByXPath(xpath);

			driver.switchTo().frame(webElement);

			System.out.println("Sucessfully switch to frame for Webelement"+xpath);
		} catch (NoSuchFrameException e) {

			System.err.println("dont match the frame webelement"+xpath);

		}
		catch (WebDriverException e) {
			System.err.println("it is due to unknown error handled by webdriver");
		}
		catch(Exception e) {

			System.err.println("it is due to unknown error handled by super exception");
		}
		finally {
			takeSnap();
		}

	}

	public void selectIndexByXpath(String xpath, int value) {


		try {

			Select sel=new Select(driver.findElementByXPath(xpath));

			sel.selectByIndex(value);

			System.out.println("The element"+xpath+"is selected"+value);
		}

		catch(ElementNotSelectableException e) {

			System.err.println("The Element"+xpath+"is not selected");
		}
		catch(WebDriverException e) {

			System.err.println("it is not selected it is handled by webdriver");
		}
		catch(Exception e) {

			System.err.println("it is unknown error handled by super exception");
		}

		finally {

			takeSnap();
		}


	}

	public void selectVisibileTextByXPath(String xpath, String value) {


		try {

			Select sel=new Select(driver.findElementByXPath(xpath));

			sel.selectByVisibleText(value);

			System.out.println("The element"+xpath+"is selected"+value);
		}

		catch(ElementNotSelectableException e) {

			System.err.println("The Element"+xpath+"is not selected");
		}
		catch(WebDriverException e) {

			System.err.println("it is not selected it is handled by webdriver");
		}
		catch(Exception e) {

			System.err.println("it is unknown error handled by super exception");
		}

		finally {

			takeSnap();
		}

	}

	public void selectValueById(String id, String value) {


		try {

			Select sel=new Select(driver.findElementById(id));

			sel.selectByValue(value);

			System.out.println("The element"+id+"is selected"+value);
		}

		catch(ElementNotSelectableException e) {

			System.err.println("The Element"+id+"is not selected");
		}
		catch(WebDriverException e) {

			System.err.println("it is not selected it is handled by webdriver");
		}
		catch(Exception e) {

			System.err.println("it is unknown error handled by super exception");
		}

		finally {

			takeSnap();
		}

	}

	public void selectValueByXPath(String xpath, String value) {
		
		try {

			Select sel=new Select(driver.findElementByXPath(xpath));

			sel.selectByValue(value);

			System.out.println("The element"+xpath+"is selected"+value);
		}

		catch(ElementNotSelectableException e) {

			System.err.println("The Element"+xpath+"is not selected");
		}
		catch(WebDriverException e) {

			System.err.println("it is not selected it is handled by webdriver");
		}
		catch(Exception e) {

			System.err.println("it is unknown error handled by super exception");
		}

		finally {

			takeSnap();
		}

	}

	public void selectByIndexByName(String name, int value) {


		try {

			Select sel=new Select(driver.findElementByName(name));

			sel.selectByIndex(value);

			System.out.println("The element"+name+"is selected"+value);
		}

		catch(ElementNotSelectableException e) {

			System.err.println("The Element"+name+"is not selected");
		}
		catch(WebDriverException e) {

			System.err.println("it is not selected it is handled by webdriver");
		}
		catch(Exception e) {

			System.err.println("it is unknown error handled by super exception");
		}

		finally {

			takeSnap();
		}
	}

	public void selectByValueName(String name, String value) {
		try {

			Select sel=new Select(driver.findElementByName(name));

			sel.selectByValue(value);

			System.out.println("The element"+name+"is selected"+value);
		}

		catch(ElementNotSelectableException e) {

			System.err.println("The Element"+name+"is not selected");
		}
		catch(WebDriverException e) {

			System.err.println("it is not selected it is handled by webdriver");
		}
		catch(Exception e) {

			System.err.println("it is unknown error handled by super exception");
		}

		finally {

			takeSnap();
		} 

	}

	public void selectByVisibleTextByName(String name, String value) {


		try {

			Select sel=new Select(driver.findElementByName(name));

			sel.selectByVisibleText(value);

			System.out.println("The element"+name+"is selected"+value);
		}

		catch(ElementNotSelectableException e) {

			System.err.println("The Element"+name+"is not selected");
		}
		catch(WebDriverException e) {

			System.err.println("it is not selected it is handled by webdriver");
		}
		catch(Exception e) {

			System.err.println("it is unknown error handled by super exception");
		}

		finally {

			takeSnap();
		}

	}

	public void switchToFrame(int data) {

		try {

			driver.switchTo().frame(data);

			System.out.println("frame sucessfully switched index value"+data);
		}
		catch(NoSuchFrameException e) {

			System.err.println("no such frame in the dom");
		}

		catch(WebDriverException e) {

			System.err.println("unknown error handled by webdriver");
		}
		catch(Exception e) {

			System.err.println("unknown error handled by super exception");
		}

		finally {

			takeSnap();
		}




	}

	public void clearTextBoxById(String id) {
		try {

			driver.findElementById(id).clear();

			System.out.println("Textbox is sucessfully clicked"+id);
		}

		catch(NoSuchElementException e) {

			System.err.println("element not present in the dom"+id);

		}
		catch(WebDriverException e) {

			System.err.println("unknown error handled by webdriver");
		}
		catch(Exception e) {

			System.err.println("unknown error handled by super exception");
		}
		finally {
			takeSnap();
		}


	}

	public void clearTextBoxName(String name) {
		try {

			driver.findElementByName(name).clear();

			System.out.println("Textbox is sucessfully clicked"+name);
		}

		catch(NoSuchElementException e) {

			System.err.println("element not present in the dom"+name);

		}
		catch(WebDriverException e) {

			System.err.println("unknown error handled by webdriver");
		}
		catch(Exception e) {

			System.err.println("unknown error handled by super exception");
		}
		finally {
			takeSnap();
		}

	}

	public void clearTextBoxXpath(String xpath) {

		try {

			driver.findElementByXPath(xpath).clear();

			System.out.println("Textbox is sucessfully clicked"+xpath);
		}

		catch(NoSuchElementException e) {

			System.err.println("element not present in the dom"+xpath);

		}
		catch(WebDriverException e) {

			System.err.println("unknown error handled by webdriver");
		}
		catch(Exception e) {

			System.err.println("unknown error handled by super exception");
		}
		finally {
			takeSnap();
		}

	}

	public boolean textBoxEnabledOrNotById(String id) {
		boolean status; 

		try {

			status=driver.findElementById(id).isEnabled();

			System.out.println("Textbox is enabled"+id  +"staus="+status);




		}
		catch(NoSuchElementException e) {

			System.err.println("element not present in the dom"+id);

		}
		catch(WebDriverException e) {

			System.err.println("unknown error handled by webdriver");
		}
		catch(Exception e) {

			System.err.println("unknown error handled by super exception");
		}
		finally {
			takeSnap();
		}
		return false;


	}

	public boolean textBoxEnabledOrNotByName(String name) {

		boolean status; 

		try {

			status=driver.findElementByName(name).isEnabled();

			System.out.println("Textbox is enabled"+name  +"staus="+status);


			

		}
		
		
		
		catch(NoSuchElementException e) {

			System.err.println("element not present in the dom"+name);

		}
		catch(WebDriverException e) {

			System.err.println("unknown error handled by webdriver");
		}
		catch(Exception e) {

			System.err.println("unknown error handled by super exception");
		}
		finally {
			takeSnap();
		}
		return false;
	}

	public boolean textBoxEnabledOrNotByXPath(String xpath) {
		boolean status; 

		try {

			status=driver.findElementByXPath(xpath).isEnabled();

			System.out.println("Textbox is enabled"+xpath  +"staus="+status);


			

		}
		
		
		
		catch(NoSuchElementException e) {

			System.err.println("element not present in the dom"+xpath);

		}
		catch(WebDriverException e) {

			System.err.println("unknown error handled by webdriver");
		}
		catch(Exception e) {

			System.err.println("unknown error handled by super exception");
		}
		finally {
			takeSnap();
		}
		return false;
	


	}



}




