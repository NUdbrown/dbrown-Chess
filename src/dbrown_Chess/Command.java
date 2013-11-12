package dbrown_Chess;

public class Command {

	private String pieceSquare;
	private String destinationSquare;
	private String possiblePiece;
	private String possiblePieceColor;
	private String possiblePieceCode;
	private String possibleColorCode;
	CommandType typeCommand;
	
	
	public enum CommandType {
		CAPTURE, MOVE, DOUBLE_MOVE, PLACEMENT;
	}
	
	
	
	public Command(String piece, String pieceColor, String destinationSquare,String possiblePieceCode,String possibleColorCode, CommandType typeCommand)
	{
		
		this.possiblePiece = piece;
		this.destinationSquare = destinationSquare;
		this.typeCommand = typeCommand;
		this.possiblePieceCode = possiblePieceCode;
		this.possibleColorCode = possibleColorCode;
	}
	
	public Command(String pieceSquare, String destinationSquare, CommandType typeCommand)
	{
		this.pieceSquare = pieceSquare;
		this.destinationSquare = destinationSquare;
		this.typeCommand = typeCommand;
		
		
	}
	
	
	
	
	public String getPiece() {
		return possiblePiece;
	}
	public void setPiece(String piece) {
		this.possiblePiece = piece;
	}
	public String getPieceSquare() {
		return pieceSquare;
	}
	public void setPieceSquare(String pieceSquare) {
		this.pieceSquare = pieceSquare;
	}



	public String getDestinationSquare() {
		return destinationSquare;
	}



	public void setDestinationSquare(String destinationSquare) {
		this.destinationSquare = destinationSquare;
	}

	public String getPossiblePieceColor() {
		return possiblePieceColor;
	}

	public void setPossiblePieceColor(String possiblePieceColor) {
		this.possiblePieceColor = possiblePieceColor;
	}

	public String getPossiblePieceCode() {
		return possiblePieceCode;
	}

	public void setPossiblePieceCode(String possiblePieceCode) {
		this.possiblePieceCode = possiblePieceCode;
	}

	public String getPossibleColorCode() {
		return possibleColorCode;
	}

	public void setPossibleColorCode(String possibleColorCode) {
		this.possibleColorCode = possibleColorCode;
	}
	
}
