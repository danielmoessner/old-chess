package sample.pieces;

import javafx.scene.image.WritableImage;
import sample.Chess;

public class Bishop extends Piece {
    public Bishop(int x, int y, PieceColor pieceColor, Chess chess) {
        super(x, y, PieceType.bishop, pieceColor, chess);
        this.steps = 8;
        if (pieceColor == PieceColor.white)
            this.image = new WritableImage(pieces.getPixelReader(), 333 * 2 + 1, 0, 330, 330);
        if (pieceColor == PieceColor.black)
            this.image = new WritableImage(pieces.getPixelReader(), 333 * 2 + 1, 330, 330, 330);
    }

    public void move(int newX, int newY) {
        if (Math.abs(newX - x) != Math.abs(newY - y))
            return;
        super.move(newX, newY);
    }
}
