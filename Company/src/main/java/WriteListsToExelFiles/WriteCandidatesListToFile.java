package WriteListsToExelFiles;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WriteCandidatesListToFile {

    private static String[] columns = {"First Name", "Last Name", "Age", "Phone Number", "Profession", "Profession Category ", "Years of Experience"};
    private static List<Candidate> candidates = new ArrayList<Candidate>();
    private static final String FILE_NAME = "Candidates.xmlx";


    static {
        candidates.add(new Candidate("Peter", "Petrov",
                40, "089777654",
                "CEO", "Management", 9));
        candidates.add(new Candidate("Maria", "Todorova",
                32, "089347654",
                "QA", "IT", 7));
        candidates.add(new Candidate("Todor", "Petkov",
                30, "089777944",
                "Developer", "IT", 7));
        candidates.add(new Candidate("Peter", "Petrov",
                23, "089777124",
                "Marketing Specialist", "Marketing", 1));


    }

    public static void main(String[] args) throws IOException, InvalidFormatException {

        // Create a Workbook
        Workbook workbook = new XSSFWorkbook();

        CreationHelper createHelper = workbook.getCreationHelper();

        Sheet sheet = workbook.createSheet("Candidate");

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

        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        int rowNum = 1;
        for (Candidate candidate : candidates) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(candidate.getFirstName());

            row.createCell(1)
                    .setCellValue(candidate.getLastName());

            row.createCell(2)
                    .setCellValue(candidate.getAge());

            row.createCell(3)
                    .setCellValue(candidate.getPhoneNumber());

            row.createCell(4)
                    .setCellValue(candidate.getProfession());

            row.createCell(5)
                    .setCellValue(candidate.getProfessionCategory());
            row.createCell(6)
                    .setCellValue(candidate.getYearsOfExperience());

        }

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        FileOutputStream fileOut = new FileOutputStream("Candidates.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        workbook.close();
    }

    private static void setStartDate(int year, int month, int day) {
        Calendar startDate = Calendar.getInstance();
        startDate.getTime();
    }

}