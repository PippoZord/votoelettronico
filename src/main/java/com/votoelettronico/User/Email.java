package com.votoelettronico.User;
import java.util.Objects;

public class Email {
    
    private String email;

    public Email(String email){
        check(email);
        this.email = email;
    }

    private void check(String email) {
        Objects.requireNonNull(email);
        if (!email.contains("@"))
            throw new IllegalArgumentException("IT IS NOT AN  EMAIL");
        String s[] = email.split("@");
        
        if (s[0].length() < 1)
            throw new IllegalArgumentException("minore prima");
        s = s[1].split("\\.");
        if (s[0].length()<1 || s[1].length()>3)
            throw new IllegalArgumentException("minore dopo");
        
    }

    public String getEmail(){
        return this.email;
    }


    @Override
    public String toString() {
        return this.email;
    }
}
