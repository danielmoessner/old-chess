package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.controller.Keyboard;

public class Main extends Application {

    public static final int SIZE = 800;
    public static Canvas canvasChess;
    public static VBox menuBox, vBox;
    public static GraphicsContext gc;
    public static Chess chess;

    public void start(Stage primaryStage) throws Exception {

        canvasChess = FXMLLoader.load(getClass().getResource("fxml/game.fxml"));
        menuBox = FXMLLoader.load(getClass().getResource("fxml/menu.fxml"));

        gc = canvasChess.getGraphicsContext2D();

        vBox = new VBox();
        vBox.getChildren().add(menuBox);

        chess = new Chess(new Image(getClass().getResourceAsStream("/res/Chess_Board_1.png")), primaryStage);
        chess.initialize(gc);

        canvasChess.setOnMouseClicked(event -> {
            chess.movePiece(event.getX(), event.getY(), gc);
        });
        canvasChess.setOnMouseDragged(moveEvent ->{
            chess.movePieceUpdate(moveEvent.getX(), moveEvent.getY(), gc);
        });

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, new Keyboard());
        primaryStage.setTitle("Chess");
        primaryStage.setScene(new Scene(vBox, SIZE, SIZE));
        primaryStage.getIcons().add(new Image("/res/icon.png"));
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}






















