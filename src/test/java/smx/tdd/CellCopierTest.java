package smx.tdd;

import static org.mockito.Mockito.*;
import static smx.tdd.Position.position;

import org.apache.poi.ss.usermodel.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CellCopierTest {

	@Mock
	private Sheet sheet;
	@Mock
	private Row rowOrigen;
	@Mock
	private Row rowDestino;
	@Mock
	private Cell celdaOrigen;
	@Mock
	private Cell celdaDestino;
	private CellCopier cellCopier;

	@Before
	public void setUp() {
		when(celdaOrigen.getStringCellValue()).thenReturn("some value");
		cellCopier = new CellCopier();
	}

	@Test
	public void puedoCopiarUnaCeldaHaciaUnaRowQueNoExiste() {
		when(sheet.getRow(1)).thenReturn(rowOrigen);
		when(rowOrigen.getCell(2)).thenReturn(celdaOrigen);

		when(sheet.getRow(3)).thenReturn(null);
		when(sheet.createRow(3)).thenReturn(rowDestino);
		when(rowDestino.createCell(5)).thenReturn(celdaDestino);

		cellCopier.copy(sheet, position(1, 2), position(3, 5));

		verify(celdaDestino).setCellValue("some value");
	}

	@Test
	public void puedoCopiarUnaCeldaHaciaUnaRowQueExiste() {
		when(sheet.getRow(1)).thenReturn(rowOrigen);
		when(rowOrigen.getCell(2)).thenReturn(celdaOrigen);

		when(sheet.getRow(3)).thenReturn(rowDestino);
		when(rowDestino.createCell(5)).thenReturn(celdaDestino);

		cellCopier.copy(sheet, position(1, 2), position(3, 5));

		verify(celdaDestino).setCellValue("some value");
	}

}
