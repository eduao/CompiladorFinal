    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compila;

import java.io.IOException;

/**
 *
 * @author Augusto FADC
 */
public class AnalisadorSintatico {

    public void casaToken(byte tokenEsperado) throws IOException {
        byte tokenAtual = AnalisadorLexico.nextToken().getToken();
        if (tokenEsperado != tokenAtual) {
            erroSintatico();
        }
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
        System.exit(-1);
    }
    StringBuffer sb;
    byte token;
    String ID, CONST, QUEBRA_DE_LINHA;//AINDA NAO SEI O QUE FAZER

    public void INICIO() throws IOException {
        //preciso ler o primeiro token aqui!
        while (token != 1
                || token != 4
                || token != 2
                || token != 5
                || token != 3
                || token != 7
                || token != 6) {
            DECLARACOES_VARIAVEIS_INICIAIS();
        }
        casaToken((byte) 35);
        casaToken(QUEBRA_DE_LINHA);
        while (token != 37
                || token != 10
                || token != Main.tabelaDeSimbolos.IDToken
                || token != 12
                | token != 13
                || token != 15
                || token != 11) {
            CODIGO();
        }
        casaToken(QUEBRA_DE_LINHA);
        casaToken((byte) 36);


    }

    public void DECLARACOES_VARIAVEIS_INICIAIS() throws IOException {
        if (token == 1) {
            casaToken((byte) 1);
            casaToken(QUEBRA_DE_LINHA);
            while (token == Main.tabelaDeSimbolos.IDToken) {
                casaToken(Main.tabelaDeSimbolos.IDToken);
                casaToken((byte) 22);
                DPONTO();
            }
        } else if (token == 4) {
            casaToken((byte) 4);
            casaToken(QUEBRA_DE_LINHA);
            while (token == Main.tabelaDeSimbolos.IDToken) {
                casaToken(Main.tabelaDeSimbolos.IDToken);
                casaToken((byte) 22);
                DCOR();
            }
        } else if (token == 2) {
            casaToken((byte) 2);
            casaToken(QUEBRA_DE_LINHA);
            while (token == Main.tabelaDeSimbolos.IDToken) {
                casaToken(Main.tabelaDeSimbolos.IDToken);
                casaToken((byte) 22);
                DFACE();
            }
        } else if (token == 5) {
            casaToken((byte) 5);
            casaToken(QUEBRA_DE_LINHA);
            while (token == Main.tabelaDeSimbolos.IDToken) {
                casaToken(Main.tabelaDeSimbolos.IDToken);
                casaToken((byte) 22);
                DLUZ();
            }
        } else if (token == 3) {
            casaToken((byte) 3);
            casaToken(QUEBRA_DE_LINHA);
            while (token == Main.tabelaDeSimbolos.IDToken) {
                casaToken(Main.tabelaDeSimbolos.IDToken);
                casaToken((byte) 22);
                DOBJETO();
            }
        } else if (token == 7) {
            casaToken((byte) 7);
            casaToken(QUEBRA_DE_LINHA);
            while (token == Main.tabelaDeSimbolos.IDToken) {
                casaToken(Main.tabelaDeSimbolos.IDToken);
                casaToken((byte) 22);
                DCONST();
            }
        } else if (token == 6) {
            casaToken((byte) 6);
            casaToken(QUEBRA_DE_LINHA);
            while (token == Main.tabelaDeSimbolos.IDToken) {
                casaToken(Main.tabelaDeSimbolos.IDToken);
                casaToken((byte) 22);
                DVAR();
            }
        }
    }

    public void REPETICAO() throws IOException {
        casaToken((byte) 13);
        if (token == Main.tabelaDeSimbolos.CONSTToken) {
            casaToken(Main.tabelaDeSimbolos.CONSTToken);
        } else if (token == Main.tabelaDeSimbolos.IDToken) {
            casaToken(Main.tabelaDeSimbolos.IDToken);
        } else {
            erroSintatico();
        }
        OPERADOR_CONDICIONAL();
        if (token == Main.tabelaDeSimbolos.CONSTToken) {
            casaToken(Main.tabelaDeSimbolos.CONSTToken);
        } else if (token == Main.tabelaDeSimbolos.IDToken) {
            casaToken(Main.tabelaDeSimbolos.IDToken);
        } else {
            erroSintatico();
        }
        casaToken((byte) 14);
        if (token.equals(QUEBRA_DE_LINHA)) {
            casaToken(QUEBRA_DE_LINHA);
            casaToken((byte) 35);
            casaToken(QUEBRA_DE_LINHA);
            while (token != 37
                    || token != 10
                    || token != Main.tabelaDeSimbolos.IDToken
                    || token != 12
                    | token != 13
                    || token != 15
                    || token != 11) {
                CODIGO();
            }
            casaToken((byte) 36);
            casaToken(QUEBRA_DE_LINHA);

        } else if (token == 37
                || token == 10
                || token == Main.tabelaDeSimbolos.IDToken
                || token == 12
                | token == 13
                || token == 15
                || token == 11) {
            CODIGO();
        } else {
            erroSintatico();
        }

    }

