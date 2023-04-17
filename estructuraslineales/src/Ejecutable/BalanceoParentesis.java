package Ejecutable;

import javax.swing.JOptionPane;
import java.util.Stack;

public class BalanceoParentesis {

    public static void main(String[] args) {
        String expresion = JOptionPane.showInputDialog(null, "Ingrese expresi�n:");
        boolean balanceado = esBalanceado(expresion);
        if (balanceado) {
            JOptionPane.showMessageDialog(null, "Par�ntesis balanceados.");
        } else {
            JOptionPane.showMessageDialog(null, "No tiene par�ntesis balanceados.");
        }
    }

    public static boolean esBalanceado(String expresion) {
        Stack<Character> pila = new Stack<Character>();
        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);
            if (caracter == '(') {
                pila.push(caracter);
            } else if (caracter == ')') {
                if (!pila.isEmpty() && pila.peek() == '(') {
                    pila.pop();
                } else {
                    return false;
                }
            }
        }
        return pila.isEmpty();
    }

}
