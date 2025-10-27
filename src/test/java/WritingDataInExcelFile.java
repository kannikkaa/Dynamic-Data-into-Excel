import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WritingDataInExcelFile {
    public static void main(String[] args) throws IOException {

        //excel File -->  WorkBook --> sheets --> rows --> cells
        //create a new workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //create new sheet
       XSSFSheet sheet = workbook.createSheet("Data");

       //create 1st row
        XSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("Java");
        row1.createCell(1).setCellValue("19");
        row1.createCell(2).setCellValue("automation");

        XSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("python");
        row2.createCell(1).setCellValue("21");
        row2.createCell(2).setCellValue("automation");

        XSSFRow row3 = sheet.createRow(2);
        row3.createCell(0).setCellValue("selenium");
        row3.createCell(1).setCellValue("25");
        row3.createCell(2).setCellValue("automation");

        FileOutputStream file  = new FileOutputStream(System.getProperty("user.dir")+"\\Excelfile2.xlsx");

        workbook.write(file);
        workbook.close();
        file.close();

        System.out.println("file is created");

    }
}
