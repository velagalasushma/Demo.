package orangehrm.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Utils.XLUtils;
import constants.OrangeHRMConstants;
import orangehrm.library.Employee;
import orangehrm.library.OrangeHRMHomePage;
import orangehrm.library.User;

public class OrangeHRMBatchTest extends OrangeHRMConstants
{
    int i;
    
	public String keywordfile="D:\\Selenium930\\OrangeHRM_HybridFramework\\keywordfiles\\OrangeHRMKeywords.xlsx";
	public String tcsheet="TestCases";
	public String tssheet="TestSteps";
	
	@Test
	public void batchTest() throws IOException
	{
		int tccount=XLUtils.getRowCount(keywordfile, tcsheet);
		int tscount=XLUtils.getRowCount(keywordfile, tssheet);
		String tcexecute, tcid, tstcid, keyword; 
		String adminuid,adminpwd, fname, lname, empname, uname, psw,empuid,emppsw;
		String tsresult,tcresult;
		
		boolean res = false;                                                         
		OrangeHRMHomePage hrm=new OrangeHRMHomePage();
		Employee emp = new Employee();
		User uhrm = new User();
		
		for(i=1; i<=tccount; i++)
		{
			 tcexecute=XLUtils.getStringCellData(keywordfile, tcsheet, i, 2);
			 if(tcexecute.equalsIgnoreCase("y"))
			 {
				 tcid=XLUtils.getStringCellData(keywordfile, tcsheet, i, 0);
				 for(int j=1; j<=tscount; j++)
				 {
					 tstcid=XLUtils.getStringCellData(keywordfile, tssheet, j, 0);
					 if(tcid.equalsIgnoreCase(tstcid))
					 {
						 keyword=XLUtils.getStringCellData(keywordfile, tssheet, j,4);
						 switch (keyword.toLowerCase())
						 {
						case "adminlogin":
							adminuid=XLUtils.getStringCellData(keywordfile, tssheet, j, 5);
							adminpwd=XLUtils.getStringCellData(keywordfile, tssheet, j, 6);
							res=hrm.adminLogin(adminuid, adminpwd);
							break;
						case "adminlogout":
							res = hrm.logout();
                            break;
						case "newempreg":
							fname = XLUtils.getStringCellData(keywordfile, tssheet, j,5);
							lname = XLUtils.getStringCellData(keywordfile, tssheet, j,6);
							res = emp.addEmployee(fname, lname);
							break;
						case "newuserreg":
							empname = XLUtils.getStringCellData(keywordfile, tssheet, j,5);
							uname = XLUtils.getStringCellData(keywordfile, tssheet, j,6);
							psw = XLUtils.getStringCellData(keywordfile, tssheet, j,7);
							res = uhrm.addUser(empname, uname, psw);
							break;
						case "emplogin":
							empuid = XLUtils.getStringCellData(keywordfile, tssheet, j,5);
							emppsw = XLUtils.getStringCellData(keywordfile, tssheet, j,6);
							res = hrm.employeeLogin(empuid, emppsw);
				            break;
						case "emplogout":
							res = hrm.logout();
							break;
					       }
						 if(res)
						 {
							 tsresult="Pass";
							 XLUtils.setCellData(keywordfile, tssheet, j, 3, tsresult);
							 XLUtils.fillGreenColor(keywordfile, tssheet, j, 3);
						 
						 }
						 else
						 {
							 tsresult="Fail";
							 XLUtils.setCellData(keywordfile, tssheet, j, 3, tsresult);
                             XLUtils.fillRedColor(keywordfile, tssheet, j, 3); 
						 }
					 
						 tcresult=XLUtils.getStringCellData(keywordfile, tcsheet, i, 3);
						 if(!tcresult.equalsIgnoreCase("fail"))
						 {
							 XLUtils.setCellData(keywordfile, tcsheet, i, 3, tsresult);
						 }
						 tcresult=XLUtils.getStringCellData(keywordfile, tcsheet, i, 3);
						 if(tcresult.equalsIgnoreCase("Pass"))
						 {
							 XLUtils.fillGreenColor(keywordfile, tcsheet, i, 3);
						 }else
						 {
							 XLUtils.fillRedColor(keywordfile, tcsheet, i, 3);
						 }
						 
						 
					 }
				 }
			 }
			 else{
				 XLUtils.setCellData(keywordfile, tcsheet, i, 3,"Blocked");
				 XLUtils.fillRedColor(keywordfile, tcsheet, i, 3);
			 }
		}
		
		
	}
	
	
	
}
