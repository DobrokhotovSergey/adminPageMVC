package ua.laksmi.web.controller;

/**
 * Created by Dobriks on 18.06.2017.
 */
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.util.IOUtils;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class ImageTest {

    public static void main(String[] args) {
        try {

            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("My Sample Excel");
           // XSSFWorkbook workbook = new XSSFWorkbook();
        //    XSSFSheet spreadsheet = wb.createSheet("Fontstyle");
            XSSFRow row = sheet.createRow(1);
            //Create a new font and alter it.
            XSSFFont font = wb.createFont();
            font.setFontHeightInPoints((short) 28);
            font.setFontName("Times New Roman");
            font.setItalic(true);
            font.setColor(HSSFColor.BLACK.index);


            //Set font into style
            XSSFCellStyle style = wb.createCellStyle();
            style.setFont(font);
            // Create a cell with a value and set style to it.
            XSSFCell cell1 = row.createCell(3);
            cell1.setCellValue("ZNS GROUP LIMITED");
            cell1.setCellStyle(style);


            XSSFFont font12 = wb.createFont();
            font12.setFontHeightInPoints((short) 12);
            font12.setFontName("Times New Roman");
            font12.setBold(true);
            font12.setColor(HSSFColor.BLACK.index);


            XSSFCellStyle style12 = wb.createCellStyle();
            style12.setFont(font12);
            // Create a cell with a value and set style to it.
            XSSFRow row1 = sheet.createRow(2);
            XSSFCell cell4 = row1.createCell(3);
            cell4.setCellValue("P. O. Box 52373-00100, Nairobi , Kenya");
            cell4.setCellStyle(style12);

            XSSFRow row2 = sheet.createRow(3);
            XSSFCell cell5 = row2.createCell(3);
            cell5.setCellValue("PIN NO : P 051623051Z");
            cell5.setCellStyle(style12);

            XSSFRow row3 = sheet.createRow(4);
            XSSFCell cell6 = row3.createCell(3);
            cell6.setCellValue("License NO. L11/05907");
            cell6.setCellStyle(style12);

            XSSFFont font18 = wb.createFont();
            font18.setFontHeightInPoints((short) 18);
            font18.setFontName("Times New Roman");
            font18.setBold(true);
            font18.setColor(HSSFColor.BLACK.index);

            XSSFCellStyle style18 = wb.createCellStyle();
            style18.setFont(font18);
            XSSFRow row8 = sheet.createRow(8);
            XSSFCell cell8 = row8.createCell(4);
            cell8.setCellValue("ZNS INVOICE");
            cell8.setCellStyle(style18);


              /* Create an object of type XSSFTable */
            XSSFTable my_table = sheet.createTable();

        /* get CTTable object*/
            CTTable cttable = my_table.getCTTable();
            AreaReference my_data_range = new AreaReference(new CellReference(0, 0), new CellReference(2, 2));
            cttable.setRef(my_data_range.formatAsString());
            cttable.setDisplayName("MYTABLE");      /* this is the display name of the table */
            cttable.setName("Test");    /* This maps to "displayName" attribute in <table>, OOXML */
            cttable.setId(1L); //id attribute against table as long value
            CTTableColumns columns = cttable.addNewTableColumns();
            columns.setCount(2L); //define number of columns

        /* Define Header Information for the Table */

            for(int i =0; i <3;i++){
                XSSFRow rowT = sheet.createRow(i+20);
                for (int j = 0; j < 2; j++){
                    XSSFCell localXSSFCell = rowT.createCell(j+1);
                    if(j==0 && i==0){
                        localXSSFCell.setCellValue("FLT NO.");
                    }else if(j==1 && i == 0){
                        localXSSFCell.setCellValue("FLT value");
                    }else if(j==0 && i == 1){
                        localXSSFCell.setCellValue("MAWB");
                    }else if(j==1 && i == 1){
                        localXSSFCell.setCellValue("MAWB value");
                    }else if(j==0 && i == 2){
                        localXSSFCell.setCellValue("ABV");
                    }else if(j==1 && i == 2){
                        localXSSFCell.setCellValue("ABV value");
                    }
                }

            }
            for (int i = 0; i < 2; i++){
                CTTableColumn column = columns.addNewTableColumn();
                column.setName("Column" + i);
                column.setId(i+1);
            }
            XSSFFont font10Bold = wb.createFont();
            font10Bold.setFontHeightInPoints((short) 10);
            font10Bold.setFontName("Times New Roman");
            font10Bold.setBold(true);
            font10Bold.setColor(HSSFColor.BLACK.index);
            XSSFCellStyle style10Bold = wb.createCellStyle();
            style10Bold.setFont(font10Bold);
            style10Bold.setBorderBottom(CellStyle.BORDER_THICK);
            style10Bold.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            style10Bold.setBorderLeft(CellStyle.BORDER_THICK);
            style10Bold.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            style10Bold.setBorderRight(CellStyle.BORDER_THICK);
            style10Bold.setRightBorderColor(IndexedColors.BLACK.getIndex());
            style10Bold.setBorderTop(CellStyle.BORDER_THICK);
            style10Bold.setTopBorderColor(IndexedColors.BLACK.getIndex());


            for(int i =0; i < 10;i++){
                XSSFRow rowT = sheet.createRow(i+9);
                XSSFCell localXSSFCell = rowT.createCell(1);
                if(i==0){
                    localXSSFCell.setCellValue("CONSIGNEE:");
                }else{
                    localXSSFCell.setCellValue(i);
                    if(i==1){
                        for (int j = 0; j < 2; j++){
                            localXSSFCell = rowT.createCell(j+9);
                            localXSSFCell.setCellStyle(style10Bold);
                            if(j==0 && i==1){
                                localXSSFCell.setCellValue("Date");

                            }else if(j==1 && i == 1){
                                localXSSFCell.setCellValue("value Date");
                            }
                        }
                    }
                    else if(i==2){
                        for (int j = 0; j < 2; j++){
                            localXSSFCell = rowT.createCell(j+9);
                            localXSSFCell.setCellStyle(style10Bold);
                       if(j==0 && i == 2){
                            localXSSFCell.setCellValue("ZNS INVOICE NO.");


                        }else if(j==1 && i == 2) {
                           localXSSFCell.setCellValue("invoice value");
                       }
                        }
                    }
                }

            }

            for(int i =0; i <2;i++){
                XSSFRow rowT = sheet.createRow(i+24);
                for (int j = 0; j < 10; j++){
                    XSSFCell localXSSFCell = rowT.createCell(j+1);
                    if(i==0){
                        if(j==0){
                            localXSSFCell.setCellValue("FARM");
                        }else if(j==1){
                            localXSSFCell.setCellValue("BOXES");
                        }else if(j==2){
                            localXSSFCell.setCellValue("VARIETY");
                        }else if(j==3){
                            localXSSFCell.setCellValue("CLIENT");
                        }else if(j==4){
                            localXSSFCell.setCellValue("STD");
                        }else if(j==5){
                            localXSSFCell.setCellValue("SPRAY");
                        }else if(j==6){
                            localXSSFCell.setCellValue("LENGTH");
                        }else if(j==7){
                            localXSSFCell.setCellValue("STEMS");
                        }else if(j==8){
                            localXSSFCell.setCellValue("FCA PRICE/STEM");
                        }else if(j==9){
                            localXSSFCell.setCellValue("TOTAL AMOUNT");
                        }
                    }else if(i==1){
                        if(j==6){
                            localXSSFCell.setCellValue("(CMS)");
                        }else if(j==8){
                            localXSSFCell.setCellValue("EURO");
                        }else if(j==9){
                            localXSSFCell.setCellValue("EURO");
                        }
                    }
                   // localXSSFCell.setCellStyle(style10Bold);
                }
                sheet.autoSizeColumn(8);
                sheet.autoSizeColumn(9);
            }


            //FileInputStream obtains input bytes from the image file
            InputStream inputStream = new FileInputStream("D:/zns_logo.png");
            //Get the contents of an InputStream as a byte[].
            byte[] bytes = IOUtils.toByteArray(inputStream);
            //Adds a picture to the workbook
            int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            //close the input stream
            inputStream.close();
            //Returns an object that handles instantiating concrete classes
            CreationHelper helper = wb.getCreationHelper();
            //Creates the top-level drawing patriarch.
            Drawing drawing = sheet.createDrawingPatriarch();

            //Create an anchor that is attached to the worksheet
            ClientAnchor anchor = helper.createClientAnchor();

            //create an anchor with upper left cell _and_ bottom right cell
//            anchor.setCol1(1); //Column B
//            anchor.setRow1(2); //Row 3
//            anchor.setCol2(2); //Column C
//            anchor.setRow2(3); //Row 4

            //Creates a picture
            Picture pict = drawing.createPicture(anchor, pictureIdx);

            //Reset the image to the original size
            pict.resize(); //don't do that. Let the anchor resize the image!

            //Create the Cell B3
            Cell cell = sheet.createRow(0).createCell(0);

          // set width to n character widths = count characters * 256
            int widthUnits = 250;
            sheet.setColumnWidth(0, widthUnits);

           // set height to n points in twips = n * 20
            short heightUnits = 160;
            cell.getRow().setHeight(heightUnits);




            //Write the Excel file
            FileOutputStream fileOut = null;
            fileOut = new FileOutputStream("D:/myFile.xlsx");
            wb.write(fileOut);
            fileOut.close();

        } catch (IOException ioex) {
            System.out.println(ioex);
        }
    }
}
