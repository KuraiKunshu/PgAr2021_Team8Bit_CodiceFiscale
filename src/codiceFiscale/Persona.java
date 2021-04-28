package codiceFiscale;

public class Persona {
    //FARE LA JAVADOC
    private String id;
    private String nome;
    private String cognome;
    private char sesso;
    private String dataDiNascita;
    private Comune comune;
    private CodiceFiscale cf;
    //meglio instanziare un comune ogni volta o fare che punti a qualcosa?
    /*public Persona(int id, String nome, String cognome, char sesso, String dataDiNascita, String comune) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.sesso = sesso;
        this.dataDiNascita = dataDiNascita;
        this.comune=new Comune(comune);
        this.cf=new CodiceFiscale(nome, cognome,  dataDiNascita, sesso, this.comune.getCodice());
    }*/

    public Persona(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public char getSesso() {
        return sesso;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Comune getComune() {
        return comune;
    }

    public void setComune(Comune comune) {
        this.comune = comune;
    }

    public CodiceFiscale getCf() {
        return cf;
    }

    public void setCf(CodiceFiscale cf) {
        this.cf = cf;
    }
}