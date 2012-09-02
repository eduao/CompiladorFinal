/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compila;

import java.util.Hashtable;

/**
 *
 * @author Augusto FADC
 */
public class TabelaDePalavrasReservadas extends Hashtable<Token, ID> {

    public TabelaDePalavrasReservadas() {
        carregarPalavrasReservadas();
    }
    
    
    private void carregarPalavrasReservadas() {
        System.out.println("Abastecendo a tabela de palavras reservadas...");
        put(new Token("DPonto"), new ID(1));
        put(new Token("DFace"), new ID(2));
        put(new Token("DObjeto"), new ID(3));
        put(new Token("DCor"), new ID(4));
        put(new Token("DLuz"), new ID(5));
        put(new Token("DVar"), new ID(6));
        put(new Token("DConst"), new ID(7));
        put(new Token("inteiro"), new ID(8));
        put(new Token("real"), new ID(9));
        put(new Token("Escala"), new ID(10));
        put(new Token("Pausa"), new ID(11));
        put(new Token("Rottrans"), new ID(12));
        put(new Token("Enquanto"), new ID(13));
        put(new Token("faca"), new ID(14));
        put(new Token("Se"), new ID(15));
        put(new Token("entao"), new ID(16));
        put(new Token("senao"), new ID(17));
        put(new Token("E"), new ID(18));
        put(new Token("OU"), new ID(19));
        put(new Token("NAO"), new ID(20));
        put(new Token("=="), new ID(21));
        put(new Token("="), new ID(22));
        put(new Token("("), new ID(23));
        put(new Token(")"), new ID(24));
        put(new Token(","), new ID(25));
        put(new Token("+"), new ID(26));
        put(new Token("-"), new ID(27));
        put(new Token("*"), new ID(28));
        put(new Token("<"), new ID(29));
        put(new Token(">"), new ID(30));
        put(new Token("<>"), new ID(31));
        put(new Token(">="), new ID(32));
        put(new Token("<="), new ID(33));
        put(new Token("/"), new ID(34));
        put(new Token("inicio"), new ID(35));
        put(new Token("fim"), new ID(36));
        System.out.println("Palavras Reservadas carregadas...");
    }
}
