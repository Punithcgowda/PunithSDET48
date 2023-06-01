package hrm_Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.WebdriverUtility;

public class Corporate 
{
	
	 WebdriverUtility web_Utlil = new WebdriverUtility();
	 
	 //xpath for corporate main button
	 @FindBy(xpath="//p[contains(.,'CORPORATE')]") private WebElement corporateButton;
	 
	 //xpath for addCorporate link
	 @FindBy(xpath ="//a[@href='Add_corporate.php']") private WebElement addCorporateLnk;
	 
   // xpath for AddCOrporate button
	@FindBy(xpath ="//button[contains(.,'Add Corporate')]") private WebElement addCorporateButton;
	
	//xpath for corporate name textfield
	 @FindBy(xpath="//input[@name='corporate_name' and @placeholder='Corporate Name']") private WebElement corporateName;
	 
	
	//xpath for corporate savebutton
	@FindBy(xpath="//button[.='Save']") private WebElement saveButton;
	
	//xpath for search bar of  Add corporate page
	@FindBy(xpath ="//div[@id='example1_filter']/label/input") private WebElement searchBarAddCorpPage;
	
    //xpath to veiw table assending order
	@FindBy(xpath ="//th[@aria-label='ID: activate to sort column ascending']") private WebElement idAssendingButton ;
	
    //xpath for searched name details
	@FindBy(xpath ="//th[@aria-label='//td[@tabindex='0']/following-sibling::td[.='corpName']") private WebElement corporateNameTable ;
	
    //xapth for edit button
	//@FindBy(xpath ="//td[.='"+corpName+"']/following-sibling::td/button[.='Edit'])[1]") private WebElement corporateNameTableEdtButton ;
	
	//xpath for edit corporate name textfield
	@FindBy(xpath ="//div[@class='modal fade show']//input[@name='corporate_name']") private WebElement corporatenameEdtTextFld;
	
	//xpath for update button
	@FindBy(xpath ="//div[@class='modal fade show']//button[.='Update']") private WebElement updateEdtButton ;
	
	//xpath for delete button in table
	@FindBy(xpath="//table/tbody/tr[1]/td[4]/button[.='Delete']") private WebElement deleteButtoninTable;
	
	//xpath for delete button
	@FindBy(xpath="//div[@class='modal fade show']//button[.='Delete']") private WebElement deleteButton;

    // Constructor to initvalize all web elements
	public Corporate(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

    //getters to provide indvrct acess for elements
	public WebdriverUtility getWeb_Utlil() {
		return web_Utlil;
	}

	public WebElement getCorporateButton() {
		return corporateButton;
	}

	public WebElement getAddCorporateLnk() {
		return addCorporateLnk;
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

	public WebElement getSearchBarAddCorpPage() {
		return searchBarAddCorpPage;
	}

	public WebElement getIdAssendingButton() {
		return idAssendingButton;
	}

	public WebElement getCorporateNameTable() {
		return corporateNameTable;
	}

	//public WebElement getCorporateNameTableEdtButton() {
		//return corporateNameTableEdtButton;
	

	public WebElement getCorporatenameEdtTextFld() {
		return corporatenameEdtTextFld;
	}

	public WebElement getUpdateEdtButton() {
		return updateEdtButton;
	}
	
	public WebElement getdeleteButtoninTable() {
		return deleteButtoninTable;
	}
	
	public WebElement getdeleteButton() {
		return deleteButton;
	}
	
	//method to create a new corporate
		public void createCorporate(String corpName,WebDriver driver)
		{
			corporateButton.click();
			
			addCorporateLnk.click();
			
			addCorporateButton.click();
			
			
			corporateName.sendKeys(corpName);
			
			saveButton.click();
			
			//handle popUp after logout to account
			 web_Utlil.switchToAlertPopupAndAccept(driver,"Su");
			 System.out.println("Alert handled ofter Corporate Create");
			
			
		}
		//method to edit a corporate
		

		public void editCorporateName(String corpName,WebDriver driver,String corpName1) throws InterruptedException
		{
             corporateButton.click();
			
			addCorporateLnk.click();
			
			searchBarAddCorpPage.sendKeys(corpName);
			
			//idAssendingButton.click();
			
			Thread.sleep(3000);
					
			
			driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]/button[.='Edit']")).click();
			
			String t1 = corporatenameEdtTextFld.getText();
			System.out.println(t1);
			
			corporatenameEdtTextFld.clear();
			
			corporatenameEdtTextFld.sendKeys(corpName1);
			
			updateEdtButton.click();
			
			//handle popUp after logout to account
			 web_Utlil.switchToAlertPopupAndAccept(driver,"Su");
       }
//		public void deleteCorporate(String corpName,WebDriver driver) throws InterruptedException
//		{
//             corporateButton.click();
//			
//			addCorporateLnk.click();
//			
//			searchBarAddCorpPage.sendKeys(corpName);
//			
//			//idAssendingButton.click();
//			
//			Thread.sleep(3000);
//					
//			
//			deleteButtoninTable.click();
//			
//			
//			
//		
//			
//			deleteButton.click();
//			
//			//handle popUp after logout to account
//			 web_Utlil.switchToAlertPopupAndAccept(driver,"Su");
		
//}

		public void deleteCorporate1( WebDriver driver,String corpName) throws InterruptedException 
		{
			//JavascriptExecutor jse=(JavascriptExecutor)driver;
			 corporateButton.click();
				
				addCorporateLnk.click();
				
				searchBarAddCorpPage.sendKeys(corpName);
				
				//idAssendingButton.click();
				
				Thread.sleep(3000);
						
				
				deleteButtoninTable.click();
				
				Thread.sleep(3000);
				//web_Utlil.customWait(10, deleteButton, 1000);
			//	 String text_dlt_corp = driver.findElement(By.xpath("//div[@class='modal fade show']//h4[.='Delete Corporate']")).getText();
			//	   System.out.println(text_dlt_corp);
				
				//web_Utlil.waitTillElementToBeClickable(driver, deleteButton);
				//jse.executeScript("arguments[0].click",deleteButton);
			
			//String text1 = driver.findElement(By.xpath("//div[@class='modal fade show']//input[@name='corporate_name']")).getText();
			//System.out.println(text1);
				
			//	driver.findElement(By.xpath("//div[@class='modal fade show']//div[@class='modal-content']/div/button[.='Delete']")).click();
				deleteButton.click();
				
				 web_Utlil.switchToAlertPopupAndAccept(driver,"Su");
				 System.out.println("Alert handled ofter Corporate Delete");
		}
}
////td[.='"+corpName+"']/following-sibling::td/button[.='Edit'])[1])

//(//td[.='Punith']/following-sibling::td/button[.='Edit'])[1]




