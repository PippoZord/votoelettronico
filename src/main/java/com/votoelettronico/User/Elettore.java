package com.votoelettronico.User;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;

import com.votoelettronico.Dao.UserDaoImpl;
/**
 * OVERVIEW: Le istanze di questa classe estendo la classe User.
 *           Un Elettore è uno User con la capacità di votare in una sessione di voto.
 *           I campi aggiuntivi sono: hasVoted, telefono, email
 */
public class Elettore extends User {

    //CAMPI
    /**- Ogni campo non può essere NULL
     * - hasVoted rappresenta se l'elettore ha votato o meno
    */
    private boolean hasVoted;
    private String telefono;
    private Email email;
    
    /**
     * Istanzia this passando ai campip i parametri formali e chiamando il costruttore di super()
     *
     * @param cognome  non NULL altrimenti sollevo un'eccezione di tipo
     *                 NullPointerException
     * @param codFisc  non NULL altrimenti sollevo un'eccezione di tipo
     *                 NullPointerException
     * @param data     non NULL altrimenti sollevo un'eccezione di tipo
     *                 NullPointerException
     * @param sex      non NULL altrimenti sollevo un'eccezione di tipo
     *                 NullPointerException
     * @param password non NULL altrimenti sollevo un'eccezione di tipo
     *                 NullPointerException
     * @param nascita  non NULL altrimenti sollevo un'eccezione di tipo
     *                 NullPointerException
     * @param nazione  non NULL altrimenti sollevo un'eccezione di tipo
     *                 NullPointerException
     * @param email    non NULL altrimenti sollevo un'eccezione di tipo
     *                 NullPointerException
     * @param telefono non NULL altrimenti sollevo un'eccezione di tipo
     *                 NullPointerException
     * @param hasVoted non NULL altrimenti sollevo un'eccezione di tipo
     *                 NullPointerException
     */
    public Elettore(String nome, String cognome, CodFisc codFisc, LocalDate data, char sex, String password, String nascita, String nazione, Email email, String telefono, boolean hasVoted) {
        super(nome, cognome, codFisc, data, sex, nascita, nazione, password);
        Objects.requireNonNull(hasVoted, "hasvoted non può essere NULL");
        Objects.requireNonNull(telefono, "telefono non può essere NULL");
        Objects.requireNonNull(hasVoted, "email non può essere NULL");
        this.hasVoted = hasVoted;
        this.telefono = telefono;
        this.email = email;
    }

    /**
     * 
     * @return la email di this
     */
    public Email getEmail(){
        return this.email;
    }

    /**
     * 
     * @return il numero di telefono di this
     */
    public String getTelefono() {
        return this.telefono;
    }

    /**
     * Si collega con il DBMS 'voto' e la tabella 'Elettore' per controllare se l'elettore ha già votato
     * 
     * @return true se 'votato' all'interno del DBMS è = 1. false altrimenti
     * @throws SQLException se ho errori connesione al DBMS 
     */
    public boolean hasVoted() throws SQLException{
        UserDaoImpl u = new UserDaoImpl();
        if (u.hasVoted(this))
            return true;
        return false;
    }

    /**
     * Si collega con il DBMS 'voto' e la tabella 'Elettore' settando a 1 il campo 'votato' associato this
     * 
     * @throws SQLException se c'è un errore all'acceso del DBMS 
     */
    public void vote() throws SQLException{
        UserDaoImpl u = new UserDaoImpl();
        u.vote(this);
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
