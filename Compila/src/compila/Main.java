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
    static Hashtable< Token, ID> palavraReservada = new Hashtable< Token, ID>(); 
    
    
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
            
            
            setPalavrasReservadas();

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
            System.out.format("O arquivo %s não existe", args[0]);
            //System.out.println("O arquivo  não existe");
        }
    }

    private static void setPalavrasReservadas() {
        palavraReservada.put(new Token("DPonto"), new ID(1));
        palavraReservada.put(new Token("DFace"), new ID(2));
        palavraReservada.put(new Token("DObjeto"), new ID(3));
        palavraReservada.put(new Token("DCor"), new ID(4));
        palavraReservada.put(new Token("DLuz"), new ID(5));
        palavraReservada.put(new Token("DVar"), new ID(6));
        palavraReservada.put(new Token("DConst"), new ID(7));
        palavraReservada.put(new Token("inteiro"), new ID(8));
        palavraReservada.put(new Token("real"), new ID(9));
        palavraReservada.put(new Token("Escala"), new ID(10));
        palavraReservada.put(new Token("Pausa"), new ID(11));
        palavraReservada.put(new Token("Rottrans"), new ID(12));
        palavraReservada.put(new Token("Enquanto"), new ID(13));
        palavraReservada.put(new Token("faca"), new ID(14));
        palavraReservada.put(new Token("Se"), new ID(15));
        palavraReservada.put(new Token("entao"), new ID(16));
        palavraReservada.put(new Token("senao"), new ID(17));
        palavraReservada.put(new Token("E"), new ID(18));
        palavraReservada.put(new Token("OU"), new ID(19));
        palavraReservada.put(new Token("NAO"), new ID(20));
        palavraReservada.put(new Token("=="), new ID(21));
        palavraReservada.put(new Token("="), new ID(22));
        palavraReservada.put(new Token("("), new ID(23));
        palavraReservada.put(new Token(")"), new ID(24));
        palavraReservada.put(new Token(","), new ID(25));
        palavraReservada.put(new Token("+"), new ID(26));
        palavraReservada.put(new Token("-"), new ID(27));
        palavraReservada.put(new Token("*"), new ID(28));
        palavraReservada.put(new Token("<"), new ID(29));
        palavraReservada.put(new Token(">"), new ID(30));
        palavraReservada.put(new Token("<>"), new ID(31));
        palavraReservada.put(new Token(">="), new ID(32));
        palavraReservada.put(new Token("<="), new ID(33));
        palavraReservada.put(new Token("/"), new ID(34));
        palavraReservada.put(new Token("inicio"), new ID(35));
        palavraReservada.put(new Token("fim"), new ID(36));
        
        
        
        
        
    }
}
