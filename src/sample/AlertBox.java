package sample;

import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.pieces.*;

public class AlertBox {

    public static void display(String text, Stage owner) {
        Label label = new Label();
        label.setPrefSize(200, 200);
        label.setFont(new Font(30));
        label.setTextFill(Color.BLACK);
        label.setAlignment(Pos.BASELINE_CENTER);
        label.setStyle("-fx-border-Color: #000000; -fx-font-Color: #000000;");

        VBox box = new VBox();
        box.setStyle("-fx-border-width: 3; -fx-border-color: #000000; -fx-background-color: #61210B");
        box.getChildren().add(label);
        box.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(box, 200, 150);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOnCloseRequest(Event::consume);
        stage.getIcons().add(new Image("/res/icon.png"));
        stage.setX(owner.getX()+owner.getWidth()/2-scene.getWidth()/2);
        stage.setY(owner.getY()+owner.getHeight()/2-scene.getHeight()/2);


        box.setOnMouseEntered(e -> stage.close());

        label.setText(text);

        stage.show();
    }

    private static Piece newPiece;
    public static Piece display(Piece pawn, Chess chess, Stage owner) {

        Stage stage = new Stage();

        Label queen = new Label("Queen");
        queen.setPrefSize(200, 200);
        queen.setFont(new Font(30));
        queen.setTextFill(Color.BLACK);
        queen.setAlignment(Pos.BASELINE_CENTER);
        queen.setStyle("-fx-border-Color: #000000;");

        Label bishop = new Label("Bishop");
        bishop.setPrefSize(200, 200);
        bishop.setFont(new Font(30));
        bishop.setTextFill(Color.BLACK);
        bishop.setAlignment(Pos.BASELINE_CENTER);
        bishop.setStyle("-fx-border-Color: #000000;");

        Label knight = new Label("Knight");
        knight.setPrefSize(200, 200);
        knight.setFont(new Font(30));
        knight.setTextFill(Color.BLACK);
        knight.setAlignment(Pos.BASELINE_CENTER);
        knight.setStyle("-fx-border-Color: #000000;");

        Label rook = new Label("Rook");
        rook.setPrefSize(200, 200);
        rook.setFont(new Font(30));
        rook.setTextFill(Color.BLACK);
        rook.setAlignment(Pos.BASELINE_CENTER);
        rook.setStyle("-fx-border-Color: #000000;");

        queen.setOnMouseEntered(event -> queen.setEffect(new DropShadow()));
        queen.setOnMouseExited(event -> queen.setEffect(null));
        bishop.setOnMouseEntered(event -> bishop.setEffect(new DropShadow()));
        bishop.setOnMouseExited(event -> bishop.setEffect(null));
        knight.setOnMouseEntered(event -> knight.setEffect(new DropShadow()));
        knight.setOnMouseExited(event -> knight.setEffect(null));
        rook.setOnMouseEntered(event -> rook.setEffect(new DropShadow()));
        rook.setOnMouseExited(event -> rook.setEffect(null));

        queen.setOnMouseClicked(e -> {
            newPiece = new Queen(pawn.x, pawn.y, pawn.pieceColor, chess);
            stage.close();
        });
        bishop.setOnMouseClicked(e -> {
            newPiece = new Bishop(pawn.x, pawn.y, pawn.pieceColor, chess);
            stage.close();
        });
        knight.setOnMouseClicked(e -> {
            newPiece = new Knight(pawn.x, pawn.y, pawn.pieceColor, chess);
            stage.close();
        });
        rook.setOnMouseClicked(e -> {
            newPiece = new Rook(pawn.x, pawn.y, pawn.pieceColor, chess);
            stage.close();
        });

        VBox box = new VBox();
        box.setPadding(new Insets(10, 10, 10, 10));
        box.setSpacing(10);
        box.setStyle("-fx-border-width: 3; -fx-border-color: #000000; -fx-background-color: #61210B");
        box.getChildren().addAll(queen, bishop, knight, rook);

        Scene scene = new Scene(box, 200, 300);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setX(owner.getX()+owner.getWidth()/2-scene.getWidth()/2);
        stage.setY(owner.getY()+owner.getHeight()/2-scene.getHeight()/2);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.getIcons().add(new Image("/res/icon.png"));
        stage.setOnCloseRequest(Event::consume);

        stage.showAndWait();

        return newPiece;
    }

}
