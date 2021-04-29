package codiceFiscale;

public class Main {
    static public void main(String[] args){
        String comuniFile="comuni.xml";
        String firstPath=System.getProperty("java.class.path")+"\\xmlFile\\";
        String comuniPath=firstPath+comuniFile;
        ReaderXML lettore = new ReaderXML();
        lettore.LeggiXMLComuni(comuniPath);
    }
}