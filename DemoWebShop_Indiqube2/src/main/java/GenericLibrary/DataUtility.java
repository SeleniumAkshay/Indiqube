package GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility implements FrameWorkConstants{
	
	FileInputStream fis;
	
	public String getPropertyData(String key) throws IOException {
		fis=new FileInputStream(propertyPath);
		Properties pro=new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;		
	}
	
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		
		fis=new FileInputStream(excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		
		DataFormatter formate=new DataFormatter();
		String value = formate.formatCellValue(wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		return value;
		
	}
	
	public Object[][] getAllExcelData(String sheetName) throws EncryptedDocumentException, IOException {
		
		fis=new FileInputStream(excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int rowNum=sheet.getPhysicalNumberOfRows();
		int cellNum=sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] array=new Object[rowNum-1][cellNum];
		for (int i = 1; i <rowNum; i++) {
			for (int j = 0; j < cellNum; j++) {
				array[i-1][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		
		return array;
		
	}
	

}
