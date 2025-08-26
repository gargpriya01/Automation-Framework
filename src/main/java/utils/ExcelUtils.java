package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;


public class ExcelUtils {

    private final Sheet sheet;

    public ExcelUtils(String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            Workbook wb = new XSSFWorkbook(fis);
            sheet = wb.getSheet(sheetName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getCellData(int row, int col) {
        return sheet.getRow(row).getCell(col).getStringCellValue();
    }

    public int getRowCount() {
        return sheet.getLastRowNum();

    }
}
