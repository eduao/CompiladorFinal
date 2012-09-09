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

    public void casaToken(String token) {
    }
    String token;
    String ID, CONST;//AINDA NAO SEI O QUE FAZER

    public void INICIO() {
        while (!(token.equals("DPonto"))
                || !(token.equals("DCor"))
                || !(token.equals("DFace"))
                || !(token.equals("DLuz"))
                || !(token.equals("DObjeto"))
                || !(token.equals("DConst"))
                || !(token.equals("DVar"))) {
            DECLARACOES_VARIAVEIS_INICIAIS();
        }
        casaToken("Inicio");
        casaToken("<R>");
        while (!(token.equals("Luz"))
                || !(token.equals("Escala"))
                || !(token.equals(ID))
                || !(token.equals("Rottrans"))
                || !(token.equals("enquanto"))
                || !(token.equals("se"))
                || !(token.equals("pause"))) {
            CODIGO();
        }
        casaToken("<R>");
        casaToken("Fim");


    }

    public void DECLARACOES_VARIAVEIS_INICIAIS() {
        if (token.equals("DPonto")) {
            casaToken("DPonto");
            casaToken("<R>");
            while (token.equals(ID)) {
                casaToken(ID);
                casaToken("=");
                DPONTO();
            }
        } else if (token.equals("DCor")) {
            casaToken("DCor");
            casaToken("<R>");
            while (token.equals(ID)) {
                casaToken(ID);
                casaToken("=");
                DCOR();
            }
        } else if (token.equals("DFace")) {
            casaToken("DFace");
            casaToken("<R>");
            while (token.equals(ID)) {
                casaToken(ID);
                casaToken("=");
                DFACE();
            }
        } else if (token.equals("DLuz")) {
            casaToken("DLuz");
            casaToken("<R>");
            while (token.equals(ID)) {
                casaToken(ID);
                casaToken("=");
                DLUZ();
            }
        } else if (token.equals("DObjeto")) {
            casaToken("DObjeto");
            casaToken("<R>");
            while (token.equals(ID)) {
                casaToken(ID);
                casaToken("=");
                DOBJETO();
            }
        } else if (token.equals("DConst")) {
            casaToken("DConst");
            casaToken("<R>");
            while (token.equals(ID)) {
                casaToken(ID);
                casaToken("=");
                DCONST();
            }
        } else if (token.equals("DVar")) {
            casaToken("DVar");
            casaToken("<R>");
            while (token.equals(ID)) {
                casaToken(ID);
                casaToken("=");
                DVAR();
            }
        }


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
        casaToken("(");
        if (token.equals("-")) {
            casaToken("-");
        }
        casaToken(CONST);
        casaToken(",");
        if (token.equals("-")) {
            casaToken("-");
        }
        casaToken(CONST);
        casaToken(",");
        if (token.equals("-")) {
            casaToken("-");
        }
        casaToken(CONST);
        casaToken(")");
    }

    public void DCOR() {
        casaToken("(");
        if(token.equals(CONST)){
            casaToken(CONST);
        }else if (token.equals(ID)){
            casaToken(ID);
        }
        casaToken(",");
        if(token.equals(CONST)){
            casaToken(CONST);
        }else if (token.equals(ID)){
            casaToken(ID);
        }
        casaToken(",");
        if(token.equals(CONST)){
            casaToken(CONST);
        }else if (token.equals(ID)){
            casaToken(ID);
        }
        casaToken(",");
        if(token.equals(CONST)){
            casaToken(CONST);
        }else if (token.equals(ID)){
            casaToken(ID);
        }
        casaToken(",");
        if(token.equals(CONST)){
            casaToken(CONST);
        }else if (token.equals(ID)){
            casaToken(ID);
        }
        casaToken(",");
        if(token.equals(CONST)){
            casaToken(CONST);
        }else if (token.equals(ID)){
            casaToken(ID);
        }
        casaToken(",");
        if(token.equals(CONST)){
            casaToken(CONST);
        }else if (token.equals(ID)){
            casaToken(ID);
        }
        casaToken(")");
    }

    public void DFACE() {
        casaToken("(");
        casaToken(ID);
        casaToken(",");
        casaToken(ID);
        casaToken(",");
        casaToken(ID);
        casaToken(",");
        casaToken(ID);
        casaToken(",");
        casaToken(ID);
        casaToken(")");
    }

    public void DLUZ() {
        casaToken("(");
        if (token.equals("-")) {
            casaToken("-");
        }
        casaToken(CONST);
        casaToken(",");
        if (token.equals("-")) {
            casaToken("-");
        }
        casaToken(CONST);
        casaToken(",");
        if (token.equals("-")) {
            casaToken("-");
        }
        casaToken(CONST);
        casaToken(")");
    }

    public void DOBJETO() {
        casaToken(ID);
        casaToken(",");
        casaToken(ID);
        casaToken(",");
        casaToken(ID);
        casaToken(",");
        casaToken(ID);
        casaToken(",");
        casaToken(ID);
        casaToken(",");
        casaToken(ID);
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