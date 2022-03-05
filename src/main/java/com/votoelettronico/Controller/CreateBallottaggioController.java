package com.votoelettronico.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.votoelettronico.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreateBallottaggioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private TextField cognome1;

    @FXML
    private TextField cognome2;

    @FXML
    private Button create;

    @FXML
    private TextArea description;

    @FXML
    private DatePicker end;

    @FXML
    private Label label;

    @FXML
    private TextField nome1;

    @FXML
    private TextField nome2;

    @FXML
    private TextField primoPartito;

    @FXML
    private TextField secondoPartito;

    @FXML
    private DatePicker start;

    @FXML
    private TextField title;

    @FXML
    void handleBack(ActionEvent event) throws IOException {
        App.navigate("Session");
    }

    @FXML
    void handleCreate(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'CreateBallottaggio.fxml'.";
        assert cognome1 != null : "fx:id=\"cognome1\" was not injected: check your FXML file 'CreateBallottaggio.fxml'.";
        assert cognome2 != null : "fx:id=\"cognome2\" was not injected: check your FXML file 'CreateBallottaggio.fxml'.";
        assert create != null : "fx:id=\"create\" was not injected: check your FXML file 'CreateBallottaggio.fxml'.";
        assert description != null : "fx:id=\"description\" was not injected: check your FXML file 'CreateBallottaggio.fxml'.";
        assert end != null : "fx:id=\"end\" was not injected: check your FXML file 'CreateBallottaggio.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'CreateBallottaggio.fxml'.";
        assert nome1 != null : "fx:id=\"nome1\" was not injected: check your FXML file 'CreateBallottaggio.fxml'.";
        assert nome2 != null : "fx:id=\"nome2\" was not injected: check your FXML file 'CreateBallottaggio.fxml'.";
        assert primoPartito != null : "fx:id=\"primoPartito\" was not injected: check your FXML file 'CreateBallottaggio.fxml'.";
        assert secondoPartito != null : "fx:id=\"secondoPartito\" was not injected: check your FXML file 'CreateBallottaggio.fxml'.";
        assert start != null : "fx:id=\"start\" was not injected: check your FXML file 'CreateBallottaggio.fxml'.";
        assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'CreateBallottaggio.fxml'.";

    }

}
