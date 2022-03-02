package com.votoelettronico.Dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

import com.votoelettronico.App;
import com.votoelettronico.User.Elettore;
import com.votoelettronico.User.User;

import Sessione.Referendum;

/**
 * OVERVIEW: Le istanze di questa classe estendono la classe SessionDaoImpl e consentono di collegarsi al DBMS 'voto' e
 *           accedere alla tabella 'Sessioni' e 'Referendum'. Referendum.titolo è chiave esterna di Sessioni.titolo
 *           La classe consente di creare un referendum e contestualmente una sessione e di inserire un voto all'interno dei campi 'si' e 'no' della tabella Referendum
 *           Istanze Immutabili
 */
public class ReferendumDaoImpl extends SessionDaoImpl{

    /**
     * Accede al DBMS invocando il costruttore di SessioDaoImpl
     * 
     * @throws SQLException se ho un'errore in accesso al DBMS
     */
    public ReferendumDaoImpl() throws SQLException{
        super();
    }

    /**
     * Crea una sessione di voto invocando il metodo super.createSession(voto) e crea un referendum inserendo i parametri all'interno di 'Referednum'.
     * All'inizio il campo viene 'si' e 'no' vengono instaziati a 0;
     * 
     * @param voto non NULL altrimenti sollevo un'eccezione di tipo
     *             NullPointerException (vedi super)
     * @throws SQLException se ho un'errore in accesso al DBMS
     */
    public void createReferendum(Referendum voto) throws SQLException{
        super.createSession(voto);
        PreparedStatement prepStat = myConnection.prepareStatement("insert into Referendum values(?,?,?);");
        prepStat.setString(1, voto.titolo);
        prepStat.setInt(2, 0);
        prepStat.setInt(3, 0);
        prepStat.executeUpdate();
    }

    /**
     * Dato lo User 'e' come l'utente che si è loggato nel sistema, se 'e'  è un Elettore e non ha votato per la sessione di voto attiva
     * allora si fa votare l'Elettore accedendo alla tabella Referendum e si incrementa il contatore in base al voto: 
     * - Se voto.equals("SI") Referendum.si = Referendum.si + 1;
     * - Se voto.equals("NO") Referendum.si = Referendum.no + 1;
     * - Altrimenti sollevo un eccezioni di tipo IllegalArgumentException 
     * 
     * 
     * @param voto non NULL altrimenti sollevo un'eccezione di tipo
     *             NullPointerException
     * @throws SQLException se ho un'errore in accesso al DBMS
     */
    public void insertVote(String voto) throws SQLException{
        Objects.requireNonNull(voto, "voto non può essere null");
        User e = App.getUser();
        if (e instanceof Elettore) {
            Elettore el = (Elettore) e;
            if (voto.equals("SI") && !el.hasVoted()){
                PreparedStatement prepStat = myConnection.prepareStatement("update Referendum set si = si+1 where titolo = ?;");
                prepStat.setString(1, this.getTitleActiveSession());
                prepStat.executeUpdate();
                el.vote();
            } else if (voto.equals("NO") && !el.hasVoted()){
                PreparedStatement prepStat = myConnection.prepareStatement("update Referendum set no = no+1 where titolo = ?;");
                prepStat.setString(1, this.getTitleActiveSession());
                prepStat.executeUpdate();
                el.vote();
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}
