package dbrown_Chess;

import java.util.ArrayList;

public abstract class Piece {
	
	
	private String pieceType;
	private String pieceColor;
	private String pieceTypeCode;
	private String pieceColorCode;
	private final int ROW_LENGTH = 8;
	private final int COL_LENGTH = 8;
	


public Piece(String pieceType, String pieceColor, String pieceTypeCode, String pieceColorCode) {
		this.pieceType = pieceType; //this.getClass().getSimpleName();
		this.pieceColor = pieceColor; //pieceColorCode.equals("l")?"light":"dark";
		this.pieceTypeCode = pieceTypeCode;
		this.pieceColorCode = pieceColorCode;
	}
public Piece(String pieceTypeCode, String pieceColorCode){
	this.pieceTypeCode = pieceTypeCode;
	this.pieceColorCode = pieceColorCode;
}

public boolean isValidMove(Move theMove, Board theBoard){
	ArrayList<Position> listOfMoves = getMoves(theMove.getSource(), theBoard);
	for( Position p: listOfMoves ){
		if(p.equals(theMove.getDestination())){
			return true;
		}
	}
	System.out.println("Invalid Move");
	return false;
	
}

public abstract ArrayList<Position> getMoves(Position thePosition, Board theBoard); 

public void addAvailablePosition(int row, int col, Board theBoard,ArrayList<Position> validMoves, boolean isCapturable) {
	
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

public String getPieceColor() {
	return pieceColor;
}

public String getPieceType() {
	return pieceType;
}

public String getPieceColorCode() {
	return pieceColorCode;
}


public String getPieceTypeCode() {
	return pieceTypeCode;
}


}