package generic_Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hrm_Object_Repository.Corporate;
import hrm_Object_Repository.HRM_Head_Dashboardpage;
import hrm_Object_Repository.HR_Head_Loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class_TestNG 
{
 
  public FileUtility flib=new FileUtility();
  public Excel_Utility elib = new Excel_Utility();
  public Java_Utility jlib = new Java_Utility();
  public WebdriverUtility wlib= new WebdriverUtility();
  
  public WebDriver driver;
  // Corporate corporate= new Corporate(driver);
  // HRM_Head_Dashboardpage hr_H_Dash =new HRM_Head_Dashboardpage(driver);
  
  /*
   * Used to connect to the database
   */
 /* @BeforeSuit
  public void Config_BS()
  {
	  
  }
  */
  
  /*
   * Used to lounch the browser
   */
  @BeforeClass
  public void Cofig_BC() throws Throwable
  {
	  String BROWSER = flib.getPropertyKeyValue("browser");
	  
	  if(BROWSER.equalsIgnoreCase("chrome"))
	   {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
	   }
	   else if(BROWSER.equalsIgnoreCase("firefox"))
	   {
		   driver =new FirefoxDriver();
	   } 
	  
	  wlib.maximizeWinow(driver);
	  

	  System.out.println("Browser lounched and Maximised ");
	
  }
  
  
  /*
   * used to login to the application
   */
  
 @BeforeMethod 
 
 public void Config_BM() throws Throwable
 {
	String URL = flib.getPropertyKeyValue("url");
	String USERNAME =flib.getPropertyKeyValue("username");
	String PASSWORD = flib.getPropertyKeyValue("password");
	
	driver.get(URL);
	wlib.waitTillPageGetLoad(driver);
	System.out.println("Page Loaded");
	HR_Head_Loginpage hr_H_login = new HR_Head_Loginpage(driver);
	  hr_H_login.loginToApp(USERNAME,PASSWORD,"→ HR Head", driver,"Dash");
	  
	  System.out.println("Logged in as HR Head ");
 }
 
// @Test
// public void Config_T1() throws Throwable
// {
//	// Corporate corporate= new Corporate(driver); 
//	   corporate.createCorporate("Punith",driver);
//	   System.out.println("Corporate Created");
// }
// 
// @Test
// public void Config_T2() throws Throwable
// {
//	// Corporate corporate= new Corporate(driver); 
//	   corporate.deleteCorporate1(driver, "Punith");
// }
// @Test
// public void Config_T3() throws Throwable
// {
//	// Corporate corporate= new Corporate(driver); 
//	   corporate.editCorporateName("Punith", driver, "Punith_01");
// }
 /*
  * used to logout from application
  */
 @AfterMethod
 public void Cofig_AM()
 {
	 HRM_Head_Dashboardpage hr_H_Dash =new HRM_Head_Dashboardpage(driver);
	 hr_H_Dash.logout(driver, "Log");
 }
//close the browser
	@AfterClass
	public void config_AC()
	{
		driver.close();
	}
}
