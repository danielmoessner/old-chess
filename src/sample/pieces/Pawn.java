package sample.pieces;

import javafx.scene.image.WritableImage;
import sample.Chess;

public class Pawn extends Piece {
    public Pawn(int x, int y, PieceColor pieceColor, Chess chess) {
        super(x, y, PieceType.pawn, pieceColor, chess);
        steps = 1;
        if (pieceColor == PieceColor.white)
            this.image = new WritableImage(pieces.getPixelReader(), 333 * 5, 0, 330, 330);
        if (pieceColor == PieceColor.black)
            this.image = new WritableImage(pieces.getPixelReader(), 333 * 5, 330, 330, 330);
    }

    public void move(int newX, int newY) {
        if (y == 2 || y == 7)
            steps = 2;

        if (pieceColor == PieceColor.white)
            if (y <= newY)
                return;
        if (pieceColor == PieceColor.black)
            if (y >= newY)
                return;

        if (x != newX && (chess.getPiece(newX, newY) == null || Math.abs(newX - x) > 1 || Math.abs(newY - y) > 1)) {
            return;
        }

        if (x == newX && (chess.getPiece(newX, newY) != null))
            return;

        super.move(newX, newY);
        steps = 1;
    }
}
