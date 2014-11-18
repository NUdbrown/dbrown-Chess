package dbrown_Chess;

import java.util.ArrayList;


public class Bishop extends Piece {


    public Bishop(String pieceType, String pieceColor, String pieceTypeCode, String pieceColorCode) {
        super(pieceType, pieceColor, pieceTypeCode, pieceColorCode);
    }

    @Override
    public ArrayList<Position> getMoves(Position thePosition, Board theBoard) {
        ArrayList<Position> validMoves = new ArrayList<Position>();

        boolean foundPiece = false;
        for (int i = 1; !foundPiece && (i < SIZE); i++) {
            Position targetPos = new Position(thePosition.getRow() + i, thePosition.getCol() + i);
            if (targetPos.isOnBoard()) {
                addAvailablePosition(targetPos, theBoard, validMoves);

                if (theBoard.isPieceAtPosition(targetPos) && !thePosition.equals(targetPos)) {
                    break;

                }

            }
        }

        for (int i = 1; !foundPiece && (i < SIZE); i++) {
            Position targetPos = new Position(thePosition.getRow() + i, thePosition.getCol() - i);
            if (targetPos.isOnBoard()) {
                addAvailablePosition(targetPos, theBoard, validMoves);

                if (theBoard.isPieceAtPosition(targetPos) && !thePosition.equals(targetPos)) {
                    break;
                }

            }
        }

        for (int i = 1; !foundPiece && (i < SIZE); i++) {
            Position targetPos = new Position(thePosition.getRow() - i, thePosition.getCol() + i);
            if (targetPos.isOnBoard()) {
                addAvailablePosition(targetPos, theBoard, validMoves);

                if (theBoard.isPieceAtPosition(targetPos) && !thePosition.equals(targetPos)) {
                    break;
                }

            }
        }

        for (int i = 1; !foundPiece && (i < SIZE); i++) {
            Position targetPos = new Position(thePosition.getRow() - i, thePosition.getCol() - i);
            if (targetPos.isOnBoard()) {
                addAvailablePosition(targetPos, theBoard, validMoves);

                if (theBoard.isPieceAtPosition(targetPos) && !thePosition.equals(targetPos)) {
                    break;
                }

            }
        }

        return validMoves;
    }


}
