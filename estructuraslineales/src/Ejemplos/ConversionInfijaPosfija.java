package Ejemplos;

import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConversionInfijaPosfija {
    public static void main(String[] args) {
        String infija = JOptionPane.showInputDialog(null, "Ingrese una expresión infija:");
        String posfija = "";
        Stack<Character> pila = new Stack<Character>();
        int longitud = infija.length();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Carácter");
        modelo.addColumn("Estado actual de la pila");
        modelo.addColumn("Expresión posfija");
        for (int i = 0; i < longitud; i++) {
            char caracter = infija.charAt(i);
            String estadoPila = "";
            for (Character c : pila) {
                estadoPila += c;
            }
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
            modelo.addRow(new Object[] {caracter, estadoPila, posfija});
        }
        while (!pila.empty()) {
            posfija += pila.pop();
        }
        modelo.addRow(new Object[] {"", "", posfija});
        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        JOptionPane.showMessageDialog(null, scroll, "Estados de la pila", JOptionPane.PLAIN_MESSAGE);
    }

    public static int obtenerPrecedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}


