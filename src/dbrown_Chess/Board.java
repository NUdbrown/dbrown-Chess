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

			} else {
				System.out.println("It is not your turn!");
			}	

		}

		else {
			if (pieceToMove.getPieceColor().equals("dark")) {
				makeMove(theMove);
				isLightTurn = true;

			} else {
				System.out.println("It is not your turn!");
			}

		}

	}
	
	public boolean checkForCheck(String color, Board theBoard){
		Boolean inCheck = false;
		ArrayList<Piece> boardPieces = new ArrayList<Piece>();
		Position kingPosition = getKingsLocation(color);

		for(Position pos : positionsOnTheBoard()){
			if(hasPiece(pos)){
				Piece p = getPiece(pos);
				if(!p.getPieceColor().equals(color)){
					for(Position destinPos : p.getMoves(pos, theBoard)){
						if(destinPos.equals(kingPosition)){
							inCheck = true;
						}
					}
				}
			}
		}

		return inCheck;	

	}		
	
	public Position getKingsLocation(String color){
		Position kingPos = null;		
		for(Position p: positionsOnTheBoard()){
			Piece thePiece = getPiece(p);
			if(hasPiece(p) && thePiece instanceof King && color.equals(thePiece.getPieceColor())){
				kingPos = p;						
				return kingPos;
			}
		}
		{
			throw new NullPointerException("There aren't any Kings on the Board");
		}

	}

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

}