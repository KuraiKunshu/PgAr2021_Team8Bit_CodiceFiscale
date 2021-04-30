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
  
    public Persona(){}

    /**
     * ritorna una stringa che indica l'id della persona
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * imposta l'id della persona
     * @param id stringa come numero
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * ritorna una stringa che indica il nome della persona
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     * imposta il nome della persona
     * @param nome stringa per nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * ritorna una stringa che indica il congnome della persona
     * @return
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * imposta il cognome della persona
     * @param cognome stringa per cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * ritorna un char che indica il sesso (M/F)
     * @return
     */
    public char getSesso() {
        return sesso;
    }

    /**
     * imposta il sesso della persona
     * @param sesso un char che deve essere 'M' o 'F'
     */
    public void setSesso(char sesso) {
        this.sesso = sesso;
    }
    /**
     * ritorna la stringa della data di nascita della persona (anno-mese-giorno)
     * @return
     */
    public String getDataDiNascita() {
        return dataDiNascita;
    }

    /**
     * imposta la data di nascita della persona
     * @param dataDiNascita stringa della data di nascita della persona (anno-mese-giorno)
     */
    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }


    /**
     * ritorna la classe comune della persona
     * @return
     */
    public Comune getComune() {
        return comune;
    }


    /**
     * imposta il comune della persona
     * @param comune
     */
    public void setComune(Comune comune) {
        this.comune = comune;
    }


    /**
     * ritorna la classe CodiceFiscale della persona
     * @return
     */
    public CodiceFiscale getCf() {
        return cf;
    }


    /**
     * imposta il codice fiscale di una persona
     * @param cf
     */
    public void setCf(CodiceFiscale cf) {
        this.cf = cf;
    }
}