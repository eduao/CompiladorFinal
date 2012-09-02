/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *
 */
package compila;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import javax.swing.JOptionPane;

/**
 *
 * @author Augusto & Eduardo
 */
public class Main {

    static TabelaDeSimbolos tabelaDeSimbolos;
    static TabelaDePalavrasReservadas tabelaDePalavrasReservadas;
    static File arquivoEntrada;

    private static boolean verificarArquivoEntrada(String string) {

        arquivoEntrada = new File(string);
        if (arquivoEntrada.exists()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        System.out.println("Rodando a Análise Léxica...");

        tabelaDeSimbolos = new TabelaDeSimbolos();
        tabelaDePalavrasReservadas = new TabelaDePalavrasReservadas();

        // @TODO Ler arquivo de entrada através do args[0] verificar se existe e etc
        //if (verificarArquivoEntrada(args[0])) {
        if (verificarArquivoEntrada(JOptionPane.showInputDialog("Qual o nome do arquivo de teste encontrado na pasta do projeto?", "arquivoTeste.txt"))) {


            AnaliseLexica analiseLexica = new AnaliseLexica();

            BufferedReader entrada = new BufferedReader(new FileReader(arquivoEntrada));
            String linha;
            System.out.println("Verificando se o arquivo está léxicamente correto...");
            for (int numeroLinha = 1; entrada.ready(); numeroLinha++) {
                linha = entrada.readLine();
                analiseLexica.verificaString(linha.toCharArray(), numeroLinha);
            }
            entrada.close();
            // @TODO Criar while para fim de arquivo
            System.out.println("O arquivo está léxicamente correto!");

        } else {
            // @TODO O arquivo encontrado não existe
            //System.out.format("O arquivo %s não existe", args[0]);
            System.out.format("O arquivo não existe\n");
            //System.out.println("O arquivo  não existe");
        }
    }
}
