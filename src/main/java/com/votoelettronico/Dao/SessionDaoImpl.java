package com.votoelettronico.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Voto.Voto;

public abstract class SessionDaoImpl {
    
    protected Connection myConnection;

    public SessionDaoImpl() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/voto";
        String root = "root";
        String pass = "root";
        myConnection = DriverManager.getConnection(url, root, pass);
    }

    protected void createSession(Voto voto) throws SQLException {
        try{
            checkData(voto);
            PreparedStatement prepStat = myConnection.prepareStatement("insert into Sessioni values(?,?,?,?);");
            prepStat.setString(1, voto.titolo);
            prepStat.setString(2, voto.descrizione);
            prepStat.setDate(3, Date.valueOf(voto.inizio));
            prepStat.setDate(4, Date.valueOf(voto.fine));
            prepStat.executeUpdate();
        } catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

    private void checkData(Voto voto) throws SQLException {
        PreparedStatement prepStat = myConnection.prepareStatement("select * from Sessioni where ((inizio <= ? and fine >= ?) or (inizio <= ? and fine >= ?) or (inizio > ? and fine < ?));");
        prepStat.setDate(1, Date.valueOf(voto.inizio));
        prepStat.setDate(2, Date.valueOf(voto.inizio));
        prepStat.setDate(3, Date.valueOf(voto.fine));
        prepStat.setDate(4, Date.valueOf(voto.fine));
        prepStat.setDate(5, Date.valueOf(voto.inizio));
        prepStat.setDate(6, Date.valueOf(voto.fine));
        ResultSet set = prepStat.executeQuery();
        if (set.next()) throw new IllegalArgumentException();
    }
}
