package dbrown_Chess;

import java.util.ArrayList;

public class Rook extends Piece{

	private final int ROW_LENGTH = 8;
	private final int COL_LENGTH = 8;
	
	
	public Rook(String pieceType, String pieceColor, String pieceTypeCode,
			String pieceColorCode) {
		super(pieceType, pieceColor, pieceTypeCode, pieceColorCode);
		
	}

	@Override
	public ArrayList<Position> getMoves(Position thePosition, Board theBoard) {
		ArrayList<Position> validMoves = new ArrayList<Position>();
	    
		for(int i = 0; i < ROW_LENGTH; i++){
			addUnoccupiedPosition(thePosition.getRow()+i, thePosition.getCol(), theBoard, validMoves); //moving up the rows
			addUnoccupiedPosition(thePosition.getRow()-i, thePosition.getCol(), theBoard, validMoves); //moving down the rows
			addUnoccupiedPosition(thePosition.getRow(), thePosition.getCol()+i, theBoard, validMoves); //moving across the columns
			addUnoccupiedPosition(thePosition.getRow(), thePosition.getCol()-i, theBoard, validMoves); //moving down across the columns
		}
		return validMoves;
	}
	
	private void addUnoccupiedPosition(int row, int col, Board theBoard,
			ArrayList<Position> validMoves) {
		if(row >= 0 && row < ROW_LENGTH && col >= 0 && col < COL_LENGTH){
			Position newPosition = new Position(row, col);
			if(!theBoard.hasPiece(newPosition)){
				validMoves.add(newPosition);
			}
		}
	}



}
