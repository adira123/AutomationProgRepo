package pages;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipMobileSearch {
	
	WebDriver driver;
	
	By flipsearch=By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input");
    By searchbtn=By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[1]/div[1]/header/div[1]/div[2]/form/div/button");
    By Brandsearch=By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div[1]/div/section[3]/div[2]/div[1]/div[2]/div/label/div[1]");
    By Flipphn=By.xpath("//*[contains(@class,'KzDlHZ')]");
     
    By Flipaddcart=By.xpath("//*[contains(@class,'QqFHMw vslbG+ In9uk2')]");
    By add =By.xpath("//*[contains(@class,'QqFHMw eTWN7O')]");
    
    By Flipviewcart=By.xpath("//*[contains(@class,'_9Wy27C')]");
    By Flipremove=By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[2]/div/div[3]/div[2]/div[2]");
    By Flipremovee=By.xpath("//*[@id=\"container\"]/div/div[1]/div/div[3]/div/div[1]");
   
    public FlipMobileSearch(WebDriver driver)
    {
    	this.driver=driver;
    }
    
    
    public void searchmobile(String searchvalue) throws Exception
    {
    	
    	    driver.manage().window().maximize();
    	  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	    String parentWindow = driver.getWindowHandle();
    	    System.out.println("parent window title: " + driver.getTitle());

    	    driver.findElement(flipsearch).sendKeys(searchvalue);
    	    driver.findElement(searchbtn).click();
    	  

    	   
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    	    
    	    WebElement brand=wait.until(ExpectedConditions.visibilityOfElementLocated(Brandsearch));
    	    brand.click();
    	    
    	    Thread.sleep(5000);
    	    
    	    WebElement phoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Flipphn));
    	    
    	    // Check if the element is blocked by another element
    	    try {
    	        // Attempt to scroll and click
    	    	
    	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", phoneElement);
    	        phoneElement.click();  // First try normal click
    	        
    	    } catch (ElementClickInterceptedException e) {
    	        
    	    	// If normal click fails, try again with JavaScript
    	    	
    	        System.out.println("Click intercepted, trying JavaScript click.");
    	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", phoneElement);
    	    }
	
  	  
  	  switchToNewWindow(parentWindow);
  	   	  
     //driver.findElement(Flipaddcart).click();
  	 
  	 WebElement addcart= wait.until(ExpectedConditions.visibilityOfElementLocated(Flipaddcart));
	 addcart.click();
	 
	 WebElement additem=wait.until(ExpectedConditions.visibilityOfElementLocated(add));
	 additem.click();
	
  	  driver.close();
  	  
  	  driver.switchTo().window(parentWindow);
  	  
  	 WebElement viewcart=wait.until(ExpectedConditions.visibilityOfElementLocated(Flipviewcart));
	 viewcart.click();
	 
	 WebElement remove=wait.until(ExpectedConditions.visibilityOfElementLocated(Flipremove));
	 
	 JavascriptExecutor js= (JavascriptExecutor)driver;
		
	 js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[2]/div/div[3]/div[2]/div[2]")));
	
  	 remove.click();
  	 
  	 WebElement removeagain=wait.until(ExpectedConditions.visibilityOfElementLocated(Flipremovee));
	 removeagain.click();
  	 
	 driver.navigate().back();
	 driver.navigate().back();
	 driver.navigate().back();
	 
    }
    
    
    private void switchToNewWindow(String parentWindow)
    {
    	 Set<String> allwindowhandles = driver.getWindowHandles();
    	   
    	   for(String handle:allwindowhandles)
    	   {
    		   System.out.println(handle);
    		   
    		   if(!handle.equalsIgnoreCase(parentWindow))
    		   {
    			   driver.switchTo().window(handle);
    			   
    			  break;  
    		   }
    		   	   
    	   }	   
    }
    
    
     
}
