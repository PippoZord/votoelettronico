package com.votoelettronico.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.votoelettronico.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeViewScrutinatoreController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button creaSessione;

    @FXML
    private Button exit;

    @FXML
    private Button gestisciSessione;

    @FXML
    void handleCreaSessione(ActionEvent event) throws IOException {
        App.navigate("Session");
    }

    @FXML
    void handleGestisciSessione(ActionEvent event) {

    }


    @FXML
    void handleExit(ActionEvent event) throws IOException {
        App.navigate("HomeView");
    }

    @FXML
    void initialize() {
        assert creaSessione != null
                : "fx:id=\"creaSessione\" was not injected: check your FXML file 'HomeViewScrutinatore.fxml'.";
        assert gestisciSessione != null
                : "fx:id=\"gestisciSessione\" was not injected: check your FXML file 'HomeViewScrutinatore.fxml'.";

        assert exit != null : "fx:id=\"exit\" was not injected: check your FXML file 'HomeViewScrutinatore.fxml'.";
    }

}
