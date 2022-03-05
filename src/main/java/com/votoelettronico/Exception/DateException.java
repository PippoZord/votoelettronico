package com.votoelettronico.Exception;

import java.sql.SQLException;

/**
 * OVERVIEW: Estende la classe SQLException. Le istanze di questa classe vengono sollevate quando ci sono errori nell'inserimento di una sessione di voto 
 *           poichè la data si interseca con un'altra data di un'altra sessione già inserita
 */
public class DateException  extends SQLException{
    public DateException(String s){
        super(s);
    }

    public DateException() {
        super();
    }

}

