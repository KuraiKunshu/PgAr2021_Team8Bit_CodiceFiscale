package codiceFiscale;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Map;

public class ReaderXML {
    private static final String PERSONA = "persona";
    private static final String NOME = "nome";
    private static final String COGNOME = "cognome";
    private static final String SESSO = "sesso";
    private static final String COMUNE_NASCITA = "comune_nascita";
    private static final String DATA_NASCITA = "data_nascita";
    private static final String CODICE = "codice";
    private static final String COMUNE = "comune";

    private Map<String, String> elenco_comuni;
    private ArrayList<CodiceFiscale> elenco_codici_fiscali;
    private ArrayList<CodiceFiscale> elenco_codici_invalidi;
    private ArrayList<Persona> elenco_persone;

    public Map<String, String> getElenco_comuni() {
        return elenco_comuni;
    }

    public ArrayList<CodiceFiscale> getElenco_codici_fiscali() {
        return elenco_codici_fiscali;
    }

    public void setElenco_codici_fiscali(ArrayList<CodiceFiscale> elenco_codici_fiscali) {
        this.elenco_codici_fiscali = elenco_codici_fiscali;
    }

    public ArrayList<CodiceFiscale> getElenco_codici_invalidi() {
        return elenco_codici_invalidi;
    }

    public void setElenco_codici_invalidi(ArrayList<CodiceFiscale> elenco_codici_invalidi) {
        this.elenco_codici_invalidi = elenco_codici_invalidi;
    }

    public ArrayList<Persona> getElenco_persone() {
        return elenco_persone;
    }

    public void setElenco_persone(ArrayList<Persona> elenco_persone) {
        this.elenco_persone = elenco_persone;
    }

    /**Costruttore di ReaderXML.
     * Inizializza gli ArrayList che verranno riempiti durante la lettura dell'xml.
     */
    public ReaderXML() {
        elenco_codici_fiscali = new ArrayList<CodiceFiscale>();
        elenco_codici_invalidi = new ArrayList<CodiceFiscale>();
        elenco_persone = new ArrayList<Persona>();
    }

