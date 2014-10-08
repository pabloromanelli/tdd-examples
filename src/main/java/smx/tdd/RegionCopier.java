package smx.tdd;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;

import com.google.inject.Inject;

public class RegionCopier {

	private final AreaReferenceProvider areaReferenceProvider;
	private final AreaReferenceCopier areaReferenceCopier;

	@Inject
	public RegionCopier( //
		AreaReferenceProvider areaReferenceProvider,
		AreaReferenceCopier areaReferenceCopier) {
		this.areaReferenceProvider = areaReferenceProvider;
		this.areaReferenceCopier = areaReferenceCopier;
	}

	public void copy(Workbook workbook, String rangeName, Position to) {
		Name name = workbook.getName(rangeName);
		AreaReference areaReference = areaReferenceProvider.get(name);

		CellReference firstCell = areaReference.getFirstCell();
		int deltaRow = to.getRowIndex() - firstCell.getRow();
		int deltaCol = to.getColumnIndex() - firstCell.getCol();

		areaReferenceCopier.copyDelta(workbook, areaReference, deltaRow, deltaCol);
	}

	public static class AreaReferenceProvider {
		public AreaReference get(Name name) {
			return new AreaReference(name.getRefersToFormula());
		}
	}

}
