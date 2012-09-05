/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compila;

/**
 *
 * @author Augusto & Eduardo & Kassia
 */
public class AnaliseLexica {

    public AnaliseLexica() {
    }


    boolean eLexemaUsado(Lexema lexema) {
        //return Main.tabelaDeSimbolos.containsKey(l.getLexema());
        for (Lexema l : Main.tabelaDeSimbolos.keySet()) {
            if (l.getLexema().equals(lexema.getLexema())){
                return true;
            }
        }
        return false;
    }

    boolean ePalavraReservada(Lexema lexema) {
        //return Main.tabelaDePalavrasReservadas.containsKey(l.getLexema());
       /* for (Token t : Main.tabelaDePalavrasReservadas.keySet()) {
            if (t.getToken().equals(lexema.getLexema())){
                return true;
            }
        }*/
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
        String lexema[] = {""};

        boolean continueAnalysing = true;
        int pos[] = {-1};
        int estado[] = {0};
        char c = 0;
        while (pos[0] < string.length) {
            switch (estado[0]) {
                case 0:
                    c = nextChar(string, pos);
                    if (c == ':') {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 1;
                    } else if (c == ';') {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 2;
                    } else if (eDelimitador(c)) {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 3;
                    } else if (c == '{') {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 4;
                    } else if (c == '}') {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 5;
                    } else if (c == '[') {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 6;
                    } else if (c == ']') {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 7;
                    } else if (c == '\'') {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 8;
                    } else if (c == '\"') {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 9;
                    } else if (c == '!') {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 10;
                    } else if (c == '?') {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 11;
                    } else if (eLetra(c)) {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 12;
                    } else if (c == '=') {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 14;
                    } else if (c == '(') {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 15;
                    } else if (c == ')') {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 16;
                    } else if (c == '+') {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 17;
                    } else if (c == '-') {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 18;
                    } else if (c == '*') {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 19;
                    } else if (c == '/') {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 20;
                    } else if (c == '<') {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 21;
                    } else if (c == '>') {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 25;
                    } else if (c == '.') {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 32;
                    } else if (eNumero(c)) {
                        lexema[0] = lexema[0].concat("" + c);
                        estado[0] = 28;
                    } else {
                        falhar(numeroLinha, pos[0], "Um token não pode começar com o simbolo '" + c + "'.");
                    }
                    break;

                case 1://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                case 2://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                case 3://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                case 4://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                case 5://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                case 6://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                case 7://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                case 8://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                case 9://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                case 10://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                case 11://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                case 12:
                    c = nextChar(string, pos);
                    if (eNumero(c) || eLetra(c)) {
                        lexema[0] = lexema[0].concat(c + "");
                        estado[0] = 12;
                    } else {
                        estado[0] = 13;
                    }
                    break;

                case 13://aceitação
                    inserirSimbolo(lexema,"", pos, estado);
                    break;
                case 14://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                case 15://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                case 16://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                case 17://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                case 18://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                case 19://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                case 20://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                case 21:
                    c = nextChar(string, pos);
                    if (c == '=') {
                        lexema[0] = lexema[0].concat(c + "");
                        estado[0] = 23;
                    } else if (c == '>') {
                        lexema[0] = lexema[0].concat(c + "");
                        estado[0] = 24;
                    } else {
                        estado[0] = 22;
                    }
                    break;

                case 22://aceitação
                    inserirSimbolo(lexema,"", pos, estado);
                    break;

                case 23://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                case 24://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                case 25:
                    c = nextChar(string, pos);
                    if (c == '=') {
                        lexema[0] = lexema[0].concat(c + "");
                        estado[0] = 27;
                    } else {
                        estado[0] = 26;
                    }
                    break;

                case 26://aceitação
                    inserirSimbolo(lexema,"", pos, estado);
                    break;

                case 27://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                case 28:
                    c = nextChar(string, pos);
                    if (eNumero(c)) {
                        lexema[0] = lexema[0].concat(c + "");
                        estado[0] = 29;
                    } else if (c == '.') {
                        lexema[0] = lexema[0].concat(c + "");
                        estado[0] = 32;
                    } else {
                        estado[0] = 37;
                    }
                    ;
                    break;

                case 29:
                    c = nextChar(string, pos);
                    if (eNumero(c)) {
                        lexema[0] = lexema[0].concat(c + "");
                        estado[0] = 30;
                    } else if (c == '.') {
                        lexema[0] = lexema[0].concat(c + "");
                        estado[0] = 32;
                    } else {
                        estado[0] = 37;
                    }
                    break;

                case 30:
                    c = nextChar(string, pos);
                    if (eNumero(c)) {
                        lexema[0] = lexema[0].concat(c + "");
                        estado[0] = 31;
                    } else if (c == '.') {
                        lexema[0] = lexema[0].concat(c + "");
                        estado[0] = 32;
                    } else {
                        estado[0] = 37;
                    }
                    break;

                case 31:
                    c = nextChar(string, pos);
                    if (c == '.') {
                        lexema[0] = lexema[0].concat(c + "");
                        estado[0] = 32;
                    } else if (eNumero(c)) {
                        falhar(numeroLinha, pos[0], "Um número ou uma parte fracionária não podem conter 5 ou mais dígitos!");
                    } else {
                        estado[0] = 37;
                    }
                    break;

                case 32:
                    c = nextChar(string, pos);
                    if (eNumero(c)) {
                        lexema[0] = lexema[0].concat(c + "");
                        estado[0] = 33;
                    } else if (c == '.') {
                        falhar(numeroLinha, pos[0], "Um número não pode contar duas partes fracionárias!");
                    } else {
                        estado[0] = 37;
                    }
                    break;

                case 33:
                    c = nextChar(string, pos);
                    if (eNumero(c)) {
                        lexema[0] = lexema[0].concat(c + "");
                        estado[0] = 34;
                    } else if (c == '.') {
                        falhar(numeroLinha, pos[0], "Um número não pode contar duas partes fracionárias!");
                    } else {
                        estado[0] = 37;
                    }
                    break;

                case 34:
                    c = nextChar(string, pos);
                    if (eNumero(c)) {
                        lexema[0] = lexema[0].concat(c + "");
                        estado[0] = 35;
                    } else if (c == '.') {
                        falhar(numeroLinha, pos[0], "Um número não pode contar duas partes fracionárias!");
                    } else {
                        estado[0] = 37;
                    }
                    break;

                case 35:
                    c = nextChar(string, pos);
                    if (eNumero(c)) {
                        lexema[0] = lexema[0].concat(c + "");
                        estado[0] = 36;
                    } else if (c == '.') {
                        falhar(numeroLinha, pos[0], "Um número não pode contar duas partes fracionárias!");
                    } else {
                        estado[0] = 37;
                    }
                    break;

                case 36:
                    c = nextChar(string, pos);
                    if (eNumero(c)) {
                        falhar(numeroLinha, pos[0], "Um número ou uma parte fracionária não podem conter 5 ou mais dígitos!");
                    } else if (c == '.') {
                        falhar(numeroLinha, pos[0], "Um número não pode contar duas partes fracionárias!");
                    } else {
                        estado[0] = 37;
                    }
                    break;

                case 37://aceitação
                    inserirSimbolo(lexema,"", estado);
                    break;

                default:

                    break;
            }
        }
    }

