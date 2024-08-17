package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.FlipMobileSearch;

import pages.FlipTravel;


public class Fliptest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}
	
	@BeforeMethod
	public void url()
	{
		driver.get("https://www.flipkart.com/");
	}
	
	@Test
	public void test() throws Exception
	{
		FlipMobileSearch ob=new FlipMobileSearch(driver);
		ob.searchmobile("mobile phones");
		
		FlipTravel obj=new FlipTravel(driver);
		obj.travel();
		
	}

}
