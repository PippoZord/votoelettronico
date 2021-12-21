package com.votoelettronico.User;
import java.time.LocalDate;

public class Elettore extends User {

    private boolean hasVoted;
    private String telefono;
    private Email email;
    
    public Elettore(String nome, String cognome, CodFisc codFisc, LocalDate data, char sex, String password, String nascita, String nazione, Email email, String telefono, boolean hasVoted) {
        super(nome, cognome, codFisc, data, sex, nascita, nazione, password);
        this.hasVoted = hasVoted;
        this.telefono = telefono;
        this.email = email;
    }
    
    public Email getEmail(){
        return this.email;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public boolean hasVoted(){
        return hasVoted;
    }

    public void vote(){
        if (hasVoted == false);
            hasVoted = true;
    }

    @Override
    public String toString(){
        if (hasVoted == false)
            return "\nELETTORE\nNOME: " + this.getName() + "\nCOGNOME: " + this.getSurname() + "\nUSERNAME: "
                    + this.getCodFisc() + "\nDATA DI NASCITA: " + this.getData() + "\nCOMUNE DI NASCITA: "
                    + this.getNascita() + "\nNAZIONE DI NASCITA: " + this.getNazione() + "\nEMAIL: " + this.getEmail() + "\nTELEFONO: " + this.getTelefono()
                    + "\nSEX: " + this.getSex() + "\nVOTATO: " + "NO";

        return "\nELETTORE\nNOME: " + this.getName() + "\nCOGNOME: " + this.getSurname() + "\nUSERNAME: "
                + this.getCodFisc() + "\nDATA DI NASCITA: " + this.getData() + "\nCOMUNE DI NASCITA: "
                + this.getNascita() + "\nNAZIONE DI NASCITA: " + this.getNazione()+ "\nEMAIL: " + this.getEmail() + "\nTELEFONO: " + this.getTelefono() + "\nSEX: "
                + this.getSex() + "\nVOTATO: " + "SI";
    }
}
