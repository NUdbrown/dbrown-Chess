package dbrown_Chess;

import java.util.ArrayList;


public class King extends Piece{

	private final int ROW_LENGTH = 8;
	private final int COL_LENGTH = 8;
	
	public King(String pieceType, String pieceColor, String pieceTypeCode,
			String pieceColorCode) {
		super(pieceType, pieceColor, pieceTypeCode, pieceColorCode);
		
	}

	@Override
	public ArrayList<Position> getMoves(Position thePosition, Board theBoard) {
		ArrayList<Position> validMoves = new ArrayList<Position>();
	    
		addUnoccupiedPosition(thePosition.getRow()+1, thePosition.getCol(), theBoard, validMoves); 
		addUnoccupiedPosition(thePosition.getRow()-1, thePosition.getCol(), theBoard, validMoves); 
		addUnoccupiedPosition(thePosition.getRow(), thePosition.getCol()+1, theBoard, validMoves); 
		addUnoccupiedPosition(thePosition.getRow(), thePosition.getCol()-1, theBoard, validMoves); 
		addUnoccupiedPosition(thePosition.getRow()-1, thePosition.getCol()+1, theBoard, validMoves); 
		addUnoccupiedPosition(thePosition.getRow()-1, thePosition.getCol()-1, theBoard, validMoves); 
		addUnoccupiedPosition(thePosition.getRow()+1, thePosition.getCol()-1, theBoard, validMoves); 
		addUnoccupiedPosition(thePosition.getRow()+1, thePosition.getCol()+1, theBoard, validMoves); 
		
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

	/**
	 * Need to check if there is a piece on the square that is trying to be moved. - done
	 * Need to check to see if there is another piece on the position where the piece is trying to move.
	 * Move the Piece to its new destination based on if it is valid or not.
	 * King can move anywhere only once.
	 */
	

		


}

