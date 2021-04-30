package codiceFiscale;

public class Main {
    static public void main(String[] args){
        //stringhe per indicere la posizione relativa dei file in input e output
        String firstPath="src/xmlFile/";
        String comuniFile="comuni.xml";
        String codiciFiscaliFile="codiciFiscali.xml";
        String inputPersoneFile="inputPersone.xml";
        String nomeOutputFile="codiciPersone.xml";
        //input
        ReaderXML lettore = new ReaderXML();
        lettore.LeggiXMLComuni(firstPath+comuniFile);
        lettore.LeggiXMLCodiciFiscali(firstPath+codiciFiscaliFile);
        lettore.LeggiXMLInputPersone(firstPath+inputPersoneFile);
        //output
        WriterXML scrittore = new WriterXML();
        scrittore.ScriviXML(lettore.getElenco_persone(),lettore.getElenco_codici_fiscali(),lettore.getElenco_codici_invalidi(),firstPath+nomeOutputFile);

        System.out.println("fine");
    }
}