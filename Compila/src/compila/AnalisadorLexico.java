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

    static InputStreamReader br = Main.br;
    ;
    static int ultimoID = -1;
    //static int posicao;
    static int estado = 0;
    static Hashtable<String, Integer> tabelaDeSimbolos = Main.tabelaDeSimbolos;
    static int valorChar = 0;//, valorCharAnterior;
    static char c = ' ', outroValor = ' ';
    static boolean fimArquivo = false, pegouProxValorChar = false, pegouOutro = false;
    static String l = "";

    static String insereChar(String l, char c) {
        //l.setLexema();
        return l.concat("" + c);
    }

    static boolean eSimbolo(char c) {

        if (c == '+' || c == '-'
                || c == ';'
                || c == '(' || c == ')'
                || c == '*' || c == '/'
                || c == '$' || c == ',') {
            return true;
        }
        return false;
    }

    static boolean possuiTabela(String l) {
        if (tabelaDeSimbolos.contains(l)) {
            return true;
        }
        return false;
    }

    static void vaiProximo() throws IOException {
        valorChar = proximoValorChar();
        c = (char) valorChar;
        pegouProxValorChar = true;
    }

    static boolean quebraLinha(int valorChar) {
        if (valorChar == 13 || valorChar == 10) {
            return true;
        }
        return false;
    }

    static int proximoValorChar() throws IOException {
        return br.read();
    }

    public AnalisadorLexico() throws IOException {

        for (Integer a : tabelaDeSimbolos.values()) {
            int valorDado;
            if ((valorDado = a) > ultimoID) {
                ultimoID = valorDado;
            }
        }
        while (br.ready() && !fimArquivo) {
            if (!pegouProxValorChar) {
                valorChar = br.read();
                c = (char) valorChar;
            }
            if (valorChar == -1) {
                fimArquivo = true;
            } else {
                switch (estado) {
                    case 0: //inicial

                        System.out.println(">>>>" + valorChar);
                        /*if (quebraLinha(valorChar)){
                            
                         }*/
                        if (c == ' ' || quebraLinha(valorChar)) {
                            vaiProximo();
                        }
                        if (Character.isDigit(valorChar)) {
                            estado = 1; // inteiro ou real
                            System.out.println("Leu " + c);
                            l = insereChar(l, c);
                            vaiProximo();
                        } else if (Character.isLetter(c)) {
                            estado = 2; //identificadores e palavras reservadas
                            l = insereChar(l, c);
                            vaiProximo();
                        } else if (c == '.') {
                            estado = 4; //real
                            l = insereChar(l, c);
                            vaiProximo();
                        } else if (c == '{') {
                            estado = 9;
                            vaiProximo();
                        } else if (eSimbolo(c)) {
                            vaiProximo();
                            //estado = 3; // simbolos
                            //l = insereChar(l, c);
                        } else if (c == '=') {
                            estado = 11; //igual
                            l = insereChar(l, c);
                            vaiProximo();
                        }
                        break;
                    case 1: // inteiro ou real
                        if (Character.isDigit(c)) {
                            l = insereChar(l, c);
                            System.out.println("Leu " + c);
                            vaiProximo();
                        } else if (c == '.') {
                            estado = 4; //real
                        } else {
                            outroValor = c;
                            pegouOutro = true;
                            estado = 3;
                        }
                        break;
                    case 2:
                        if (Character.isDigit(c) || Character.isLetter(c)) {
                            l = insereChar(l, c);
                            vaiProximo();
                        } else {
                            estado = 3;
                            pegouOutro = true;
                        }
                        break;
                    case 3:

                        if (!possuiTabela(l)) {
                            tabelaDeSimbolos.put(l, ultimoID++);
                            System.out.println("Inserido = " + l);

                        }
                        if (!pegouOutro) { //resolve o primeiro e depois retorna o proximo char    
                            vaiProximo();
                            pegouOutro = false;
                        }
                        l = "";
                        estado = 0;
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
                        if (c == '}') {
                            estado = 0;
                        }
                        break;
                    case 10:
                        break;
                    case 11:
                        if (c == '='){
                            insereChar(l, c);
                            estado = 3;
                        }else{
                            estado = 0;
                            vaiProximo();
                        }
                        break;
                    case 12:
                        if (c == '=') {
                            estado = 13;
                            l = insereChar(l, c);
                        } else if (c != '=') {
                            estado = 3;
                        }
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
