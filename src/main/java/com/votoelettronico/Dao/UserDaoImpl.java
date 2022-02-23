package com.votoelettronico.Dao;
import java.sql.*;

import com.votoelettronico.User.CodFisc;
import com.votoelettronico.User.Elettore;
import com.votoelettronico.User.Email;
import com.votoelettronico.User.Scrutinatore;
import com.votoelettronico.User.User;


public class UserDaoImpl implements UserDao{

    private Connection myConnection;
    
    public UserDaoImpl() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/voto";
        String root = "root";
        String pass = "root";
        myConnection = DriverManager.getConnection(url, root, pass);
    }

    @Override
    public Elettore getElettore(CodFisc codFisc) throws SQLException {      
        try  { 
            PreparedStatement prepStat = myConnection.prepareStatement("select * from Elettore where codFiscale = ?");
            prepStat.setString(1, sqlEscapeInjection(codFisc.getCodFisc()));
            ResultSet myResultSet =  prepStat.executeQuery();
            myResultSet.next();
            return new Elettore(myResultSet.getString("nome"), myResultSet.getString("cognome"), new CodFisc(myResultSet.getString("codFiscale")), myResultSet.getDate("data").toLocalDate(),myResultSet.getString("sex").charAt(0), myResultSet.getString("password"), myResultSet.getString("luogoDiNascita"),myResultSet.getString("nazione"), new Email(myResultSet.getString("email")), myResultSet.getString("telefono"), myResultSet.getBoolean("votato"));
        } catch (Exception e) {
            throw new IllegalArgumentException("codFiscale does not exist");
        }
    }

    @Override
    public Scrutinatore getScrutinatore(CodFisc codFisc) throws SQLException {
        try {
            PreparedStatement prepStat = myConnection.prepareStatement("select * from Scrutinatore where codFiscale = ?");
            prepStat.setString(1, sqlEscapeInjection(codFisc.getCodFisc()));
            ResultSet myResultSet =  prepStat.executeQuery();
            myResultSet.next();
            return new Scrutinatore(myResultSet.getString("nome"), myResultSet.getString("cognome"), new CodFisc(myResultSet.getString("codFiscale")), myResultSet.getDate("data").toLocalDate(), myResultSet.getString("sex").charAt(0), myResultSet.getString("nascita"), myResultSet.getString("nazione"), myResultSet.getString("password"));
        } catch (Exception e){
            throw new IllegalArgumentException("codFiscale does not exist");
        }
    }

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
        PreparedStatement prepStat = myConnection.prepareStatement("insert into Elettore values(?,?,?,?,?,?,?,?,?,?,?)");
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


    
}
