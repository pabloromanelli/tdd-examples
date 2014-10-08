package smx.tdd;

import org.apache.poi.ss.usermodel.*;

public class CellCopier {

	public void copy(Sheet sheet, Position origen, Position destino) {
		Cell cellOrigen = getCell(sheet, origen.getRowIndex(), origen.getColumnIndex());
		Cell cellDestino = createCell(sheet, destino.getRowIndex(), destino.getColumnIndex());
		cellDestino.setCellValue(cellOrigen.getStringCellValue());
	}

	private Cell createCell(Sheet sheet, int rowIndex, int columnIndex) {
		return getRow(sheet, rowIndex).createCell(columnIndex);
	}

	private Row getRow(Sheet sheet, int rowIndex) {
		Row row = sheet.getRow(rowIndex);
		return row != null ? row : sheet.createRow(rowIndex);
	}

	private Cell getCell(Sheet sheet, int rowIndex, int columnIndex) {
		return sheet.getRow(rowIndex).getCell(columnIndex);
	}

}
