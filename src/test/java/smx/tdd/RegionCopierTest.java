package smx.tdd;

import static org.mockito.Mockito.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import smx.tdd.RegionCopier.AreaReferenceProvider;
import static smx.tdd.Position.*;

@RunWith(MockitoJUnitRunner.class)
public class RegionCopierTest {

	@Mock
	private Workbook workbook;
	@Mock
	private Name name;
	@Mock
	private AreaReferenceProvider areaReferenceProvider;
	@Mock
	private AreaReferenceCopier areaReferenceCopier;
	@Mock
	private AreaReference areaReference;
	@Mock
	private CellReference cell;

	@Before
	public void setUp() {
		when(workbook.getName("range_name")).thenReturn(name);
		when(areaReferenceProvider.get(name)).thenReturn(areaReference);
		when(areaReference.getFirstCell()).thenReturn(cell);
		when(cell.getRow()).thenReturn(2);
		when(cell.getCol()).thenReturn((short) 3);
	}

	@Test
	public void puedoCopiarUnaRegion() {
		RegionCopier namedRegionCopier = new RegionCopier(areaReferenceProvider, areaReferenceCopier);
		namedRegionCopier.copy(workbook, "range_name", position(7, 5));

		verify(areaReferenceCopier).copyDelta(workbook, areaReference, 5, 2);
	}

}
