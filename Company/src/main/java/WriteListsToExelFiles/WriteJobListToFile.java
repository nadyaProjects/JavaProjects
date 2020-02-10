package WriteListsToExelFiles;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteJobListToFile {

    private static String[] columns = {"Profession","Profession category","Years of Experience", "Company"};
    private static List<Job> jobs = new ArrayList<>();
    private static final String FILE_NAME = "Job.xmlx";

    static {
        jobs.add(new Job("QA","IT", 2, "Matrix"));
        jobs.add(new Job("Developer", "IT", 4,"Map"));
        jobs.add(new Job("CEO","Management",8, "Honeywell"));
        jobs.add(new Job("Marketing Specialist","Marketing", 3,"Concetrix"));
    }
    public static void main(String[] args) throws IOException, InvalidFormatException {

        Workbook workbook = new XSSFWorkbook();


        CreationHelper createHelper = workbook.getCreationHelper();

        Sheet sheet = workbook.createSheet("Job");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }


        int rowNum = 1;
        for (Job job : jobs) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(job.getProfession());

            row.createCell(1)
                    .setCellValue(job.getProfessionCategory());

            row.createCell(2)
                    .setCellValue(job.getYearsOfExperience());

        }

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        FileOutputStream fileOut = new FileOutputStream("Job.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        workbook.close();
    }
}
