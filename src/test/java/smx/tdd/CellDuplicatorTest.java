package smx.tdd;

import static org.junit.Assert.*;

import java.io.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

/**
 * Requerimientos:
 * <p>
 * Dado un string con "nombres de region"=>"destino de la copia" separados por
 * coma, copiar todas las celdas de esas regiones en su destino.
 * </p>
 * Restricciones:
 * <ul>
 * <li>Las regiones tienen que ser contiguas</li>
 * <li>Las copias se realizarán en la misma hoja donde se encuentra la región</li>
 * </ul>
 */
@RunWith(MockitoJUnitRunner.class)
public class CellDuplicatorTest {

	@Mock
	private Workbook workbook;
	@Mock
	private Sheet sheet;
	@Mock
	private Row row3;
	@Mock
	private Row row6;
	@Mock
	private Cell c3;
	@Mock
	private Cell d6;
	
	@Test
	public void puedoCopiarUnaCelda() throws InvalidFormatException, IOException {
		when(workbook.getSheetAt(0)).thenReturn(sheet);
		when(sheet.getRow(2)).thenReturn(row3);
		when(sheet.createRow(5)).thenReturn(row6);
		when(row3.getCell(2)).thenReturn(c3);
		when(row6.createCell(3)).thenReturn(d6);
		when(c3.getStringCellValue()).thenReturn("some value");
		
		CellDuplicator cellDuplicator = new CellDuplicator(workbook);
		cellDuplicator.copy(0, "C", 3, "D", 6);
		
		verify(d6).setCellValue("some value");
	}

}