    public void CONDICIONAL_SE() throws IOException {
        casaToken((byte) 15);
        if (token == Main.tabelaDeSimbolos.CONSTToken) {
            casaToken(Main.tabelaDeSimbolos.CONSTToken);
        } else if (token == Main.tabelaDeSimbolos.IDToken) {
            casaToken(Main.tabelaDeSimbolos.IDToken);
        } else {
            erroSintatico();
        }
        OPERADOR_CONDICIONAL();
        if (token == Main.tabelaDeSimbolos.CONSTToken) {
            casaToken(Main.tabelaDeSimbolos.CONSTToken);
        } else if (token == Main.tabelaDeSimbolos.IDToken) {
            casaToken(Main.tabelaDeSimbolos.IDToken);
        } else {
            erroSintatico();
        }
        casaToken((byte) 16);
        if (token.equals(QUEBRA_DE_LINHA)) {
            casaToken(QUEBRA_DE_LINHA);
            casaToken((byte) 35);
            casaToken(QUEBRA_DE_LINHA);
            while (token != 37
                    || token != 10
                    || token != Main.tabelaDeSimbolos.IDToken
                    || token != 12
                    | token != 13
                    || token != 15
                    || token != 11) {
                CODIGO();
            }
            casaToken((byte) 36);
            casaToken(QUEBRA_DE_LINHA);

        } else if (token == 37
                || token == 10
                || token == Main.tabelaDeSimbolos.IDToken
                || token == 12
                | token == 13
                || token == 15
                || token == 11) {
            CODIGO();
        } else {
            erroSintatico();
        }
        if (token == 17) {
            CONDICIONAL_SENAO();
        }
    }

    public void CONDICIONAL_SENAO() throws IOException {
        casaToken((byte) 17);
        if (token.equals(QUEBRA_DE_LINHA)) {
            casaToken(QUEBRA_DE_LINHA);
            casaToken((byte) 35);
            casaToken(QUEBRA_DE_LINHA);
            while (token != 37
                    || token != 10
                    || token != Main.tabelaDeSimbolos.IDToken
                    || token != 12
                    | token != 13
                    || token != 15
                    || token != 11) {
                CODIGO();
            }
            casaToken((byte) 36);
            casaToken(QUEBRA_DE_LINHA);

        } else if (token == 37
                || token == 10
                || token == Main.tabelaDeSimbolos.IDToken
                || token == 12
                | token == 13
                || token == 15
                || token == 11) {
            CODIGO();
        } else {
            erroSintatico();
        }
    }

    public void OPERADOR_CONDICIONAL() throws IOException {
        if (token == 30) {
        } else if (token == 32) {
            casaToken((byte) 32);
        } else if (token == 29) {
            casaToken((byte) 29);
        } else if (token == 33) {
            casaToken((byte) 33);
        } else if (token == 21) {
            casaToken((byte) 21);
        } else if (token == 31) {
            casaToken((byte) 31);
        } else {
            erroSintatico();
        }
    }

