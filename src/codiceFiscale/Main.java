package codiceFiscale;

import java.util.Arrays;

public class Main {
    static public void main(String[] args){
        //pppppp
        System.out.println("Funziona?");
        String nome="gbttill";
        CodiceFiscale x=new CodiceFiscale();
        //char[][] nomeCF=x.getMatriceVocaliConsonanti(nome);
        //System.out.println(x.isVocale(nome.charAt(1)));
        //System.out.println(nomeCF[0].length);
        System.out.println(x.generaNomeCF(nome));

    }

}