/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compila;

/**
 *
 * @author 365564
 */
public class Linha {

    public String getLexema() {
        return Lexema;
    }

    public void setLexema(String Lexema) {
        this.Lexema = Lexema;
    }

    public int getToken() {
        return Token;
    }

    public void setToken(int Token) {
        this.Token = Token;
    }
    
    private String Lexema;
    private int Token;

    public Linha(String Lexema,int Token) {
        this.Lexema = Lexema;
        this.Token = Token;
    }
    
    
}
