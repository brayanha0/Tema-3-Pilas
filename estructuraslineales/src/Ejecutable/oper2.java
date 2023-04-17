package Ejecutable;

import java.util.Stack;

import EntradaSalida.Tools;
import estructuraslineales.PilaA;

public class oper2 {
	public static void main(String[] args) {
		Stack <Integer> pila = new Stack();
		int dato;
		String op=" ";
		do {
			op=Tools.seleccionBoton("PUSH,POP,PEEK,FREE,SALIR");
			switch(op) {
			case "PUSH":
				dato=(Tools.leerInt("Escrube un dato entero"));
				pila.push(dato);
				Tools.imprimirMSJE("Datos de pila:\n"+pila);
				break;
			case "POP":
				if (pila.isEmpty())Tools.imprimirErrorMSJE("Pila vacia");
				else
					Tools.imprimirMSJE("Dato eliminado de la cima de la pila:==>"+pila.pop()+"\n"+pila.toString());
				break;
			case "PEEK":
				if(pila.isEmpty()) Tools.imprimirErrorMSJE("Pila vacia");
				else
					Tools.imprimirMSJE("Dato de la cima de la pila: ==>"+pila.peek()+"\n"+pila.toString());
				break;
			case "FREE":
				if (pila.isEmpty()) Tools.imprimirErrorMSJE("Pila vacia");
				else {
					pila=null;
					pila= new Stack();
				}
				break;
			}
		}while(!op.equals("SALIR"));
		
	}
}

