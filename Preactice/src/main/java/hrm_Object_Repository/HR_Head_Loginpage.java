package hrm_Object_Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Test_Ng.Fetch_fromExcel;
import generic_Utility.WebdriverUtility;
/**
 * 
 * @author NETHRADHANU
 *
 */

public class HR_Head_Loginpage 
{
	//Utitility class objects
	 WebdriverUtility web_Utlil = new WebdriverUtility();
  //Declaration
	@FindBy(xpath ="//input[@name='hr_email']")
	private WebElement usernameTxtEdt;
	
	@FindBy(xpath ="//input[@name='hr_password']")
	private WebElement passwordTxtEdt;
	
	@FindBy(xpath = "//button[.='Sign In']")
	private WebElement submitBtnClk;
	
	@FindBy(xpath = "//select[@name='hr_type']")
	private WebElement selectDropdown;
	
	//initializaton
	public HR_Head_Loginpage(WebDriver driver)  //Constructor
	{
		PageFactory.initElements(driver, this);
	}
	//utilization provivde getters and setters and busines libraries

	public WebElement getUsernameTxtEdt() 
	{
		return usernameTxtEdt;
	}

	public WebElement getPasswordTxtEdt() 
	{
		return passwordTxtEdt;
	}
	public WebElement getselectDropdown()
	{
		return selectDropdown;
	}

	public WebElement getSubmitBtnClk() 
	{
		return submitBtnClk;
	}
	
	//create a method for login
	public void loginToApp(String username, String password, String account,WebDriver driver,String dash)
	{
		//send value for username textfild
	 usernameTxtEdt.sendKeys(username);
	 
	    //send value for password textfild
	 passwordTxtEdt.sendKeys(password);
	 
	    //select account from dropdown
	 WebdriverUtility web_Util = new WebdriverUtility();
	 web_Util.selectElementInDropdown(account,selectDropdown);
	 
	    //click on login button
	 submitBtnClk.click();
	 System.out.println("clicked on submit button----login page");
	 
	 //handle popUp after login to account
	 web_Util.waitForAlertPopup(driver);
	
	 web_Utlil.switchToAlertPopupAndAccept(driver,"Su");
	 
	 String title = driver.getTitle();
	 if(title.trim().contains(dash.trim()))
	 {
     System.out.println("login page Displayed" +" " +title);
	}
	 else 
	 {
		 System.out.println("Login page not displayed");
	 }
}
	public void login_hr(WebDriver driver) throws Throwable
	{
		Fetch_fromExcel fetchfromexcel = new Fetch_fromExcel();
		
		
	    HashMap<String,String> flds =fetchfromexcel.createMap("Sheet3");
		for(Entry<String,String> set:flds.entrySet())
		{
			if(set.getKey().equalsIgnoreCase("hr_email") || set.getKey().equalsIgnoreCase("hr_password"))
			{
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());  //selectElementInDropdown
			}
			else if(set.getKey().equalsIgnoreCase("hr_type"))
			{
		      web_Utlil.selectElementInDropdown(set.getValue(), driver.findElement(By.name(set.getKey())));   //driver.findElement(By.name(set.getKey())), set.getValue()
			}
			else
			{
				driver.findElement(By.name(set.getKey())).click();
			}
		}
		web_Utlil.switchToAlertPopupAndAccept(driver,"Su");
		
	}
	
	
}
