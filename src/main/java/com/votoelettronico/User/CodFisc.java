package com.votoelettronico.User;

import java.time.LocalDate;
import java.util.Objects;

public class CodFisc {

    private final String codFisc;

    public CodFisc(String codFisc) {
        Objects.requireNonNull(codFisc);
        this.codFisc = codFisc;
    }

    public String getCodFisc() {
        return this.codFisc;
    }

    @Override
    public String toString() {
        return this.codFisc;
    }

    public static CodFisc checkCodFisc(String nome, String cognome, String nazione, String comune, LocalDate data,
            String sex, String codFisc) {
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

    private static boolean controlloCognome(String treLettere, String cognome) {
        int iControllo = 0;

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

    private static boolean controlloNome(String treLettere, String nome) {
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

    private static boolean controllaData(String str, LocalDate data, String sex) {
    
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

    private static boolean cinquePos(String codFisc, String nazione) {
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
