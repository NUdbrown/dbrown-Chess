package dbrown_Chess;

public class Position {

	private int row;
	private int col;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public Position(int row, int column){
		this.row = row;
		this.col = column;
	}
	public Position(char theRow, char theCol){
				
		this.row = 7 - (theRow -'1');
		this.col = theCol - 'a';		
	}
	
//	public static void main (String[]args){
//		Position pos = new Position('1','a');
//		System.out.println("Row : "+ pos.getRow() + "\nCol: " + pos.getCol()) ;
//		Position pos1 = new Position('8','h');
//		System.out.println("Row : "+ pos1.getRow() + "\nCol: " + pos1.getCol()) ;
//	}
	
}
