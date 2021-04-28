package codiceFiscale;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class WriterXML {
    private static final String OUTPUT = "output";
    private static final String CODICI = "codici";
    private static final String NUMERO = "numero";
    private static final String CODICE_FISCALE = "codice_fiscale";
    private static final String ASSENTE = "ASSENTE";
    private static final String INVALIDI = "invalidi";
    private static final String SPAIATI = "spaiati";
    private static final String PERSONE = "persone";
    private static final String PERSONA = "persona";
    private static final String ID = "id";
    private static final String NOME = "nome";
    private static final String COGNOME = "cognome";
    private static final String SESSO = "sesso";
    private static final String COMUNE_NASCITA = "comune_nascita";
    private static final String DATA_NASCITA = "data_nascita";
    private static final String CODICE = "codice";

    /**Costruttore del WriterXML
     */
    public WriterXML(){}

    /**Metodo utilizzato per creare un file codiciPersone.xml
     * @param elenco_persone ArrayList di Persona, dal quale verranno presi i dati e scritti sul file xml.
     * @param elenco_codici_fiscali ArrayList di CodiceFiscale, contenente codici fiscali validi, che nel file xml verranno divisi in spaiati e appaiati(con una Persona).
     * @param elenco_codici_invalidi ArrayList di CodiceFiscale contenente codici fiscali non validi, che verranno scritti sul file xml.
     * @param filePath il file xml creato
     */
    public void ScriviXML(ArrayList<Persona> elenco_persone, ArrayList<CodiceFiscale> elenco_codici_fiscali, ArrayList<CodiceFiscale> elenco_codici_invalidi,String filePath) {
        //Questo frammento di codice serve a creare ed istanziare la variabile xmlw di tipo XMLStreamWriter, che
        //sarà utilizzata per scrivere il file XML. Viene inoltre inizializzato il documento XML.
        XMLOutputFactory xmlof = null;
        XMLStreamWriter xmlw = null;
        try {
            xmlof = XMLOutputFactory.newInstance();
            xmlw = xmlof.createXMLStreamWriter(new FileOutputStream(filePath), "utf-8");
            xmlw.writeStartDocument("utf-8", "1.0");
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del writer:");
            System.out.println(e.getMessage());
        }
        try {
            xmlw.writeStartElement(OUTPUT);
            xmlw.writeStartElement(PERSONE);
            xmlw.writeAttribute(NUMERO, Integer.toString(elenco_persone.size()));
            for (int i = 0; i < elenco_persone.size(); i++) {
                xmlw.writeStartElement(PERSONA);
                xmlw.writeAttribute(ID, elenco_persone.get(i).getId());
                xmlw.writeStartElement(NOME);
                xmlw.writeCharacters(elenco_persone.get(i).getNome());
                xmlw.writeEndElement();
                xmlw.writeStartElement(COGNOME);
                xmlw.writeCharacters(elenco_persone.get(i).getCognome());
                xmlw.writeEndElement();
                xmlw.writeStartElement(SESSO);
                xmlw.writeCharacters(Character.toString(elenco_persone.get(i).getSesso()));
                xmlw.writeEndElement();
                xmlw.writeStartElement(COMUNE_NASCITA);
                xmlw.writeCharacters(elenco_persone.get(i).getComune().getNome());
                xmlw.writeEndElement();
                xmlw.writeStartElement(DATA_NASCITA);
                xmlw.writeCharacters(elenco_persone.get(i).getDataDiNascita());
                xmlw.writeEndElement();
                xmlw.writeStartElement(CODICE_FISCALE);
                CodiceFiscale cf = elenco_persone.get(i).getCf();
                if (cf.isPresente(elenco_codici_fiscali))
                    xmlw.writeCharacters(elenco_persone.get(i).getCf().getCodice());
                else xmlw.writeCharacters(ASSENTE);
                xmlw.writeEndElement();
                xmlw.writeEndElement();
            }
            xmlw.writeEndElement();
        } catch (Exception e) { // se trova un errore viene eseguita questa parte
            System.out.println("Errore nella scrittura persone");
        }
        try {
            xmlw.writeStartElement(CODICI);
            xmlw.writeStartElement(INVALIDI);
            xmlw.writeAttribute(NUMERO, Integer.toString(elenco_codici_invalidi.size()));
            //Stampa codici invalidi
            for (int i=0; i<elenco_codici_invalidi.size(); i++) {
                xmlw.writeStartElement(CODICE);
                xmlw.writeCharacters(elenco_codici_invalidi.get(i).getCodice());
                xmlw.writeEndElement();
            }
            xmlw.writeEndElement();
            xmlw.writeStartElement(SPAIATI);
            xmlw.writeAttribute(NUMERO, Integer.toString(elenco_codici_fiscali.size()));
            //Stampa codici spaiati
            for (int i=0; i<elenco_codici_fiscali.size(); i++) {
                xmlw.writeStartElement(CODICE);
                xmlw.writeCharacters(elenco_codici_fiscali.get(i).getCodice());
                xmlw.writeEndElement();
            }
            xmlw.writeEndElement();
            xmlw.writeEndElement();
            xmlw.writeEndElement();
            xmlw.writeEndDocument();
            xmlw.flush();
            xmlw.close();
        } catch (Exception e) { // se trova un errore viene eseguita questa parte
            System.out.println("Errore nella scrittura codici");
        }
    }
}