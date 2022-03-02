package com.votoelettronico.User;
import java.util.Objects;
/**
 * OVERVIEW: Le istanze di questa classe rappresentano una email. 
 *           Istanze Immuatbili
 */
public class Email {
    
    //CAMPI
    /**Rappresenta  l'email*/
    private String email;

    //COSTRUTTORI
    /**
     * istanzia this.email = email se check(email) = true altriemnti solleva un'ec cezione di tipo IllegalArgumentexception()
     * 
     * @param email no NULL altirmenti sollevo un'eccezione di tipo NullPointerException
     */
    public Email(String email){
        Objects.requireNonNull(email, "email non può essere NULL");
        if (!check(email))
            throw new IllegalArgumentException("email non corretta");
        this.email = email;
    }

    private boolean check(String email) {
        Objects.requireNonNull(email);
        if (!email.contains("@"))
            return false;
        String s[] = email.split("@");
        if (s[0].length() < 1)
            return false;
        s = s[1].split("\\.");
        if (s[0].length()<1 || s[1].length()>3)
            return false;
        return true;
    }  

    /**
     * 
     * @return this.email
     */
    public String getEmail(){
        return this.email;
    }


    @Override
    public String toString() {
        return this.email;
    }
}
