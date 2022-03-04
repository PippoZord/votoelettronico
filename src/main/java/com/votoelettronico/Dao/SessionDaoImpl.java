package com.votoelettronico.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;

import Sessione.Referendum;
import Sessione.Sessione;

/**
 * OVERVIEW: Questa classe consente di collegarsi alla DBMS 'voto'.
 *           L'oggetto SessioneDaoImpl consente inoltre di gestire la tabella 'Sessione' del DBMS:
 *           Crea una nuova sessione, capisce se una sessione è attiva, restituisce il titolo/descrizione/tipo tempo della sessione attiva.
 *           Tipo: Referendum, Ordinale, OrdinalePreferenze, Ballottaggio, Categorico
 *           Istanze immutabili
 */
public class SessionDaoImpl {
    
    //CAMPI
    /**connesione al DBMS */
    protected Connection myConnection;
    /**Sessione di voto attiva*/
    protected ResultSet activeSession;

    //COSTRUTTORI
    /**
     * Si collega al DBMS voto e associa a activeSession la sessione attiva al giorno corrente in cui si accede al sistema.
     * 
     * @throws SQLException se ho un errore in connesione al DBMS
     */
    public SessionDaoImpl() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/voto";
        String root = "root";
        String pass = "root";
        myConnection = DriverManager.getConnection(url, root, pass);
        getActiveSession();
    }

    /**
     * Accede alla tabella 'Sessioni' del DBMS 'voto' ed associa ad activeSession la
     * sessione attiva al momento dell'accesso al sistema.
     * 
     * @throws SQLException se ho un errore in accesso al DBMS
     */
    private void getActiveSession() throws SQLException {
        LocalDate now = LocalDate.now();
        PreparedStatement prepStat = myConnection.prepareStatement("select * from sessioni where (inizio <= ? and fine >= ?);");
        prepStat.setDate(1, Date.valueOf(now));
        prepStat.setDate(2, Date.valueOf(now));
        activeSession = prepStat.executeQuery();
        activeSession.next();
    }

    //METODI

    /**
     * Dato voto crea una sessione all'interno della tabella 'Sessioni' associando i
     * valori di di 'sessione' ad ogni campo della tabella.
     * Al campo tipo della tabella Sessioni associo una stringa in base al tipo di Sessione
     * 
     * @param non può essere NULL altrimenti sollevo un'eccezione di tipo
     *            NullPointerException
     * @throws SQLException se ho un errore in accesso al DBMS
     */
    protected void createSession(Sessione sessione) throws SQLException {
        Objects.requireNonNull(sessione, "sessione non può Essere null");
        if (checkData(sessione)){
            PreparedStatement prepStat = myConnection.prepareStatement("insert into sessioni values(?,?,?,?,?,?);");
            prepStat.setString(1, sessione.titolo);
            prepStat.setString(2, sessione.descrizione);
            prepStat.setDate(3, Date.valueOf(sessione.inizio));
            prepStat.setDate(4, Date.valueOf(sessione.fine));
            if (sessione instanceof Referendum)
                prepStat.setString(5, "Referendum");
            prepStat.setBoolean(6, sessione.quorum);
            prepStat.executeUpdate();
        }
    }
    
    /**
     * Controlla se all'interno della tabella 'Sessioni' esiste una sessione che si
     * interseca con la data di sessione
     * 
     * @param sessione non può essere NULLL altrimenti sollevo un'eccezione di tipo
     *                 NullPointerException
     * 
     * @throws SQLExceptionnon se ho un'errore in accesso al DBMS
     * 
     * @return false se la data impostata per sessione si sovrappone con almeno una
     *         sessione all'interno della tabella 'Sessioni'. true altrimenti.
     */
    private boolean checkData(Sessione sessione) throws SQLException {
        Objects.requireNonNull(sessione, "sessione non può essere null");
        PreparedStatement prepStat = myConnection.prepareStatement("select * from sessioni where ((inizio <= ? and fine >= ?) or (inizio <= ? and fine >= ?) or (inizio > ? and fine < ?));");
        prepStat.setDate(1, Date.valueOf(sessione.inizio));
        prepStat.setDate(2, Date.valueOf(sessione.inizio));
        prepStat.setDate(3, Date.valueOf(sessione.fine));
        prepStat.setDate(4, Date.valueOf(sessione.fine));
        prepStat.setDate(5, Date.valueOf(sessione.inizio));
        prepStat.setDate(6, Date.valueOf(sessione.fine));
        ResultSet set = prepStat.executeQuery();
        return !set.next();
    }

    /**
     * Se activeSession = NULL sollevo un'eccezione di tipo NullPointerException
     * 
     * @return il titolo della sessione attiva
     * @throws SQLException se ho un'errore in accesso al DBMS
     */
    public String getTitleActiveSession() throws SQLException {
        Objects.requireNonNull(activeSession, "Nessuna Votazione");
        return activeSession.getString(1);
    }

    /**
     * Se activeSession = NULL sollevo un'eccezione di tipo NullPointerException
     * 
     * @return la descrizione associata alla sessione attiva
     * @throws SQLException se ho un'errore in accesso al DBMS
     */
    public String getDescriptionActiveSession() throws SQLException {
        Objects.requireNonNull(activeSession, "Nessuna Descrizione");
        return activeSession.getString(2);
    }

    /**
     * Se activeSession = NULL sollevo un'eccezione di tipo NullPointerException
     * 
     * @return una stringa in cui si evidenziano la data di inizio e di fine della
     *         sessione attiva
     * @throws SQLException se ho un'errore in accesso al DBMS
     */
    public String getTime() throws SQLException {
        Objects.requireNonNull(activeSession, "Nessuna Descrizione");
        return activeSession.getDate(3) + " " + activeSession.getDate(4);
    }
    
    /**
     * Se activeSession = NULL sollevo un'eccezione di tipo NullPointerException
     * 
     * @return il tipo della sessione attiva
     * @throws SQLException se ho un'errore in accesso al DBMS
     */
    public String type() throws SQLException {
        Objects.requireNonNull(activeSession, "Nessuna Descrizione");
        return activeSession.getString(5);
    }
}
