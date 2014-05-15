package dbrown_Chess;

public class Board {

	private static final int BOARD_SIZE = 8;
	private Piece [][] BOARD;

	public Board() {
		BOARD = new Piece[BOARD_SIZE][BOARD_SIZE];
		init();

	}
	
	public String boardLetter(int letter)
	{
		String boardLetter= (char)((int) 'a' + letter) + "";
		return boardLetter;
	}
	
	public String boardNumber(int number)
	{
		String boardNumber = BOARD_SIZE - number + "";
		return boardNumber;
	}
	
	public static int getColumn(char letter) {
		return (int) (letter - 'a');
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
	
	public void placePiece(char row, char col, Piece thePiece)
	{
		BOARD[getRow(row)][getColumn(col)] = thePiece;
	}
	
	
	public void makeMove(Move theMove){
		Piece thePiece = BOARD[theMove.getSource().getRow()][theMove.getSource().getCol()];
		if(thePiece.isValidMove(theMove, this)){
			BOARD[theMove.getSource().getRow()][theMove.getSource().getCol()] = null;
			BOARD[theMove.getDestination().getRow()][theMove.getDestination().getCol()] = thePiece;
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
	
	
	boolean isLightTurn = true;	
	
	public void turnTaking(Move theMove){
		Piece currentPiece = getPiece(theMove.getSource());
		
		if(isLightTurn){
			if(currentPiece.getPieceColorCode().equals("l")){
				makeMove(theMove);
			}
			
			isLightTurn = !isLightTurn;
						
		}
		else{
			System.out.println("Not your turn!");
		}
		
		if(!isLightTurn){
			if(currentPiece.getPieceColorCode().equals("d")){
				makeMove(theMove);
			}
			
			isLightTurn = true;
		}
		else{
			System.out.println("Not your turn!");
		}
		
		  
		  
		 
	}
	
	
	public void print() {

		for (int letters = 0; letters < BOARD_SIZE; letters++) {
			System.out.print("   " + (char) ((int) 'b' + letters - 1) + " ");
		}
		System.out.println();
		for (int x = 0; x < BOARD_SIZE; x++) {
			System.out.print(BOARD_SIZE - x + " ");

			for (int y = 0; y < BOARD_SIZE; y++) {
				Piece piece = BOARD[x][y];
				if(piece == null)
				{
					System.out.print("[" + "--" + "] ");
				}
				else
				System.out.print("[" + piece.getPieceColorCode() + piece.getPieceTypeCode() + "] ");

			}
			System.out.println();

		}
		System.out.println();

	}


}