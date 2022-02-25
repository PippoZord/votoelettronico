package Voto;

import java.time.LocalDate;

public class Referendum extends Voto {

    public Referendum(String titolo, String descrizione, LocalDate inizio, LocalDate fine) {
        super(titolo, descrizione, inizio, fine);
    }

}
