package com.votoelettronico.Dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.votoelettronico.App;
import com.votoelettronico.User.Elettore;
import com.votoelettronico.User.User;

import Voto.Referendum;


public class ReferendumDaoImpl extends SessionDaoImpl{

    public ReferendumDaoImpl() throws SQLException{
        super();
    }

    public void createReferendum(Referendum voto) throws SQLException{
        try {
            super.createSession(voto);
            PreparedStatement prepStat = myConnection.prepareStatement("insert into Referendum values(?,?,?);");
            prepStat.setString(1, voto.titolo);
            prepStat.setInt(2, 0);
            prepStat.setInt(3, 0);
            prepStat.executeUpdate();
        } catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

    public void insertVote(String s) throws SQLException{
        User e = App.getUser();
        if (e instanceof Elettore) {
            Elettore el = (Elettore) e;
            if (s.equals("SI") && !el.hasVoted()){
                PreparedStatement prepStat = myConnection.prepareStatement("update Referendum set si = si+1 where titolo = ?;");
                prepStat.setString(1, this.getTitleActiveSession());
                prepStat.executeUpdate();
                el.vote();
            } else if (s.equals("NO") && !el.hasVoted()){
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
