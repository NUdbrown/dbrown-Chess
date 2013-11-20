package dbrown_Chess;

public class Piece {
	
	
	private String pieceType;
	private String pieceColor;
	private String pieceTypeCode;
	private String pieceColorCode;
	


public Piece(String pieceType, String pieceColor, String pieceTypeCode, String pieceColorCode) {
		this.pieceType = pieceType;
		this.pieceColor = pieceColor;
		this.pieceTypeCode = pieceTypeCode;
		this.pieceColorCode = pieceColorCode;
	}
public Piece(String pieceTypeCode, String pieceColorCode){
	this.pieceTypeCode = pieceTypeCode;
	this.pieceColorCode = pieceColorCode;
}

//public void move(Board theboard){
//
//	Command comand = Command
//	theboard.placePiece(Command.getDestinColumn(), command.getDestinRow() , piece);
//}

public String getPieceColor() {
	return pieceColor;
}


public void setPieceColor(String pieceColor) {
	this.pieceColor = pieceColor;
}


public String getPieceType() {
	return pieceType;
}


public void setPieceType(String pieceType) {
	this.pieceType = pieceType;
}


public String getPieceColorCode() {
	return pieceColorCode;
}


public void setPieceColorCode(String pieceColorCode) {
	this.pieceColorCode = pieceColorCode;
}


public String getPieceTypeCode() {
	return pieceTypeCode;
}


public void setPieceTypeCode(String pieceTypeCode) {
	this.pieceTypeCode = pieceTypeCode;
}


}