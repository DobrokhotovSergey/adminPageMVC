package ua.laksmi.web.controller;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Dobriks on 28.06.2017.
 */
public class Imeges2 {
    public static void main(String[] args) throws IOException {
        File myFile = new File("D:/InvoiceExcel.xlsx");
        FileInputStream fis = new FileInputStream(myFile);

        // Finds the workbook instance for XLSX file
        XSSFWorkbook wb = new XSSFWorkbook (fis);

        XSSFSheet sheet1 = wb.getSheet("Sheet1");
        XSSFRow row8 = sheet1.getRow(9);
        XSSFCell cell8 = row8.getCell(3);
        cell8.setCellValue("4/16/2017");
        FileOutputStream fileOut = new FileOutputStream("D:/new.xlsx");
        wb.write(fileOut);
        fileOut.close();
    }

}
