package codiceFiscale;

public class Main {
    static public void main(String[] args){
        System.out.println(System.getProperty("java.class.path")+"\\xmlFile\\comuni.xml");
        ReaderXML lettore = new ReaderXML();
        lettore.LeggiXMLComuni(System.getProperty("java.class.path")+"\\xmlFile\\comuni.xml");
    }
}