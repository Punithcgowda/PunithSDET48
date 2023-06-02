package jenkins_Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sample_class_01
{
	
public static void main(String[] args) throws Throwable
{
  String BROWSER ="chrome";//System.getProperty("browser");
  String URL = "https://amazon.in";//System.getProperty("urlS");
  
  WebDriver driver;
  if(BROWSER.equalsIgnoreCase("chrome"))
  {
	  driver=WebDriverManager.chromedriver().create();
	 // driver =new ChromeDriver();
  }
  else if(BROWSER.equalsIgnoreCase("firefox"))
  {
	  driver = new FirefoxDriver();
  }
  else
  {
	  driver = new EdgeDriver();
  }
   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   driver.manage().window().maximize();
   driver.get(URL);
   driver.quit();
}

}

