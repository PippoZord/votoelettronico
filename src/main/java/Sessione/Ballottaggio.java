package Sessione;

import java.time.LocalDate;
import java.util.Objects;

public class Ballottaggio extends Sessione {
    
    private final Candidato c1, c2;
    /**
     * Istanzia il Ballottaggio
     * 
     * @param titolo      non NULL altrimenti sollevo un'eccezione di tipo
     *                    NullPointerException (vedi super())
     * @param descrizione non NULL altrimenti sollevo un'eccezione di tipo
     *                    NullPointerException (vedi super())
     * @param inizio      non NULL altrimenti sollevo un'eccezione di tipo
     *                    NullPointerException (vedi super())
     * @param fine        non NULL altrimenti sollevo un'eccezione di tipo
     *                    NullPointerException (vedi super())
     * @param c1          non NULL altrimenti sollevo un'eccezione di tipo
     *                    NullPointerException
     * @param c2          non NULL altrimenti sollevo un'eccezione di tipo
     *                    NullPointerException
     */
    public Ballottaggio(String titolo, String descrizione, LocalDate inizio, LocalDate fine, Candidato c1, Candidato c2) {
        super(titolo, descrizione, inizio, fine);
        Objects.requireNonNull(c1, "c1 non può essere NULL");
        Objects.requireNonNull(c2, "c2 non può essere NULL");
        this.c1 = c1;
        this.c2 = c2;
    }
    
}