    public void CODIGO() throws IOException {
        if (token == 37) {
            casaToken((byte) 37);
            casaToken(Main.tabelaDeSimbolos.IDToken);
        } else if (token == 10) {
            casaToken((byte) 10);
            casaToken(Main.tabelaDeSimbolos.IDToken);
            casaToken((byte) 25);
            casaToken(Main.tabelaDeSimbolos.IDToken);
        } else if (token == Main.tabelaDeSimbolos.IDToken) {
            casaToken(Main.tabelaDeSimbolos.IDToken);
            casaToken((byte) 22);
            if (token == Main.tabelaDeSimbolos.CONSTToken) {
                casaToken(Main.tabelaDeSimbolos.CONSTToken);
            } else if (token == Main.tabelaDeSimbolos.IDToken) {
                casaToken(Main.tabelaDeSimbolos.IDToken);
            } else {
                erroSintatico();
            }
        } else if (token == 12) {
            casaToken((byte) 12);
            casaToken(Main.tabelaDeSimbolos.IDToken);
            casaToken((byte) 25);
            if (token == Main.tabelaDeSimbolos.CONSTToken) {
                casaToken(Main.tabelaDeSimbolos.CONSTToken);
            } else if (token == Main.tabelaDeSimbolos.IDToken) {
                casaToken(Main.tabelaDeSimbolos.IDToken);
            } else {
                erroSintatico();
            }
            casaToken((byte) 25);
            if (token == Main.tabelaDeSimbolos.CONSTToken) {
                casaToken(Main.tabelaDeSimbolos.CONSTToken);
            } else if (token == Main.tabelaDeSimbolos.IDToken) {
                casaToken(Main.tabelaDeSimbolos.IDToken);
            } else {
                erroSintatico();
            }
            casaToken((byte) 25);
            if (token == Main.tabelaDeSimbolos.CONSTToken) {
                casaToken(Main.tabelaDeSimbolos.CONSTToken);
            } else if (token == Main.tabelaDeSimbolos.IDToken) {
                casaToken(Main.tabelaDeSimbolos.IDToken);
            } else {
                erroSintatico();
            }
            casaToken((byte) 25);
            if (token == Main.tabelaDeSimbolos.CONSTToken) {
                casaToken(Main.tabelaDeSimbolos.CONSTToken);
            } else if (token == Main.tabelaDeSimbolos.IDToken) {
                casaToken(Main.tabelaDeSimbolos.IDToken);
            } else {
                erroSintatico();
            }
            casaToken((byte) 25);
            if (token == Main.tabelaDeSimbolos.CONSTToken) {
                casaToken(Main.tabelaDeSimbolos.CONSTToken);
            } else if (token == Main.tabelaDeSimbolos.IDToken) {
                casaToken(Main.tabelaDeSimbolos.IDToken);
            } else {
                erroSintatico();
            }
            casaToken((byte) 25);
            if (token == Main.tabelaDeSimbolos.CONSTToken) {
                casaToken(Main.tabelaDeSimbolos.CONSTToken);
            } else if (token == Main.tabelaDeSimbolos.IDToken) {
                casaToken(Main.tabelaDeSimbolos.IDToken);
            } else {
                erroSintatico();
            }
        } else if (token == 13) {//repeticao
            REPETICAO();
        } else if (token == 15) {//condicional se
            CONDICIONAL_SE();
        } else if (token == 11) {
            casaToken((byte) 11);
            if (token == Main.tabelaDeSimbolos.CONSTToken) {
                casaToken(Main.tabelaDeSimbolos.CONSTToken);
            } else if (token == Main.tabelaDeSimbolos.IDToken) {
                casaToken(Main.tabelaDeSimbolos.IDToken);
            } else {
                erroSintatico();
            }
        } else {
            erroSintatico();
        }
        casaToken(QUEBRA_DE_LINHA);
    }

    public void DPONTO() throws IOException {
        casaToken((byte) 23);
        if (token == 27) {
            casaToken((byte) 27);
        }
        casaToken(Main.tabelaDeSimbolos.CONSTToken);
        casaToken((byte) 25);
        if (token == 27) {
            casaToken((byte) 27);
        }
        casaToken(Main.tabelaDeSimbolos.CONSTToken);
        casaToken((byte) 25);
        if (token == 27) {
            casaToken((byte) 27);
        }
        casaToken(Main.tabelaDeSimbolos.CONSTToken);
        casaToken((byte) 24);
    }

    public void DCOR() throws IOException {
        casaToken((byte) 23);
        if (token == Main.tabelaDeSimbolos.CONSTToken) {
            casaToken(Main.tabelaDeSimbolos.CONSTToken);
        } else if (token == Main.tabelaDeSimbolos.IDToken) {
            casaToken(Main.tabelaDeSimbolos.IDToken);
        } else {
            erroSintatico();
        }
        casaToken((byte) 25);
        if (token == Main.tabelaDeSimbolos.CONSTToken) {
            casaToken(Main.tabelaDeSimbolos.CONSTToken);
        } else if (token == Main.tabelaDeSimbolos.IDToken) {
            casaToken(Main.tabelaDeSimbolos.IDToken);
        } else {
            erroSintatico();
        }
        casaToken((byte) 25);
        if (token == Main.tabelaDeSimbolos.CONSTToken) {
            casaToken(Main.tabelaDeSimbolos.CONSTToken);
        } else if (token == Main.tabelaDeSimbolos.IDToken) {
            casaToken(Main.tabelaDeSimbolos.IDToken);
        } else {
            erroSintatico();
        }
        casaToken((byte) 25);
        if (token == Main.tabelaDeSimbolos.CONSTToken) {
            casaToken(Main.tabelaDeSimbolos.CONSTToken);
        } else if (token == Main.tabelaDeSimbolos.IDToken) {
            casaToken(Main.tabelaDeSimbolos.IDToken);
        } else {
            erroSintatico();
        }
        casaToken((byte) 25);
        if (token == Main.tabelaDeSimbolos.CONSTToken) {
            casaToken(Main.tabelaDeSimbolos.CONSTToken);
        } else if (token == Main.tabelaDeSimbolos.IDToken) {
            casaToken(Main.tabelaDeSimbolos.IDToken);
        } else {
            erroSintatico();
        }
        casaToken((byte) 25);
        if (token == Main.tabelaDeSimbolos.CONSTToken) {
            casaToken(Main.tabelaDeSimbolos.CONSTToken);
        } else if (token == Main.tabelaDeSimbolos.IDToken) {
            casaToken(Main.tabelaDeSimbolos.IDToken);
        } else {
            erroSintatico();
        }
        casaToken((byte) 25);
        if (token == Main.tabelaDeSimbolos.CONSTToken) {
            casaToken(Main.tabelaDeSimbolos.CONSTToken);
        } else if (token == Main.tabelaDeSimbolos.IDToken) {
            casaToken(Main.tabelaDeSimbolos.IDToken);
        } else {
            erroSintatico();
        }
        casaToken((byte) 24);
    }

