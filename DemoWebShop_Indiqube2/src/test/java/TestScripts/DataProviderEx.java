package TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericLibrary.DataUtility;

public class DataProviderEx {
	
	@Test(dataProvider = "Example")
	public void data(String firstName,String lastName,String Email,String passWord,String confirmPassword) {
		
		System.out.println(firstName +" "+ lastName +" "+Email +" "+passWord +" "+confirmPassword);
		
	}
	
	@DataProvider(name="Example")
	public Object[][] dataProvider() throws EncryptedDocumentException, IOException {
		DataUtility du=new DataUtility();
		return du.getAllExcelData("RegisterTC");
	}

}
