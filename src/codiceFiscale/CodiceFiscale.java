package codiceFiscale;

import java.util.AbstractMap;
import java.util.Map;

public class CodiceFiscale {
    private String codice;
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
    private final Map<Character, Integer> arrayMesi =Map.ofEntries(
    		  new AbstractMap.SimpleEntry<>('A',31),
              new AbstractMap.SimpleEntry<>('B',28),
              new AbstractMap.SimpleEntry<>('C',31),
              new AbstractMap.SimpleEntry<>('D',30),
              new AbstractMap.SimpleEntry<>('E',31),
              new AbstractMap.SimpleEntry<>('H',30),
              new AbstractMap.SimpleEntry<>('L',31),
              new AbstractMap.SimpleEntry<>('M',31),
              new AbstractMap.SimpleEntry<>('P',30),
              new AbstractMap.SimpleEntry<>('R',31),
              new AbstractMap.SimpleEntry<>('S',30),
              new AbstractMap.SimpleEntry<>('T',31)
    );
    public CodiceFiscale() {
    	
    }
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
    
 /*------------------------------------------------------------------------------------------------------------*/
    /**
     * 
     * @param carattere_alfabeto : è il carattere del codice fiscale che dobbiamo controllare se sia una vocale o meno.
     * @return true se il carattere preso è effettivamente una vocale.
     */
    public boolean isVocale(char carattere_alfabeto) {
    	for(int i = 0; i<vocali.length;i++) {
    		if(carattere_alfabeto == vocali[i]) {
    			return true;
    		}	
    	}
    	return false;
    }
    
    /**
     * 
     * @param lettera_per_mese : carattere alfabetico che dovrebbe indicare il mese di nascita.
     * @return true se il il carattere è effettivamente tra quelli utilizzati per indicare un mese.
     */
    public boolean meseCorretto(char lettera_per_mese) {
     
    	return arrayMesi.containsKey(lettera_per_mese);
    }
    
    /**
     * 
     * @param carattere_numerico : carattere da controllare se sia un numero o no.
     * @return true se il carattere è effettivamente numerico.
     */
    public boolean isNumero(char carattere_numerico) {
    	try {
            Integer.parseInt(String.valueOf(carattere_numerico));
            }
            catch(NumberFormatException e) {
            	return false;
            }
    	return true;
    }
    
    /**
     * 
     * @param decina_giorno : carattere del codice fiscale che indica la decina del giorno di nascita. 
     * @param unità_giorno : carattere del codice fiscale che indica l'unità del giorno di nascita.
     * @param codiceMese : carattere del codice fiscale che identifica il mese di nascita.
     * @return true, se il giorno di nascita è compreso tra 1 e l'ultimo giorno del mese di nascita per gli uomini e tra 41 e l'ultimo giorno del mese di nascita per le donne.       
     */
    public boolean giornoCorretto(char decina_giorno, char unità_giorno, char codiceMese) {
    	if(isNumero(decina_giorno) && isNumero(unità_giorno)){
          int x = Integer.parseInt(String.valueOf(decina_giorno));
          int y = Integer.parseInt(String.valueOf(unità_giorno));
          int giorno_nascita = 10*x + y;
          if((1<=giorno_nascita&&giorno_nascita<=arrayMesi.get(codiceMese))||(41<=giorno_nascita && giorno_nascita<=(arrayMesi.get(codiceMese)+40))) {
        	  return true;
          }
    	}
    	return false;
    }
    
    /**
     * 
     * @param carattere_alfabeto : carattere_alfabeto : è il carattere del codice fiscale che dobbiamo controllare se sia una consonante o meno.
     * @return true se il carattere è effettivamente una consonante;
     */
    public boolean isConsonante(char carattere_alfabeto) {
    	for(int i = 0; i<consonanti.length;i++) {
    		if(carattere_alfabeto == consonanti[i]) {
    			return true;
    		}	
    	}
    	return false;
    }
    
    /**
     * 
     * @param carattere : carattere del codice fiscale da controllare se sia una lettera o no.
     * @return true se è una vocale o una consonante, e quindi una lettera.
     */
    public boolean isLettera(char carattere) {
    	if(isVocale(carattere)) {
    		return true;
    	}
    	if(isConsonante(carattere)) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * 
     * @param codice : codice fiscale presente nell'array di codici forniti dal fale xml.
     * @return true se il codice non presenta nessun errore di sorta a seguito dei vari controlli precedenti.
     */
    public boolean isValido(String codice) {
       char[] codiceFiscale = codice.toCharArray();
       if(codice.length()!=16) {
    	   return false;
       }
       if((isVocale(codiceFiscale[0])) && isVocale(codiceFiscale[3])) {
     	  return false;
       }
       if(isVocale(codiceFiscale[1])) {
    	   if(!isVocale(codiceFiscale[2])) {
    		   return false; 
               }
       }  
       if(isVocale(codiceFiscale[4])) {
    	   if(!isVocale(codiceFiscale[5])) {
    		   return false; 
               }
       }  
       if(!(isNumero(codiceFiscale[6])||isNumero(codiceFiscale[7]))) {
    	   return false;
       }
       if(!meseCorretto(codiceFiscale[8])) {
    	   return false;
       }
       if(!giornoCorretto(codiceFiscale[9],codiceFiscale[10], codiceFiscale[8])) {
    	   return false;
       }
       if(!isLettera(codiceFiscale[11])) {
    	   return false;
       }
       if((!isNumero(codiceFiscale[12]))||(!isNumero(codiceFiscale[13]))||(!isNumero(codiceFiscale[14]))) {
    	   return false;
       }
       
       if(!(codiceFiscale[15]==generaCarattereDiControlloCF(codice.substring(0, 15)))) {
    	   return false;
       }
       
       return true;
     }
 /*---------------------------------------------------------------------------------------------------*/      
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
    
    public char generaCarattereDiControlloCF(String codiceParziale){
    	int valoreCarattere=0;
    	for(int i=0; i<codiceParziale.length();i++) {
    		if(i%2==0) {
    			valoreCarattere+=arrayCaratteriAlfanumericiDispari.get(codiceParziale.charAt(i));
    		}
    		else {
    			valoreCarattere+=arrayCaratteriAlfanumericiPari.get(codiceParziale.charAt(i));
    		}
    	}
        return resto[valoreCarattere%26];
    }
}