    /**Metodo che serve per leggere il file comuni.xml, analizzare i dati contenuti nell'xml attraverso
     * i metodi dello XMLStreamReader e creare un Map<String, String> costituito dal nome del comune
     * e dal rispettivo codice.
     * @param filename il file comuni.xml che verrà fornito al metodo alla chiamata nel Main.
     */
    public void LeggiXMLComuni (String filename) {
        //Questo frammento di codice serve a creare ed istanziare la variabile xmlr di tipo XMLStreamReader, che sarà
        //utilizzata per leggere il file XML
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;
        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(filename, new FileInputStream(filename));
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }
        Comune c = null;
        try{
            while (xmlr.hasNext()) {
                if (xmlr.getEventType() == XMLStreamConstants.START_ELEMENT) {
                    String nome_tag = xmlr.getLocalName();
                    switch (nome_tag) {
                        case COMUNE:
                            c = new Comune();
                            break;
                        case NOME:
                            xmlr.next();
                            c.setNome(xmlr.getText());
                            xmlr.next();
                            break;
                        case CODICE:
                            xmlr.next();
                            c.setCodice(xmlr.getText());
                            xmlr.next();
                            break;
                    }
                } else if (xmlr.getEventType() == XMLStreamConstants.END_ELEMENT) {
                    if (xmlr.getLocalName().equals(COMUNE)) {
                        elenco_comuni.put(c.getNome(), c.getCodice());
                    }
                }
                xmlr.next();
            }
        }catch (Exception e){
            System.out.println("Errore nella lettura di comuni.xml:");
            System.out.println(e.getMessage());
        }
        return;
    }

    /**Metodo che serve per leggere il file codiciFiscali.xml, analizzare i dati contenuti nell'xml attraverso
     * i metodi dello XMLStreamReader e aggiungere i codici fiscali nei 2 ArrayList di CodiceFiscale
     * inizializzati nel costruttore del ReaderXML. I codici fiscali validi vengono aggiunti
     * nell'ArrayList elenco_codici_fiscali, quelli non validi nell'ArrayList elenco_codici_invalidi.
     * @param filename il file codiciFiscali.xml che verrà fornito al metodo alla chiamata nel Main.
     */
    public void LeggiXMLCodiciFiscali (String filename) {
        //Questo frammento di codice serve a creare ed istanziare la variabile xmlr di tipo XMLStreamReader, che sarà
        //utilizzata per leggere il file XML
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;
        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(filename, new FileInputStream(filename));
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }
        CodiceFiscale c = null;
        try{
            while (xmlr.hasNext()) {
                if (xmlr.getEventType() == XMLStreamConstants.START_ELEMENT) {
                    String nome_tag = xmlr.getLocalName();
                    if (nome_tag.equals(CODICE)) {
                        c = new CodiceFiscale();
                        xmlr.next();
                        c.setCodice(xmlr.getText());
                        xmlr.next();
                    }
                } else if (xmlr.getEventType() == XMLStreamConstants.END_ELEMENT) {
                    if (xmlr.getLocalName().equals(CODICE))
                        if (c.isValido())
                            elenco_codici_fiscali.add(c);
                        else elenco_codici_invalidi.add(c);
                }
                xmlr.next();
            }
        }catch (Exception e){
            System.out.println("Errore nella lettura di codiciFiscali.xml:");
            System.out.println(e.getMessage());
        }
        return;
    }

    /**Metodo che serve per leggere il file inputPersone.xml e analizzare i dati contenuti nell'xml attraverso
     * i metodi dello XMLStreamReader. Crea oggetti di classe Persona che hanno come attributi id, nome, cognome, sesso,
     * data di nascita, Comune (nome e codice) e crea per ognuno il codice fiscale. I vari oggetti
     * Persona vengono aggiunti all'ArrayList elenco_persone, già inizializzato nel costruttore del ReaderXML.
     * @param filename il file inputPersone.xml che verrà fornito al metodo alla chiamata nel Main.
     */
    public void LeggiXMLInputPersone (String filename){
        //Questo frammento di codice serve a creare ed istanziare la variabile xmlr di tipo XMLStreamReader, che sarà
        //utilizzata per leggere il file XML
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;
        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(filename, new FileInputStream(filename));
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }
        Persona p = null;
        try{
            while (xmlr.hasNext()){
                if (xmlr.getEventType() == XMLStreamConstants.START_ELEMENT){
                    String nome_tag = xmlr.getLocalName();
                    switch (nome_tag){
                        case PERSONA:
                            p = new Persona();
                            p.setId(xmlr.getAttributeValue(0));
                            break;
                        case NOME:
                            xmlr.next();
                            p.setNome(xmlr.getText());
                            xmlr.next();
                            break;
                        case COGNOME:
                            xmlr.next();
                            p.setCognome(xmlr.getText());
                            xmlr.next();
                            break;
                        case SESSO:
                            xmlr.next();
                            p.setSesso(xmlr.getText().charAt(0));
                            xmlr.next();
                            break;
                        case COMUNE_NASCITA:
                            xmlr.next();
                            String comune = xmlr.getText();
                            p.setComune(new Comune(comune, elenco_comuni.get(comune)));
                            xmlr.next();
                            break;
                        case DATA_NASCITA:
                            xmlr.next();
                            p.setDataDiNascita(xmlr.getText());
                            xmlr.next();
                            break;
                    }
                }
                else if (xmlr.getEventType() == XMLStreamConstants.END_ELEMENT){
                    if (xmlr.getLocalName().equals(PERSONA))
                        p.setCf(new CodiceFiscale(p.getNome(), p.getCognome(), p.getDataDiNascita(), p.getSesso(), p.getComune().getCodice()));
                        elenco_persone.add(p);
                }
                xmlr.next();
            }
        }catch (Exception e){
            System.out.println("Errore nella lettura di inputPersone.xml:");
            System.out.println(e.getMessage());
        }
        return;
    }
}