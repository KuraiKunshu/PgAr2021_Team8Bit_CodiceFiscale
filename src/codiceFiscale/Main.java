package codiceFiscale;

public class Main {
    static public void main(String[] args){
        String firstPath="src/xmlFile/";
        String comuniFile="comuni.xml";
        String codiciFiscaliFile="codiciFiscali.xml";
        String inputPersoneFile="inputPersone.xml";
        String nomeOutputFile="codiciPersone.xml";
        ReaderXML lettore = new ReaderXML();
        lettore.LeggiXMLComuni(firstPath+comuniFile);
        lettore.LeggiXMLCodiciFiscali(firstPath+codiciFiscaliFile);
        lettore.LeggiXMLInputPersone(firstPath+inputPersoneFile);
        WriterXML scrittore = new WriterXML();
        scrittore.ScriviXML(lettore.getElenco_persone(),lettore.getElenco_codici_fiscali(),lettore.getElenco_codici_invalidi(),firstPath+nomeOutputFile);
        System.out.println("fine");
    }
}