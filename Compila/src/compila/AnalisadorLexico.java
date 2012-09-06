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
    static Hashtable<String, Integer> tabelaDeSimbolos = Main.tabelaDeSimbolos;

    static String insereChar(String l, char c) {
        //l.setLexema();
        return l.concat("" + c);
    }

    static boolean eSimbolo(char c) {

        if (c == '+' || c == '-'
                || c == '(' || c == ')'
                || c == '*' || c == '/'
                || c == '<' || c == '>'
                || c == '$') {
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
        br = Main.br;
        int valorChar = 0;//, valorCharAnterior;
        char c = ' ', outroValor = ' ';
        boolean fimArquivo = false, pegouProxValorChar = false, pegouOutro = false;
        String l = "";
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
                            valorChar = proximoValorChar();
                            c = (char) valorChar;
                            pegouProxValorChar = true;
                        }
                        if (Character.isDigit(valorChar)) {
                            estado = 1; // inteiro ou real
                            System.out.println("Leu " + c);
                            l = insereChar(l, c);
                            valorChar = proximoValorChar();
                            c = (char) valorChar;
                            pegouProxValorChar = true;
                        } else if (Character.isLetter(c)) {
                            estado = 2; //identificadores e palavras reservadas
                            l = insereChar(l, c);
                            valorChar = proximoValorChar();
                            c = (char) valorChar;
                            pegouProxValorChar = true;
                        } else if (c == '.') {
                            estado = 4; //real
                            l = insereChar(l, c);
                            valorChar = proximoValorChar();
                            c = (char) valorChar;
                            pegouProxValorChar = true;
                        } else if (c == '{') {
                            estado = 9;
                            valorChar = proximoValorChar();
                            c = (char) valorChar;
                            pegouProxValorChar = true;
                        } else if (eSimbolo(c)) {
                            estado = 3; // simbolos
                            l = insereChar(l, c);
                        } else if (c == '=') {
                            estado = 11; //igual
                            l = insereChar(l, c);
                            valorChar = proximoValorChar();
                            c = (char) valorChar;
                            pegouProxValorChar = true;
                        }
                        break;
                    case 1: // inteiro ou real
                        if (Character.isDigit(c)) {
                            l = insereChar(l, c);
                            System.out.println("Leu " + c);
                            valorChar = proximoValorChar();
                            c = (char) valorChar;
                            pegouProxValorChar = true;
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
                        } else {
                            // TODO Aqui é onde lê outro valor
                        }
                        break;
                    case 3:

                        if (!possuiTabela(l)) {
                            tabelaDeSimbolos.put(l, ultimoID++);
                            System.out.println("Inserido = " + l);

                        }
                        if (!pegouOutro) { //resolve o primeiro e depois retorna o proximo char    
                            valorChar = proximoValorChar();
                            c = (char) valorChar;
                            pegouProxValorChar = true;
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
