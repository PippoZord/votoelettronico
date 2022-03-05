package com.votoelettronico.Exception;

import java.sql.SQLException;
/**
 * OVERVIEW: Le istanze di questa classe estendono una SQLException. Si solleva quando 
 *           la sessione di voto da inserire ha lo stesso titolo di una sessione già presente nel DBMS 
 */
public class PrimaryKeyException extends SQLException{
    public PrimaryKeyException(String s) {
        super(s);
    }

    public PrimaryKeyException() {
        super();
    }
}
