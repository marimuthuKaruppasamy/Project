
package wrapper;


public interface Wrappers {
	
	//Launch the browser and send your url
	
	public void invokeApp(String browser, String url);

	//TextBoxes
	public void enterById(String idValue, String data);
	
	public void enterByName(String nameValue, String data) ;	
	
	public void enterByXpath(String xpathValue, String data);
	
	public void clearTextBoxById(String id);
	
	public void clearTextBoxName(String name);
	
	public void clearTextBoxXpath(String xpath);
	
	public boolean textBoxEnabledOrNotById(String id);
	
	public boolean textBoxEnabledOrNotByName(String name);
	
	public boolean textBoxEnabledOrNotByXPath(String xpath);

	//Verify the title
	public void verifyTitle(String title);
	
	//verify the text of the element
	public void verifyTextById(String id, String text);
	
	public void verifyTextByXpath(String xpath, String text);
	
	public void verifyTextContainsByXpath(String xpath, String text);
	
   //Click 
	public void clickById(String id) ;

	public void clickByClassName(String classVal);
	
	public void clickByName(String name) ;
	
	public void clickByLink(String name);
	
	public void clickByLinkNoSnap(String name);

	public void clickByXpath(String xpathVal);
	
	public void clickByXpathNoSnap(String xpathVal);
	
	//Take the getText
	public String getTextById(String idVal);

	public String getTextByXpath(String xpathVal);
	
	//Select operations
    public void selectVisibileTextByXPath(String xpath, String value);
	
	public void selectValueById(String id,String value);
	
	public void selectValueByXPath(String xpath,String value);
	
	public void selectByIndexByName(String name,int value);
	
	public void selectByValueName(String name,String value);
	
	public void selectByVisibleTextByName(String name,String value);

	public void selectVisibileTextById(String id, String value);
	
	public void selectIndexById(String id, int value);
	
	public void selectIndexByXpath(String xpath, int value);
	
	//windows
	public void switchToParentWindow();
	
	public void switchToLastWindow();
	
	//alerts
	public void acceptAlert();
	
	public void dismissAlert();
	
	public String getAlertText();
	
	//take snap
	public void takeSnap();
	
	//close browsers
	public void closeBrowser();
	
	public void closeAllBrowsers();
 
	//frames
	public void switchToFrame(String data);
	
	public void switchToFrameWebElement(String xpath);
	
	public void switchToFrame(int data);
	
	
	
	
	
}



