package sample.controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Keyboard implements EventHandler<KeyEvent>{

    public void handle(KeyEvent key) {

        if(key.getCode() == KeyCode.M){
            sample.Main.vBox.getChildren().removeAll(sample.Main.vBox.getChildren());
            sample.Main.vBox.getChildren().add(sample.Main.menuBox);
        }
    }
}
