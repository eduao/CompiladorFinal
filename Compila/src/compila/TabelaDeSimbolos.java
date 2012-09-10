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
public class TabelaDeSimbolos extends Hashtable<String, Linha> {

    public TabelaDeSimbolos() {
        //carregarPalavrasReservadas();
    }
    

    @Override
    public synchronized String toString() {
        ValueComparator valueComparator =  new ValueComparator(this);
        TreeMap<String, Linha> hashTableOrdenada = new TreeMap<String, Linha>(valueComparator);
        hashTableOrdenada.putAll(this);
        String str;
        str = "======================================================";
        str = str + "\nImprimindo a tabela de simbolos...";
        for (String lexema : hashTableOrdenada.keySet()) {
            str = str + "\n[" + padronizarTam(lexema, 5) + ", " + padronizarTam(get(lexema).getToken(), 20) + "]";
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
    
    

    
    
    class ValueComparator implements Comparator<String> {

        Map<String, Linha> base;
        
        public ValueComparator(Map<String, Linha> base) {
            this.base = base;            
        }

        // Note: this comparator imposes orderings that are inconsistent with equals.    
       /* public int compare(Linha a, Linha b) {
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
