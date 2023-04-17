package Ejecutable;

import EntradaSalida.Tools;
import MemoriaEstatica.PilaC;
import MemoriaEstatica.PilaD;
import estructuraslineales.PilaA;

public class oper {
	public static void main(String[] args) {
		operacionesPilaEstatica();
	}
public static void operacionesPilaEstatica() {
		
		//PilaA <Integer> pila = new PilaA((byte)10);
	//PilaC <Integer>pila=new PilaC();	
	PilaD<Integer>pila=new PilaD<Integer>();
	String op="";
		
		do {
			op=Tools.seleccionBoton("PUSH,POP,PEEK,FREE,SALIR");
			switch(op) {
			case "PUSH":
				pila.pushPila(Tools.leerInt("Escrube un dato entero"));
				Tools.imprimirMSJE("Datos de pila:\n"+pila.toString());
				break;
			case "POP":
				if (pila.isEmptyPila())Tools.imprimirErrorMSJE("Pila vacia");
				else
					Tools.imprimirMSJE("Dato eliminado de la cima de la pila:==>"+pila.popPila()+"\n"+pila.toString());
				break;
			case "PEEK":
				if(pila.isEmptyPila()) Tools.imprimirErrorMSJE("Pila vacia");
				else
					Tools.imprimirMSJE("Dato de la cima de la pila: ==>"+pila.peekPila()+"\n"+pila.toString());
				break;
			case "FREE":
				if (pila.isEmptyPila()) Tools.imprimirErrorMSJE("Pila vacia");
				else {
					pila.vaciar();
				}
				break;
			}
		}while(!op.equals("SALIR"));
		
	}
}
