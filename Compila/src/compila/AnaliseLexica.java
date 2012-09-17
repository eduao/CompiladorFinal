/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compila;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import sun.applet.Main;

/**
 *
 * @author Augusto FADC
 */
public class AnaliseLexica {

    private File arquivo;
    private BufferedReader leitorArquivo;
    private boolean devolver;
    private char caractereAtual;
    private int linha;
    private int coluna;

    public AnaliseLexica() {
        arquivo = new File(JOptionPane.showInputDialog("Nome do arquivo", "teste.gl"));

        try {
            leitorArquivo = new BufferedReader(new FileReader(arquivo));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Arquivo não existente. O programa será encerrado!");
            System.exit(-1);
        }

        devolver = false;
        linha = 0;
        coluna = 0;
    }

    private char lerProximo() {
        try {
            if (devolver) {
                devolver = false;
            } else {
                caractereAtual = (char) leitorArquivo.read();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Erro ao ler o proximo caractere. O programa será encerrado!");
            System.exit(-1);
        }

        return caractereAtual;
    }

    private boolean eSimbolo() {
        return (caractereAtual == '=' || caractereAtual == '-' || caractereAtual == '*' || caractereAtual == '/'
                || caractereAtual == '(' || caractereAtual == ')' || caractereAtual == ',' || caractereAtual == ';'
                || caractereAtual == ':' || caractereAtual == '\"' || caractereAtual == '\'' || caractereAtual == '['
                || caractereAtual == ']' || caractereAtual == '?' || caractereAtual == '!' ||
                caractereAtual == '+' || caractereAtual == '\r' || caractereAtual == '\n') ? true : false;
    }

    private boolean eDigito() {
        return (caractereAtual >= '0' && caractereAtual <= '9') ? true : false;
    }

    private boolean eDigito(char c) {
        return (c >= '0' && c <= '9') ? true : false;
    }

    private boolean eLetra() {
        return ((caractereAtual >= 'a' && caractereAtual <= 'z')
                || (caractereAtual >= 'A' && caractereAtual <= 'Z')) ? true : false;
    }

    private boolean eLetra(char c) {
        return ((c >= 'a' && c <= 'z')
                || (c >= 'A' && c <= 'Z')) ? true : false;
    }

    public boolean eFimDeArquivo() {
        lerProximo();
        return (caractereAtual == -1 || caractereAtual == 65535) ? true : false;
    }

    public boolean eConstante(String lexema) {
        return eDigito(lexema.charAt(0));
    }

    public boolean eIdentificador(String lexema) {
        return eLetra(lexema.charAt(0));
    }

    public byte lerProximoToken() {
        byte retorno = 0;
        int estado = 0;
        String lexema = "";


        while (true) {
            switch (estado) {
                case 0:
                    lerProximo();
                    if (caractereAtual == ' ') {
                        estado = 0;
                    } else if (eSimbolo()) {
                        lexema = lexema + caractereAtual;
                        estado = 1;
                    } else if (caractereAtual == '>') {
                        lexema = lexema + caractereAtual;
                        estado = 2;
                    } else if (caractereAtual == '<') {
                        lexema = lexema + caractereAtual;
                        estado = 3;
                    } else if (caractereAtual == '=') {
                        lexema = lexema + caractereAtual;
                        estado = 4;
                    } else if (eDigito()) {
                        lexema = lexema + caractereAtual;
                        estado = 3;
                    } else if (caractereAtual == '.') {
                        lexema = lexema + caractereAtual;
                        estado = 9;
                    } else if (eLetra()) {
                        lexema = lexema + caractereAtual;
                        estado = 6;
                    } else if (caractereAtual == '{') {
                        estado = 8;
                    } else if (caractereAtual == '$') {
                        estado = 10;
                    } else {
                        erro("Um Token não pode começar com o caractere \'" + caractereAtual + "\'  numero: " + (int)caractereAtual);
                    }

                    break;
                case 1:
                    if (!Principal.tabelaDeSimbolos.containsKey(lexema)) {
                        if (eIdentificador(lexema)) {//se for uma token do tipo ID
                            Principal.tabelaDeSimbolos.put(lexema, new Registro(lexema, Principal.tabelaDeSimbolos.token_id));
                            retorno = Principal.tabelaDeSimbolos.token_id;
                        } else {//se for uma token do tipo constante
                            retorno = Principal.tabelaDeSimbolos.token_constante;
                        }
                    } else {
                        retorno = Principal.tabelaDeSimbolos.get(lexema).getToken();
                    }
                    return retorno;
                case 2:
                    lerProximo();
                    if (caractereAtual == '=') {
                        lexema = lexema + caractereAtual;
                        estado = 1;
                    } else {
                        devolver = true;
                        estado = 1;
                    }
                    break;
                case 3:
                    lerProximo();
                    if (caractereAtual == '=') {
                        lexema = lexema + caractereAtual;
                        estado = 1;
                    } else if (caractereAtual == '>') {
                        lexema = lexema + caractereAtual;
                        estado = 1;
                    } else {
                        devolver = true;
                        estado = 1;
                    }
                    break;
                case 4:
                    lerProximo();
                    if (caractereAtual == '=') {
                        lexema = lexema + caractereAtual;
                        estado = 1;
                    } else {
                        devolver = true;
                        estado = 1;
                    }
                    break;
                case 5:
                    lerProximo();
                    if (eDigito()) {
                        lexema = lexema + caractereAtual;
                        estado = 5;
                        if (lexema.length() > 4) {
                            erro("Um número deve possuir no máximo 4 casas inteiras.");
                        }
                    } else if (caractereAtual == '.') {
                        lexema = lexema + caractereAtual;
                        estado = 9;
                    } else {
                        devolver = true;
                        estado = 1;
                    }
                    break;
                case 6:
                    lerProximo();
                    if (eLetra() || eDigito()) {
                        lexema = lexema + caractereAtual;
                        estado = 6;
                    } else {
                        devolver = true;
                        estado = 1;
                    }
                    break;
                case 8:
                    lerProximo();
                    if (caractereAtual == '}') {
                        estado = 0;
                    } else {
                        estado = 8;
                    }
                    break;
                case 9:
                    lerProximo();
                    if (eDigito()) {
                        lexema = lexema + caractereAtual;
                        estado = 9;
                        if (lexema.split("\\.").length > 4) {
                            erro("Um número deve possuir no máximo 4 casas decimais.");
                        }
                    } else if (caractereAtual == '.') {
                        erro("Um número deve possuir apenas uma parte fracionária");
                    } else {
                        devolver = true;
                        estado = 1;
                    }
                    break;
                case 10:
                    lerProximo();
                    if (caractereAtual == '\n') {
                        estado = 0;
                    } else {
                        estado = 10;
                    }
                    break;
            }
        }

        //System.out.println("Erro inesperado ao tentar ler o próximo token. O programa será encerrado!");
        //System.exit(-1);
        //return -1;
    }

    public void erro(String mensagem) {
        System.out.println(mensagem);
        System.exit(-1);
    }
}
