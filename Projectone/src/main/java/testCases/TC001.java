package testCases;



import org.testng.annotations.Test;

import utils.DP;
import wrapper.GenericWrapper;
import wrapper.ProjectWrapper;

public class TC001 extends ProjectWrapper{
	
	@Test(dataProvider = "fetchData",dataProviderClass = DP.class)
	public void irctc(String userId,String pass/*,String conpass,String secAns,String fname,String mName,String lName,String mail,String mobile,String street,
			String street1,String area,String pincode,String state,String mobile1*/) {
		
		//invokeApp("chrome", "https://www.irctc.co.in/nget/train-search");
		
		clickByXpath("//button[@type='submit']");
		
		clickByLink("REGISTER");
		
		enterById("userName", userId);
		
		enterById("usrPwd", pass);
		
		enterById("cnfUsrPwd","8122710896a@A");
		
		clickByXpath("");
		
		clickByXpath("//span[text()='What is your pet name?']");
		
		enterByXpath("//input[@placeholder='Security Answer']", "mano");
		
		clickByXpath("//label[text()='Select Preferred Language']");
		
		clickByXpath("//span[text()='English']");
		
		enterById("firstName", "mari");
		
		enterById("middleName", "muthu");
		
		enterById("lastname", "karuppasamy");
		
		clickById("M");
		
		clickByXpath("//span[@class='ng-tns-c12-9 ui-calendar']//child::input");
		
		selectIndexByXpath("//select[@class='ui-datepicker-month ng-tns-c12-9 ng-star-inserted']", 5);
		
		selectVisibileTextByXPath("//select[@class='ui-datepicker-year ng-tns-c12-9 ng-star-inserte", "1992");
		
		clickByXpath("//a[text()='22']");
		
	    clickByXpath("//*[@id=\'divMain\']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[9]/div[4]/p-dropdown/div/div[3]/span");
		
		clickByXpath("//span[text()='SELF EMPLOYED']");
		
		clickByXpath("//input[@value='U']");
		
		selectVisibileTextByXPath("//select[@formcontrolname='resCountry']", "India");
		
		enterById("email", "manoece18@gmail.com");
		
		enterById("mobile", "8122710896");
		
		selectVisibileTextByXPath("//select[@formcontrolname='nationality']", "India");
		
		enterById("resAddress1", "pillaiyar kovil street");
		
		enterByName("resAddress2", "street");
		
		enterById("resAddress3", "muthukrishnapuram");
		
		enterByName("resPinCode", "627751");
		
		enterById("resState", "tamilnadu");
		
		selectIndexByXpath("//select[@formcontrolname='resCity']", 1);
		
		selectIndexByXpath("//select[@formcontrolname='resPostOff']", 3);
		
		enterById("resPhone", "9994723746");
		
		
		
		
		
		
		
		
		
		
		
	
	}

}
