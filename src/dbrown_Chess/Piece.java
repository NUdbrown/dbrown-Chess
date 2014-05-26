package dbrown_Chess;

import java.util.ArrayList;

public abstract class Piece {
	
	
	private String pieceType;
	private String pieceColor;
	private String pieceTypeCode;
	private String pieceColorCode;
	


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