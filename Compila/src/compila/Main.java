/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *
 */
package compila;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import javax.swing.JOptionPane;

/**
 *
 * @author Augusto & Eduardo
 */
public class Main {

    static TabelaDeSimbolos tabelaDeSimbolos = new TabelaDeSimbolos();
    //static TabelaDePalavrasReservadas tabelaDePalavrasReservadas;
    static File arquivoEntrada;
    static String nomeArquivoEntrada = "exemplo2.gl";
    static FileInputStream fis;
    static InputStreamReader br;
    
    
    
    static void carregarPalavrasReservadas() {
        System.out.println("Abastecendo a tabela de palavras reservadas...");
        tabelaDeSimbolos.put("DPonto", new Linha("DPonto", 1));
        tabelaDeSimbolos.put("DFace", new Linha("DFace", 2));
        tabelaDeSimbolos.put("DObjeto", new Linha("DObjeto", 3));
        tabelaDeSimbolos.put("DCor", new Linha("DCor", 4));
        tabelaDeSimbolos.put("DLuz", new Linha("DLuz", 5));
        tabelaDeSimbolos.put("DVar", new Linha("DVar", 6));
        tabelaDeSimbolos.put("DConst", new Linha("DConst", 7));
        tabelaDeSimbolos.put("inteiro", new Linha("inteiro", 8));
        tabelaDeSimbolos.put("real", new Linha("real", 9));
        tabelaDeSimbolos.put("Escala", new Linha("Escala", 10));
        tabelaDeSimbolos.put("Pausa", new Linha("Pausa",11 ));
        tabelaDeSimbolos.put("Rottrans", new Linha("Rottrans", 12));
        tabelaDeSimbolos.put("Enquanto", new Linha("Enquanto", 13));
        tabelaDeSimbolos.put("faca", new Linha("faca", 14));
        tabelaDeSimbolos.put("Se", new Linha("Se", 15));
        tabelaDeSimbolos.put("entao", new Linha("entao", 16));
        tabelaDeSimbolos.put("senao", new Linha("senao", 17));
        tabelaDeSimbolos.put("E", new Linha("E", 18));
        tabelaDeSimbolos.put("OU", new Linha("OU", 19));
        tabelaDeSimbolos.put("NAO", new Linha("NAO", 20));
        tabelaDeSimbolos.put("==", new Linha("==", 21));
        tabelaDeSimbolos.put("=", new Linha("=", 22));
        tabelaDeSimbolos.put("(", new Linha("(", 23));
        tabelaDeSimbolos.put(")", new Linha(")", 24));
        tabelaDeSimbolos.put(",", new Linha(",", 25));
        tabelaDeSimbolos.put("+", new Linha("+", 26));
        tabelaDeSimbolos.put("-", new Linha("-", 27));
        tabelaDeSimbolos.put("*", new Linha("*", 28));
        tabelaDeSimbolos.put("<", new Linha("<", 29));
        tabelaDeSimbolos.put(">", new Linha(">", 30));
        tabelaDeSimbolos.put("<>", new Linha("<>",31));
        tabelaDeSimbolos.put(">=", new Linha(">=", 32));
        tabelaDeSimbolos.put("<=", new Linha("<=", 33));
        tabelaDeSimbolos.put("/", new Linha("/", 34));
        tabelaDeSimbolos.put("inicio", new Linha("inicio", 35));
        tabelaDeSimbolos.put("fim", new Linha("fim", 36));
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
            System.out.println(tabelaDeSimbolos);
        
        } else {
            // @TODO O arquivo encontrado não existe
            //System.out.format("O arquivo %s não existe", args[0]);
            System.out.format("O arquivo não existe\n");
            //System.out.println("O arquivo  não existe");
        }
    }
    
    
    
}
