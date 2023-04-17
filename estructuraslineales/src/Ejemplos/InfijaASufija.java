package Ejemplos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class InfijaASufija {

    public static String infijaASufija(String expresionInfija) {
        Map<String, Integer> precedencia = new HashMap<>();
        precedencia.put("*", 3);
        precedencia.put("/", 3);
        precedencia.put("+", 2);
        precedencia.put("-", 2);
        precedencia.put("(", 1);
        Stack<String> pilaOperadores = new Stack<>();
        List<String> listaSufija = new ArrayList<>();
        String[] listaSimbolos = expresionInfija.split(" ");

        for (String simbolo : listaSimbolos) {
            if (simbolo.matches("[A-Z0-9]+")) {
                listaSufija.add(simbolo);
            } else if (simbolo.equals("(")) {
                pilaOperadores.push(simbolo);
            } else if (simbolo.equals(")")) {
                String simboloTope = pilaOperadores.pop();
                while (!simboloTope.equals("(")) {
                    listaSufija.add(simboloTope);
                    simboloTope = pilaOperadores.pop();
                }
            } else {
                while (!pilaOperadores.empty() && precedencia.get(pilaOperadores.peek()) >= precedencia.get(simbolo)) {
                    listaSufija.add(pilaOperadores.pop());
                }
                pilaOperadores.push(simbolo);
            }
        }

        while (!pilaOperadores.empty()) {
            listaSufija.add(pilaOperadores.pop());
        }

        return String.join(" ", listaSufija);
    }

    public static void main(String[] args) {
        System.out.println(infijaASufija("A * B + C * D"));
        System.out.println(infijaASufija("( A + B ) * C - ( D - E ) * ( F + G )"));
    }
}