package com.votoelettronico.User;

import java.time.LocalDate;
import java.util.Objects;
/**
 * OVERVIEW: Si tratta di una classe che rappresenta il codice fiscale di un User.
 *           Questa classe non genera il codice fiscale ma controlla se è accettabile  
 */
public class CodFisc {

    /**Rappresneta il codice fiscale*/
    private final String codFisc;

    //COSTRUTTORI
    /**
     * Istanzia this.codFisc = codFisc
     * @param codFisc non NULL Altrimenti sollevo un'eccezione di tipo NullPointerException
     */
    public CodFisc(String codFisc) {   
        Objects.requireNonNull(codFisc);
        this.codFisc = codFisc;
    }

    //METODI
    /**
     * 
     * @return this.codFisc
     */
    public String getCodFisc() {
        return this.codFisc;
    }

    @Override
    public String toString() {
        return this.codFisc;
    }

    /**
     * Metedo statico che costruisce un codice fiscale se iparametri sono corretti. 
     * Si Veda RASD per il controllo dei carattere del codice fiscale
     * 
     * @param nome    non NULL altrimenti solleva un'eccezione di tipo
     *                NullPointerException
     * @param cognome non NULL altrimenti solleva un'eccezione di tipo
     *                NullPointerException
     * @param nazione non NULL altrimenti solleva un'eccezione di tipo
     *                NullPointerException
     * @param comune  non NULL altrimenti solleva un'eccezione di tipo
     *                NullPointerException
     * @param data    non NULL altrimenti solleva un'eccezione di tipo
     *                NullPointerException
     * @param sex     non NULL altrimenti solleva un'eccezione di tipo
     *                NullPointerException
     * @param codFisc non NULL altrimenti solleva un'eccezione di tipo
     *                NullPointerException
     * @return un oggetto CodFisc se il parametro formale codFisc è corretto in
     *         corrispondenza agli altri paremetri. Altrimenti solleva un eccezione
     *         di tipo IllegalArgumentException
     */
    public static CodFisc checkCodFisc(String nome, String cognome, String nazione, String comune, LocalDate data,
            String sex, String codFisc) {
        Objects.requireNonNull(nome, "nome non può essere NULL");
        Objects.requireNonNull(cognome, "cognome non può essere NULL");
        Objects.requireNonNull(codFisc, "codFisc non può essere NULL");
        Objects.requireNonNull(data, "data non può essere NULL");
        Objects.requireNonNull(sex, "sex non può essere NULL");
        Objects.requireNonNull(comune, "nascita non può essere NULL");
        Objects.requireNonNull(nazione, "nazione non può essere NULL");
        codFisc = codFisc.toUpperCase();
        if (!controlloCognome(codFisc.substring(0, 3), cognome))
            throw new IllegalArgumentException();
        if (!controlloNome(codFisc.substring(3, 6), nome))
            throw new IllegalArgumentException();
        if (!controllaData(codFisc.substring(6, 11), data, sex))
            throw new IllegalArgumentException();
        if (!cinquePos(codFisc, nazione))
            throw new IllegalArgumentException();

        return new CodFisc(codFisc);
    }

    /**
     * 
     * @param treLettere non può essere null altrimenti sollevo un'eccezione di tipo NullPointerException
     * @return true se si rispettano le linea definite per la generazione del codice fiscale
     */
    private static boolean controlloCognome(String treLettere, String cognome) {
        int iControllo = 0;
        Objects.requireNonNull(treLettere, "treLettere non può essere NULL");
        for (char c : cognome.toUpperCase().toCharArray()) {
            if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                if (c != treLettere.charAt(iControllo)) {
                    return false;
                } else {
                    iControllo++;
                    if (iControllo == 3)
                        return true;
                }
            }
        }

