package codiceFiscale;

public class Comune {
    String nome;
    String codice;

    /**
     * crea l'istanza di un comune
     * @param nome      stringa che indica il nome del comune
     * @param codice    stringa formata dal 1 caratere dell'alfabeto e 3 numeri (tutto in formato stringa)
     */
    public Comune(String nome, String codice) {
        this.nome = nome;
        this.codice = codice;
    }

    /**
     * costruttore vuoto in caso di necessita
     */
    public Comune(){}

    /**
     * ritorna il nome del comune
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     * imposta il nome del comune
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * ritorna il codice del comune
     * @return
     */
    public String getCodice() {
        return codice;
    }

    /**
     * imposta il codice del comune
     * @param codice
     */
    public void setCodice(String codice) {
        this.codice = codice;
    }
}
