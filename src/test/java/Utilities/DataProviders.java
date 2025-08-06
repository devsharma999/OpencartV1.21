package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="logindata")
	public Object [][] getData() {
		return new Object[][] {
	        // Valid credentials
	        {"sample2@gmail.com", "12345678","valid"},
	        {"sample3@gmail.com", "987987","valid"},

	        // Invalid email 
	        {"john.doeexample.com", "ValidPass123","invalid"},         // Missing '@'
	        {"@example.com", "ValidPass123","invalid"},                // Missing local part

	        // Invalid 
	        {"valid.user@example.com", "","invalid"},                  // Empty password
	        {"valid.user@example.com", "short","invalid"},  
	
		};
	}
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//@DataProvider(name="logindata")
//	public String [][] getData() throws IOException
//	{
//	    String path=".\\testData\\Opencart_loginData.xlsx"; //taking x1 file from testdata
//	    ExcelUtility x1util=new ExcelUtility(path); //creating an object for XLUtility
//
//	    int totalrows=x1util.getRowCount("Sheet1");
//	    int totalcols=x1util.getCellCount("Sheet1",1);
//
//	    String logindata[][]=new String[totalrows][totalcols]; //created for two dimension array which can store rows & col
//
//	    for(int i=1;i<=totalrows;i++) //1 //read the data from xl storing in two demensional array
//	    {
//	        for(int j=0;j<totalcols;j++) //0
//	        {
//	            logindata[i-1][j]= x1util.getCellData("Sheet1", i, j); //1,0
//	        }
//	    }
//	    return logindata; //returning two dimension array
//	}
