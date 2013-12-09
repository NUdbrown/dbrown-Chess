package dbrown_Chess;

public class PlayAround {
	private static final int BOARD_SIZE = 8;
	private static final Piece BOARD[][] = new Piece[BOARD_SIZE][BOARD_SIZE];
	
	public static void main(String[]args)
	{
		PlayAround play = new PlayAround();
		
	}

	public PlayAround() {
		init();
		placePiece('c','5', new Bishop("Bishop", "Light", "b", "l"));
		print();
		getPiece();

	}
	
	public static  String boardLetter(int letter)
	{
		String boardLetter= (char)((int) 'a' + letter) + "";
		return boardLetter;
	}
	
	public static String boardNumber(int number)
	{
		String boardNumber = BOARD_SIZE - number + "";
		return boardNumber;
	}
	
	public static int getColumn(char letter) {
		return (int) (letter - 'a');
	}
	
	public static int getRow(char letter) {
		return BOARD_SIZE + 1 - (letter - '0');
	}
	
	public static void init() {

		for (int x = 0; x <= BOARD_SIZE - 1; x++) {

			for (int y = 0; y <= BOARD_SIZE - 1; y++) {
				BOARD[x][y] = null;
			}
		}
	}
	
	public static void placePiece(char col, char row, Piece thePiece)
	{
		int c = getColumn(col);
		int r = getRow(row);
		System.out.println(c+ ","+r);
		BOARD[getColumn(col)][getRow(row)] = thePiece;
	}
	
	public static void getPiece(){
		
	}
	

	public static void print() {

		for (int letters = 0; letters <= BOARD_SIZE - 1; letters++) {
			System.out.print("   " + (char) ((int) 'b' + letters - 1) + " ");
		}
		System.out.println();
		for (int x = 0; x <= BOARD_SIZE - 1; x++) {
			System.out.print(BOARD_SIZE - x + " ");

			for (int y = 0; y <= BOARD_SIZE - 1; y++) {
				Piece piece = BOARD[x][y];
				if(piece == null)
				{
					System.out.print("[" + "--" + "] ");
				}
				else
				System.out.print("[" + piece.getPieceTypeCode() + piece.getPieceColorCode() + "] ");

			}
			System.out.println();

		}
		System.out.println();

	}
}
