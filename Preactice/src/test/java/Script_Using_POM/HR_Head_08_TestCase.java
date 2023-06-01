package Script_Using_POM;

import generic_Utility.Excel_Utility;
import generic_Utility.Java_Utility;

public class HR_Head_08_TestCase 
{

	public static void main(String[] args ) throws Throwable 
	{
		Excel_Utility x_Util = new Excel_Utility();
		//Java_Utility j_util = new Java_Utility();
		for(int i=0;i<13;i++)
		{
		
//		String data1 = x_Util.getoExcelData("Sheet1", 1, i);
//		System.out.println(data1);
		
		x_Util.insertDataIntoExcel("Sheet1",1,i,"punith");
		
		}
	}
}
