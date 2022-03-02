package com.votoelettronico.User;

import java.time.LocalDate;
import java.util.Objects;

/**
 * OVERVIEW: Le Istanze di questa classe astratta rappresentano un utente all'interno del sistema 'voto' con i campi.
 *           nome, cognome, password, luogo di nascita, nazione di nascita, codice fiscale, data di nascita e sesso.
 *           Istanze Immutabile
 */

public abstract class User {
    
    //CAMPI
    /**
     * - Ogni campo no può essere NULL.
     * - sex = "M" o "F"
     */
    private String nome, cognome, password, nascita, nazione;
    private final CodFisc codiceFiscale;
    private final LocalDate data;
    private char sex;

    //COSTRUTTORI
    /**
     * Istanzia i campi di this con i parametri formali
     * 
     * @param nome     non NULL altrimenti sollevo un eccezione di tipo
     *                 NullPointerException
     * @param cognome  non NULL altrimenti sollevo un eccezione di tipo
     *                 NullPointerException
     * @param codFisc  non NULL altrimenti sollevo un eccezione di tipo
     *                 NullPointerException
     * @param data     non NULL altrimenti sollevo un eccezione di tipo
     *                 NullPointerException
     * @param sex      non NULL altrimenti sollevo un eccezione di tipo
     *                 NullPointerException
     * @param nascita  non NULL altrimenti sollevo un eccezione di tipo
     *                 NullPointerException
     * @param nazione  non NULL altrimenti sollevo un eccezione di tipo
     *                 NullPointerException
     * @param password non NULL altrimenti sollevo un eccezione di tipo
     *                 NullPointerException
     */
    public User(String nome, String cognome, CodFisc codFisc, LocalDate data, char sex, String nascita, String nazione, String password){
        Objects.requireNonNull(nome, "nome non può essere NULL");
        Objects.requireNonNull(cognome, "cognome non può essere NULL");
        Objects.requireNonNull(codFisc, "codFisc non può essere NULL");
        Objects.requireNonNull(data, "data non può essere NULL");
        Objects.requireNonNull(sex, "sex non può essere NULL");
        Objects.requireNonNull(nascita, "nascita non può essere NULL");
        Objects.requireNonNull(nazione, "nazione non può essere NULL");
        Objects.requireNonNull(password, "password non può essere NULL");
        this.nome = nome.toUpperCase();
        this.data = data;
        this.sex = sex;
        this.cognome = cognome.toUpperCase();
        this.nazione = nazione.toUpperCase();
        this.codiceFiscale = codFisc;
        this.nascita = nascita.toUpperCase();
        this.password = password;
    }

    /**
     * 
     * @return il nome di this
     */
    public String getName(){
        return this.nome;
    }

    /**
     * 
     * @return il cognome
     */
    public String getSurname(){
        return this.cognome;
    }

    /**
     * 
     * @return il codice fiscale
     */
    public CodFisc getCodFisc() {
        return this.codiceFiscale;
    }

    /**
     * 
     * @return la password di this
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 
     * @return la data di nascita di this
     */
    public LocalDate getData() {
        return this.data;
    }

    /**
     * 
     * @return il sesso di this
     */
    public char getSex() {
        return this.sex;
    }

    /**
     * 
     * @return il luogo di nascita di this
     */
    public String getNascita(){
        return this.nascita;
    }

    /**
     * 
     * @return la nazione di nascita di this
     */
    public String getNazione(){
        return this.nazione;
    }
}

