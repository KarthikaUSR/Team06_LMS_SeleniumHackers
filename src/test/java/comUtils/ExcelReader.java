package comUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pojo.batchRecords;
import pojo.programRecords;

public class excelReader {
	
	// Batch Module

	public List<batchRecords> readExcel_LMSPrograms(String SheetName) throws IOException {

		
		String path = System.getProperty("user.dir") + "/src/test/resources/testData/Testdata.xlsx";

		File Excelfile = new File(path);
		List<batchRecords> batchRecordlist = new ArrayList<>();
		FileInputStream Fis = new FileInputStream(Excelfile);
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(Fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Entered sheet in excel:" + SheetName);

		if (SheetName != null && SheetName.trim().equalsIgnoreCase("Batch")) {

			batchRecordlist = getbatchRecordlist(workbook, SheetName);
		}

		else if (SheetName != null && SheetName.trim().equalsIgnoreCase("Class")) {
			batchRecordlist = getbatchRecordlist(workbook, SheetName);
		} else {
			System.out.println("Enter valid Sheetname");
		}
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("read batch list values : " + batchRecordlist);
		return batchRecordlist;
	}
	
	// Program Module
	public List<programRecords> readExcel_ProgramRecords(String SheetName) throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/resources/testData/Testdata.xlsx";

		File Excelfile = new File(path);
		List<programRecords> programRecordlist = new ArrayList<>();
		FileInputStream Fis = new FileInputStream(Excelfile);
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(Fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Entered sheet in excel:" + SheetName);

		if (SheetName != null && SheetName.trim().equalsIgnoreCase("Program")) {
			programRecordlist = getProgramRecordlist(workbook, SheetName);
		} else {
			System.out.println("Enter valid Sheetname");
		}
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("read program list values : " + programRecordlist);
		return programRecordlist;
	}

	// commom methed to Fetch the List from Data excel----- Batch Module

	private List<batchRecords> getbatchRecordlist(XSSFWorkbook workbook, String sheetName) throws IOException {
		List<batchRecords> batchRecordlist = new ArrayList<>();
		sheetName = sheetName.trim();

		XSSFSheet sheet = workbook.getSheet(sheetName);
		System.out.println("Last row index: " + sheet.getLastRowNum());

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);
			if (row != null) {
				String ProgramName = row.getCell(0) != null ? row.getCell(0).getStringCellValue().trim() : "";
				String BatchNo = row.getCell(1) != null ? getCellData(row.getCell(1)) : "";
				String Description = row.getCell(2) != null ? row.getCell(2).getStringCellValue().trim() : "";
				String Classcount = row.getCell(3) != null ? getCellData(row.getCell(3)) : "";
				batchRecordlist.add(new batchRecords(ProgramName, BatchNo, Description, Classcount));
			}
		}

		workbook.close();
		return batchRecordlist;
	}
	// commom methed to Fetch the List from Data excel----- Program Module
	
	private List<programRecords> getProgramRecordlist(XSSFWorkbook workbook, String sheetName) throws IOException {
		List<programRecords> programRecordlist = new ArrayList<>();
		sheetName = sheetName.trim();
		System.out.print("######"+sheetName);

		XSSFSheet sheet = workbook.getSheet(sheetName);
		System.out.println("Last row index: " + sheet.getLastRowNum());

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);
			if (row != null) {
				String name = row.getCell(0) != null ? row.getCell(0).getStringCellValue().trim() : "";
				String description = row.getCell(1) != null ? row.getCell(1).getStringCellValue().trim() : "";
				programRecordlist.add(new programRecords(name, description));
			}
		}

		workbook.close();
		return programRecordlist;
	}

//sub method for numeric cell
	private String getCellData(Cell cell) {
		if (cell.getCellType() == CellType.NUMERIC) {
			return String.valueOf((int) cell.getNumericCellValue());
		} else {
			return cell.getStringCellValue().trim();
		}
	}

}