package Test_Ng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Fetch_fromExcel 
{
  @Test
  
  public Object[] [] fetchExcelData() throws Throwable
  {
	  FileInputStream fis = new FileInputStream("./Files/Test_NG_Excel.xlsx");
	  Workbook wb= WorkbookFactory.create(fis);
	  Sheet sh= wb.getSheet("Sheet1");
	  int lastrowno= sh.getLastRowNum()+1;
	  int lastcel = sh.getRow(0).getLastCellNum();
	  
	  Object[] [] obj = new Object[lastrowno][lastcel];
	  
	  for (int i=0; i<lastrowno;i++)//row
	  {
		 for(int j=0; j<lastcel;j++) //column
		 {
			//System.out.println(sh.getRow(i).getCell(j).getStringCellValue());
			 obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
		 }
		  
	  }
	  return obj;
  }
  
  public HashMap<String, String> createMap(String sheetname) throws Throwable
  {
	  FileInputStream fis = new FileInputStream("./src/test/resources/DDT_Excel_02.xlsx");
	  Workbook wb= WorkbookFactory.create(fis);
	  Sheet sh= wb.getSheet(sheetname);
	  int count= sh.getLastRowNum();
	 
	  
	  HashMap<String,String> map = new HashMap<String,String>();
	  
	  for(int i=0;i<=count; i++ )
	  {
		  String key =sh.getRow(i).getCell(0).getStringCellValue();
		  String value=sh.getRow(i).getCell(1).getStringCellValue();
		  map.put(key, value);
	  }
	  return map;
	  
  }
}
