package dbrown_Chess;

import java.util.ArrayList;

public abstract class Piece {


    private String pieceType;
    protected String pieceColor;
    protected String pieceTypeCode;
    private String pieceColorCode;
    protected final int ROW_LENGTH = 8;
    protected final int COL_LENGTH = 8;
    protected final int SIZE = 8;
    protected boolean isValid = false;


    public Piece(String pieceType, String pieceColor, String pieceTypeCode, String pieceColorCode) {
        this.pieceType = pieceType; //this.getClass().getSimpleName();
        this.pieceColor = pieceColor; //pieceColorCode.equals("l")?"light":"dark";
        this.pieceTypeCode = pieceTypeCode;
        this.pieceColorCode = pieceColorCode;
    }

    public Piece(String pieceTypeCode, String pieceColorCode) {
        this.pieceTypeCode = pieceTypeCode;
        this.pieceColorCode = pieceColorCode;
    }

    public boolean isValidMove(Move theMove, Board theBoard) {
        ArrayList<Position> listOfMoves = getMoves(theMove.getSource(), theBoard);
        for (Position p : listOfMoves) {
            if (p.equals(theMove.getDestination())) { //remember to account for moving into checkmate.

                return isValid = true;
            }
        }
        System.out.println("Invalid Move");
        return isValid;
    }

    public abstract ArrayList<Position> getMoves(Position thePosition, Board theBoard);

    public void addAvailablePosition(int row, int col, Board theBoard, ArrayList<Position> validMoves) {

        Position newPosition = new Position(row, col);
        addAvailablePosition(newPosition, theBoard, validMoves);
    }

    public void addAvailablePosition(Position newPosition, Board theBoard, ArrayList<Position> validMoves) {

        if (newPosition.isOnBoard() && theBoard.isEmptyOrHasColor(newPosition, theBoard.otherColor(this.pieceColor))) {

            validMoves.add(newPosition);

        }

    }


    public boolean hasSameColor(Piece piece) {
        return this.pieceColorCode.equals(piece.pieceColorCode);
    }

    protected boolean firstMove = true;


    public void setMoved() {
        firstMove = false;
    }

    public void setFirstMove(boolean moved) {
        firstMove = moved;
    }

    public boolean getFirstMove() {
        return firstMove;
    }

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