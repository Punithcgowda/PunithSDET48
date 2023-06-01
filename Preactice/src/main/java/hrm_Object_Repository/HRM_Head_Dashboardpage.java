package hrm_Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.WebdriverUtility;

/**
 * 
 * @author NETHRADHANU
 *
 */
public class HRM_Head_Dashboardpage

{
	//Utitility class objects
		 WebdriverUtility web_Utlil = new WebdriverUtility();
		 
	//declaration
	@FindBy(xpath="//span[.='Administrator']") private WebElement administratorText;
	
	@FindBy(xpath="//p[contains(.,'CORPORATE')]") private WebElement corporateButton;
	
	@FindBy(xpath="//a[@href='Add_corporate.php']") private WebElement addCorporateLink;
	
	@FindBy(xpath="//button[contains(.,'Add Corporate')]") private WebElement addCorporateButton;
	
     @FindBy(xpath="//input[@name='corporate_name' and @placeholder='Corporate Name']") private WebElement corporateName;
	
	@FindBy(xpath="//button[.='Save']") private WebElement saveButton;
	
	@FindBy(xpath="//i[@class='fa fa-user']") private WebElement profileButtonToLogot;
	
	@FindBy(xpath="//a[@href='log_out.php']") private WebElement logoutButton;
	
	//initialization
	public HRM_Head_Dashboardpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization

	public WebElement getAdministratorText() {
		return administratorText;
	}

	public WebElement getCorporateButton() {
		return corporateButton;
	}

	public WebElement getAddCorporateLink() {
		return addCorporateLink;
	}

	public WebElement getAddCorporateButton() {
		return addCorporateButton;
	}

	

	public WebElement getCorporateName() {
		return corporateName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getProfileButtonToLogot() {
		return profileButtonToLogot;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}
     
	
  //Enter Corporate name and clickon save burrtton
	public void createCorporate(String corpName,WebDriver driver)
	{
		corporateButton.click();
		addCorporateLink.click();
		addCorporateButton.click();
		
		
		corporateName.sendKeys(corpName);
		
		saveButton.click();
		
		//handle popUp after logout to account
		 web_Utlil.switchToAlertPopupAndAccept(driver,"Su");
		 System.out.println("Alert handled ofter Corporate Create");
		
		
	}
	
	//Logout as HR_Head
	public void logout(WebDriver driver,String title1)
	{
		profileButtonToLogot.click();
		logoutButton.click();
		
		//handle popUp after logout to account
		
		 web_Utlil.switchToAlertPopupAndAccept(driver,"Su");
		 
		 String title = driver.getTitle();
		 System.out.println("After logout As HR Head" +title);
		 if(title.trim().contains(title1.trim()))
		 {
	     System.out.println("login page Displayed" +" " +title);
		}
		 else 
		 {
			 System.out.println("Login page not displayed");
		 }
		
	}
	
}
