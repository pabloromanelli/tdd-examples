package smx.tdd;

import static smx.tdd.Position.position;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;

import com.google.inject.Inject;

public class AreaReferenceCopier {

	private final CellCopier cellCopier;

	@Inject
	public AreaReferenceCopier(CellCopier cellCopier) {
		this.cellCopier = cellCopier;
	}

	public void copyDelta(Workbook workbook, AreaReference areaReference, int deltaRow, int deltaCol) {
		Sheet sheet = getSheet(workbook, areaReference);

		for (CellReference cellReference : areaReference.getAllReferencedCells()) {
			short col = cellReference.getCol();
			int row = cellReference.getRow();

			cellCopier.copy(sheet, position(row, col), position(row + deltaRow, col + deltaCol));
		}
	}

	private Sheet getSheet(Workbook workbook, AreaReference areaReference) {
		return workbook.getSheet(areaReference.getFirstCell().getSheetName());
	}

}
