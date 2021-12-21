package com.votoelettronico.User;

import java.time.LocalDate;


public abstract class User {
    
    private String nome, cognome, password, nascita, nazione;
    private final CodFisc codiceFiscale;
    private final LocalDate data;
    private char sex;

    public User(String nome, String cognome, CodFisc codFisc, LocalDate data, char sex, String nascita, String nazione, String password){
        this.nome = nome.toUpperCase();
        this.data = data;
        this.sex = sex;
        this.cognome = cognome.toUpperCase();
        this.nazione = nazione.toUpperCase();
        this.codiceFiscale = codFisc;
        this.nascita = nascita.toUpperCase();
        this.password = password;
    }

    public String getName(){
        return this.nome;
    }

    public String getSurname(){
        return this.cognome;
    }


    public CodFisc getCodFisc() {
        return this.codiceFiscale;
    }

    public String getPassword() {
        return this.password;
    }

    public LocalDate getData() {
        return this.data;
    }

    public char getSex() {
        return this.sex;
    }

    public String getNascita(){
        return this.nascita;
    }

    public String getNazione(){
        return this.nazione;
    }
}

