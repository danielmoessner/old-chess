package sample.controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class gameController {

    public Label winLabel = new Label();
    public Button gg = new Button();

    public void ggAction(){
        Stage stage = (Stage) gg.getScene().getWindow();
        stage.close();
    }

    public void setWinLabel(String string){
        winLabel.setText(string);
    }

}
