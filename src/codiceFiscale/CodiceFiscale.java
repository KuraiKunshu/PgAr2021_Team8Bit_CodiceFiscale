package codiceFiscale;

import java.util.AbstractMap;
import java.util.Map;

public class CodiceFiscale {
    private String codice;
    private boolean valido;
    private final char[] arrayCodiceMese={'A','B','C','D','E','H','L','M','P','R','S','T'};
    private final char[] resto={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    private final char[] consonanti={'B','C','D','F','G','H','J','K','L','M','N','P','Q','R','S','T','V','W','X','Y','Z'};
    private final char[] vocali={'A','E','I','O','U'};
    private final Map<Character, Integer> arrayCaratteriAlfanumericiDispari=Map.ofEntries(
            new AbstractMap.SimpleEntry<>('0',1),
            new AbstractMap.SimpleEntry<>('1',0),
            new AbstractMap.SimpleEntry<>('2',5),
            new AbstractMap.SimpleEntry<>('3',7),
            new AbstractMap.SimpleEntry<>('4',9),
            new AbstractMap.SimpleEntry<>('5',13),
            new AbstractMap.SimpleEntry<>('6',15),
            new AbstractMap.SimpleEntry<>('7',17),
            new AbstractMap.SimpleEntry<>('8',19),
            new AbstractMap.SimpleEntry<>('9',21),
            new AbstractMap.SimpleEntry<>('A',1),
            new AbstractMap.SimpleEntry<>('B',0),
            new AbstractMap.SimpleEntry<>('C',5),
            new AbstractMap.SimpleEntry<>('D',7),
            new AbstractMap.SimpleEntry<>('E',9),
            new AbstractMap.SimpleEntry<>('F',13),
            new AbstractMap.SimpleEntry<>('G',15),
            new AbstractMap.SimpleEntry<>('H',17),
            new AbstractMap.SimpleEntry<>('I',19),
            new AbstractMap.SimpleEntry<>('J',21),
            new AbstractMap.SimpleEntry<>('K',2),
            new AbstractMap.SimpleEntry<>('L',4),
            new AbstractMap.SimpleEntry<>('M',18),
            new AbstractMap.SimpleEntry<>('N',20),
            new AbstractMap.SimpleEntry<>('O',11),
            new AbstractMap.SimpleEntry<>('P',3),
            new AbstractMap.SimpleEntry<>('Q',6),
            new AbstractMap.SimpleEntry<>('R',8),
            new AbstractMap.SimpleEntry<>('S',12),
            new AbstractMap.SimpleEntry<>('T',14),
            new AbstractMap.SimpleEntry<>('U',16),
            new AbstractMap.SimpleEntry<>('V',10),
            new AbstractMap.SimpleEntry<>('W',22),
            new AbstractMap.SimpleEntry<>('X',25),
            new AbstractMap.SimpleEntry<>('Y',24),
            new AbstractMap.SimpleEntry<>('Z',23)
    );
    // CREARE SOLO UN ARRAY ALFABETO INVECE CHE MAP PER I PARI?
    private final Map<Character, Integer> arrayCaratteriAlfanumericiPari =Map.ofEntries(
            new AbstractMap.SimpleEntry<>('0',0),
            new AbstractMap.SimpleEntry<>('1',1),
            new AbstractMap.SimpleEntry<>('2',2),
            new AbstractMap.SimpleEntry<>('3',3),
            new AbstractMap.SimpleEntry<>('4',4),
            new AbstractMap.SimpleEntry<>('5',5),
            new AbstractMap.SimpleEntry<>('6',6),
            new AbstractMap.SimpleEntry<>('7',7),
            new AbstractMap.SimpleEntry<>('8',8),
            new AbstractMap.SimpleEntry<>('9',9),
            new AbstractMap.SimpleEntry<>('A',0),
            new AbstractMap.SimpleEntry<>('B',1),
            new AbstractMap.SimpleEntry<>('C',2),
            new AbstractMap.SimpleEntry<>('D',3),
            new AbstractMap.SimpleEntry<>('E',4),
            new AbstractMap.SimpleEntry<>('F',5),
            new AbstractMap.SimpleEntry<>('G',6),
            new AbstractMap.SimpleEntry<>('H',7),
            new AbstractMap.SimpleEntry<>('I',8),
            new AbstractMap.SimpleEntry<>('J',9),
            new AbstractMap.SimpleEntry<>('K',10),
            new AbstractMap.SimpleEntry<>('L',11),
            new AbstractMap.SimpleEntry<>('M',12),
            new AbstractMap.SimpleEntry<>('N',13),
            new AbstractMap.SimpleEntry<>('O',14),
            new AbstractMap.SimpleEntry<>('P',15),
            new AbstractMap.SimpleEntry<>('Q',16),
            new AbstractMap.SimpleEntry<>('R',17),
            new AbstractMap.SimpleEntry<>('S',18),
            new AbstractMap.SimpleEntry<>('T',19),
            new AbstractMap.SimpleEntry<>('U',20),
            new AbstractMap.SimpleEntry<>('V',21),
            new AbstractMap.SimpleEntry<>('W',22),
            new AbstractMap.SimpleEntry<>('X',23),
            new AbstractMap.SimpleEntry<>('Y',24),
            new AbstractMap.SimpleEntry<>('Z',25)
    );

    public CodiceFiscale(String nome,String cognome, String dataDiNascita, char sesso, String comune) {
        this.codice = "";
        this.codice+=this.generaNomeCF(nome);
        this.codice+=this.generaCognomeCF(cognome);
        this.codice+=this.generaDataDiNascitaCF(dataDiNascita);
        this.codice+=this.generaGiornoESessoCF(dataDiNascita, sesso);
        this.codice+=this.generaCarattereDiControlloCF(this.codice);
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }
    public boolean isVocale(char lettera) {
    	for(int i = 0; i<5;i++) {
    		if(lettera == vocali[i]) {
    			return true;
    		}	
    	}
    	return false;
    }
   /* public boolean isValido(String codice) {
       char[] codiceFiscale = codice.toCharArray();
       for(int i=0; i<16; i++) {
    	   if(i==0) {
              if(isVocale(codiceFiscale[0])) {
            	  return false;
              }
    	   }
           if((i>0)&&(i<3)) {
        	   
           }
       }  
     }*/
       

    public void setValido(boolean valido) {
        this.valido = valido;
    }
    public String generaNomeCF(String nome){
        String nomeCF;
        return null;
    }
    public String generaCognomeCF(String cognome){
        return null;
    }
    public String generaDataDiNascitaCF(String data){
        return null;
    }
    public String generaGiornoESessoCF(String data, char sesso){
        return null;
    }
    public String generaCarattereDiControlloCF(String codiceParziale){
        return null;
    }
}
