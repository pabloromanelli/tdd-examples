package smx.tdd;

import org.apache.poi.ss.usermodel.*;

public class CellDuplicator {

	private final Workbook workbook;

	public CellDuplicator(Workbook workbook) {
		this.workbook = workbook;
	}

	public void copy(int sheetIndex, String colOrigen, int rowOrigen, String colDestino, int rowDestino) {
		Sheet sheet = workbook.getSheetAt(0);

		int colOrigenIndex = colNameToIndex(colOrigen);
		int colDestinoIndex = colNameToIndex(colDestino);
		
		Cell origen = sheet.getRow(rowOrigen - 1).getCell(colOrigenIndex);
		Cell destino = sheet.createRow(rowDestino - 1).createCell(colDestinoIndex);

		destino.setCellValue(origen.getStringCellValue());
	}

	private int colNameToIndex(String colOrigen) {
		return (colOrigen.toUpperCase().charAt(0)) - 'A';
	}

}
