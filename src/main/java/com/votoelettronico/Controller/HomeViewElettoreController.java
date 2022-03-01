package com.votoelettronico.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.votoelettronico.App;
import com.votoelettronico.Dao.SessionDaoImpl;
import com.votoelettronico.User.Elettore;
import com.votoelettronico.User.User;

import javafx.event.ActionEvent;
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
    private Label labelTitle;

    @FXML
    private Button vote;

    @FXML
    void handleExit(ActionEvent event) throws IOException {
        App.navigate("LoginElettore");
    }

    @FXML
    void handleVote(ActionEvent event) throws SQLException, IOException {
        User u = App.getUser();
        if (u instanceof Elettore){
            Elettore el = (Elettore) u;
            if (!el.hasVoted()){
                try {
                    SessionDaoImpl s = new SessionDaoImpl();
                    switch (s.type()){
                        case "Referendum":
                            App.navigate("VoteReferendum");
                    }
                }catch (Exception e){
                    label.setText("NESSUNA VOTAZIONE IN CORSO");
                }
            } else {
                label.setText("HAI GIÀ VOTATO PER QUESTA SESSIONE");
            }
        }
    }
    
    @FXML
    void initialize() {
        assert exit != null : "fx:id=\"exit\" was not injected: check your FXML file 'HomeViewElettore.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'HomeViewElettore.fxml'.";
        assert labelTitle != null : "fx:id=\"labelTitle\" was not injected: check your FXML file 'HomeViewElettore.fxml'.";
        assert vote != null : "fx:id=\"vote\" was not injected: check your FXML file 'HomeViewElettore.fxml'.";
        labelTitle.setText("CIAO " + App.getUser().getName());
    }

}
