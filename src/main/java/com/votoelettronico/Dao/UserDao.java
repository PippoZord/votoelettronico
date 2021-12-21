package com.votoelettronico.Dao;

import java.sql.SQLException;

import com.votoelettronico.User.CodFisc;
import com.votoelettronico.User.Elettore;
import com.votoelettronico.User.Scrutinatore;
import com.votoelettronico.User.User;

public interface UserDao {
    public Elettore getElettore(CodFisc codFisc) throws SQLException;
    public Scrutinatore getScrutinatore(CodFisc codFisc) throws SQLException;
    public void updateUser(User student);
    public void deleteUser(User student);
    public void insertElettore(Elettore elettore) throws SQLException;
}
