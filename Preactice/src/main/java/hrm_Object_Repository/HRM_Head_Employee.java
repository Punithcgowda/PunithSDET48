package hrm_Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.WebdriverUtility;

public class HRM_Head_Employee 
{
	
	 WebdriverUtility web_Utlil = new WebdriverUtility();
	 
	// xpath to clich on employee button in dachboard
	 @FindBy(xpath="//p[.='Dashboard']/ancestor::li/following-sibling::li/a/i[@class='nav-icon fas fa-user']") private WebElement employeeButton;
	 
	 //xpath yo click on Add Employee Link
	 @FindBy(xpath="//p[.='Add Employee']") private WebElement addEmployeeLink;
	 
	 //xpath to click on addEmployee button
	 @FindBy(xpath="//button[contains(.,'Add Employee')]") private WebElement addEmployeeButton;
	 
	 //Add Employee popup
	 @FindBy(xpath="//label[.='Company ID']/following-sibling::input[@name='employee_companyid']") private WebElement employeeCompanyid;
	 
	 @FindBy(xpath="//input[@name='employee_firstname']") private WebElement employeeFirstName;	 
	 
	 @FindBy(xpath="//input[@name='employee_lastname']") private WebElement employeeLastName;
	 
	 @FindBy(xpath="//input[@name='employee_middlename']") private WebElement employeeMddleName;

	 @FindBy(xpath="//input[@name='branches_datefrom']") private WebElement branchesDateFrom;
	 
	 @FindBy(xpath="//input[@name='branches_recentdate']") private WebElement recentDateFrom;
	 
	 @FindBy(xpath="//input[@name='employee_position']") private WebElement employeePosition;
	 
	 @FindBy(xpath="//input[@name='employee_contact']") private WebElement employeeContactNumbere;
	 
	 @FindBy(xpath="//input[@name='employee_sss']") private WebElement employeeSSS;
	 
	 @FindBy(xpath="//input[@name='employee_tin']") private WebElement employeeTin;
	 
	 @FindBy(xpath="//input[@name='employee_hdmf_pagibig']") private WebElement employeePagbg;
	 
	 @FindBy(xpath="//input[@name='employee_gsis']") private WebElement employeeGsis;
	 
	 @FindBy(xpath="//input[@name='employee_file201']") private WebElement employeeFile201;
	 
	 @FindBy(xpath="//input[@name='employee_image']") private WebElement employeeiMage;

	 @FindBy(xpath="//button[.='Save']") private WebElement employeeSaveButton; 

  public HRM_Head_Employee(	WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
	  
  }

public WebElement getEmployeeButton() {
	return employeeButton;
}

public WebElement getAddEmployeeLink() {
	return addEmployeeLink;
}

public WebElement getAddEmployeeButton() {
	return addEmployeeButton;
}

public WebElement getEmployeeCompanyid() {
	return employeeCompanyid;
}

public WebElement getEmployeeFirstName() {
	return employeeFirstName;
}

public WebElement getEmployeeLastName() {
	return employeeLastName;
}

public WebElement getEmployeeMddleName() {
	return employeeMddleName;
}

public WebElement getBranchesDateFrom() {
	return branchesDateFrom;
}

public WebElement getRecentDateFrom() {
	return recentDateFrom;
}

public WebElement getEmployeePosition() {
	return employeePosition;
}

public WebElement getEmployeeContactNumbere() {
	return employeeContactNumbere;
}

public WebElement getEmployeeSSS() {
	return employeeSSS;
}

public WebElement getEmployeeTin() {
	return employeeTin;
}

public WebElement getEmployeePagbg() {
	return employeePagbg;
}

public WebElement getEmployeeGsis() {
	return employeeGsis;
}

public WebElement getEmployeeFile201() {
	return employeeFile201;
}

public WebElement getEmployeeiMage() {
	return employeeiMage;
}

public WebElement getEmployeeSaveButton() {
	return employeeSaveButton;
}
  //method to create an employee
 public void createEmployeeMethod(WebDriver driver,String empid, String fname, String lname, String mname,String bdate,
		 String rdate,String empposition, String empnumber,String sss, String tin, String pagbg, String empgsis, String file201,String empimg, String visibletext )
 {
	 employeeButton.click();
	 addEmployeeLink.click();
	 addEmployeeButton.click();
	 employeeCompanyid.sendKeys(empid);
	 employeeFirstName.sendKeys(fname);
	 employeeLastName.sendKeys(lname);
	 employeeMddleName.sendKeys(mname);
	 branchesDateFrom.sendKeys(bdate);
	 recentDateFrom.sendKeys(rdate);
	 
	 WebdriverUtility web_Util = new WebdriverUtility();
	 web_Util.selectElementInDropdown(visibletext,employeePosition);    // text
	 
	 employeeContactNumbere.sendKeys(empnumber);
	 employeeSSS.sendKeys(sss);
	 employeeTin.sendKeys(tin);
	 employeePagbg.sendKeys(pagbg);
	 employeeGsis.sendKeys(empgsis);
	 employeeFile201.sendKeys(file201);
	 employeeiMage.sendKeys(empimg);
	 
	 employeeSaveButton.click();
	 
	 web_Utlil.switchToAlertPopupAndAccept(driver,"Su");
 }
  }



