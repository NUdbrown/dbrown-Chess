package dbrown_Chess;

import javafx.geometry.Pos;

public class Move {
    private Position source;
    private Position destination;
    private Position source2;
    private Position destination2;

    public Move(Position source, Position destination) {
        this.source = source;
        this.destination = destination;
    }

    public Position getSource() {
        return source;
    }

    public Position getDestination() {
        return destination;
    }

    public Move(Position source, Position destination, Position source2, Position destination2) {
        this.source = source;
        this.destination = destination;
        this.source2 = source2;
        this.destination2 = destination2;
    }

    public Position getSource2() {
        return source2;
    }

    public Position getDestination2() {
        return destination2;
    }


}
