/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *
 */
package compila;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.Hashtable;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Augusto & Eduardo
 */
public class Main {

    static Hashtable<String,Integer> tabelaDeSimbolos = new Hashtable<String, Integer>();
    //static TabelaDePalavrasReservadas tabelaDePalavrasReservadas;
    static File arquivoEntrada;
    static String nomeArquivoEntrada = "teste.txt";
    static FileInputStream fis;
    static InputStreamReader br;
    
    
    
    static void carregarPalavrasReservadas() {
        System.out.println("Abastecendo a tabela de palavras reservadas...");
        tabelaDeSimbolos.put("DPonto", 1);
        tabelaDeSimbolos.put("DFace", 2);
        tabelaDeSimbolos.put("DObjeto", 3);
        tabelaDeSimbolos.put("DCor", 4);
        tabelaDeSimbolos.put("DLuz", 5);
        tabelaDeSimbolos.put("DVar", 6);
        tabelaDeSimbolos.put("DConst", 7);
        tabelaDeSimbolos.put("inteiro", 8);
        tabelaDeSimbolos.put("real", 9);
        tabelaDeSimbolos.put("Escala", 10);
        tabelaDeSimbolos.put("Pausa", 11);
        tabelaDeSimbolos.put("Rottrans", 12);
        tabelaDeSimbolos.put("Enquanto", 13);
        tabelaDeSimbolos.put("faca", 14);
        tabelaDeSimbolos.put("Se", 15);
        tabelaDeSimbolos.put("entao", 16);
        tabelaDeSimbolos.put("senao", 17);
        tabelaDeSimbolos.put("E", 18);
        tabelaDeSimbolos.put("OU", 19);
        tabelaDeSimbolos.put("NAO", 20);
        tabelaDeSimbolos.put("==", 21);
        tabelaDeSimbolos.put("=", 22);
        tabelaDeSimbolos.put("(", 23);
        tabelaDeSimbolos.put(")", 24);
        tabelaDeSimbolos.put(",", 25);
        tabelaDeSimbolos.put("+", 26);
        tabelaDeSimbolos.put("-", 27);
        tabelaDeSimbolos.put("*", 28);
        tabelaDeSimbolos.put("<", 29);
        tabelaDeSimbolos.put(">", 30);
        tabelaDeSimbolos.put("<>", 31);
        tabelaDeSimbolos.put(">=", 32);
        tabelaDeSimbolos.put("<=", 33);
        tabelaDeSimbolos.put("/", 34);
        tabelaDeSimbolos.put("inicio", 35);
        tabelaDeSimbolos.put("fim", 36);
        System.out.println("Palavras Reservadas carregadas...");
    }
            

    private static boolean verificarArquivoEntrada(String string) throws FileNotFoundException {

        
        File arquivo = new File(string);
        if (arquivo.exists()) {
            fis = new FileInputStream(arquivo);
            br = new InputStreamReader(fis);
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        
        // @TODO Ler arquivo de entrada através do args[0] verificar se existe e etc
        //if (verificarArquivoEntrada(args[0])) {
       
        
        if ( verificarArquivoEntrada(nomeArquivoEntrada =JOptionPane.showInputDialog("Qual o nome do arquivo de teste encontrado na pasta do projeto?", nomeArquivoEntrada))) {
            
            
            carregarPalavrasReservadas();
            AnalisadorLexico al = new AnalisadorLexico();
            br.close();
            imprimirTabelaDeSimbolos();
        
        } else {
            // @TODO O arquivo encontrado não existe
            //System.out.format("O arquivo %s não existe", args[0]);
            System.out.format("O arquivo não existe\n");
            //System.out.println("O arquivo  não existe");
        }
    }
    
    
    public static void imprimirTabelaDeSimbolos (){
        System.out.println("======================================================");
        System.out.println("Imprimindo a tabela de simbolos...");
        for (String lexema : tabelaDeSimbolos.keySet()) {
            System.out.println("["+ lexema + ", " + tabelaDeSimbolos.get(lexema) + "]");
        }
        System.out.println("======================================================");
    }
}
