package smx.tdd;

import org.apache.poi.ss.usermodel.Sheet;

public class MyCell {

	private final Sheet sheet;
	private final String column;
	private final int rowIndex;

	public MyCell(Sheet sheet, String column, int rowIndex) {
		this.sheet = sheet;
		this.column = column;
		this.rowIndex = rowIndex;
	}

	public int columnIndex() {
		return column.toUpperCase().charAt(0) - 'A';
	}

	public void setStringValue(String value) {
		sheet.createRow(rowIndex - 1).createCell(columnIndex()).setCellValue(value);
	}

	public String getStringValue() {
		return sheet.getRow(rowIndex - 1).getCell(columnIndex()).getStringCellValue();
	}

}
