package orangehrm.library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.OrangeHRMConstants;

public class User extends OrangeHRMConstants 
{

	public boolean addUser(String empname,String username,String password)
	{
		
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("User Management")).click();
		driver.findElement(By.linkText("Users")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("btnAdd"))));
		
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(empname);
		driver.findElement(By.id("systemUser_userName")).sendKeys(username);
		driver.findElement(By.id("systemUser_password")).sendKeys(password);
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(password);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("btnSave"))));
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(username);
		driver.findElement(By.id("searchBtn")).click();
		
		
		
		
		WebElement usertable=driver.findElement(By.id("resultTable"));
		
		List<WebElement> rows,cols;
		rows=usertable.findElements(By.tagName("tr"));		
		boolean userexist=false;
		for(int i=1;i<rows.size();i++)
		{
			cols=rows.get(i).findElements(By.tagName("td"));
			if(cols.get(1).getText().equalsIgnoreCase(username))
			{
				userexist=true;
				break;
			}
			
		}
		if(userexist)
		{
			return true;
		}else
		{
			return false;
		}
		
	}
	
	
	
}
