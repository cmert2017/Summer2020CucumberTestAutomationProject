package com.vytrack.utils;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class ExcelIO {

    @Test
    public void readDataFromExcel() throws IOException {

        String path1 = "/Users/mathinformatics/IdeaProjects/Summer2020CucumberTestAutomationProject/SampleData.xlsx";
        String path2 = "SampleData.xlsx";
        Workbook workbook = WorkbookFactory.create(new File(path1));
        Sheet sheet = workbook.getSheet("SalesOrders");

        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        System.out.println(cell.getStringCellValue());

        System.out.println("----------------------------------");

        int lastRow = sheet.getLastRowNum();
        System.out.println(sheet.getRow(lastRow).getCell(0));

        System.out.println("----------------------------------");

        for(int i=0; i<= lastRow;i++){
            System.out.println(sheet.getRow(i).getCell(0));
        }

        System.out.println("----------------------------------");
        for(int i=0; i<= lastRow;i++){
            int lastColumn = sheet.getRow(i).getLastCellNum()-1;
            System.out.print(sheet.getRow(i).getCell(0));
            System.out.print("---->"+sheet.getRow(i).getCell(lastColumn));
            System.out.println();
        }

    }

}
