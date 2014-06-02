package dbrown_Chess;

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class Board {

	private static final int BOARD_SIZE = 8;
	private Piece [][] BOARD;
	private boolean isLightTurn = true;

	public Board() {
		BOARD = new Piece[BOARD_SIZE][BOARD_SIZE];
		init();

	}
	
	public String boardLetter(int letter)
	{
		String boardLetter= (char)('a' + letter) + "";
		return boardLetter;
	}
	
	public Piece[][] getBOARD(){
		return BOARD;
	}
	
	public String boardNumber(int number)
	{
		String boardNumber = BOARD_SIZE - number + "";
		return boardNumber;
	}
	
	public static int getColumn(char letter) {
		return letter - 'a';
	}
	
	public static int getRow(char letter) {
		return BOARD_SIZE - (letter - '0');
	}
	
	public void init() {

		for (int x = 0; x < BOARD_SIZE; x++) {

			for (int y = 0; y < BOARD_SIZE; y++) {
				BOARD[x][y] = null;
			}

		}

	}
	
	public void print() {

		for (int letters = 0; letters < BOARD_SIZE; letters++) {
			System.out.print("   " + (char) ('b' + letters - 1) + " ");
		}
		System.out.println();
		for (int x = 0; x < BOARD_SIZE; x++) {
			System.out.print(BOARD_SIZE - x + " ");

			for (int y = 0; y < BOARD_SIZE; y++) {
				Piece piece = BOARD[x][y];
				if(piece == null)
				{
					System.out.print("[" + "__" + "] ");
				}
				else
				System.out.print("[" + piece.getPieceColorCode().toUpperCase() + piece.getPieceTypeCode().toUpperCase() + "] ");

			}
			System.out.println();

		}
		System.out.println();

	}
	
	public void placePiece(char row, char col, Piece thePiece)
	{
		BOARD[getRow(row)][getColumn(col)] = thePiece;
	}
	
	
	public void makeMove(Move theMove){
		Piece thePiece = BOARD[theMove.getSource().getRow()][theMove.getSource().getCol()];
		if(thePiece != null){
			if(thePiece.isValidMove(theMove, this)){
				BOARD[theMove.getSource().getRow()][theMove.getSource().getCol()] = null;
				BOARD[theMove.getDestination().getRow()][theMove.getDestination().getCol()] = thePiece;
				thePiece.setMoved();
			}
		}
		

	}
	
	public Piece getPiece(Position thePosition){
		return BOARD[thePosition.getRow()][thePosition.getCol()];	
	}
	
	public boolean hasPiece(Position thePosition) {
		return getPiece(thePosition) != null;
	}
	
	public void removePiece(Piece thePiece, Position thePosition){
		thePiece = BOARD[thePosition.getRow()][thePosition.getCol()];
		Piece temp = thePiece;
		temp = null;		
	}


	public void turnTaking(Move theMove) {
		Piece pieceToMove = getPiece(theMove.getSource());

		if (isLightTurn) {
			if (pieceToMove.getPieceColor().equals("light")) {
				makeMove(theMove);
				isLightTurn = false;
				checkForCheck(theMove);

			} else {
				System.out.println("It is not your turn!");
			}	

		}

		else {
			if (pieceToMove.getPieceColor().equals("dark")) {
				makeMove(theMove);
				isLightTurn = true;
				checkForCheck(theMove);
			} else {
				System.out.println("It is not your turn!");
			}

		}
		
	}
	
	/**go through every one of piece's (param) moves list
	*see if there is a piece at the other end
	* if that piece is a king && that kind's color != piece (param)'s color
	* piece can attack king
	**/ 
	
	public boolean checkForKingCapture(Piece thePiece, Position pos){
		boolean canCaptureKing = false;
		
		for(Position p: thePiece.getMoves(pos, this)){
			if(hasPiece(p)){
				Piece endPiece = getPiece(p);
				if(endPiece instanceof King && !endPiece.getPieceColor().equals(thePiece.getPieceColor())){
					canCaptureKing = true;
					System.out.println(thePiece.getPieceColor().toUpperCase()+" "+thePiece.getPieceType()+" can attack "+ endPiece.getPieceColor().toUpperCase() +" King!");
				}
					
			}
			
		}		
		
		return canCaptureKing;
	}
	
	public boolean checkForCheck(Move theMove){
		boolean isInCheck = false;
		Position kingPos = null;
	
		if(checkForKingCapture(getPiece(theMove.getDestination()), theMove.getDestination())){
			isInCheck = true;
			System.out.println("Is in Check!");
		}
		return isInCheck;
	}
	
	
//	public boolean checkForCheck(String color, Board theBoard){
//		Boolean inCheck = false;
//		ArrayList<Piece> boardPieces = new ArrayList<Piece>();
//		Position kingPosition = getKingsLocation();
//
//		for(Position pos : positionsOnTheBoard()){
//			if(hasPiece(pos)){
//				Piece p = getPiece(pos);
//				if(!p.getPieceColor().equals(color)){
//					ArrayList<Position> listOfMoves = p.getMoves(pos, this);
//					for(Position destinPos : listOfMoves){
//						if(destinPos.equals(kingPosition)){
//							inCheck = true;
//							System.out.println(color.toUpperCase() + " King is in check");
//						}
//					}
//				}
//			}
//		}
//
//		return inCheck;	
//
//	}		
//
//	public Position getKingsLocation(String color){
//		Position kingPos = null;		
//		for(Position p: positionsOnTheBoard()){
//			Piece thePiece = getPiece(p);
//			if(hasPiece(p) && thePiece instanceof King && color.equals(thePiece.getPieceColor())){
//				kingPos = p;						
//				return kingPos;
//			}
//		}
//		{
//			throw new NullPointerException("There aren't any Kings on the Board");
//		}
//
//	}

	public ArrayList<Position> positionsOnTheBoard(){
		ArrayList<Position> boardPositions = new ArrayList<Position>();
		for (int x = 0; x < BOARD_SIZE; x++) {
			for (int y = 0; y < BOARD_SIZE; y++) {
				Position newPos = new Position(x,y);				
				boardPositions.add(newPos);
			}
		}
		return boardPositions;		
	}
	
	public ArrayList<Piece> piecesOnTheBoard(){
		ArrayList<Piece>boardPieces = new ArrayList<Piece>();
		
		for(Position p: positionsOnTheBoard()){
			Piece piece = getPiece(p);
			boardPieces.add(piece);
		}
		
		return boardPieces;
	}

}