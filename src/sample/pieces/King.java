package sample.pieces;

import javafx.scene.image.WritableImage;
import sample.Chess;

public class King extends Piece {

    public King(int x, int y, PieceColor pieceColor, Chess chess) {
        super(x, y, PieceType.king, pieceColor, chess);
        this.steps = 1;
        if (pieceColor == PieceColor.white) this.image = new WritableImage(pieces.getPixelReader(), 0, 0, 330, 330);
        if (pieceColor == PieceColor.black) this.image = new WritableImage(pieces.getPixelReader(), 0, 330, 330, 330);
    }


    public void move(int newX, int newY) {
        if (!stepsMade) {
            if ((newX == 3 || newX == 7) && (newY == 8 || newY == 1) && !checkChess()) {
                try {
                    if (!isWayBlocked(newX, newY) && !chess.getPiece((int) Math.round(1.75 * newX - 4.25), newY).stepsMade) {
                        chess.getPiece((int) Math.round(1.75 * newX - 4.25), newY).x = (int) Math.round(0.5 * newX + 2.5);
                        this.x = newX;
                        chess.moved = true;
                        return;
                    }
                } catch (NullPointerException ex) {
                    return;
                }
            }
        }
        super.move(newX, newY);
        if (x != 5 || (y != 8 && y != 1))
            stepsMade = true;
    }


    public boolean checkChess() {
        return chess.pieces.stream()
                .filter(piece -> piece.pieceColor != pieceColor)
                .map(piece -> {
                    int oldX = piece.x;
                    int oldY = piece.y;
                    piece.move(x,y);
                    if (piece.x != oldX || piece.y != oldY) {
                        piece.x = oldX;
                        piece.y = oldY;
                        chess.moved=false;
                        return true;
                    } else {
                        return false;
                    }
                })
                .reduce(false, (a, b) -> a || b);
    }
}
