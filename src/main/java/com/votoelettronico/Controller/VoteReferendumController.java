package com.votoelettronico.Controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.votoelettronico.Dao.SessionDaoImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class VoteReferendumController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private Label description;

    @FXML
    private Label message;

    @FXML
    private CheckBox no;

    @FXML
    private Label title;

    @FXML
    private Button vote;

    @FXML
    private CheckBox yes;

    @FXML
    void handleBack(ActionEvent event) {

    }

    @FXML
    void handleNo(ActionEvent event) {
        yes.setSelected(false);
    }

    @FXML
    void handleVote(ActionEvent event) {

    }

    @FXML
    void handleYes(ActionEvent event) {
        no.setSelected(false);
    }

    @FXML
    void initialize() throws SQLException {
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'VoteReferendum.fxml'.";
        assert description != null
                : "fx:id=\"description\" was not injected: check your FXML file 'VoteReferendum.fxml'.";
        assert message != null : "fx:id=\"message\" was not injected: check your FXML file 'VoteReferendum.fxml'.";
        assert no != null : "fx:id=\"no\" was not injected: check your FXML file 'VoteReferendum.fxml'.";
        assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'VoteReferendum.fxml'.";
        assert vote != null : "fx:id=\"vote\" was not injected: check your FXML file 'VoteReferendum.fxml'.";
        assert yes != null : "fx:id=\"yes\" was not injected: check your FXML file 'VoteReferendum.fxml'.";
        setWindow(); 
    }

    private void setWindow() throws SQLException {
        SessionDaoImpl s = new SessionDaoImpl();
        title.setText("REFERENDUM: " + s.getTitleActiveSession());
        description.setText(s.getDescriptionActiveSession());
    }   

}
