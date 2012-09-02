/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compila;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Augusto & Eduardo & Kassia
 */
public class AnaliseLexica {

    public AnaliseLexica() {
    }

    void insereTabela(Lexema l, Token t) {
        if (!eLexemaUsado(l) && !ePalavraReservada(l)) {
            Main.tabelaDeSimbolos.put(l, t);
        } else {
            // Não sei o que pose entrar aqui.... :'/
        }
    }

    boolean eLexemaUsado(Lexema l) {
        if (Main.tabelaDeSimbolos.containsKey(l)) {
            return true;
        }
        return false;
    }

    boolean ePalavraReservada(Lexema l) {
        if (Main.tabelaDePalavrasReservadas.containsKey(new Token(l.getLexema()))) {
            return true;
        }
        return false;
    }

    char nextChar(char[] string, int[] posicao) {
        posicao[0]++;
        if (posicao[0] < string.length) {
            return string[posicao[0]];
        }
        return '\n';
    }

    // @TODO Precisa criar o que Pode ser representado nos tokens
    void verificaString(char[] string, int numeroLinha) {
        Token t = new Token();
        Lexema l = new Lexema();
        String lexema = "";

        boolean continueAnalysing = true;
        int pos[] = {-1};
        char estado = 0;
        char c = 0;
        while (pos[0] < string.length) {
            switch (estado) {
                case 0:
                    c = nextChar(string, pos);
                    if (isDelimitator(c)) {
                        estado = 0;
                    } else if (isLetter(c)) {
                        lexema.concat(c + "");
                        estado = 1;
                    } else if (isDigit(c)) {
                        lexema.concat(c + "");
                        estado = 20;
                    } else if (isEOF(c)) {
                        estado = 24;
                    } else if (c == '=') {
                        lexema.concat(c + "");
                        estado = 3;
                    } else if (c == '(') {
                        lexema.concat(c + "");
                        estado = 5;
                    } else if (c == ')') {
                        lexema.concat(c + "");
                        estado = 7;
                    } else if (c == '+') {
                        lexema.concat(c + "");
                        estado = 9;
                    } else if (c == '-') {
                        lexema.concat(c + "");
                        estado = 10;
                    } else if (c == '*') {
                        lexema.concat(c + "");
                        estado = 11;
                    } else if (c == '/') {
                        lexema.concat(c + "");
                        estado = 12;
                    } else if (c == '<') {
                        lexema.concat(c + "");
                        estado = 13;
                    } else if (c == '>') {
                        lexema.concat(c + "");
                        estado = 17;
                    } else if (c == ';') {
                        lexema.concat(c + "");
                        estado = 26;
                    } else if (c == '$') {
                        lexema.concat(c + "");
                        estado = 27;
                    } else if (c == ':') {
                        lexema.concat(c + "");
                        estado = 28;
                    } else if (c == '\"') {
                        lexema.concat(c + "");
                        estado = 29;
                    } else if (c == '\'') {
                        lexema.concat(c + "");
                        estado = 30;
                    } else if (c == '/') {
                        lexema.concat(c + "");
                        estado = 31;
                    } else if (c == '!') {
                        lexema.concat(c + "");
                        estado = 32;
                    } else if (c == '?') {
                        lexema.concat(c + "");
                        estado = 33;
                    } else {
                        falhar(numeroLinha, pos[0], "Um lexema não pode comecar com o caractere '" + c + "'");
                    }
                    break;

                // l   {l,d}
                case 1:
                    c = nextChar(string, pos);
                    if (isDigit(c) || isLetter(c)) {
                        lexema.concat(c + "");
                        estado = 1;
                    } else {
                        lexema.concat(c + "");
                        estado = 2;
                    }
                    break;

                    // outro   -(l,d)
                case 2:// aceitacao
                    l.setLexema(lexema);
                    t.setToken("constante");
                    Main.tabelaDeSimbolos.put(l, t);
                    pos[0]--;
                    estado = 0;
                    break;

                    // =
                case 3:
                    c = nextChar(string, pos);
                    if (c == '=') {
                        lexema.concat(c + "");
                        estado = 4;
                    } else {
                        lexema.concat(c + "");
                        estado = 25;
                    }
                    break;

                    // =
                case 4:// aceitacao
                    l.setLexema(lexema);
                    t.setToken("constante");
                    Main.tabelaDeSimbolos.put(l, t);
                    pos[0]--;
                    estado = 0;
                    break;
                    
                    // (
                case 5:
                    c = nextChar(string, pos);
                    lexema.concat(c + "");
                    estado = 6;
                    break;

                case 6:// aceitacao
                    l.setLexema(lexema);
                    t.setToken("constante");
                    Main.tabelaDeSimbolos.put(l, t);
                    pos[0]--;
                    estado = 0;
                    break;

                case 7:
                    c = nextChar(string, pos);
                    lexema.concat(c + "");
                    estado = 8;
                    break;

                case 8:// aceitacao
                    l.setLexema(lexema);
                    t.setToken("constante");
                    Main.tabelaDeSimbolos.put(l, t);
                    pos[0]--;
                    estado = 0;
                    break;

                case 9:// aceitacao
                    l.setLexema(lexema);
                    t.setToken("constante");
                    Main.tabelaDeSimbolos.put(l, t);
                    pos[0]--;
                    estado = 0;
                    break;

                case 10:// aceitacao
                    l.setLexema(lexema);
                    t.setToken("constante");
                    Main.tabelaDeSimbolos.put(l, t);
                    pos[0]--;
                    estado = 0;
                    estado = 0;
                    break;

                case 11:// aceitacao
                    l.setLexema(lexema);
                    t.setToken("constante");
                    Main.tabelaDeSimbolos.put(l, t);
                    pos[0]--;
                    estado = 0;
                    estado = 0;
                    break;

                case 12:// aceitacao
                    l.setLexema(lexema);
                    t.setToken("constante");
                    Main.tabelaDeSimbolos.put(l, t);
                    pos[0]--;
                    estado = 0;
                    estado = 0;
                    break;

                case 13:
                    c = nextChar(string, pos);
                    if (c == '=') {
                        lexema.concat(c + "");
                        estado = 14;
                    } else if (c == '>') {
                        lexema.concat(c + "");
                        estado = 15;
                    } else {
                        estado = 16;
                    }
                    break;

                case 14:// aceitacao
                    l.setLexema(lexema);
                    t.setToken("constante");
                    Main.tabelaDeSimbolos.put(l, t);
                    pos[0]--;
                    estado = 0;
                    estado = 0;
                    break;

                case 15:// aceitacao
                    l.setLexema(lexema);
                    t.setToken("constante");
                    Main.tabelaDeSimbolos.put(l, t);
                    pos[0]--;
                    estado = 0;
                    estado = 0;
                    break;

                case 16:// aceitacao
                    l.setLexema(lexema);
                    t.setToken("constante");
                    Main.tabelaDeSimbolos.put(l, t);
                    pos[0]--;
                    estado = 0;
                    estado = 0;
                    break;

                case 17:
                    c = nextChar(string, pos);
                    if (c == '=') {
                        estado = 19;
                    } else {
                        estado = 18;
                    }
                    break;

                case 18:// aceitacao
                    estado = 0;
                    break;

                case 19:// aceitacao
                    l.setLexema(lexema);
                    t.setToken("constante");
                    Main.tabelaDeSimbolos.put(l, t);
                    pos[0]--;
                    estado = 0;
                    estado = 0;
                    break;

                case 20:
                    c = nextChar(string, pos);
                    if (isDigit(c)) {
                        estado = 20;
                    } else if (c == '.') {
                        estado = 21;
                    } else {
                        estado = 23;
                    }
                    break;

                case 21:
                    c = nextChar(string, pos);
                    if (isDigit(c)) {
                        estado = 21;
                    } else if (c == '.') {
                        falhar(numeroLinha, pos[0], "Um número não pode conter dois '.'s.");
                    } else {
                        estado = 22;
                    }
                    break;

                case 22:// aceitacao
                    l.setLexema(lexema);
                    t.setToken("constante");
                    Main.tabelaDeSimbolos.put(l, t);
                    pos[0]--;
                    estado = 0;
                    estado = 0;
                    break;

                case 23:// aceitacao
                    l.setLexema(lexema);
                    t.setToken("constante");
                    Main.tabelaDeSimbolos.put(l, t);
                    pos[0]--;
                    estado = 0;
                    estado = 0;
                    break;

                case 24:// aceitacao
                    System.out.println("fim de arquivo");
                    continueAnalysing = false;
                    break;

                case 25:
                    c = nextChar(string, pos);
                    estado = 0;
                    break;

                // ;
                case 26:// aceitacao
                    c = nextChar(string, pos);
                    // 
                    estado = 0;
                    break;

                // $
                case 27:// aceitacao
                    c = nextChar(string, pos);
                    // 
                    estado = 0;
                    break;

                // :
                case 28:// aceitacao
                    c = nextChar(string, pos);
                    // 
                    estado = 0;
                    break;

                // "
                case 29:// aceitacao
                    c = nextChar(string, pos);
                    // 
                    estado = 0;
                    break;

                // '
                case 30:// aceitacao
                    c = nextChar(string, pos);
                    estado = 0;
                    break;

                // /
                case 31:// aceitacao
                    c = nextChar(string, pos);
                    estado = 0;
                    break;

                // !
                case 32:// aceitacao
                    c = nextChar(string, pos);
                    estado = 0;
                    break;

                // ?
                case 33:// aceitacao
                    c = nextChar(string, pos);
                    estado = 0;
                    break;

                default:
                    break;
            }
        }
    }

    public boolean isDelimitator(char c) {
        // 10 = LINE FEED
        if (c == ' ' || c == '\t' || c == '\r' || c == '\n' || c == 10) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isLetter(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isDigit(char c) {
        if ((c >= '0' && c <= '9')) {
            return true;
        } else {
            return false;
        }
    }

    public void falhar(int numeroLinha, int coluna, String mensagem) {
        System.out.println("======================================================"
                + "\n[Erro]    : Léxico"
                + "\n[Linha]   : " + numeroLinha + ""
                + "\n[Coluna]  : " + coluna + ""
                + "\n[Mensagem]: " + mensagem + ""
                + "\n======================================================");

        System.exit(-1);
    }

    public boolean isEOF(char c) {
        if (c == (char) -1) {
            return true;
        } else {
            return false;
        }
    }
}
