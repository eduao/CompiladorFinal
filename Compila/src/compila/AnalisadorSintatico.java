    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compila;

/**
 *
 * @author Augusto FADC
 */
public class AnalisadorSintatico {

    String token;
    public void INICIO() {
        while (!(token.equals("DPonto")) ||
                !(token.equals("DCor")) || 
                !(token.equals("DFace")) ||
                !(token.equals("DLuz")) ||
                !(token.equals("DObjeto")) ||
                !(token.equals("DConst")) ||
                !(token.equals("DVar"))) {
            DECLARACOES_VARIAVEIS_INICIAIS();
        }
    }

    public void DECLARACOES_VARIAVEIS_INICIAIS() {
    }

    public void REPETICAO() {
    }

    public void CONDICIONAL_SE() {
    }

    public void CONDICIONAL_SENAO() {
    }

    public void OPERADOR_CONDICIONAL() {
    }

    public void CODIGO() {
    }

    public void DPONTO() {
    }

    public void DCOR() {
    }

    public void DFACE() {
    }

    public void DLUZ() {
    }

    public void DOBJETO() {
    }

    public void DCONST() {
    }

    public void DVAR() {
    }

    public void EXPRESSAO_MATEMATICA() {
    }

    public void OPERADOR_MATEMATICO() {
    }
}