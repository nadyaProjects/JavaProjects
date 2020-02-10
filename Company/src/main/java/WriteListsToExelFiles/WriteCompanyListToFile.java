package WriteListsToExelFiles;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

import java.util.*;

public class WriteCompanyListToFile {

    private static String[] columns = {"First Name", "Last Name", "Phone Number", "Profession", "Company ", "Start Date"};
    private static List<Employee> employees = new ArrayList<>();
    private static final String FILE_NAME = "Employees.xmlx";


    static {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2020, 7, 21);
        employees.add(new Employee("Maria", "Petrova",
                "0888149067", "QA",
                "Matrix", startDate.getTime()));
        startDate.set(2019, 05, 01);
        employees.add(new Employee("Georgi", "Petkov",
                "0897632354", "DevOps",
                "MentorMate", startDate.getTime()));
        startDate.set(2019, 07, 11);
        employees.add(new Employee("Maia", "Ivanova",
                "0897654894", "HR",
                "Honeywell", startDate.getTime()));
        startDate.set(2018, 05, 20);
        employees.add(new Employee("Maria", "Petkova",
                "0897621354", "Marketing Specialist",
                "SumUp", startDate.getTime()));
    }

    public static void main(String[] args) throws IOException, InvalidFormatException {


        Workbook workbook = new XSSFWorkbook();


        CreationHelper createHelper = workbook.getCreationHelper();


        Sheet sheet = workbook.createSheet("Employee");


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
        for (Employee employee : employees) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(employee.getFirstName());

            row.createCell(1)
                    .setCellValue(employee.getLastName());

            row.createCell(2)
                    .setCellValue(employee.getPhoneNumber());

            row.createCell(3)
                    .setCellValue(employee.getProfession());

            row.createCell(4)
                    .setCellValue(employee.getCompany());

            Cell startDateCell = row.createCell(5);
            startDateCell.setCellValue(employee.getStartDate());
            startDateCell.setCellStyle(dateCellStyle);

        }


        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }


        FileOutputStream fileOut = new FileOutputStream("Employees.xlsx");
        workbook.write(fileOut);
        fileOut.close();


        workbook.close();
    }

    private static void setStartDate(int year, int month, int day) {
        Calendar startDate = Calendar.getInstance();
        startDate.getTime();
    }
}

