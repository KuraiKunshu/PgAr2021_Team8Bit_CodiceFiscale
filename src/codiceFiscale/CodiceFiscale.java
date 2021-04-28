package codiceFiscale;

import java.sql.Array;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

public class CodiceFiscale {
    private String codice;

    private final char UOMO='M';
    private final char DONNA='F';
    private final int DIMENSIONE_PARTE_CF=3;
    private final int POSIZIONEVOCALI=0;
    private final int POSIZIONICONSONANTI=1;
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
    
    public CodiceFiscale(String nome,String cognome, String dataDiNascita, char sesso, String codiceComune) {
        this.codice = "";
        this.codice+=this.generaCognomeCF(cognome);
        this.codice+=this.generaNomeCF(nome);
        this.codice+=this.generaDataDiNascitaCF(dataDiNascita);
        this.codice+=this.generaGiornoESessoCF(dataDiNascita, sesso);
        this.codice+=codiceComune;
        this.codice+=this.generaCarattereDiControlloCF(this.codice);
    }

    public CodiceFiscale() {

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
     * @param carattere_alfabeto : � il carattere del codice fiscale che dobbiamo controllare se sia una vocale o meno.
     * @return true se il carattere preso � effettivamente una vocale.
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
     * @return true se il il carattere � effettivamente tra quelli utilizzati per indicare un mese.
     */
    public boolean meseCorretto(char lettera_per_mese) {
     
    	return arrayMesi.containsKey(lettera_per_mese);
    }
    
    /**
     * 
     * @param carattere_numerico : carattere da controllare se sia un numero o no.
     * @return true se il carattere � effettivamente numerico.
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
     * @param unit�_giorno : carattere del codice fiscale che indica l'unit� del giorno di nascita.
     * @param codiceMese : carattere del codice fiscale che identifica il mese di nascita.
     * @return true, se il giorno di nascita � compreso tra 1 e l'ultimo giorno del mese di nascita per gli uomini e tra 41 e l'ultimo giorno del mese di nascita per le donne.       
     */
    public boolean giornoCorretto(char decina_giorno, char unit�_giorno, char codiceMese) {
    	if(isNumero(decina_giorno) && isNumero(unit�_giorno)){
          int x = Integer.parseInt(String.valueOf(decina_giorno));
          int y = Integer.parseInt(String.valueOf(unit�_giorno));
          int giorno_nascita = 10*x + y;
          if((1<=giorno_nascita&&giorno_nascita<=arrayMesi.get(codiceMese))||(41<=giorno_nascita && giorno_nascita<=(arrayMesi.get(codiceMese)+40))) {
        	  return true;
          }
    	}
    	return false;
    }
    
    /**
     * 
     * @param carattere_alfabeto : carattere_alfabeto : � il carattere del codice fiscale che dobbiamo controllare se sia una consonante o meno.
     * @return true se il carattere � effettivamente una consonante;
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
     * @return true se � una vocale o una consonante, e quindi una lettera.
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
=======

    /**
     * @param lettera
     * @return ritorna true se il carattere inserito è una vocale, altrimenti false
     */
    public boolean isVocale(char lettera) {
    	for(int i = 0; i<5;i++) if(Character.toUpperCase(lettera) == vocali[i]) return true;
    	return false;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }


    /**
     * Vengono prese le consonanti del nome (o dei nomi, se ve ne è più di uno) nel loro ordine (primo nome, di seguito il secondo e così via) in questo modo:
     * se il nome contiene quattro o più consonanti, si scelgono la prima, la terza e la quarta (per esempio: Gianfranco → GFR),
     * altrimenti le prime tre in ordine (per esempio: Tiziana → TZN). Se il nome non ha consonanti a sufficienza, si prendono anche le vocali;
     * in ogni caso le vocali vengono riportate dopo le consonanti (per esempio: Luca → LCU).
     * Nel caso in cui il nome abbia meno di tre lettere la parte di codice viene completata aggiungendo la lettera X.
     * @param nome
     * @return ritorna le prime 3 lettere del codice fiscale secondo lo standard
     */

    public String generaNomeCF(String nome){
        char[][] m=getMatriceVocaliConsonanti(nome.toUpperCase());
        if(m[POSIZIONICONSONANTI].length==DIMENSIONE_PARTE_CF)return String.valueOf(m[POSIZIONICONSONANTI]);
        else if(m[POSIZIONICONSONANTI].length>DIMENSIONE_PARTE_CF)return String.valueOf(m[POSIZIONICONSONANTI][0])+String.valueOf(m[POSIZIONICONSONANTI],2,2);
        else{
            String r=String.valueOf(m[POSIZIONICONSONANTI])+String.valueOf(m[POSIZIONEVOCALI]);
            if(r.length()<DIMENSIONE_PARTE_CF)r+="XXX";
            return r.substring(0,3);
        }
    }

    /**
     * questo metodo, data una stringa, ritorna un array bidimensionale formato da un array di consonanti e uno di vocali rispetto al nome
     * @param nome
     * @return
     */
    public char[][] getMatriceVocaliConsonanti(String nome){
        String consonantiNome="";
        String vocaliNome="";
        //divido il nome nelle sue rispettive consonanti e vocali
        for(int i=0; i<nome.length();i++){
            if(isVocale(nome.charAt(i)))vocaliNome+=Character.toUpperCase(nome.charAt(i));
            else consonantiNome+=Character.toUpperCase(nome.charAt(i));
        }
        System.out.println(vocaliNome);
        System.out.println(consonantiNome);
        char[][] m=new char[2][];
        m[POSIZIONEVOCALI]=vocaliNome.toCharArray();
        m[POSIZIONICONSONANTI]=consonantiNome.toCharArray();
        return m;
    }

    /**
     * Vengono prese le consonanti del cognome (o dei cognomi, se ve ne è più di uno) nel loro ordine (primo cognome, di seguito il secondo e così via).
     * Se le consonanti sono insufficienti, si prelevano anche le vocali (se sono sufficienti le consonanti si prelevano la prima, la seconda e la terza consonante),
     * sempre nel loro ordine e, comunque, le vocali vengono riportate dopo le consonanti (per esempio: Rosi → RSO). Nel caso in cui un cognome abbia meno di tre lettere,
     * la parte di codice viene completata aggiungendo la lettera X (per esempio: Fo → FOX). Per le donne, viene preso in considerazione il solo cognome da nubile.
     * @param cognome
     * @return
     */

    public String generaCognomeCF(String cognome){
        char[][] m=getMatriceVocaliConsonanti(cognome.toUpperCase());
        if(m[POSIZIONICONSONANTI].length==DIMENSIONE_PARTE_CF)return String.valueOf(m[POSIZIONICONSONANTI]);
        else if(m[POSIZIONICONSONANTI].length>DIMENSIONE_PARTE_CF)return String.valueOf(m[POSIZIONICONSONANTI],0,3);
        else{
            String r=String.valueOf(m[POSIZIONICONSONANTI])+String.valueOf(m[POSIZIONEVOCALI]);
            if(r.length()<DIMENSIONE_PARTE_CF)r+="XXX";
            return r.substring(0,3);
        }
    }

    /**
     * Anno di nascita (due cifre): si prendono le ultime due cifre dell'anno di nascita;
     * Mese di nascita (una lettera): a ogni mese dell'anno viene associata una lettera in base all'array arrayCodiceMese
     * @param data
     * @return ritorna una stringa formata da 2 numeri e un carattere presente in arrayCodiceMese
     */
    public String generaDataDiNascitaCF(String data){
        return data.substring(2,4)+String.valueOf(arrayCodiceMese[Integer.parseInt(data.substring(5,7))-1]);
    }


    /**
     * Si prendono le due cifre del giorno di nascita (se è compreso tra 1 e 9 si pone uno zero come prima cifra);
     * per i soggetti di sesso femminile, a tale cifra va sommato il numero 40. In questo modo il campo contiene la doppia informazione giorno di nascita e sesso.
     * Avremo pertanto la seguente casistica: i maschi avranno il giorno con cifra da 01 a 31, mentre per le donne la cifra relativa al giorno sarà da 41 a 71.
     * @param data
     * @param sesso
     * @return ritorna una stringa formata da 2 cifre
     */
    public String generaGiornoESessoCF(String data, char sesso){
        String d=data.substring(data.length()-2);
        if(Character.toUpperCase(sesso)==UOMO)return d;
        else return String.valueOf(Integer.parseInt(d)+40);
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
