package com.votoelettronico.Dao;
import java.sql.*;
import java.util.Objects;

import com.votoelettronico.User.CodFisc;
import com.votoelettronico.User.Elettore;
import com.votoelettronico.User.Email;
import com.votoelettronico.User.Scrutinatore;
import com.votoelettronico.User.User;

/**
 * OVERVIEW: Questa classe implementa l'interfaccia UserDao e consente la gestione degli utenti, Scrutinatore ed Elettore, con al DBMS 'voto'
 *           Istanze immutabili
 */
public class UserDaoImpl implements UserDao{

    //CAMPI
    /**Rappresenta la Connesione al DBMS 'voto'*/
    private Connection myConnection;
    
    /**
     * 
     * @throws SQLException se ho un errore di accesso al DBMS
     */
    public UserDaoImpl() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/voto";
        String root = "root";
        String pass = "root";
        myConnection = DriverManager.getConnection(url, root, pass);
    }

    @Override
    public Elettore getElettore(CodFisc codFisc) throws SQLException {      
        PreparedStatement prepStat = myConnection.prepareStatement("select * from elettori where codfiscale = ?");
        prepStat.setString(1, sqlEscapeInjection(codFisc.getCodFisc()));
        ResultSet myResultSet =  prepStat.executeQuery();
        myResultSet.next();
        return new Elettore(myResultSet.getString("nome"), myResultSet.getString("cognome"), new CodFisc(myResultSet.getString("codfiscale")), myResultSet.getDate("data").toLocalDate(),myResultSet.getString("sex").charAt(0), myResultSet.getString("password"), myResultSet.getString("luogonascita"),myResultSet.getString("nazione"), new Email(myResultSet.getString("email")), myResultSet.getString("telefono"), myResultSet.getBoolean("votato"));
    }

    @Override
    public Scrutinatore getScrutinatore(CodFisc codFisc) throws SQLException {
        PreparedStatement prepStat = myConnection.prepareStatement("select * from scrutinatori where codfiscale = ?");
        prepStat.setString(1, sqlEscapeInjection(codFisc.getCodFisc()));
        ResultSet myResultSet =  prepStat.executeQuery();
        myResultSet.next();
        return new Scrutinatore(myResultSet.getString("nome"), myResultSet.getString("cognome"), new CodFisc(myResultSet.getString("codfiscale")), myResultSet.getDate("data").toLocalDate(), myResultSet.getString("sex").charAt(0), myResultSet.getString("luogonascita"), myResultSet.getString("nazione"), myResultSet.getString("password"));
    }
    
    
    /**
     * Consente di evitare le sql injection modificando str
     * 
     * @param str non NULL e str.length > 0 altriemnti sollevo un'eccezione di tipo IllegalArgumentExcpetion
     * @return str modificata per evitare sql injection
     */
    private String sqlEscapeInjection(String str) {
        String data = null;
        if (str != null && str.length() > 0) {
            str = str.replace("\\", "\\\\");
            str = str.replace("'", "\\'");
            str = str.replace("\0", "\\0");
            str = str.replace("\n", "\\n");
            str = str.replace("\r", "\\r");
            str = str.replace("\"", "\\\"");
            str = str.replace("\\x1a", "\\Z");
            str = str.replace(";", "\\Z");
            data = str;
        } else {
            throw new IllegalArgumentException("str non può essere NULL");
        }
        return data;
    }

    @Override
    public void updateUser(User user) {
        
    }

    @Override
    public void deleteUser(User user) {
    
    }

    @Override
    public void insertElettore(Elettore e) throws SQLException {
        PreparedStatement prepStat = myConnection.prepareStatement("insert into elettori values(?,?,?,?,?,?,?,?,?,?,?)");
        prepStat.setString(1, e.getCodFisc().getCodFisc());
        prepStat.setString(2, e.getName());
        prepStat.setString(3, e.getSurname());
        prepStat.setString(4, Character.toString(e.getSex()));
        prepStat.setDate(5, Date.valueOf(e.getData()));
        prepStat.setBoolean(6, e.hasVoted());
        prepStat.setString(7, e.getPassword());
        prepStat.setString(8, e.getEmail().getEmail());
        prepStat.setString(9, e.getNascita());
        prepStat.setString(10, e.getTelefono());
        prepStat.setString(11, e.getNazione());
        prepStat.executeUpdate();
    }

    @Override
    public void vote(Elettore e) throws SQLException{
        Objects.requireNonNull(e, "e non può essere NULL");
        PreparedStatement prepStat = myConnection.prepareStatement("update elettori set votato = 1 where codfiscale = ?;");
        prepStat.setString(1, e.getCodFisc().getCodFisc());
        prepStat.executeUpdate();
    }

    @Override
    public boolean hasVoted(Elettore e) throws SQLException {
        Objects.requireNonNull(e, "e Non può essere NULL");
        PreparedStatement prepStat = myConnection.prepareStatement("select votato from elettore where codfiscale = ?;");
        prepStat.setString(1, e.getCodFisc().getCodFisc());
        ResultSet set = prepStat.executeQuery();
        if (set.next() && set.getBoolean(1)==true){
            return true;
        }   
        return false;
    }

    
}
