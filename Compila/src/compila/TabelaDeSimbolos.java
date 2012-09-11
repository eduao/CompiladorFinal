/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compila;

import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Augusto FADC
 */
public class TabelaDeSimbolos extends Hashtable<String, Registro> {

    static byte IDToken = 38;
    static byte CONSTToken = 39;
    
    public TabelaDeSimbolos() {
        carregarPalavrasReservadas();
    }
    

    @Override
    public synchronized String toString() {
        ValueComparator valueComparator =  new ValueComparator(this);
        TreeMap<String, Registro> hashTableOrdenada = new TreeMap<String, Registro>(valueComparator);
        hashTableOrdenada.putAll(this);
        String str;
        str = "======================================================";
        str = str + "\nImprimindo a tabela de simbolos...";
        for (String lexema : hashTableOrdenada.keySet()) {
            str = str + "\n[" + padronizarTam(get(lexema).getToken()+"", 5) + ", " + padronizarTam(lexema, 20) + "]";
        }
        str = str + "\n======================================================";
        return str;
    }

    public String padronizarTam(String str, int tam) {
        String retorno = str;
        while (retorno.length() < tam) {
            retorno = retorno + " ";
        }
        return retorno;
    }
    
     public String padronizarTam(Integer str, int tam) {
        String retorno = str+"";
        while (retorno.length() < tam) {
            retorno = retorno + " ";
        }
        return retorno;
    }
     
     private void carregarPalavrasReservadas() {
        System.out.println("Abastecendo a tabela de palavras reservadas...");
        this.put("DPonto", new Registro("DPonto", (byte) 1));
        this.put("DFace", new Registro("DFace", (byte) 2));
        this.put("DObjeto", new Registro("DObjeto", (byte) 3));
        this.put("DCor", new Registro("DCor", (byte) 4));
        this.put("DLuz", new Registro("DLuz", (byte) 5));
        this.put("DVar", new Registro("DVar", (byte) 6));
        this.put("DConst", new Registro("DConst", (byte) 7));
        this.put("inteiro", new Registro("inteiro", (byte) 8));
        this.put("real", new Registro("real", (byte) 9));
        this.put("Escala", new Registro("Escala", (byte) 10));
        this.put("Pausa", new Registro("Pausa", (byte) 11));
        this.put("Rottrans", new Registro("Rottrans", (byte) 12));
        this.put("Enquanto", new Registro("Enquanto", (byte) 13));
        this.put("faca", new Registro("faca", (byte) 14));
        this.put("Se", new Registro("Se", (byte) 15));
        this.put("entao", new Registro("entao", (byte) 16));
        this.put("senao", new Registro("senao", (byte) 17));
        this.put("E", new Registro("E", (byte) 18));
        this.put("OU", new Registro("OU", (byte) 19));
        this.put("NAO", new Registro("NAO", (byte) 20));
        this.put("==", new Registro("==", (byte) 21));
        this.put("=", new Registro("=", (byte) 22));
        this.put("(", new Registro("(", (byte) 23));
        this.put(")", new Registro(")", (byte) 24));
        this.put(",", new Registro(",", (byte) 25));
        this.put("+", new Registro("+", (byte) 26));
        this.put("-", new Registro("-", (byte) 27));
        this.put("*", new Registro("*", (byte) 28));
        this.put("<", new Registro("<", (byte) 29));
        this.put(">", new Registro(">", (byte) 30));
        this.put("<>", new Registro("<>", (byte) 31));
        this.put(">=", new Registro(">=", (byte) 32));
        this.put("<=", new Registro("<=", (byte) 33));
        this.put("/", new Registro("/", (byte) 34));
        this.put("inicio", new Registro("inicio", (byte) 35));
        this.put("fim", new Registro("fim", (byte) 36));
        this.put("Luz", new Registro("Luz", (byte) 37));
        System.out.println("Palavras Reservadas carregadas...");
    }
    
    

    
    
    class ValueComparator implements Comparator<String> {

        Map<String, Registro> base;
        
        public ValueComparator(Map<String, Registro> base) {
            this.base = base;            
        }

        // Note: this comparator imposes orderings that are inconsistent with equals.    
       /* public int compare(Registro a, Registro b) {
            if (a.getToken() < b.getToken()) {
                return -1;
            } else {
                return 1;
            } // returning 0 would merge keys
        }*/

        @Override
        public int compare(String o1, String o2) {
            if (base.get(o1).getToken() < base.get(o2).getToken()) {
                return -1;
            } else {
                return 1;
            } // returning 0 would merge keys
            /*throw new UnsupportedOperationException("Not supported yet.");*/
        }

       
    }
    
}
