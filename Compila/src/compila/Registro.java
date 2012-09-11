/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compila;

/**
 *
 * @author 365564
 */
public class Registro {

    public String getLexema() {
        return Lexema;
    }

    public void setLexema(String Lexema) {
        this.Lexema = Lexema;
    }

    public byte getToken() {
        return Token;
    }

    public void setToken(byte Token) {
        this.Token = Token;
    }
    
    private String Lexema;
    private byte Token;

    public Registro(String Lexema,byte Token) {
        this.Lexema = Lexema;
        this.Token = Token;
    }
    
    
}
