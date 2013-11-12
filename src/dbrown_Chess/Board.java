package dbrown_Chess;
import java.util.HashMap;
import java.util.Map;

public class Board {

	static final int BOARD_SIZE = 8;
	static final int PIECE_COUNT = 32;
	static String boardLetter;
	static String boardNumber;
	static String square;
	Map<String, Piece> chessPieces;

	public Board() {
		chessPieces = new HashMap<String, Piece>();
		init();

	}

	public void init() {

		for (int x = 0; x <= BOARD_SIZE - 1; x++) {

			for (int y = 0; y <= BOARD_SIZE - 1; y++) {

				boardLetter = (char) ((int) 'a' + y) + "";
				boardNumber = BOARD_SIZE - x + "";
				square = boardLetter + boardNumber;
				chessPieces.put(square, null);

			}

		}

	}

	public void print() {

		for (int letters = 0; letters <= BOARD_SIZE - 1; letters++) {
			System.out.print("   " + (char) ((int) 'b' + letters - 1) + " ");
		}
		System.out.println();
		for (int x = 0; x <= BOARD_SIZE - 1; x++) {
			System.out.print(BOARD_SIZE - x + " ");

			for (int y = 0; y <= BOARD_SIZE - 1; y++) {

				boardLetter = (char) ((int) 'a' + y) + "";
				boardNumber = BOARD_SIZE - x + "";
				square = boardLetter + boardNumber;
				Piece piece = chessPieces.get(square);
				if(piece == null)
				{
					System.out.print("[" + "--" + "] ");
				}
				else
				System.out.print("[" + piece.getPieceColorCode()+piece.getPieceTypeCode() + "] ");

			}
			System.out.println();

		}
		System.out.println();

	}

	// make default method that places pieces in there orginal spot.

}