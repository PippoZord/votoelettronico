package Sessione;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * OVERVIEW: Le istanze di questa classe rappresentano un partito del sistema ossia un'insieme di candidati.
 *           le istanze son mutabili e il numero massimo di candidati per partito sono 50
 */ 

public class Partito {
    
    /**insieme di cadidati che formano un partito */
    private List<Candidato> candidati;
    /**nomne del partito */
    private String nome;
    /**
     * instazia un nuovo partito vuoto e this.nome = nome
     * 
     * @param nome non NULL altrimenti sollevo un'eccezione di tipo NullPointerException
     */
    public Partito(String nome){
        Objects.requireNonNull(nome, "nome non può essere NULL");
        candidati = new ArrayList<>();
        this.nome = nome;
    }

    /**
     * Inserisce un candidato nel partito se non è presente e il numero di candidati è minore di 50. 
     * Altriemnti sollevo un'eccezione di tipo IllegalArgumentException
     * 
     * @param c non NULL altrimenti sollevo un'eccezione di tipo
     *          NullPointerException
     */
    public void insert(Candidato c){
        Objects.requireNonNull(c, "c non può essere NULL");
        if (candidati.contains(c) && !(candidati.size()<50))
            throw new IllegalArgumentException("c presente nel partito");
    }

    /**
     * 
     * @param c non NULL altrimenti sollevo un eccezione di tipo
     *          NullPointerException
     * @return true se c presemte in this.candidati false altrimenti
     */
    public boolean contains(Candidato c){
        return candidati.contains(c);
    }

    /**
     * 
     * @return this.nome
     */
    public String getName(){
        return this.nome;
    }

    @Override
    public String toString() {
        String s="";
        for (Candidato candidato : candidati) {
            s += candidato +"\n";
        }
        return s;
    }


}
