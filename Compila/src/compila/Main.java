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

    static Hashtable<Lexema,ID> tabelaDeSimbolos = new Hashtable<Lexema, ID>();
    //static TabelaDePalavrasReservadas tabelaDePalavrasReservadas;
    static File arquivoEntrada;
    static String nomeArquivoEntrada = "teste.txt";
    static FileInputStream fis;
    static InputStreamReader br;
    
    
    
    static void carregarPalavrasReservadas() {
        System.out.println("Abastecendo a tabela de palavras reservadas...");
        tabelaDeSimbolos.put(new Lexema("DPonto"), new ID(1));
        tabelaDeSimbolos.put(new Lexema("DFace"), new ID(2));
        tabelaDeSimbolos.put(new Lexema("DObjeto"), new ID(3));
        tabelaDeSimbolos.put(new Lexema("DCor"), new ID(4));
        tabelaDeSimbolos.put(new Lexema("DLuz"), new ID(5));
        tabelaDeSimbolos.put(new Lexema("DVar"), new ID(6));
        tabelaDeSimbolos.put(new Lexema("DConst"), new ID(7));
        tabelaDeSimbolos.put(new Lexema("inteiro"), new ID(8));
        tabelaDeSimbolos.put(new Lexema("real"), new ID(9));
        tabelaDeSimbolos.put(new Lexema("Escala"), new ID(10));
        tabelaDeSimbolos.put(new Lexema("Pausa"), new ID(11));
        tabelaDeSimbolos.put(new Lexema("Rottrans"), new ID(12));
        tabelaDeSimbolos.put(new Lexema("Enquanto"), new ID(13));
        tabelaDeSimbolos.put(new Lexema("faca"), new ID(14));
        tabelaDeSimbolos.put(new Lexema("Se"), new ID(15));
        tabelaDeSimbolos.put(new Lexema("entao"), new ID(16));
        tabelaDeSimbolos.put(new Lexema("senao"), new ID(17));
        tabelaDeSimbolos.put(new Lexema("E"), new ID(18));
        tabelaDeSimbolos.put(new Lexema("OU"), new ID(19));
        tabelaDeSimbolos.put(new Lexema("NAO"), new ID(20));
        tabelaDeSimbolos.put(new Lexema("=="), new ID(21));
        tabelaDeSimbolos.put(new Lexema("="), new ID(22));
        tabelaDeSimbolos.put(new Lexema("("), new ID(23));
        tabelaDeSimbolos.put(new Lexema(")"), new ID(24));
        tabelaDeSimbolos.put(new Lexema(","), new ID(25));
        tabelaDeSimbolos.put(new Lexema("+"), new ID(26));
        tabelaDeSimbolos.put(new Lexema("-"), new ID(27));
        tabelaDeSimbolos.put(new Lexema("*"), new ID(28));
        tabelaDeSimbolos.put(new Lexema("<"), new ID(29));
        tabelaDeSimbolos.put(new Lexema(">"), new ID(30));
        tabelaDeSimbolos.put(new Lexema("<>"), new ID(31));
        tabelaDeSimbolos.put(new Lexema(">="), new ID(32));
        tabelaDeSimbolos.put(new Lexema("<="), new ID(33));
        tabelaDeSimbolos.put(new Lexema("/"), new ID(34));
        tabelaDeSimbolos.put(new Lexema("inicio"), new ID(35));
        tabelaDeSimbolos.put(new Lexema("fim"), new ID(36));
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

        /*System.out.println("Rodando a Análise Léxica...");*/

        //tabelaDeSimbolos = new TabelaDeSimbolos();
        //tabelaDePalavrasReservadas = new TabelaDePalavrasReservadas();

        // @TODO Ler arquivo de entrada através do args[0] verificar se existe e etc
        //if (verificarArquivoEntrada(args[0])) {
       
        //String nomeArquivo="arquivoTeste.txt";
        if ( verificarArquivoEntrada(nomeArquivoEntrada =JOptionPane.showInputDialog("Qual o nome do arquivo de teste encontrado na pasta do projeto?", nomeArquivoEntrada))) {
            
            
            carregarPalavrasReservadas();
            AnalisadorLexico al = new AnalisadorLexico();
            
            
            
            /*
            System.out.println("");
            System.out.println("Imprimindo todos Agora!!!!!!!");
            System.out.println("");
            
            for (Lexema i :  tabelaDeSimbolos.keySet()) {
                System.out.println(" L : "+i.getLexema()+" ID : "+tabelaDeSimbolos.get(i).getID());
            }*/

/*
            AnaliseLexica analiseLexica = new AnaliseLexica();

            br = new BufferedReader(new FileReader(arquivoEntrada));
            String linha;
            System.out.println("Verificando se o arquivo está léxicamente correto...");
            for (int numeroLinha = 1; br.ready(); numeroLinha++) {
                linha = br.readLine();
                analiseLexica.verificaString((linha+"\n").toCharArray(), numeroLinha);
            }
            br.close();
            // @TODO Criar while para fim de arquivo
            System.out.println("O arquivo está léxicamente correto!");
            imprimirTabelaDeSimbolos();*/

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
        for (Lexema lexema : tabelaDeSimbolos.keySet()) {
            System.out.println("["+ lexema.getLexema() + ", " + tabelaDeSimbolos.get(lexema).getID() + "]");
        }
        System.out.println("======================================================");
    }
}
