package Ejemplos;

import java.util.*;

public class EvaluacionNotacionSufija {

    public static int evaluacionNotacionSufija(String expresionSufija) {
        // Crea una pila para almacenar los operandos
        Stack<Integer> pilaOperandos = new Stack<>();
        // Divide la expresi�n en notaci�n sufija en una lista de s�mbolos utilizando un espacio como separador
        String[] listaSimbolos = expresionSufija.split(" ");

        // Itera sobre la lista de s�mbolos
        for (String simbolo : listaSimbolos) {
            // Verifica si el s�mbolo es un operando (n�mero)
            if (simbolo.matches("[0-9]+")) {
                // Si es un operando, convi�rtelo a un entero y agr�galo a la pila de operandos
                pilaOperandos.push(Integer.parseInt(simbolo));
            } else {
                // Si es un operador, saca los dos �ltimos operandos de la pila y aplica la operaci�n correspondiente
                int operando2 = pilaOperandos.pop();
                int operando1 = pilaOperandos.pop();
                int resultado = hacerAritmetica(simbolo, operando1, operando2);
                // Agrega el resultado a la pila de operandos
                pilaOperandos.push(resultado);
            }
        }

        // El resultado final se encuentra en la cima de la pila de operandos, s�calo y devu�lvelo
        return pilaOperandos.pop();
    }

    public static int hacerAritmetica(String operador, int operandoIzquierda, int operandoDerecha) {
        // Determina qu� operaci�n realizar en base al operador recibido y devuelve el resultado
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
        // Llama al m�todo evaluacionNotacionSufija con una expresi�n en notaci�n sufija y muestra el resultado en la salida est�ndar
        System.out.println(evaluacionNotacionSufija("(A*B)C/(E*F)"));
    }
}
