package codiceFiscale;

public class Main {
    static public void main(String[] args){
        //creo delle stringhe per indicare i file e la loro posizione relativa in comune(firstPath)
        String firstPath="src/xmlFile/";
        String comuniFile="comuni.xml";
        String codiciFiscaliFile="codiciFiscali.xml";
        String inputPersoneFile="inputPersone.xml";
        String nomeOutputFile="codiciPersone.xml";
        //inizìalizzo la classe che andrà a leggere i file xml
        ReaderXML lettore = new ReaderXML();
        //prendo i vari dati dai file xml
        lettore.LeggiXMLComuni(firstPath+comuniFile);
        lettore.LeggiXMLCodiciFiscali(firstPath+codiciFiscaliFile);
        lettore.LeggiXMLInputPersone(firstPath+inputPersoneFile);
        //inizzializo la classe che andra a generare il file di output xml
        WriterXML scrittore = new WriterXML();
        //chiamo il metodo per creare la classe
        scrittore.ScriviXML(lettore.getElenco_persone(),lettore.getElenco_codici_fiscali(),lettore.getElenco_codici_invalidi(),firstPath+nomeOutputFile);
        System.out.println("Programma Terminato");
    }
}