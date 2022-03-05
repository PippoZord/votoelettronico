package Sessione;
import java.time.LocalDate;
import java.util.Objects;
/**
 * OVERVIEW: Le istanze di questa classe astratta rappresentano una Sessione di voto.
 *           Ogni sessione ha un titolo, una descrizione una data di inizio e di fine.
 *           Le istanze sono immutabili
 */
public abstract class Sessione {

    //CAMPI
    
    /**titole e descrizione della sessione, non possono essere NULL*/
    public final String titolo, descrizione;
    /**Inizio e fine della sessione: inizio < fine. fine e inizio != da null*/
    public final LocalDate inizio, fine; 
    /**true se la sessione ha bisogno del quorum false altrimenti*/
 


    /**
     * Se checkData = true -> Istanzia this.titolo = titolo, this.descrizione =
     * descrizione, this.inizio = inizio, this.fine = fine
     * Altimenti sollevo un eccezione di tipo IllegalArgumentException
     * 
     * @param titolo      non NULL altrimenti sollevo un'eccezione di tipo
     *                    NullPointerException
     * @param descrizione non NULL altrimenti sollevo un'eccezione di tipo
     *                    NullPointerException
     * @param inizio      non NULL altrimenti sollevo un'eccezione di tipo
     *                    NullPointerException
     * @param fine        non NULL altrimenti sollevo un'eccezione di tipo
     *                    NullPointerException
     */
    public Sessione(String titolo, String descrizione, LocalDate inizio, LocalDate fine){
        Objects.requireNonNull(titolo, "titolo non può essere NULL");
        Objects.requireNonNull(descrizione, "descrizione non può essere NULL");
        Objects.requireNonNull(inizio, "inizio non può essere NULL");
        Objects.requireNonNull(fine, "fine non può essere NULL");
        if (!checkDate(inizio, fine))
            throw new IllegalArgumentException("inizio deve essere prima di fine");
        this.inizio = inizio;
        this.fine = fine;
        this.titolo = titolo;
        this.descrizione = descrizione;
    }
    
    /**
     * 
     * @return true se inizio < fine. false altrimenti
     */
    private boolean checkDate(LocalDate inizio, LocalDate fine) {
        if (inizio.compareTo(fine) >= 0)
            return false;
        return true;
    }

}
