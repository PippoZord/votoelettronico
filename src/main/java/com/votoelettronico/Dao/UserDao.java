package com.votoelettronico.Dao;

import java.sql.SQLException;

import com.votoelettronico.User.CodFisc;
import com.votoelettronico.User.Elettore;
import com.votoelettronico.User.Scrutinatore;
import com.votoelettronico.User.User;
/**
 * OVERVIEW: Interfaccia che descrive i comporatamenti che bisogna implementare per gestire gli User del sistema
 */
public interface UserDao {
    /**
     * 
     * @param codFisc non NULL altrimenti sollevo un'eccezione di tipo NullPointerException
     * @return Elettore all'interno della tabella Elettore del DBMS voto associato a codFisc
     * @throws SQLException se ho un errroe in accesso al DBMS
     */
    public Elettore getElettore(CodFisc codFisc) throws SQLException;

    /**
     * 
     * @param codFisc non NULL altrimenti sollevo un'eccezione di tipo
     *                NullPointerException
     * @return Scrutinatore all'interno della tabella Elettore del DBMS voto associato a
     *         codFisc
     * @throws SQLException se ho un errroe in accesso al DBMS
     */
    public Scrutinatore getScrutinatore(CodFisc codFisc) throws SQLException;

    /**
     * 
     * @param student 
     */
    public void updateUser(User user);
    
    /**
     * 
     * @param user
     */
    public void deleteUser(User user);

    /**
     * Inserisce 'elettore' con i suoi parametri all'interno della tabella Elettore
     * del DBMS voto
     * 
     * @param elettore non può essere NULL altrimenti sollevo un eccezione di tipo
     *                 NullPointerException
     * @throws SQLException se ho un errroe in accesso al DBMS
     */
    public void insertElettore(Elettore elettore) throws SQLException;

    /**
     * Associa a true il valore di 'votato' all'interno del DBMS associato all'elettore 'e' se e.hasVoted = false
     * 
     * @param e non NULL altrimenti sollevo un'eccezione di tipo
     *          NullPointerException
     * @throws SQLException SQLException se ho un errroe in accesso al DBMS
     */
    public void vote(Elettore e) throws SQLException;

    /**
     * 
     * @param e non NULL altrimenti sollevo un'eccezione di tipo
     *          NullPointerException
     * @return true se il campo 'votato' associato all'elettore 'e' è = 1 altrimenti false
     * @throws SQLException SQLException se ho un errroe in accesso al DBMS
     */
    public boolean hasVoted(Elettore e) throws SQLException;
}
