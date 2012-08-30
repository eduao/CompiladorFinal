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

/**
 *
 * @author Augusto & Eduardo
 */
public class Main {

    static Hashtable<Lexema, Token> tabela = new Hashtable<Lexema, Token>();
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

        // @TODO Ler arquivo de entrada através do args[0] verificar se existe e etc
        if (verificarArquivoEntrada(args[0])) {

            AnaliseLexica analiseLexica = new AnaliseLexica();

            BufferedReader entrada = new BufferedReader(new FileReader(arquivoEntrada));
            String[] linha;
            while (entrada.ready()) {
                linha = entrada.readLine().split(" ");
                for (int i = 0; i < linha.length; i++) {
                    analiseLexica.verificaString(linha[i].toCharArray());
                }
            }
            entrada.close();


            // @TODO Criar while para fim de arquivo
            // @TODO Criar while para fim de arquivo


            //analiseLexica.verificaString("");


        } else {
            // @TODO O arquivo encontrado não existe
            System.out.format("O arquivo {0} não existe", args[0]);
            //System.out.println("O arquivo  não existe");
        }
    }
}
