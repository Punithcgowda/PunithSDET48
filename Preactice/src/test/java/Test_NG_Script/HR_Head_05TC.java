package Test_NG_Script;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic_Utility.Base_Class_TestNG;
import hrm_Object_Repository.Corporate;

public class HR_Head_05TC extends Base_Class_TestNG
{
	
	
	// corporate= new Corporate(driver);
  @Test
 public void Config_T1() throws Throwable
 {
		 Corporate corporate= new Corporate(driver); 
		   corporate.createCorporate("Punith",driver);
		  // Reporter.log("New Corporate Created",true);
		   //Assert.assertTrue(false, null);
}
	 
	 @Test
	 public void Config_T2() throws Throwable
	 {
		 Corporate corporate= new Corporate(driver); 
		   corporate.deleteCorporate1(driver, "Punith");
		   Reporter.log("New Corporate Deleted",true);
	 }
	 @Test
	 public void Config_T3() throws Throwable
	 {
		 Corporate corporate= new Corporate(driver); 
		   corporate.editCorporateName("Punith", driver, "Punith_01");
		   Reporter.log("New Corporate Edited",true);
	 }
//njnjun
}
