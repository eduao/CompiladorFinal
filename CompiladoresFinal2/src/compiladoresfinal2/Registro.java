/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladoresfinal2;

/**
 *
 * @author Augusto FADC
 */
public class Registro {
    private String lexema;
    private byte token;

    public Registro(String lexema, byte token) {
        this.lexema = lexema;
        this.token = token;
    }
    
    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public byte getToken() {
        return token;
    }

    public void setToken(byte token) {
        this.token = token;
    }
}
