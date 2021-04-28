package codiceFiscale;

public class Comune {
    String nome;
    String codice;

    public Comune(String nome) {
        this.nome = nome;
    }

    public Comune(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }
}
