package MemoriaEstatica;

import estructuraslineales.pilaTDA;

public class PilaD<T> implements pilaTDA<T> {
	private Nodo pila;
	public PilaD() {
		pila =null;
		
	}
	public boolean isEmptyPila() {
		return (pila==null);
	}
	public void vaciar()
	{
		pila=null;
	}
	public T peekPila() {
		@SuppressWarnings("unchecked")
		T info = (T) pila.getInfo();
		return info;
	}
	public void pushPila(T dato) {
		Nodo<T> tope=new Nodo<T>(dato);
		if(isEmptyPila())pila=tope;
		else {
			tope.sig=pila;
			pila=tope;
		}
	}
	public T popPila() {
		Nodo<T> tope=pila;
		T dato=(T) pila.getInfo();
		pila=pila.getSig();
		tope=null;
		return dato;
	}
	public String toString() {
		Nodo tope=pila;
		return toString(tope);
	}
	private String toString (Nodo i) {
	return (i!=null)?"tope ===>"+"["+i.getInfo()+"]\n"+ toString(i.getSig()):"";
	}
	
	
	
	

}
