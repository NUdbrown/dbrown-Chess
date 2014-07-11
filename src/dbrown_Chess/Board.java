package dbrown_Chess;

import java.awt.List;
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
	
	public Position getPositionOfPiece(Piece piece){
		Position piecePos = null;
		for(Position p: positionsOnTheBoard()){
			if(hasPiece(p) && getPiece(p).equals(piece)){
				return piecePos = p;
			}
		}
		
		return piecePos;
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
				checkForKingCapture(pieceToMove, theMove.getDestination());
				

			} else {
				System.out.println("It is not your turn!");
			}	

		}

		else {
			if (pieceToMove.getPieceColor().equals("dark")) {
				makeMove(theMove);
				isLightTurn = true; 
				checkForKingCapture(pieceToMove, theMove.getDestination());
					
				
				
			} else {
				System.out.println("It is not your turn!");
			}

		}
		
	}
	
	public boolean isInCheck(String color){
		boolean check = false;
		for(Piece p: piecesOnTheBoard()){
			if(p.getPieceColor().equals(color)){
				if(checkForKingCapture(p, getPositionOfPiece(p))){
					check = true;
				}
			}
		}	
		
		return check;
	}
	
	public boolean checkForKingCapture(Piece thePiece, Position pos){
		boolean canCaptureKing = false;
		
		for(Position p: thePiece.getMoves(pos, this)){
			if(hasPiece(p)){
				Piece endPiece = getPiece(p);
				if(endPiece instanceof King && !endPiece.getPieceColor().equals(thePiece.getPieceColor())){
					canCaptureKing = true;
					System.out.println(thePiece.getPieceColor().toUpperCase()+" "+thePiece.getPieceType()+" can attack "+ endPiece.getPieceColor().toUpperCase() +" King!");
					System.out.println("Is in check!");
				}
				 
					
			}
			
		}		
		
		return canCaptureKing;
	}
	
	public String currentTurnColor(){
		String color = isLightTurn ? "light" : "dark";
		return color;
	}
	// Save the destination piece
	// make move
	// see if we are in check
	// unmake move
	// if we were not in check return false 		
	
	public boolean checkForCheckmate(String color){
		
		for(Piece p: piecesOnTheBoard()){
			if(p.getPieceColor().equals(color)){
				for(Position des: p.getMoves(getPositionOfPiece(p), this)){
					Move move = new Move(getPositionOfPiece(p), des);
					boolean firstMove = p.getFirstMove();
					Piece savedPiece = BOARD[move.getDestination().getRow()][move.getDestination().getCol()];
					makeMove(move);
					boolean check = isInCheck(otherColor(color));						
					unMakeMove(move, savedPiece, firstMove);
						
						if(!check){
							return false;
						}
									
					
				}
				
			}
			
		}
		System.out.println("CheckMate!");
		return true;
	}
	
	public void unMakeMove(Move theMove, Piece savedPiece, boolean wasMoved) {
		Piece thePiece = BOARD[theMove.getDestination().getRow()][theMove.getDestination().getCol()];
		BOARD[theMove.getSource().getRow()][theMove.getSource().getCol()] = thePiece;
		BOARD[theMove.getDestination().getRow()][theMove.getDestination().getCol()] = savedPiece;
		thePiece.setFirstMove(wasMoved);

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
	
	public ArrayList<Piece> piecesOnTheBoard(){
		ArrayList<Piece>boardPieces = new ArrayList<Piece>();
		
		for(Position p: positionsOnTheBoard()){
			if(hasPiece(p)){
				boardPieces.add(getPiece(p));
			}	
			
		}
		return boardPieces;
	}
	
//	public Position kingPosition(){
//		Position kingPos = null;
//		for(Position p: positionsOnTheBoard()){
//			if(hasPiece(p) && getPiece(p) instanceof King){
//				return kingPos = p;
//			}
//		}
//		
//		return kingPos;
//	}
	
	public String otherColor(String color){
		if(color.equals("light")){
			color = "dark";
		}
		else if(color.equals("dark")){
			color = "light";
		}
		
		return color;
	}


	public boolean isEmptyOrHasColor(Position targetPos, String otherColor) {
		
		return hasPiece(targetPos) && getPiece(targetPos).getPieceColor().equals(otherColor) || !hasPiece(targetPos);
	}





}