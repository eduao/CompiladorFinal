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


        if (verificarArquivoEntrada(nomeArquivoEntrada = JOptionPane.showInputDialog("Qual o nome do arquivo de teste encontrado na pasta do projeto?", nomeArquivoEntrada))) {

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
