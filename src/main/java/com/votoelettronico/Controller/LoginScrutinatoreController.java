package com.votoelettronico.Controller;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

import com.google.common.hash.Hashing;
import com.votoelettronico.App;
import com.votoelettronico.Dao.UserDao;
import com.votoelettronico.Dao.UserDaoImpl;
import com.votoelettronico.User.CodFisc;
import com.votoelettronico.User.Scrutinatore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginScrutinatoreController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private Label labelError;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    void handleBackButton(ActionEvent event) throws IOException {
        App.navigate("HomeView");
    }

    @FXML
    void handleLoginButton(ActionEvent event) {
        String HashPassword = Hashing.sha256().hashString(password.getText(), StandardCharsets.UTF_8).toString();
        try {
            UserDao u = new UserDaoImpl();
            Scrutinatore s = u.getScrutinatore(new CodFisc(username.getText().toUpperCase()));
            System.out.println(s);
            if (!s.getPassword().equals(HashPassword))
                throw new IllegalArgumentException();
            else
                labelError.setText("BENVENUTO");
        } catch (Exception e) {
            labelError.setText("ERRORE");
        }
    }

    @FXML
    void initialize() {
        assert backButton != null
                : "fx:id=\"backButton\" was not injected: check your FXML file 'LoginScrutinatore.fxml'.";
        assert labelError != null
                : "fx:id=\"labelError\" was not injected: check your FXML file 'LoginScrutinatore.fxml'.";
        assert loginButton != null
                : "fx:id=\"loginButton\" was not injected: check your FXML file 'LoginScrutinatore.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'LoginScrutinatore.fxml'.";
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'LoginScrutinatore.fxml'.";

    }

}
