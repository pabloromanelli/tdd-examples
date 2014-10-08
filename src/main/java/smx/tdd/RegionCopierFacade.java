package smx.tdd;

import java.io.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import com.google.inject.Inject;

public class RegionCopierFacade {

	private RegionCopier regionCopier;

	@Inject
	public RegionCopierFacade(RegionCopier regionCopier) {
		this.regionCopier = regionCopier;
	}

	public void copy(InputStream excelFile, String rangeName, Position to, OutputStream resultFile) {
		Workbook workbook = getWorkbook(excelFile);
		regionCopier.copy(workbook, rangeName, to);
		write(workbook, resultFile);
	}

	private Workbook getWorkbook(InputStream excelFile) {
		try {
			return WorkbookFactory.create(excelFile);
		} catch (InvalidFormatException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void write(Workbook workbook, OutputStream resultFile) {
		try {
			workbook.write(resultFile);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
