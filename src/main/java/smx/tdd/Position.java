package smx.tdd;

import java.util.Objects;

public class Position {

	private final int rowIndex;
	private final int columnIndex;

	public Position(int rowIndex, int columnIndex) {
		this.columnIndex = columnIndex;
		this.rowIndex = rowIndex;
	}

	public int getColumnIndex() {
		return columnIndex;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public static Position position(int rowIndex, int columnIndex) {
		return new Position(rowIndex, columnIndex);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.rowIndex, this.columnIndex);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		return Objects.equals(this.rowIndex, other.rowIndex) && //
				Objects.equals(this.columnIndex, other.columnIndex);
	}

	@Override
	public String toString() {
		return "Position [rowIndex=" + rowIndex + ", columnIndex=" + columnIndex + "]";
	}

}
