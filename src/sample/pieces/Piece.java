package sample.pieces;

import javafx.scene.image.*;
import sample.Chess;

public abstract class Piece {

    public int x, y;
    public int steps;
    public final PieceColor pieceColor;
    public final PieceType pieceType;
    public Image image;
    public boolean stepsMade;
    Chess chess;

    static Image pieces = new Image("/res/Chess_Pieces_2.png");


    public Piece(int x, int y, PieceType pt, PieceColor pieceColor, Chess chess) {
        if (x > 8 || y > 8 || x < 1 || y < 1)
            x = y = 1;
        this.x = x;
        this.y = y;
        this.pieceColor = pieceColor;
        this.chess = chess;
        this.stepsMade = false;
        this.pieceType = pt;
    }


    public boolean isWayBlocked(int newX, int newY){
        if (pieceType==PieceType.knight)
            return false;

        int x_col = x, y_col = y;
        for (int i = 0; i < Math.max(Math.abs(newY - y), Math.abs(newX - x))-1; i++) {
            if ((newY - y) < 0)
                y_col--;
            else if ((newY - y) > 0)
                y_col++;
            if ((newX - x) < 0)
                x_col--;
            else if ((newX - x) > 0)
                x_col++;
            if (chess.getPiece(x_col, y_col) != null) {
                return true;
            }
        }
        return false;
    }

    public void move(int newX, int newY) {
        if (Math.abs(newY - y) > steps || Math.abs(newX - x) > steps)
            return;

        try {
            if (chess.getPiece(newX, newY).pieceColor == this.pieceColor)
                return;
        } catch (NullPointerException ex) {
            //Continue
        }

        if (isWayBlocked(newX, newY))
            return;

        x = newX;
        y = newY;

        chess.moved = true;
    }

    public void chuck(){
        for(int i = 0; i< chess.pieces.size(); i++){
            if(this.x==chess.pieces.get(i).x && this.y==chess.pieces.get(i).y  && this.pieceColor != chess.pieces.get(i).pieceColor){
                chess.pieces.remove(chess.pieces.get(i));
            }
        }
    }

}
