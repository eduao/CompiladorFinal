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
    
    //static int posicao;
    static int estado = 0;
    public static TabelaDeSimbolos tabelaDeSimbolos = Main.tabelaDeSimbolos;
    static int valorChar = 0;//, valorCharAnterior;
    static char c = ' ', outroValor = ' ';
    static boolean fimArquivo = false, pegouProxValorChar = false, pegouOutro = false, veioDeConstante = false;
    static String l = "";
    static int linha = 0;
    static int coluna = 1;

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
        
        if (tabelaDeSimbolos.containsKey(l)) {
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
            linha++;
            coluna = 1;
            return true;
        }
        return false;
    }

    static int proximoValorChar() throws IOException {
        coluna++;
        return br.read();
    }
    
    static Registro nextToken () throws IOException{
        boolean completadoToken = false;
        Registro retorno = null;
        while (br.ready() && !completadoToken && !fimArquivo) {
            if (!pegouProxValorChar) {
                valorChar = br.read();
                c = (char) valorChar;
            }
            if (valorChar == -1) {
                fimArquivo = true;
            } else {
                switch (estado) {
                    case 0: //inicial
                        
                        if (c == ' ' || quebraLinha(valorChar)) {
                            vaiProximo();
                        } else if (Character.isDigit(valorChar)) {
                            estado = 1; // inteiro ou real
                            
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
                        } else if (c == '=') {
                            estado = 11; //igual
                            l = insereChar(l, c);
                            vaiProximo();
                        } else if (c == '<') {
                            estado = 10;
                            l = insereChar(l, c);
                            vaiProximo();
                        } else if (c == '>') {
                            estado = 8;
                            l = insereChar(l, c);
                            vaiProximo();
                        } else {
                            erro("Caractere inválido. Não é possível começar um token com o mesmo.");
                        }
                        break;
                    case 1: // inteiro ou real
                        veioDeConstante = true;
                                
                        if (Character.isDigit(c)) {
                            l = insereChar(l, c);
                            vaiProximo();
                        } else if (c == '.') {
                            l = insereChar(l, c);
                            estado = 4; //real
                        } else {
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
                        completadoToken = true;
                        if (!possuiTabela(l)) {
                            if (!veioDeConstante){
                                tabelaDeSimbolos.put(l, new Registro(l,tabelaDeSimbolos.IDToken));
                                retorno = new Registro(l, tabelaDeSimbolos.IDToken);//39 -> ID
                            }else{
                                retorno = new Registro(l, tabelaDeSimbolos.CONSTToken);
                            }
                        }else{
                            retorno = new Registro(l, tabelaDeSimbolos.get(l).getToken());
                        }
                        if (!pegouOutro) { //resolve o primeiro e depois retorna o proximo char    
                            vaiProximo();
                            pegouOutro = false;
                        }
                        veioDeConstante = false;
                        l = "";
                        estado = 0;
                        break;
                    case 4:

                        estado = 5;
                        vaiProximo();

                        break;
                    case 5:
                        //System.out.println("Entrou aqui! com +" + c);
                        if (Character.isDigit(c)) {
                            l = insereChar(l, c);
                            estado = 6;
                        } else if (c == '.') {
                            erro("Um número não pode conter duas partes fracionárias!");
                        } else {
                            estado = 3;
                        }
                        vaiProximo();
                        break;
                    case 6:
                        if (Character.isDigit(c)) {
                            l = insereChar(l, c);
                            estado = 7;
                        } else if (c == '.') {
                            erro("Um número não pode conter duas partes fracionárias!");
                        } else {
                            estado = 3;
                        }
                        vaiProximo();
                        break;
                    case 7:
                        if (Character.isDigit(c)) {
                            l = insereChar(l, c);
                            estado = 8;
                        } else if (c == '.') {
                            erro("Um número não pode conter duas partes fracionárias!");
                        } else {
                            estado = 3;
                        }
                        vaiProximo();
                        break;
                    case 8:
                        if (c == '=' || c == '<') {
                            insereChar(l, c);
                            estado = 3;
                        } else {
                            estado = 3;
                            vaiProximo();
                        }
                        break;
                    case 9:
                        if (c == '}') {
                            estado = 0;
                        }
                        vaiProximo();
                        break;
                    case 10:
                        if (c == '=' || c == '>') {
                            insereChar(l, c);
                            estado = 3;
                        } else {
                            estado = 3;
                            //vaiProximo();
                        }
                        break;
                    case 11:
                        if (c == '=') {
                            insereChar(l, c);
                            estado = 3;
                        } else {
                            estado = 3;
                            //vaiProximo();
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
        
        return retorno;
    }

    public AnalisadorLexico() throws IOException {
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
                        
                        if (c == ' ' || quebraLinha(valorChar)) {
                            vaiProximo();
                        } else if (Character.isDigit(valorChar)) {
                            estado = 1; // inteiro ou real
                            
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
                        } else if (c == '=') {
                            estado = 11; //igual
                            l = insereChar(l, c);
                            vaiProximo();
                        } else if (c == '<') {
                            estado = 10;
                            l = insereChar(l, c);
                            vaiProximo();
                        } else if (c == '>') {
                            estado = 8;
                            l = insereChar(l, c);
                            vaiProximo();
                        } else {
                            erro("Caractere inválido. Não é possível começar um token com o mesmo.");
                        }
                        break;
                    case 1: // inteiro ou real
                        veioDeConstante = true;
                                
                        if (Character.isDigit(c)) {
                            l = insereChar(l, c);
                            vaiProximo();
                        } else if (c == '.') {
                            l = insereChar(l, c);
                            estado = 4; //real
                        } else {
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
                            if (!veioDeConstante){
                                tabelaDeSimbolos.put(l, new Registro(l,tabelaDeSimbolos.IDToken));
                            }
                        }
                        if (!pegouOutro) { //resolve o primeiro e depois retorna o proximo char    
                            vaiProximo();
                            pegouOutro = false;
                        }
                        veioDeConstante = false;
                        l = "";
                        estado = 0;
                        break;
                    case 4:

                        estado = 5;
                        vaiProximo();

                        break;
                    case 5:
                        //System.out.println("Entrou aqui! com +" + c);
                        if (Character.isDigit(c)) {
                            l = insereChar(l, c);
                            estado = 6;
                        } else if (c == '.') {
                            erro("Um número não pode conter duas partes fracionárias!");
                        } else {
                            estado = 3;
                        }
                        vaiProximo();
                        break;
                    case 6:
                        if (Character.isDigit(c)) {
                            l = insereChar(l, c);
                            estado = 7;
                        } else if (c == '.') {
                            erro("Um número não pode conter duas partes fracionárias!");
                        } else {
                            estado = 3;
                        }
                        vaiProximo();
                        break;
                    case 7:
                        if (Character.isDigit(c)) {
                            l = insereChar(l, c);
                            estado = 8;
                        } else if (c == '.') {
                            erro("Um número não pode conter duas partes fracionárias!");
                        } else {
                            estado = 3;
                        }
                        vaiProximo();
                        break;
                    case 8:
                        if (c == '=' || c == '<') {
                            insereChar(l, c);
                            estado = 3;
                        } else {
                            estado = 3;
                            vaiProximo();
                        }
                        break;
                    case 9:
                        if (c == '}') {
                            estado = 0;
                        }
                        vaiProximo();
                        break;
                    case 10:
                        if (c == '=' || c == '>') {
                            insereChar(l, c);
                            estado = 3;
                        } else {
                            estado = 3;
                            //vaiProximo();
                        }
                        break;
                    case 11:
                        if (c == '=') {
                            insereChar(l, c);
                            estado = 3;
                        } else {
                            estado = 3;
                            //vaiProximo();
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

    private static void erro(String mensagemDeErro) {
        //if (linha % 2 == 1){
        //    System.out.println("[lexico][linha = " + ((linha/2)+1) + "][coluna = " + coluna + "]" + mensagemDeErro);
       // }else{
            System.out.println("[lexico][linha = " + ((linha/2)+2) + "][coluna = " + coluna + "]" + mensagemDeErro);
      //  }
        System.exit(-1);
    }
    
    
    
   
}
