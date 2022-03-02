package Sessione;

import java.time.LocalDate;
/**
 * OVERVIEW: Le istanze di questa classe estendo la classe atratta Sessione.
 *           Gli oggetti rappresentano un Referendum per ciò il comportamento è quello della classe astratta Sessione.
 *           Le istanze sono immutabiuli
 */
public class Referendum extends Sessione {
    
    /**
     * Istanzia il Referendum
     * 
     * @param titolo      non NULL altrimenti sollevo un'eccezione di tipo
     *                    NullPointerException (vedi super())
     * @param descrizione non NULL altrimenti sollevo un'eccezione di tipo
     *                    NullPointerException (vedi super())
     * @param inizio      non NULL altrimenti sollevo un'eccezione di tipo
     *                    NullPointerException (vedi super())
     * @param fine        non NULL altrimenti sollevo un'eccezione di tipo
     *                    NullPointerException (vedi super())
     */
    public Referendum(String titolo, String descrizione, LocalDate inizio, LocalDate fine) {
        super(titolo, descrizione, inizio, fine);
    }

}
