package Sessione;

import java.util.Objects;
/**
 * OVERVIEW:  Le istanze di questa classe rappresentano un candidato di un partito del sistema.
 *            Istanze immutabili
 */
public class Candidato {

    /**nome e cognome del partito */
    public final String nome, cognome;   
    /**nome del partito del candidato */
    public final String partito;

    /**
     * 
     * @param nome    non NULL altrimenti sollevo un'eccezione di tipo
     *                NullPointerException
     * @param cognome non NULL altrimenti sollevo un'eccezione di tipo
     *                NullPointerException
     * @param partito non NULL altrimenti sollevo un'eccezione di tipo
     *                NullPointerException
     */
    public Candidato(String nome, String cognome, String partito){
        Objects.requireNonNull(nome, "nome non può essere NULL");
        Objects.requireNonNull(cognome, "cognome non può essere NULL");
        Objects.requireNonNull(partito, "partito non può essere NULL");
        this.nome = nome;
        this.cognome = cognome;
        this.partito = partito;
    }

    
    /**
     * 
     * @return this.nome
     */
    public String getName() {
        return this.nome;
    }

    /**
     * 
     * @return this.cognome
     */
    public String getSurname() {
        return this.cognome;
    }

    /**
     * 
     * @return this.partito
     */
    public String getPartito() {
        return this.partito;
    }
    
    
    @Override
    public String toString() {
        return this.nome + " " + this.cognome;
    }

}
