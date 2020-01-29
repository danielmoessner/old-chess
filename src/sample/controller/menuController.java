package sample.controller;

import javafx.scene.control.Button;
import sample.Main;

public class menuController {

    public Button playButton = new Button();
    public Button newGameButton = new Button();

    public void play() {
        Main.vBox.getChildren().removeAll(sample.Main.vBox.getChildren());
        Main.vBox.getChildren().add(Main.canvasChess);
    }

    public void newGame(){
        Main.chess.initialize(Main.gc);
    }

}
