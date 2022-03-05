package com.votoelettronico.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.votoelettronico.App;
import com.votoelettronico.Dao.ReferendumDaoImpl;
import com.votoelettronico.Exception.DateException;

import Sessione.Referendum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreateReferendumController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private Button create;

    @FXML
    private TextArea description;

    @FXML
    private CheckBox quorum;

    @FXML
    private Label label;

    @FXML
    private DatePicker end;

    @FXML
    private DatePicker start;

    @FXML
    private TextField title;

    @FXML
    void handleBack(ActionEvent event) throws IOException {
        App.navigate("Session");
    }

    @FXML
    void handleCreate(ActionEvent event) throws SQLException, InterruptedException {
        try {
            ReferendumDaoImpl tmp = new ReferendumDaoImpl();
            Referendum voto = new Referendum(title.getText(), description.getText(), start.getValue(), end.getValue(), quorum.isSelected());
            tmp.createReferendum(voto);
            label.setText("CREATO");
        } catch (Exception e){
            if (e instanceof DateException)
                label.setText("ERRORE DI DATA");
            else
                label.setText("TITOLO GIÀ INSERITO");
            e.printStackTrace();    
        }
    }

    @FXML
    void initialize() {
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'Referendum.fxml'.";
        assert create != null : "fx:id=\"create\" was not injected: check your FXML file 'Referendum.fxml'.";
        assert description != null : "fx:id=\"description\" was not injected: check your FXML file 'Referendum.fxml'.";
        assert end != null : "fx:id=\"end\" was not injected: check your FXML file 'Referendum.fxml'.";
        assert quorum != null : "fx:id=\"quorum\" was not injected: check your FXML file 'CreateReferendum.fxml'.";
        assert start != null : "fx:id=\"start\" was not injected: check your FXML file 'Referendum.fxml'.";
        assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'Referendum.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'Referendum.fxml'.";
    }

}