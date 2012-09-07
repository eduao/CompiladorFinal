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
public class TabelaDeSimbolos extends Hashtable<String, Integer> {

    public TabelaDeSimbolos() {
        //carregarPalavrasReservadas();
    }

    @Override
    public synchronized String toString() {
        ValueComparator valueComparator =  new ValueComparator(this);
        TreeMap<String, Integer> hashTableOrdenada = new TreeMap<String, Integer>(valueComparator);
        hashTableOrdenada.putAll(this);
        String str;
        str = "======================================================";
        str = str + "\nImprimindo a tabela de simbolos...";
        for (String lexema : hashTableOrdenada.keySet()) {
            str = str + "\n[" + padronizarTam(get(lexema).toString(), 5) + ", " + padronizarTam(lexema, 20) + "]";
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

    class ValueComparator implements Comparator<String> {

        Map<String, Integer> base;

        public ValueComparator(Map<String, Integer> base) {
            this.base = base;
        }

        // Note: this comparator imposes orderings that are inconsistent with equals.    
        public int compare(String a, String b) {
            if (base.get(a) < base.get(b)) {
                return -1;
            } else {
                return 1;
            } // returning 0 would merge keys
        }
    }
}