    //usado quando um é um outro simbolo NÃO pertencent ao token que leva ao estado de aceitação
    public void inserirSimbolo(String[] lexema,String token, int[] pos, int[] estado) {
        Lexema l = new Lexema(lexema[0]);
        Token t = new Token(token);
        pos[0]--;
        estado[0] = 0;
        lexema[0] = "";
        if (!eLexemaUsado(l) && !ePalavraReservada(l)) {
           // Main.tabelaDeSimbolos.put(l, t);
        }
    }

    //usado quando um é um simbolo pertencent ao token que leva ao estado de aceitação
    public void inserirSimbolo(String[] lexema,String token, int[] estado) {
        Lexema l = new Lexema(lexema[0]);
        Token t = new Token(token);
        estado[0] = 0;
        lexema[0] = "";
        if (!eLexemaUsado(l) && !ePalavraReservada(l)) {
           // Main.tabelaDeSimbolos.put(l, t);
        }
        


    }

    public boolean eDelimitador(char c) {
        // 10 = LINE FEED
        if (c == ' ' || c == '\t' || c == '\r' || c == '\n' || c == 10) {
            return true;
        } else {
            return false;
        }
    }

    public boolean eLetra(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        } else {
            return false;
        }
    }

    public boolean eNumero(char c) {
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

    public boolean eFimDeArquivo(char c) {
        if (c == (char) -1) {
            return true;
        } else {
            return false;
        }
    }
}
