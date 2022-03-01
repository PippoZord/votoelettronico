package com.votoelettronico.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.votoelettronico.App;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomeViewElettoreController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exit;

    @FXML
    private Label label;

    @FXML
    private Button vote;

    @FXML
    void initialize() {
        assert exit != null : "fx:id=\"exit\" was not injected: check your FXML file 'HomeViewElettore.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'HomeViewElettore.fxml'.";
        assert vote != null : "fx:id=\"vote\" was not injected: check your FXML file 'HomeViewElettore.fxml'.";
        label.setText(App.getUSer().getName());
    }

}
