package codiceFiscale;

public class Main {
    static public void main(String[] args){
        //pppppp
    	CodiceFiscale c= new CodiceFiscale();
    	if(c.isValido("MRSVCN01P25G813J@@@@@")) {
        System.out.println("� valido");
    }
    	else{
    		System.out.println("� falso");
    	}
    }
}