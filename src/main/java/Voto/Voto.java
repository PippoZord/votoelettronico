package Voto;
import java.time.LocalDate;

public abstract class Voto {
    public final String titolo, descrizione;
    public final LocalDate inizio, fine; 

    public Voto(String titolo, String descrizione, LocalDate inizio, LocalDate fine){
        this.inizio = inizio;
        this.fine = fine;
        this.titolo = titolo;
        this.descrizione = descrizione;
    }
}
