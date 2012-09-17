/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compila;

/**
 *
 * @author Augusto FADC
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    
    public static AnaliseLexica analiseLexica;
    public static AnaliseSintatica analiseSintatica;
    public static TabelaDeSimbolos tabelaDeSimbolos;
    public static void main(String[] args) {
        // TODO code application logic here
        tabelaDeSimbolos = new TabelaDeSimbolos();
        analiseLexica = new AnaliseLexica();
        analiseSintatica = new AnaliseSintatica();
        
        while(true){
            System.out.println(analiseLexica.lerProximoToken());
        }
    }
}
