package smx.tdd;

import static org.mockito.Mockito.*;
import static smx.tdd.Position.position;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AreaReferenceCopierTest {

	@Mock
	private Workbook workbook;
	@Mock
	private Sheet sheet;
	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private AreaReference areaReference;
	@Mock
	private CellReference cell1;
	@Mock
	private CellReference cell2;
	@Mock
	private CellCopier cellCopier;

	@Before
	public void setUp() {
		when(cell1.getRow()).thenReturn(1);
		when(cell1.getCol()).thenReturn((short) 3);
		when(cell2.getRow()).thenReturn(2);
		when(cell2.getCol()).thenReturn((short) 3);
		when(areaReference.getAllReferencedCells()).thenReturn(new CellReference[] { cell1, cell2 });

		when(areaReference.getFirstCell().getSheetName()).thenReturn("someSheet");
		when(workbook.getSheet("someSheet")).thenReturn(sheet);
	}

	@Test
	public void puedoCopiarTodasLasCeldasDeUnRangoContiguo() {
		AreaReferenceCopier areaReferenceCopier = new AreaReferenceCopier(cellCopier);
		areaReferenceCopier.copyDelta(workbook, areaReference, 3, 7);

		verify(cellCopier).copy(sheet, position(1, 3), position(4, 10));
		verify(cellCopier).copy(sheet, position(2, 3), position(5, 10));
	}

}
