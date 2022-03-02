package com.votoelettronico.Controller;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.google.common.hash.Hashing;
import com.votoelettronico.App;
import com.votoelettronico.Dao.UserDao;
import com.votoelettronico.Dao.UserDaoImpl;
import com.votoelettronico.User.CodFisc;
import com.votoelettronico.User.Elettore;
import com.votoelettronico.User.Email;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class RegistraElettoreController {

    private char sex;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private TextField cell;

    @FXML
    private TextField codFisc;

    @FXML
    private TextField cognome;

    @FXML
    private TextField comune;

    @FXML
    private DatePicker data;

    @FXML
    private TextField email;

    @FXML
    private CheckBox femmina;

    @FXML
    private CheckBox maschio;

    @FXML
    private TextField nazione;

    @FXML
    private TextField nome;

    @FXML
    private PasswordField password;

    @FXML
    private Button registra;
    
    @FXML
    private Label label;

    @FXML
    void handleBack(ActionEvent event) throws IOException {
        App.navigate("HomeView");
    }

    @FXML
    void handleFemmina(ActionEvent event) {
        maschio.setSelected(false);
        sex = 'F';
    }

    @FXML
    void handleMaschio(ActionEvent event) {
        femmina.setSelected(false);
        sex = 'M';
    }

    @FXML
    void handleRegistra(ActionEvent event) throws SQLException, IOException {
        try{
            UserDao u = new UserDaoImpl();
            String HashPassword = Hashing.sha256().hashString(password.getText(), StandardCharsets.UTF_8).toString();
            CodFisc codFiscale = CodFisc.checkCodFisc(nome.getText(), cognome.getText(), nazione.getText(), comune.getText(), data.getValue(), Character.toString(sex), codFisc.getText());
            u.insertElettore(new Elettore(nome.getText(), cognome.getText(), codFiscale, data.getValue(), sex, HashPassword, comune.getText(), nazione.getText(), new Email(email.getText()), cell.getText(), false));
            label.setText("REGISTRAZIONE AVVENUTA CON SUCCESSO");
        } catch (Exception e){
            label.setText("ERRORE DI REGISTRAZIONE. RICONTROLLA I PARAMETRI.");
        }
        
    }

    @FXML
    void initialize() {
        assert cell != null : "fx:id=\"cell\" was not injected: check your FXML file 'RegistraElettore.fxml'.";
        assert codFisc != null : "fx:id=\"codFisc\" was not injected: check your FXML file 'RegistraElettore.fxml'.";
        assert cognome != null : "fx:id=\"cognome\" was not injected: check your FXML file 'RegistraElettore.fxml'.";
        assert comune != null : "fx:id=\"comune\" was not injected: check your FXML file 'RegistraElettore.fxml'.";
        assert data != null : "fx:id=\"data\" was not injected: check your FXML file 'RegistraElettore.fxml'.";
        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'RegistraElettore.fxml'.";
        assert femmina != null : "fx:id=\"femmina\" was not injected: check your FXML file 'RegistraElettore.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'RegistraElettore.fxml'.";
        assert maschio != null : "fx:id=\"maschio\" was not injected: check your FXML file 'RegistraElettore.fxml'.";
        assert nazione != null : "fx:id=\"nazione\" was not injected: check your FXML file 'RegistraElettore.fxml'.";
        assert nome != null : "fx:id=\"nome\" was not injected: check your FXML file 'RegistraElettore.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'RegistraElettore.fxml'.";
        assert registra != null : "fx:id=\"registra\" was not injected: check your FXML file 'RegistraElettore.fxml'.";
        
    }

}
