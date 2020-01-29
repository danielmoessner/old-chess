package sample.pieces;


import javafx.scene.image.WritableImage;
import sample.Chess;

public class Rook extends Piece {

    public Rook(int x, int y, PieceColor pieceColor, Chess chess) {
        super(x, y, PieceType.rook, pieceColor, chess);
        this.steps = 8;
        if (pieceColor == PieceColor.white)
            this.image = new WritableImage(pieces.getPixelReader(), 333 * 4 + 1, 0, 330, 330);
        if (pieceColor == PieceColor.black)
            this.image = new WritableImage(pieces.getPixelReader(), 333 * 4 + 1, 330, 330, 330);
    }

    public void move(int newX, int newY) {
        if (x != newX && y != newY)
            return;
        super.move(newX, newY);
        stepsMade = true;
    }

}
