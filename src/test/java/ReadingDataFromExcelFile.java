import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//excel File -->  WorkBook --> sheets --> rows --> cells
public class ReadingDataFromExcelFile {
    public static void main(String[] args) throws IOException {

        //opens excel file in reading mode
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\ExcelFile1.xlsx");

        //open workbook from excel file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //open sheets from excel file
       XSSFSheet sheet =  workbook.getSheet("Sheet1");

       //find number of rows from excel file(rows always count from 0)
       int totalRows =  sheet.getLastRowNum();

       //find no of cells, in each row, from excel file(cells always count from 1, but as per java it starts counting from 0)
       int totalCells =  sheet.getRow(1).getLastCellNum();

        System.out.println("Number of rows: "+totalRows);
        System.out.println("No of cells in each row: "+totalCells);
        System.out.println("total cells present in excel file: "+totalCells*totalRows);

        for(int r=0; r<=totalRows; r++){
            XSSFRow currentRow = sheet.getRow(r);
            for(int c=0; c<totalCells; c++){
                XSSFCell cell = currentRow.getCell(c);
                System.out.print(cell.toString()+"\t");//toString reads and convert any kind of data in string format
            }
            System.out.println();
        }
        workbook.close();
        file.close();
    }
}
