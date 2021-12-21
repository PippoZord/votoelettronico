package com.votoelettronico.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.votoelettronico.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Registrati;

    @FXML
    private Button elettoreButton;

    @FXML
    private Button scrutatoreButton;

    @FXML
    void handleElettore(ActionEvent event) throws IOException {
        App.navigate("LoginElettore");
    }

    @FXML
    void handleRegistrati(ActionEvent event) throws IOException {
        App.navigate("RegistraElettore");
    }

    @FXML
    void handleScrutatore(ActionEvent event) throws IOException {
        App.navigate("LoginScrutinatore");
    }

    @FXML
    void initialize() {
        assert Registrati != null : "fx:id=\"Registrati\" was not injected: check your FXML file 'HomeView.fxml'.";
        assert elettoreButton != null
                : "fx:id=\"elettoreButton\" was not injected: check your FXML file 'HomeView.fxml'.";
        assert scrutatoreButton != null
                : "fx:id=\"scrutatoreButton\" was not injected: check your FXML file 'HomeView.fxml'.";

    }

}
