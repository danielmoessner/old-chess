package sample.pieces;

import javafx.scene.image.WritableImage;
import sample.Chess;

public class Queen extends Piece {

    public Queen(int x, int y, PieceColor pieceColor, Chess chess) {
        super(x, y, PieceType.queen, pieceColor, chess);
        this.steps = 8;
        if (pieceColor == PieceColor.white) this.image = new WritableImage(pieces.getPixelReader(), 333, 0, 330, 330);
        if (pieceColor == PieceColor.black) this.image = new WritableImage(pieces.getPixelReader(), 333, 330, 330, 330);
    }

    public void move(int newX, int newY) {
        if (Math.abs(newX - x) != Math.abs(newY - y))
            if (x != newX && y != newY)
                return;
        super.move(newX, newY);
    }
}
