/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compila;

import sun.applet.Main;

/**
 *
 * @author Augusto FADC
 */
public class AnaliseSintatica {
    
    private byte tokenAtual;

    public AnaliseSintatica() {
        tokenAtual = Principal.analiseLexica.lerProximoToken();
        INICIO();
        
        if (!Principal.analiseLexica.eFimDeArquivo()){
            erro("Era esperado fim de arquivo, o que não aconteceu.");
        }
    }
    
    public void casaToken (byte tokenEsperado){
        if (tokenAtual != tokenEsperado){
            erro("Token esperado é diferente do token atual!");
        }else{
            tokenAtual = Principal.analiseLexica.lerProximoToken();
        }
    }
    
    public void INICIO(){
        while (tokenAtual == TabelaDeSimbolos.token_dponto ||
                tokenAtual == TabelaDeSimbolos.token_dcor ||
                tokenAtual == TabelaDeSimbolos.token_dface ||
                tokenAtual == TabelaDeSimbolos.token_dluz ||
                tokenAtual == TabelaDeSimbolos.token_dobjeto ||
                tokenAtual == TabelaDeSimbolos.token_dconst ||
                tokenAtual == TabelaDeSimbolos.token_dvar){
            DECLARACOES_VARIAVEIS_INICIAIS();
        }
        casaToken(TabelaDeSimbolos.token_inicio);
        Q();
        while (tokenAtual == TabelaDeSimbolos.token_luz ||
                tokenAtual == TabelaDeSimbolos.token_escala ||
                tokenAtual == TabelaDeSimbolos.token_id ||
                tokenAtual == TabelaDeSimbolos.token_rottrans ||
                tokenAtual == TabelaDeSimbolos.token_enquanto ||
                tokenAtual == TabelaDeSimbolos.token_se ||
                tokenAtual == TabelaDeSimbolos.token_pausa){
            COMANDO_UNICO();
            Q();
        }
        Q();
        casaToken(TabelaDeSimbolos.token_fim);
    }
    
    public void DECLARACOES_VARIAVEIS_INICIAIS () {
        
    }
    
    public void REPETICAO () {
        
    }
    
    public void CONDICIONAL_SE () {
        
    }
    
    public void CONDICIONAL_SENAO () {
        
    }
    
    public void OPERADOR_CONDICIONAL () {
        
    }
    
    public void COMANDO_UNICO () {
        
    }
    
    public void COMANDO_BLOCO () {
        
    }
    
    public void DPONTO () {
        
    }
    
    public void DCOR () {
        
    }
    
    public void DFACE () {
        
    }
    
    public void DLUZ () {
        
    }
    
    public void DOBJETO () {
        
    }
    
    public void DCONST () {
        
    }
    
    public void DVAR () {
        
    }
    
    public void EXPRESSAO () {
        
    }
    
    public void T () {
        
    }
    
    public void F () {
        
    }
    
    public void Q () {
        
    }
    
    public void erro(String mensagem){
        
    }
    
}
