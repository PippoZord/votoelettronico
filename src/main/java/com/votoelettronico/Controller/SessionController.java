package com.votoelettronico.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.votoelettronico.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SessionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private Button ballotaggio;

    @FXML
    private Button categorico;

    @FXML
    private Button ordinale;

    @FXML
    private Button preferenza;

    @FXML
    private Button referendum;

    @FXML
    void handleBackButton(ActionEvent event) throws IOException {
        App.navigate("HomeViewScrutinatore");
    }

    @FXML
    void handleBallottaggio(ActionEvent event) throws IOException {
        App.navigate("CreateBallottaggio");
    }

    @FXML
    void handleCategorico(ActionEvent event) {

    }

    @FXML
    void handleOrdinale(ActionEvent event) {

    }

    @FXML
    void handlePreferenza(ActionEvent event) {

    }

    @FXML
    void handleReferendum(ActionEvent event) throws IOException {
        App.navigate("CreateReferendum");
    }

    @FXML
    void initialize() {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'Session.fxml'.";
        assert ballotaggio != null : "fx:id=\"ballotaggio\" was not injected: check your FXML file 'Session.fxml'.";
        assert categorico != null : "fx:id=\"categorico\" was not injected: check your FXML file 'Session.fxml'.";
        assert ordinale != null : "fx:id=\"ordinale\" was not injected: check your FXML file 'Session.fxml'.";
        assert preferenza != null : "fx:id=\"preferenza\" was not injected: check your FXML file 'Session.fxml'.";
        assert referendum != null : "fx:id=\"referendum\" was not injected: check your FXML file 'Session.fxml'.";

    }

}