package dbrown_Chess;

public class Move {
    private Position source;
    private Position destination;

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



}
