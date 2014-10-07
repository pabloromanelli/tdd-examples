package smx.tdd.libraries;

import static org.junit.Assert.*;

import java.io.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

public class PoiLearningTest {

	@Test
	public void puedoCopiarUnaCelda() throws InvalidFormatException, IOException {
		// copy C3 on D6
		try (InputStream excelFile = getClass().getResourceAsStream("excel-file.xlsx")) {
			Workbook workbook = WorkbookFactory.create(excelFile);
			Sheet sheet = workbook.getSheetAt(0);

			Cell C3 = sheet.getRow(2).getCell(2);
			Cell D6 = sheet.createRow(5).createCell(3);

			D6.setCellValue(C3.getStringCellValue());

			File resultFile = new File("copy-result.xlsx");
			try (OutputStream outputStream = new FileOutputStream(resultFile)) {
				workbook.write(outputStream);
			}
		}

		File resultFile = new File("copy-result.xlsx");
		try (InputStream excelFile = new FileInputStream(resultFile)) {
			Workbook workbook = WorkbookFactory.create(excelFile);
			Sheet sheet = workbook.getSheetAt(0);
			Cell D6 = sheet.getRow(5).getCell(3);

			assertEquals("C3", D6.getStringCellValue());
		}
	}
}
