package utilities;
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
 
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
 
public class ExcelUtils {
 
    public static XSSFWorkbook workbook;
  
    public static void writeCarSrvcsDetails(List<WebElement> name, List<WebElement> Contact_No) throws IOException {
    	workbook = new XSSFWorkbook();
    	XSSFSheet sheet = workbook.createSheet("CarWashingServices");
        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Index");
        headerRow.createCell(1).setCellValue("CarSrvcs Name");
        headerRow.createCell(2).setCellValue("Contact Number");
 
        for (int i = 0; i < 5 && i < name.size(); i++) {
            XSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(i + 1);
            row.createCell(1).setCellValue(name.get(i).getText());
            row.createCell(2).setCellValue(Contact_No.get(i).getText());
        }
        ExcelUtils.writeToExcelFile("Book1.xlsx");
    }
 
    public static void writeGymSubList(List<WebElement> SubList) throws IOException {
    
    	FileInputStream file=new FileInputStream("Book1.xlsx");
    	
    	workbook = new XSSFWorkbook(file);
    	 XSSFSheet sheet;
    	try {
         sheet = workbook.createSheet("GymSubList");
    	}
    	catch(Exception e) {
    	 sheet = workbook.getSheet("GymSubList");
    	}
        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Index");
        headerRow.createCell(1).setCellValue("Sub-Menu items Of Gyms");
 
        for (int i = 0; i < SubList.size(); i++) {
            XSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(i + 1);
            row.createCell(1).setCellValue(SubList.get(i).getText());
            
        }
        file.close();
        ExcelUtils.writeToExcelFile("Book1.xlsx");
    }
 
    public static void writeToExcelFile(String filePath) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
            ExcelUtils.closeWorkbook();
        }
    }
    public static void closeWorkbook() throws IOException {
        workbook.close();
    }
}