package dbrown_Chess;

import java.util.ArrayList;

public class Pawn extends Piece{

	private final int ROW_LENGTH = 8;
	private final int COL_LENGTH = 8;
	private boolean firstMove = true;

	public Pawn(String pieceType, String pieceColor, String pieceTypeCode, String pieceColorCode) {
		super(pieceType, pieceColor, pieceTypeCode, pieceColorCode);
	}

	@Override
	public ArrayList<Position> getMoves(Position thePosition, Board theBoard) {
		ArrayList<Position> validMoves = new ArrayList<Position>();
		int direction = 1;
		if (this.getPieceColorCode().equals("l")) direction = -1;

		if(firstMove){
			addAvailablePosition(thePosition.getRow() + (direction * 2),thePosition.getCol(), theBoard, validMoves, false);
		}
		addAvailablePosition(thePosition.getRow() + (direction * 1),thePosition.getCol(), theBoard, validMoves, false);
		addAvailablePosition(thePosition.getRow() + (direction * 1),thePosition.getCol() + 1, theBoard, validMoves, true);
		addAvailablePosition(thePosition.getRow() + (direction * 1),thePosition.getCol() - 1, theBoard, validMoves, true);
		
		firstMove = false;
		return validMoves;
	}

	private void addAvailablePosition(int row, int col, Board theBoard,ArrayList<Position> validMoves, boolean isCapturable) {
		
		if(row >= 0 && row < ROW_LENGTH && col >= 0 && col < COL_LENGTH){
			Position newPosition = new Position(row, col);
			if(theBoard.hasPiece(newPosition)){
				if(theBoard.getPiece(newPosition).getPieceColorCode()!= this.getPieceColorCode()&&isCapturable){
					validMoves.add(newPosition);
				}
			}		
			else {
				validMoves.add(newPosition);
			}
			
		}
	}
	


}
