package impl;

import ReadListsToExcelFile.ExcelReader;
import WriteListsToExelFiles.Candidate;
import WriteListsToExelFiles.Job;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.io.IOException;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException {

        ExcelReader read = new ExcelReader();
        Candidate candidate = new Candidate();
        Job jobs = new Job();

        List<List<XSSFCell>> data = read.readCells("Job.xlsx");

        data.stream()
                .filter(r -> r.stream().anyMatch(c -> c.getCellType() == CellType.NUMERIC && c.getNumericCellValue() > 2)
                        && r.stream().anyMatch(c -> c.getCellType() == CellType.STRING && c.getStringCellValue().equalsIgnoreCase("Developer")))
                .forEachOrdered(System.out::println);

        List<List<XSSFCell>> dataCandiates = read.readCells("Candidates.xlsx");
        dataCandiates.stream()
                .filter(r -> r.stream().anyMatch(c -> c.getCellType() == CellType.NUMERIC && c.getNumericCellValue() > 2)
                        && r.stream().anyMatch(c -> c.getCellType() == CellType.STRING && c.getStringCellValue().equalsIgnoreCase("Developer")))
                .forEachOrdered(System.out::println);


    }

}