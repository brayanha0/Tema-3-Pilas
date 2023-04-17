package Ejemplos;
import java.util.Stack;
import javax.swing.JOptionPane;

public class ConversionInfijaPosfija {
    public static void main(String[] args) {
        String infija = JOptionPane.showInputDialog(null, "Ingrese una expresión infija:");
        String posfija = "";
        Stack<Character> pila = new Stack<Character>();
        int longitud = infija.length();
        for (int i = 0; i < longitud; i++) {
            char caracter = infija.charAt(i);
            if (caracter == '(') {
                pila.push(caracter);
            } else if (Character.isLetterOrDigit(caracter)) {
                posfija += caracter;
            } else if (caracter == ')') {
                while (!pila.empty() && pila.peek() != '(') {
                    posfija += pila.pop();
                }
                if (!pila.empty()) {
                    pila.pop();
                }
            } else {
                while (!pila.empty() && obtenerPrecedencia(pila.peek()) >= obtenerPrecedencia(caracter)) {
                    posfija += pila.pop();
                }
                pila.push(caracter);
            }
        }
        while (!pila.empty()) {
            posfija += pila.pop();
        }
        JOptionPane.showMessageDialog(null, "Expresión infija: " + infija + "\nExpresión posfija: " + posfija);
    }

    public static int obtenerPrecedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}

