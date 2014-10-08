package smx.tdd;

import static smx.tdd.Position.position;

import java.io.*;

public class RegionCopierFacadeManualTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		try (InputStream excelFile = RegionCopierFacadeManualTest.class.getResourceAsStream("manual-test.xlsx")) {
			File resultFile = new File("result-manual-test.xlsx");
			try (OutputStream outputStream = new FileOutputStream(resultFile)) {
				new RegionCopierFacade().copy(excelFile, "some_range", position(8, 4), outputStream);
			}
		}
	}

}
