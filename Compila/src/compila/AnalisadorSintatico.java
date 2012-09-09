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
        /*
         * Procedimento casaToken (Token tokenEsperado)
         *      Se tokenAtual != tokenEsperado
         *          Entao erro
         *      Senao
         *          Chamar AnalisadorLexico
         */
    }
    
    public void erroSintatico() {
        System.out.println("ERRO SINTATICO =/");
    }
    String token;
    String ID, CONST, QUEBRA_DE_LINHA;//AINDA NAO SEI O QUE FAZER

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
        casaToken("QUEBRA");
        while (!(token.equals("Luz"))
                || !(token.equals("Escala"))
                || !(token.equals(ID))
                || !(token.equals("Rottrans"))
                || !(token.equals("enquanto"))
                || !(token.equals("se"))
                || !(token.equals("pause"))) {
            CODIGO();
        }
        casaToken(QUEBRA_DE_LINHA);
        casaToken("Fim");
        
        
    }
    
    public void DECLARACOES_VARIAVEIS_INICIAIS() {
        if (token.equals("DPonto")) {
            casaToken("DPonto");
            casaToken(QUEBRA_DE_LINHA);
            while (token.equals(ID)) {
                casaToken(ID);
                casaToken("=");
                DPONTO();
            }
        } else if (token.equals("DCor")) {
            casaToken("DCor");
            casaToken(QUEBRA_DE_LINHA);
            while (token.equals(ID)) {
                casaToken(ID);
                casaToken("=");
                DCOR();
            }
        } else if (token.equals("DFace")) {
            casaToken("DFace");
            casaToken(QUEBRA_DE_LINHA);
            while (token.equals(ID)) {
                casaToken(ID);
                casaToken("=");
                DFACE();
            }
        } else if (token.equals("DLuz")) {
            casaToken("DLuz");
            casaToken(QUEBRA_DE_LINHA);
            while (token.equals(ID)) {
                casaToken(ID);
                casaToken("=");
                DLUZ();
            }
        } else if (token.equals("DObjeto")) {
            casaToken("DObjeto");
            casaToken(QUEBRA_DE_LINHA);
            while (token.equals(ID)) {
                casaToken(ID);
                casaToken("=");
                DOBJETO();
            }
        } else if (token.equals("DConst")) {
            casaToken("DConst");
            casaToken(QUEBRA_DE_LINHA);
            while (token.equals(ID)) {
                casaToken(ID);
                casaToken("=");
                DCONST();
            }
        } else if (token.equals("DVar")) {
            casaToken("DVar");
            casaToken(QUEBRA_DE_LINHA);
            while (token.equals(ID)) {
                casaToken(ID);
                casaToken("=");
                DVAR();
            }
        }
        
        
    }
    
    public void REPETICAO() {
        casaToken("enquanto");
        if (token.equals(CONST)) {
            casaToken(CONST);
        } else if (token.equals(ID)) {
            casaToken(ID);
        } else {
            erroSintatico();
        }
        OPERADOR_CONDICIONAL();
        if (token.equals(CONST)) {
            casaToken(CONST);
        } else if (token.equals(ID)) {
            casaToken(ID);
        } else {
            erroSintatico();
        }
        casaToken("faca");
        if (token.equals(QUEBRA_DE_LINHA)) {
            casaToken(QUEBRA_DE_LINHA);
            casaToken("inicio");
            casaToken(QUEBRA_DE_LINHA);
            while (!(token.equals("Luz"))
                    || !(token.equals("Escala"))
                    || !(token.equals(ID))
                    || !(token.equals("Rottrans"))
                    || !(token.equals("enquanto"))
                    || !(token.equals("se"))
                    || !(token.equals("pause"))) {
                CODIGO();
            }
            casaToken("fim");
            casaToken(QUEBRA_DE_LINHA);
            
        } else if ((token.equals("Luz"))
                || (token.equals("Escala"))
                || (token.equals(ID))
                || (token.equals("Rottrans"))
                || (token.equals("enquanto"))
                || (token.equals("se"))
                || (token.equals("pause"))) {
            CODIGO();
        } else {
            erroSintatico();
        }
        
    }
    
    public void CONDICIONAL_SE() {
        casaToken("se");
        if (token.equals(CONST)) {
            casaToken(CONST);
        } else if (token.equals(ID)) {
            casaToken(ID);
        } else {
            erroSintatico();
        }
        OPERADOR_CONDICIONAL();
        if (token.equals(CONST)) {
            casaToken(CONST);
        } else if (token.equals(ID)) {
            casaToken(ID);
        } else {
            erroSintatico();
        }
        casaToken("entao");
        if (token.equals(QUEBRA_DE_LINHA)) {
            casaToken(QUEBRA_DE_LINHA);
            casaToken("inicio");
            casaToken(QUEBRA_DE_LINHA);
            while (!(token.equals("Luz"))
                    || !(token.equals("Escala"))
                    || !(token.equals(ID))
                    || !(token.equals("Rottrans"))
                    || !(token.equals("enquanto"))
                    || !(token.equals("se"))
                    || !(token.equals("pause"))) {
                CODIGO();
            }
            casaToken("fim");
            casaToken(QUEBRA_DE_LINHA);
            
        } else if ((token.equals("Luz"))
                || (token.equals("Escala"))
                || (token.equals(ID))
                || (token.equals("Rottrans"))
                || (token.equals("enquanto"))
                || (token.equals("se"))
                || (token.equals("pause"))) {
            CODIGO();
        } else {
            erroSintatico();
        }
        if (token.equals("senao")) {
            CONDICIONAL_SENAO();
        }
    }
    
    public void CONDICIONAL_SENAO() {
        casaToken("senao");
        if (token.equals(QUEBRA_DE_LINHA)) {
            casaToken(QUEBRA_DE_LINHA);
            casaToken("inicio");
            casaToken(QUEBRA_DE_LINHA);
            while (!(token.equals("Luz"))
                    || !(token.equals("Escala"))
                    || !(token.equals(ID))
                    || !(token.equals("Rottrans"))
                    || !(token.equals("enquanto"))
                    || !(token.equals("se"))
                    || !(token.equals("pause"))) {
                CODIGO();
            }
            casaToken("fim");
            casaToken(QUEBRA_DE_LINHA);
            
        } else if ((token.equals("Luz"))
                || (token.equals("Escala"))
                || (token.equals(ID))
                || (token.equals("Rottrans"))
                || (token.equals("enquanto"))
                || (token.equals("se"))
                || (token.equals("pause"))) {
            CODIGO();
        } else {
            erroSintatico();
        }
    }
    
    public void OPERADOR_CONDICIONAL() {
        if (token.equals(">")) {
            
        } else if (token.equals(">=")) {
            
        } else if (token.equals("<")) {
            
        } else if (token.equals("<=")) {
            
        } else if (token.equals("==")) {
            
        } else if (token.equals("<>")) {
            
        } else {
            erroSintatico();
        }
    }
    
    public void CODIGO() {
        if (token.equals("Luz")) {
            casaToken("Luz");
            casaToken(ID);
        } else if (token.equals("Escala")) {
            casaToken("Escala");
            casaToken(ID);
            casaToken(",");
            casaToken(ID);
        } else if (token.equals(ID)) {
            casaToken(ID);
            casaToken("=");
            if (token.equals(CONST)) {
                casaToken(CONST);
            }else if(token.equals(ID)){
                casaToken(ID);
            }else{
                erroSintatico();
            }
        } else if (token.equals("Rottrans")) {
            casaToken("Rottrans");
            casaToken(ID);
            casaToken(",");
            if (token.equals(CONST)) {
                casaToken(CONST);
            }else if(token.equals(ID)){
                casaToken(ID);
            }else{
                erroSintatico();
            }
            casaToken(",");
            if (token.equals(CONST)) {
                casaToken(CONST);
            }else if(token.equals(ID)){
                casaToken(ID);
            }else{
                erroSintatico();
            }
            casaToken(",");
            if (token.equals(CONST)) {
                casaToken(CONST);
            }else if(token.equals(ID)){
                casaToken(ID);
            }else{
                erroSintatico();
            }
            casaToken(",");
            if (token.equals(CONST)) {
                casaToken(CONST);
            }else if(token.equals(ID)){
                casaToken(ID);
            }else{
                erroSintatico();
            }
            casaToken(",");
            if (token.equals(CONST)) {
                casaToken(CONST);
            }else if(token.equals(ID)){
                casaToken(ID);
            }else{
                erroSintatico();
            }
            casaToken(",");
            if (token.equals(CONST)) {
                casaToken(CONST);
            }else if(token.equals(ID)){
                casaToken(ID);
            }else{
                erroSintatico();
            }
        } else if (token.equals("enquanto")) {//repeticao
            REPETICAO();
        } else if (token.equals("se")) {//condicional se
            CONDICIONAL_SE();
        } else if (token.equals("pausa")) {
            casaToken("pausa");
            if (token.equals(CONST)) {
                casaToken(CONST);
            }else if(token.equals(ID)){
                casaToken(ID);
            }else{
                erroSintatico();
            }
        } else {
            erroSintatico();
        }
        casaToken(QUEBRA_DE_LINHA);
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
        if (token.equals(CONST)) {
            casaToken(CONST);
        } else if (token.equals(ID)) {
            casaToken(ID);
        } else {
            erroSintatico();
        }
        casaToken(",");
        if (token.equals(CONST)) {
            casaToken(CONST);
        } else if (token.equals(ID)) {
            casaToken(ID);
        } else {
            erroSintatico();
        }
        casaToken(",");
        if (token.equals(CONST)) {
            casaToken(CONST);
        } else if (token.equals(ID)) {
            casaToken(ID);
        } else {
            erroSintatico();
        }
        casaToken(",");
        if (token.equals(CONST)) {
            casaToken(CONST);
        } else if (token.equals(ID)) {
            casaToken(ID);
        } else {
            erroSintatico();
        }
        casaToken(",");
        if (token.equals(CONST)) {
            casaToken(CONST);
        } else if (token.equals(ID)) {
            casaToken(ID);
        } else {
            erroSintatico();
        }
        casaToken(",");
        if (token.equals(CONST)) {
            casaToken(CONST);
        } else if (token.equals(ID)) {
            casaToken(ID);
        } else {
            erroSintatico();
        }
        casaToken(",");
        if (token.equals(CONST)) {
            casaToken(CONST);
        } else if (token.equals(ID)) {
            casaToken(ID);
        } else {
            erroSintatico();
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
        casaToken(ID);
        casaToken("=");
        if (token.equals("-")) {
            casaToken("-");
        }
        casaToken(CONST);//numerica -> ver o que fazer -> verificar se há apenas numeros?
    }
    
    public void DVAR() {
        if (token.equals("inteiro")) {
            casaToken("inteiro");
        } else if (token.equals("real")) {
            casaToken("real");
        }
        casaToken(CONST);
        while ((token.equals("-"))
                || (token.equals(CONST))) {
            if (token.equals("-")) {
                casaToken("-");
            }
            casaToken(CONST);
        }
    }
    
    public void EXPRESSAO_MATEMATICA() {
        if (token.equals("-")) {
            casaToken("-");
        }
        if (token.equals(ID)) {
            casaToken(ID);
        } else if (token.equals(CONST)) {
            casaToken(CONST);
        } else {
            erroSintatico();
        }
        while (!(token.equals("+")
                || token.equals("-")
                || token.equals("*")
                || token.equals("/"))) {
            OPERADOR_MATEMATICO();
            if (token.equals(ID)) {
                casaToken(ID);
            } else if (token.equals(CONST)) {
                casaToken(CONST);
            } else {
                erroSintatico();
            }
        }
    }
    
    public void OPERADOR_MATEMATICO() {
        if (token.equals("+")) {
            casaToken("+");
        } else if (token.equals("-")) {
            casaToken("-");
        } else if (token.equals("*")) {
            casaToken("*");
        } else if (token.equals("/")) {
            casaToken("/");
        } else {
            erroSintatico();
        }
    }
}
