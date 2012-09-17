/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladoresfinal2;

import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Augusto FADC
 */
public class TabelaDeSimbolos extends Hashtable<String, Registro> {

    public static final byte token_dponto = (byte) 1;
    public static final byte token_dface = (byte) 2;
    public static final byte token_dobjeto = (byte) 3;
    public static final byte token_dcor = (byte) 4;
    public static final byte token_dluz = (byte) 5;
    public static final byte token_dvar = (byte) 6;
    public static final byte token_dconst = (byte) 7;
    public static final byte token_inteiro = (byte) 8;
    public static final byte token_real = (byte) 9;
    public static final byte token_escala = (byte) 10;
    public static final byte token_pausa = (byte) 11;
    public static final byte token_rottrans = (byte) 12;
    public static final byte token_enquanto = (byte) 13;
    public static final byte token_faca = (byte) 14;
    public static final byte token_se = (byte) 15;
    public static final byte token_entao = (byte) 16;
    public static final byte token_senao = (byte) 17;
    public static final byte token_e = (byte) 18;
    public static final byte token_ou = (byte) 19;
    public static final byte token_nao = (byte) 20;
    public static final byte token_igualigual = (byte) 21;
    public static final byte token_igual = (byte) 22;
    public static final byte token_abreparenteses = (byte) 23;
    public static final byte token_fechaparenteses = (byte) 24;
    public static final byte token_virgula = (byte) 25;
    public static final byte token_mais = (byte) 26;
    public static final byte token_menos = (byte) 27;
    public static final byte token_asterisco = (byte) 28;
    public static final byte token_menor = (byte) 29;
    public static final byte token_maior = (byte) 30;
    public static final byte token_menormaior = (byte) 31;
    public static final byte token_maiorigual = (byte) 32;
    public static final byte token_menorigual = (byte) 33;
    public static final byte token_barra = (byte) 34;
    public static final byte token_inicio = (byte) 35;
    public static final byte token_fim = (byte) 36;
    public static final byte token_luz = (byte) 37;
    public static final byte token_barrar = (byte) 38;
    public static final byte token_id = (byte) 39;
    public static final byte token_constante = (byte) 40;
    public static final byte token_abrecolchetes = (byte) 41;
    public static final byte token_fechacolchetes = (byte) 42;
    public static final byte token_abrechaves = (byte) 43;
    public static final byte token_fechachaves = (byte) 44;
    public static final byte token_barran = (byte) 45;

    public TabelaDeSimbolos() {
        abastecerTabelaComSimbolosIniciais();
    }

    private void abastecerTabelaComSimbolosIniciais() {

        this.put("DPonto", new Registro("DPonto", token_dponto));
        this.put("DFace", new Registro("DFace", token_dface));
        this.put("DObjeto", new Registro("DObjeto", token_dobjeto));
        this.put("DCor", new Registro("DCor", token_dcor));
        this.put("DLuz", new Registro("DLuz", token_dluz));
        this.put("DVar", new Registro("DVar", token_dvar));
        this.put("DConst", new Registro("DConst", token_dconst));
        this.put("inteiro", new Registro("inteiro", token_inteiro));
        this.put("real", new Registro("real", token_real));
        this.put("Escala", new Registro("Escala", token_escala));
        this.put("Pausa", new Registro("Pausa", token_pausa));
        this.put("Rottrans", new Registro("Rottrans", token_rottrans));
        this.put("Enquanto", new Registro("Enquanto", token_enquanto));
        this.put("faca", new Registro("faca", token_faca));
        this.put("Se", new Registro("Se", token_se));
        this.put("entao", new Registro("entao", token_entao));
        this.put("senao", new Registro("senao", token_senao));
        this.put("E", new Registro("E", token_e));
        this.put("OU", new Registro("OU", token_ou));
        this.put("NAO", new Registro("NAO", token_nao));
        this.put("==", new Registro("==", token_igualigual));
        this.put("=", new Registro("=", token_igual));
        this.put("(", new Registro("(", token_abreparenteses));
        this.put(")", new Registro(")", token_fechaparenteses));
        this.put(",", new Registro(",", token_virgula));
        this.put("+", new Registro("+", token_mais));
        this.put("-", new Registro("-", token_menos));
        this.put("*", new Registro("*", token_asterisco));
        this.put("<", new Registro("<", token_menor));
        this.put(">", new Registro(">", token_maior));
        this.put("<>", new Registro("<>", token_menormaior));
        this.put(">=", new Registro(">=", token_maiorigual));
        this.put("<=", new Registro("<=", token_menorigual));
        this.put("/", new Registro("/", token_barra));
        this.put("inicio", new Registro("inicio", token_inicio));
        this.put("fim", new Registro("fim", token_fim));
        this.put("Luz", new Registro("Luz", token_luz));
        this.put("\r", new Registro("\r", token_barrar));
        this.put("[", new Registro("[", token_abrecolchetes));
        this.put("]", new Registro("]", token_fechacolchetes));
        this.put("{", new Registro("{", token_abrechaves));
        this.put("}", new Registro("}", token_fechachaves));
        this.put("\n", new Registro("\n", token_barran));
        
    }
    

    @Override
    public synchronized String toString() {
        ComparadorPorValor comparadorPorValor = new ComparadorPorValor(this);
        TreeMap<String, Registro> tabelaOrdenadaPorToken = new TreeMap<String, Registro>(comparadorPorValor);
        tabelaOrdenadaPorToken.putAll(this);
        String string;
        string = "======================================================";
        string = string + "\nImprimindo a tabela de simbolos...";
        for (String lexema : tabelaOrdenadaPorToken.keySet()) {
            string = string + "\n[" + padronizarTamanho(get(lexema).getToken()+"", 5) + ", " + padronizarTamanho(lexema, 20) + "]";
        }
        string = string + "\n======================================================";
        return string;
    }
    
    public String padronizarTamanho(String str, int tam) {
        String retorno = str;
        while (retorno.length() < tam) {
            retorno = retorno + " ";
        }
        return retorno;
    }

    class ComparadorPorValor implements Comparator<String> {

        Map<String, Registro> base;

        public ComparadorPorValor(Map<String, Registro> base) {
            this.base = base;
        }

        @Override
        public int compare(String o1, String o2) {
            if (base.get(o1).getToken() < base.get(o2).getToken()) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
