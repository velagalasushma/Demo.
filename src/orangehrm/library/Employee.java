package orangehrm.library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import constants.OrangeHRMConstants;

public class Employee extends OrangeHRMConstants
{

	public boolean addEmployee(String fname,String mname,String lname)
	{
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		driver.findElement(By.id("firstName")).sendKeys(fname);
		driver.findElement(By.id("middleName")).sendKeys(mname);
		driver.findElement(By.id("lastName")).sendKeys(lname);
		String empno=driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
		
		driver.findElement(By.linkText("Employee List")).click();
		WebElement emptable=driver.findElement(By.id("resultTable"));
		
		List<WebElement> rows,cols;
		rows=emptable.findElements(By.tagName("tr"));		
		boolean empexist=false;
		for(int i=0;i<rows.size();i++)
		{
			cols=rows.get(i).findElements(By.tagName("td"));
			if(cols.get(1).getText().equalsIgnoreCase(empno))
			{
				empexist=true;
				break;
			}
			
		}
		if(empexist)
		{
			return true;
		}else
		{
			return false;
		}		
	}	
	
	
	public boolean addEmployee(String fname,String lname)
	{
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		driver.findElement(By.id("firstName")).sendKeys(fname);		
		driver.findElement(By.id("lastName")).sendKeys(lname);
		String empno=driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
		
		driver.findElement(By.linkText("Employee List")).click();
		WebElement emptable=driver.findElement(By.id("resultTable"));
		
		List<WebElement> rows,cols;
		rows=emptable.findElements(By.tagName("tr"));		
		boolean empexist=false;
		for(int i=1;i<rows.size();i++)
		{
			cols=rows.get(i).findElements(By.tagName("td"));
			if(cols.get(1).getText().equalsIgnoreCase(empno))
			{
				empexist=true;
				break;
			}
			
		}
		if(empexist)
		{
			return true;
		}else
		{
			return false;
		}		
	}
	
	
	
}
