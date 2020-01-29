package sample.pieces;

import javafx.scene.image.WritableImage;
import sample.Chess;

public class Knight extends Piece {

    public Knight(int x, int y, PieceColor pieceColor, Chess chess) {
        super(x, y, PieceType.knight, pieceColor, chess);
        this.steps = 2;
        if (pieceColor == PieceColor.white)
            this.image = new WritableImage(pieces.getPixelReader(), 333 * 3 + 1, 0, 330, 330);
        if (pieceColor == PieceColor.black)
            this.image = new WritableImage(pieces.getPixelReader(), 333 * 3 + 1, 330, 330, 330);
    }

    public void move(int newX, int newY) {
        if (Math.abs(newX - x) == 1 && Math.abs(newY - y) == 1 || Math.abs(newX - x) == 2 && Math.abs(newY - y) == 2 || Math.abs(newX - x) == 0 || Math.abs(newY - y) == 0)
            return;
        super.move(newX, newY);
    }


}
