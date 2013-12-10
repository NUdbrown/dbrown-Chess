package dbrown_Chess;

import java.util.ArrayList;

public class Pawn extends Piece{

	private final int ROW_LENGTH = 8;
	private final int COL_LENGTH = 8;

	public Pawn(String pieceType, String pieceColor, String pieceTypeCode, String pieceColorCode) {
		super(pieceType, pieceColor, pieceTypeCode, pieceColorCode);
	}

	@Override
	public ArrayList<Position> getMoves(Position thePosition, Board theBoard) {
		ArrayList<Position> validMoves = new ArrayList<Position>();
		addUnoccupiedPosition(thePosition.getRow()+1, thePosition.getCol(), theBoard, validMoves);
		addUnoccupiedPosition(thePosition.getRow()+2, thePosition.getCol(), theBoard, validMoves);
		addUnoccupiedPosition(thePosition.getRow()-1, thePosition.getCol(), theBoard, validMoves);
		addUnoccupiedPosition(thePosition.getRow()-2, thePosition.getCol(), theBoard, validMoves);
		
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