        if (iControllo < 2) {
            for (char c : cognome.toUpperCase().toCharArray()) {
                if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                    if (c != treLettere.charAt(iControllo)) {
                        return false;
                    } else {
                        iControllo++;
                        if (iControllo == 3)
                            return true;
                    }
                }
            }
        }

        while (iControllo < 3) {
            if (treLettere.charAt(iControllo) != 'X')
                return false;
            iControllo++;
        }

        return true;
    }

    /**
     * 
     * @param treLettere non può essere null altrimenti sollevo un'eccezione di tipo
     *                   NullPointerException
     * @return true se si rispettano le linea definite per la generazione del codice
     *         fiscale
     */
    private static boolean controlloNome(String treLettere, String nome) {
        Objects.requireNonNull(treLettere, "treLettere non può essere NULL");

        int cons = 0, iControllo = 0;
        for (char c : nome.toUpperCase().toCharArray()) {
            if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                cons++;
            }
        }

        if (cons < 4) {
            for (char c : nome.toUpperCase().toCharArray()) {
                if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                    if (c != treLettere.charAt(iControllo)) {
                        return false;
                    } else {
                        iControllo++;
                        if (iControllo == 3)
                            return true;
                    }
                }
            }

            if (iControllo <= 2) {
                for (char c : nome.toUpperCase().toCharArray()) {
                    if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                        if (c != treLettere.charAt(iControllo)) {
                            return false;
                        } else {
                            iControllo++;
                            if (iControllo == 3)
                                return true;
                        }
                    }
                }
            }

            while (iControllo < 3) {
                if (treLettere.charAt(iControllo) != 'X')
                    return false;
                iControllo++;
            }
        } else {

            int count = 1;
            for (char c : nome.toUpperCase().toCharArray()) {
                if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                    if (c != treLettere.charAt(iControllo) && count != 2) {
                        return false;
                    } else if (count != 2) {
                        iControllo++;
                        if (iControllo == 3)
                            return true;
                    }
                    count++;
                }
            }

            if (iControllo < 2) {
                for (char c : nome.toUpperCase().toCharArray()) {
                    if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                        if (c != treLettere.charAt(iControllo)) {
                            return false;
                        } else {
                            iControllo++;
                            if (iControllo == 3)
                                return true;
                        }
                    }
                }
            }

            while (iControllo < 3) {
                if (treLettere.charAt(iControllo) != 'X')
                    return false;
                iControllo++;
            }
        }
        return true;
    }

    /**
     * 
     * 
     * @param str non NULL altrimenti sollevo un'eccezione di tipo
     *            NullPointerException
     * @return true se si rispettano le linea definite per la generazione del codice
     *         fiscale
     */
    private static boolean controllaData(String str, LocalDate data, String sex) {
        Objects.requireNonNull(str, "str non può essere NULL");

        if (Integer.parseInt(str.substring(0, 2)) != data.getYear() % 100)
            return false;
        if (sex.equals("F")) {
            if (Integer.parseInt(str.substring(3, 5)) != (data.getDayOfMonth() % 100+40))
                return false;
        } else {
            if (Integer.parseInt(str.substring(3,5))!=data.getDayOfMonth()%100){
                return false;
            }   
        }
        switch (str.charAt(2)) {
            case 'A': {
                if (data.getMonthValue() != 1)
                    return false;
                break;
            }
            case 'B': {
                if (data.getMonthValue() != 2)
                    return false;
                break;
            }
            case 'C': {
                if (data.getMonthValue() != 3)
                    return false;
                break;
            }
            case 'D': {
                if (data.getMonthValue() != 4)
                    return false;
                break;
            }
            case 'E': {
                if (data.getMonthValue() != 5)
                    return false;
                break;
            }
            case 'H': {
                if (data.getMonthValue() != 6)
                    return false;
                break;
            }
            case 'L': {
                if (data.getMonthValue() != 7)
                    return false;
                break;
            }
            case 'M': {
                if (data.getMonthValue() != 8)
                    return false;
                break;
            }
            case 'P': {
                if (data.getMonthValue() != 9)
                    return false;
                break;
            }
            case 'R': {
                if (data.getMonthValue() != 10)
                    return false;
                break;
            }
            case 'S': {
                if (data.getMonthValue() != 11)
                    return false;
                break;
            }
            case 'T': {
                if (data.getMonthValue() != 12)
                    return false;
                break;
            }
            default:
                return false;
        }

        return true;
    }
    
    /**
     * 
     * @param codFisc non NULL altrimenti sollevo un'eccezione di tipo
     *                NullPointerException
     * @param nazione
     * @return true se si rispettano le linea definite per la generazione del codice
     *         fiscale
     */
    private static boolean cinquePos(String codFisc, String nazione) {
        Objects.requireNonNull(codFisc, "codFisc non può essere NULL");
        nazione = nazione.toUpperCase();
        if (codFisc.length() != 16)
            return false;
        else if (codFisc.toUpperCase().charAt(15) > 'Z' || codFisc.toUpperCase().charAt(15) < 'A')
            return false;
        else if (codFisc.toUpperCase().charAt(11) > 'Z' || codFisc.toUpperCase().charAt(11) < 'A')
            return false;
        else if (!nazione.equals("ITA") && codFisc.toUpperCase().charAt(11) != 'Z')
            return false;
        else if (nazione.equals("ITA") && codFisc.toUpperCase().charAt(11) == 'Z')
            return false;
        for (int i = 12; i < 15; i++)
            if (codFisc.charAt(i) < '0' && codFisc.charAt(i) > '9')
                return false;
        return true;
    }

}