    public void DFACE() throws IOException {
        casaToken((byte) 23);
        casaToken(Main.tabelaDeSimbolos.IDToken);
        casaToken((byte) 25);
        casaToken(Main.tabelaDeSimbolos.IDToken);
        casaToken((byte) 25);
        casaToken(Main.tabelaDeSimbolos.IDToken);
        casaToken((byte) 25);
        casaToken(Main.tabelaDeSimbolos.IDToken);
        casaToken((byte) 25);
        casaToken(Main.tabelaDeSimbolos.IDToken);
        casaToken((byte) 24);
    }

    public void DLUZ() throws IOException {
        casaToken((byte) 23);
        if (token == 27) {
            casaToken((byte) 27);
        }
        casaToken(Main.tabelaDeSimbolos.CONSTToken);
        casaToken((byte) 25);
        if (token == 27) {
            casaToken((byte) 27);
        }
        casaToken(Main.tabelaDeSimbolos.CONSTToken);
        casaToken((byte) 25);
        if (token == 27) {
            casaToken((byte) 27);
        }
        casaToken(Main.tabelaDeSimbolos.CONSTToken);
        casaToken((byte) 24);
    }

    public void DOBJETO() throws IOException {
        casaToken(Main.tabelaDeSimbolos.IDToken);
        casaToken((byte) 25);
        casaToken(Main.tabelaDeSimbolos.IDToken);
        casaToken((byte) 25);
        casaToken(Main.tabelaDeSimbolos.IDToken);
        casaToken((byte) 25);
        casaToken(Main.tabelaDeSimbolos.IDToken);
        casaToken((byte) 25);
        casaToken(Main.tabelaDeSimbolos.IDToken);
        casaToken((byte) 25);
        casaToken(Main.tabelaDeSimbolos.IDToken);
    }

    public void DCONST() throws IOException {
        casaToken(Main.tabelaDeSimbolos.IDToken);
        casaToken((byte) 22);
        if (token == 27) {
            casaToken((byte) 27);
        }
        casaToken(Main.tabelaDeSimbolos.CONSTToken);//numerica -> ver o que fazer -> verificar se há apenas numeros?
    }

    public void DVAR() throws IOException {
        if (token == 8) {
            casaToken((byte) 8);
        } else if (token == 9) {
            casaToken((byte) 9);
        }
        casaToken(Main.tabelaDeSimbolos.CONSTToken);
        while ((token == 27)
                || (token == Main.tabelaDeSimbolos.CONSTToken)) {
            if (token == 27) {
                casaToken((byte) 27);
            }
            casaToken(Main.tabelaDeSimbolos.CONSTToken);
        }
    }

    public void EXPRESSAO_MATEMATICA() throws IOException {
        if (token == 27) {
            casaToken((byte) 27);
        }
        if (token == Main.tabelaDeSimbolos.IDToken) {
            casaToken(Main.tabelaDeSimbolos.IDToken);
        } else if (token == Main.tabelaDeSimbolos.CONSTToken) {
            casaToken(Main.tabelaDeSimbolos.CONSTToken);
        } else {
            erroSintatico();
        }
        while (token == 26
                || token == 27
                || token == 28
                || token == 34) {
            OPERADOR_MATEMATICO();
            if (token == Main.tabelaDeSimbolos.IDToken) {
                casaToken(Main.tabelaDeSimbolos.IDToken);
            } else if (token == Main.tabelaDeSimbolos.CONSTToken) {
                casaToken(Main.tabelaDeSimbolos.CONSTToken);
            } else {
                erroSintatico();
            }
        }
    }

    public void OPERADOR_MATEMATICO() throws IOException {
        if (token==26) {
            casaToken((byte) 26);
        } else if (token==27) {
            casaToken((byte) 27);
        } else if (token==28) {
            casaToken((byte) 28);
        } else if (token==34) {
            casaToken((byte) 34);
        } else {
            erroSintatico();
        }
    }
}
