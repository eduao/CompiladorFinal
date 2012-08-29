/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *
 */
package compila;
import java.io.File;
import java.util.Hashtable;

/**
 *
 * @author Augusto & Eduardo
 */
public class Main {

    private static void verificarArquivoEntrada(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    
    Hashtable<Lexema,Token> tabela = new Hashtable<Lexema, Token>();
    
    File arquivoEntrada;
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        // @TODO Ler arquivo de entrada através do args[0] verificar se existe e etc
        verificarArquivoEntrada(args[0]);
        // @TODO Enquanto o arquivo não fechou fazer a análise léxica
        AnaliseLexica analiseLexica = new AnaliseLexica();
        analiseLexica.verificaString("");
        

    }
}
