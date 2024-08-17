package pages;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipTravel {
	
	WebDriver driver;
	
	By travellink=By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/a[4]/div/div/div");
	
	By from=By.name("0-departcity");
	By fromplace=By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div/div[2]/div/div[2]/form/div/div[1]/div[1]/div[1]/div[2]/div/div[7]/div[2]");
	
	By To=By.name("0-arrivalcity");
	By offtoplace=By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div/div[2]/div/div[2]/form/div/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[2]");
	
	By fromdate=By.name("0-datefrom");
	
	By monthh = By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div/div[2]/div/div[2]/form/div/div[3]/div[1]/div[2]/div/div/div/div/table[1]/thead/tr[1]/th[2]/div");

	By arrowbtn=By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div/div[2]/div/div[2]/form/div/div[3]/div[1]/div[2]/div/div/div/div/table[2]/thead/tr[1]/th[3]/div/button");
	
	By dateselect=By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div/div[2]/div/div[2]/form/div/div[3]/div[1]/div[2]/div/div/div/div/table[1]/tbody/tr[4]/td[3]/div/button");
	
	By travelclass=By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div/div[2]/div/div[2]/form/div/div[3]/div[2]/input");
	
	By plusbtn=By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div/div[2]/div/div[2]/form/div/div[3]/div[1]/div[2]/div/div/div/div[1]/div[1]/div[2]/div[2]/div/div[3]/button");
	By radiobtn=By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div/div[2]/div/div[2]/form/div/div[3]/div[1]/div[2]/div/div/div/div[1]/div[2]/div/label[2]/div[1]");
	
	By searchbtn=By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div/div[2]/div/div[2]/form/div/button");
	
	By flightss=By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/div[3]/div[1]");
	
	public FlipTravel(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void travel() throws Exception
	{
		driver.manage().window().maximize();
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	    
  	    WebElement trav=wait.until(ExpectedConditions.visibilityOfElementLocated(travellink));
  	    trav.click();
	
		Thread.sleep(5000);
		
		WebElement frm=driver.findElement(from);
		frm.click();
		
		
		driver.findElement(fromplace).click();
		
		WebElement offto=driver.findElement(To);
		offto.click();
		
		driver.findElement(offtoplace).click();
		
		
		driver.findElement(fromdate).click();
		
		while(true)
		{
			WebElement month=driver.findElement(monthh);
			String month1=month.getText();
			
			if(month1.equals("August 2024"))
			{
				System.out.println(month1);
				break;
			}
			else
			{
				driver.findElement(arrowbtn).click();	
			}
		}
		
		WebElement date1=driver.findElement(dateselect);
		
			String date=date1.getText();
			System.out.println(date);
			date1.click();
		
		driver.findElement(travelclass).click();
		driver.findElement(plusbtn).click();
		driver.findElement(radiobtn).click();
		
		driver.findElement(searchbtn).click();
		
		//File Screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileHandler.copy(Screenshot,new File("D://ScreenshotFlight.png"));
		
		
	    WebElement flightSS=wait.until(ExpectedConditions.visibilityOfElementLocated(flightss));
	
		File screenshort=flightSS.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshort, new File("D://ScreenshotFlight//screenshort.png"));
		
	}

}
