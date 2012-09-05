/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compila;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Hashtable;

/**
 *
 * @author Eduardo
 */
public class AnalisadorLexico {

    
    static BufferedReader br;// = Main.br;
    static CharBuffer cb;// = CharBuffer.wrap(br.toString());
    static Hashtable<Lexema,ID> tabelaDeSimbolos = Main.tabelaDeSimbolos;
    
    
    
    static char proximoChar(int posicao){
        return cb.get(posicao);
    }
    
    
    public AnalisadorLexico() throws IOException {
        
               
        br = Main.br;
        cb = CharBuffer.wrap(br.readLine());
        
        for (Lexema l : tabelaDeSimbolos.keySet()){
            System.out.println("Lexema "+l.getLexema()+" - ID "+tabelaDeSimbolos.get(l).getID());
        }
        
        //br.readLine();
        
        //System.out.println("BR = "+br.readLine());
        
        
        System.out.println("O char retornado é ("+proximoChar(4)+")");
        
    }
    
    
    
    
}
