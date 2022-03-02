package com.votoelettronico.User;

import java.time.LocalDate;
/**
 * OVERVIEW: Le istanze di questa classe rappresentano una Scrutinatore di una sessione di voto ed estendono la classe astratta User
 *   
 */
public class Scrutinatore extends User{

    public Scrutinatore(String nome, String cognome, CodFisc codFisc, LocalDate data, char sex, String nascita, String nazione, String password) {
        super(nome, cognome, codFisc, data, sex, nascita, nazione, password);
    }
    
    @Override
    public String toString() {
            return "\nSCRUTINATORE\nNOME: " + this.getName() + "\nCOGNOME: " + this.getSurname() + "\nUSERNAME: " + this.getCodFisc()+ "\nDATA DI NASCITA: " + this.getData() + "\nCOMUNE DI NASCITA: " + this.getNazione() + "\nNAZIONE DI NASCITA: "+ this.getNascita() + "\nSEX: " + this.getSex();
    }
}
