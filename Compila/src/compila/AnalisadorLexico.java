/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compila;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Hashtable;

/**
 *
 * @author Eduardo
 */
public class AnalisadorLexico {

    static InputStreamReader br;
    static int ultimoID = -1;
    static int posicao;
    static int estado = 0;
    static Hashtable<Lexema, ID> tabelaDeSimbolos = Main.tabelaDeSimbolos;

    public AnalisadorLexico() throws IOException {

        for (ID a : tabelaDeSimbolos.values()){
            int valorDado;
            if ((valorDado = a.getID()) > ultimoID){
                ultimoID= valorDado;
            }
        }
        br = Main.br;
        int valorChar, valorCharAnterior;
        char c;
        boolean fimArquivo = false;
        Lexema l = new Lexema();
        while (br.ready() && !fimArquivo) {
            valorChar = br.read();
            c = (char) valorChar;
            if (valorChar == -1) {
                fimArquivo = true;
            } else {
                switch (estado) {
                    case 0:
                        
                        if (Character.isDigit(valorChar)) {
                            estado = 1;
                            l.setLexema(l.getLexema().concat("" + c));
                        }
                        break;
                    case 1:
                        if (Character.isDigit(c)){
                            l.setLexema(l.getLexema().concat(""+c));
                        }else if (c == '.'){
                            estado = 4;
                        }else{
                            valorCharAnterior = valorChar;
                            estado = 3;                            
                        }
                        break;
                    case 2:
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    case 12:
                        break;
                    case 13:
                        break;
                    case 14:
                        break;
                    case 15:
                        break;
                }
            }

        }
        br.close();

    }
}
