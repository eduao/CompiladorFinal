/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compila;

/**
 *
 * @author Augusto & Eduardo & Kassia
 */
public class AnaliseLexica {
    
    
    char nextChar(char[] s, int posicao){
        posicao++;
        if (posicao < s.length)
            return s[posicao];
        return '\n';
    }
    
    // @TODO Precisa criar o que Pode ser representado nos tokens
    Token verificaString(char[] string) {
        boolean continueAnalysing = true;
        int pos = -1;
        char estado = 0;
        while (continueAnalysing) {
            switch (estado) {
                case 0:
                    char c = nextChar(string, pos);
                    if (isDelimitator(c)) {
                        estado = 0;
                    } else if (isLetter(c)) {
                        estado = 1;
                    } else if (c == '=') {
                        estado = 3;
                    } else if (c == '(') {
                        estado = 5;
                    } else if (c == ')') {
                        estado = 7;
                    } else if (c == '+') {
                        estado = 9;
                    } else if (c == '-') {
                        estado = 10;
                    } else if (c == '*') {
                        estado = 11;
                    } else if (c == '/') {
                        estado = 12;
                    } else if (c == '<') {
                        estado = 13;
                    } else if (c == '>') {
                        estado = 17;
                    } else if (isDigit(c)) {
                        estado = 20;
                    } else if (isEOF(c)) {
                        estado = 24;
                    } else {
                        falhar();
                    }
                    break;

                case 1:
                    c = nextChar(string, pos);
                    if (isDigit(c) || isLetter(c)) {
                        estado = 1;
                    } else {
                        estado = 2;
                    }
                    break;

                case 2:// aceitacao
                    // retorna um ID
                    break;

                case 3:
                    c = nextChar(string, pos);
                    if (c == '=') {
                        estado = 4;
                    } else {
                        estado = 25;
                    }
                    break;

                case 4:// aceitacao
                    // retorna um operador relacional
                    estado = 0;
                    break;

                case 5:
                    c = nextChar(string, pos);
                    estado = 6;
                    break;

                case 6:// aceitacao
                    // retorna um caractere especial
                    estado = 0;
                    break;

                case 7:
                    c = nextChar(string, pos);
                    estado = 8;
                    break;

                case 8:// aceitacao
                    // retorna um caractere especial
                    estado = 0;
                    break;

                case 9:// aceitacao
                    // retorna um operador aritimetico
                    estado = 0;
                    break;

                case 10:// aceitacao
                    // retorna um operador aritimetico
                    estado = 0;
                    break;

                case 11:// aceitacao
                    // retorna um operador aritimetico
                    estado = 0;
                    break;

                case 12:// aceitacao
                    // retorna um operador aritimetico
                    estado = 0;
                    break;

                case 13:
                    c = nextChar(string, pos);
                    if (c == '=') {
                        estado = 14;
                    } else if (c == '>') {
                        estado = 15;
                    } else {
                        estado = 16;
                    }
                    break;

                case 14:// aceitacao
                    // retorna um operador relacional
                    estado = 0;
                    break;

                case 15:// aceitacao
                    // retorna um operador relacional
                    estado = 0;
                    break;

                case 16:// aceitacao
                    // retorna um operador relacional
                    estado = 0;
                    break;

                case 17:
                    c = nextChar(string, pos);
                    if (c == '=') {
                        estado = 19;
                    } else {
                        estado = 18;
                    }
                    break;

                case 18:// aceitacao
                    // retorna um operador relacional
                    estado = 0;
                    break;

                case 19:// aceitacao
                    // retorna um operador relacional
                    estado = 0;
                    break;

                case 20:
                    c = nextChar(string, pos);
                    if (isDigit(c)) {
                        estado = 20;
                    } else if (c == '.') {
                        estado = 21;
                    } else {
                        estado = 23;
                    }
                    break;

                case 21:
                    Main.tabela.put(new Lexema(),new Token());
                    c = nextChar(string, pos);
                    if (isDigit(c)) {
                        estado = 21;
                    } else {
                        estado = 22;
                    }
                    break;

                case 22:// aceitacao
                    // retorna um numero
                    estado = 0;
                    break;

                case 23:// aceitacao
                    // retorna um numero
                    estado = 0;
                    break;

                case 24:// aceitacao
                    // retorna fim de arquivo
                    System.out.println("fim de arquivo");
                    continueAnalysing = false;
                    break;

                case 25:
                    c = nextChar(string, pos);
                    // retorna um operador de atribuicao
                    estado = 0;
                    break;

                default:
                    break;
            }
        }
        return new Token();
    }
    
    public boolean isDelimitator(char c) {
		if (c == ' ' || c == '\t' || c == '\n') {
			return true;
		} else {
			return false;
		}
	}

	public boolean isLetter(char c) {
		if ((c > 'a' && c < 'z') || (c > 'A' && c < 'Z'))
			return true;
		else
			return false;
	}

	public boolean isDigit(char c) {
		if ((c > '0' && c < '9'))
			return true;
		else
			return false;
	}

	public void falhar() {
		System.out.println("Erro Léxico!");
	}

	public boolean isEOF(char c) {
		if (c == (char)-1){
			return true;
		}else{
			return false;
		}
	}

    
}
