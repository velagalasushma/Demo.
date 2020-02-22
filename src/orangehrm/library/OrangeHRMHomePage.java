package orangehrm.library;

import org.openqa.selenium.By;

import constants.OrangeHRMConstants;

public class OrangeHRMHomePage extends OrangeHRMConstants
{

	
	public boolean adminLogin(String uid,String pwd)
	{
		driver.findElement(By.id("txtUsername")).sendKeys(uid);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();
		try 
		{
			driver.findElement(By.linkText("Admin"));
			return true;
		} catch (Exception e) 
		{
			return false;
		}		
	}
	
	
	public boolean employeeLogin(String uid,String pwd)
	{
		driver.findElement(By.id("txtUsername")).sendKeys(uid);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();
		
		try 
		{
			driver.findElement(By.linkText("Leave"));
			return true;
		} catch (Exception e) 
		{
			return false;
		}	
		
	}
	
	public boolean logout()
	{
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
		if(driver.findElement(By.id("btnLogin")).isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	
	
}
