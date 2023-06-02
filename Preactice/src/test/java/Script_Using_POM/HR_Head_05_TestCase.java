package Script_Using_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_Utility.Excel_Utility;
import generic_Utility.FileUtility;
import generic_Utility.Java_Utility;
import generic_Utility.WebdriverUtility;
import hrm_Object_Repository.Corporate;
import hrm_Object_Repository.HRM_Head_Dashboardpage;
import hrm_Object_Repository.HR_Head_Loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HR_Head_05_TestCase 
{
	public static void main(String[] args) throws Throwable 
	{
		//Open Browser
	   WebDriver driver;
	   
	  //create object for generic classes
	   Excel_Utility x_Util = new Excel_Utility();
	   FileUtility f_Util = new FileUtility();
	   Java_Utility j_Util=new Java_Utility ();
	   WebdriverUtility web_Utlil = new WebdriverUtility();
	   
	   //To Get random number
	   int rno = j_Util.getRandomNumber();
	   
	   //Fetch data from properety file
	   String URL =  f_Util.getPropertyKeyValue("url");
	   String BROWSER =  f_Util.getPropertyKeyValue("browser");
	   String USERNAME=  f_Util.getPropertyKeyValue("username");
	   String PASSWORD=  f_Util.getPropertyKeyValue("password");
	   
	   //Fetch Data from Excel Sheet
	  // Workbook wb= WorkbookFactory.create(new FileInputStream("./src/test/resources/ExcelDDT.xlsx"));
	  // String create = wb.getSheet("Sheet1").getRow(1).getCell(0).toString()+""+rno;
	   
	   if(BROWSER.equalsIgnoreCase("chrome"))
	   {
		  driver=WebDriverManager.chromedriver().create();
		 // driver = new ChromeDriver();
	   }
	   else if(BROWSER.equalsIgnoreCase("firefox"))
	   {
		   driver =new FirefoxDriver();
	   }
	   else 
	   {
		   driver=new EdgeDriver();
	   }
	   
	   
	   //enter URL of the Application
	   driver.get(URL);
	   
	   //Maximise the Screen
	   web_Utlil.maximizeWinow(driver);
	   
	   //Implicit wait duration for 10 seconds
	   web_Utlil.waitTillPageGetLoad(driver);
	   
	   // Create an object for LogHR_Head_Loginpagen class (contructor got initiated and driver parameter need to pass) 
	   HR_Head_Loginpage login= new HR_Head_Loginpage(driver);
	   
	  // call the method to perform login action 
	   login.loginToApp(USERNAME, PASSWORD,"→ HR Head",driver,"Dash");
	   
	   //Create an object for corporate and create a new corporate
	   Corporate corporate= new Corporate(driver);
	   corporate.createCorporate("Punith",driver);
	  
	 //Create an object forDashboard  and logout
	   HRM_Head_Dashboardpage dashboard1 =new  HRM_Head_Dashboardpage(driver);
	   dashboard1.logout(driver, "Log");
	
	//login again
	   login.loginToApp(USERNAME, PASSWORD,"→ HR Head",driver,"Dash");
	   
	   //Delete the corporate
	   corporate.deleteCorporate1(driver,"Punith");
	   
	   
	   //Create an object forDashboard  and logout

	   dashboard1.logout(driver, "Log");
	   
	 //login again
	   login.loginToApp(USERNAME, PASSWORD,"→ HR Head",driver,"Dash");
	   
	   //Edt employee
	   corporate.editCorporateName("Punith", driver,"Punith01");
	  
	}
	
}
