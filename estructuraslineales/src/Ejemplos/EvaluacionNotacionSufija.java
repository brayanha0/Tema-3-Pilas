package Ejemplos;

import java.util.*;

public class EvaluacionNotacionSufija {

    public static int evaluacionNotacionSufija(String expresionSufija) {
        // Crea una pila para almacenar los operandos
        Stack<Integer> pilaOperandos = new Stack<>();
        // Divide la expresión en notación sufija en una lista de símbolos utilizando un espacio como separador
        String[] listaSimbolos = expresionSufija.split(" ");

        // Itera sobre la lista de símbolos
        for (String simbolo : listaSimbolos) {
            // Verifica si el símbolo es un operando (número)
            if (simbolo.matches("[0-9]+")) {
                // Si es un operando, conviértelo a un entero y agrégalo a la pila de operandos
                pilaOperandos.push(Integer.parseInt(simbolo));
            } else {
                // Si es un operador, saca los dos últimos operandos de la pila y aplica la operación correspondiente
                int operando2 = pilaOperandos.pop();
                int operando1 = pilaOperandos.pop();
                int resultado = hacerAritmetica(simbolo, operando1, operando2);
                // Agrega el resultado a la pila de operandos
                pilaOperandos.push(resultado);
            }
        }

        // El resultado final se encuentra en la cima de la pila de operandos, sácalo y devuélvelo
        return pilaOperandos.pop();
    }

    public static int hacerAritmetica(String operador, int operandoIzquierda, int operandoDerecha) {
        // Determina qué operación realizar en base al operador recibido y devuelve el resultado
        if (operador.equals("*")) {
            return operandoIzquierda * operandoDerecha;
        } else if (operador.equals("/")) {
            return operandoIzquierda / operandoDerecha;
        } else if (operador.equals("+")) {
            return operandoIzquierda + operandoDerecha;
        } else {
            return operandoIzquierda - operandoDerecha;
        }
    }

    public static void main(String[] args) {
        // Llama al método evaluacionNotacionSufija con una expresión en notación sufija y muestra el resultado en la salida estándar
        System.out.println(evaluacionNotacionSufija("(A*B)C/(E*F)"));
    }
}
