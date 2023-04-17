package MemoriaEstatica;


import java.util.ArrayList;

import estructuraslineales.pilaTDA;



public class PilaC<T> implements pilaTDA<T> {
	private ArrayList pila;
	int tope;
	
	public PilaC() {
		pila=new ArrayList();
		tope=-1;
	}
	
public int Siza() {
	return pila.size();
}
@Override
public boolean  isEmptyPila()
{
	return pila.isEmpty();
}
@Override
public void pushPila(Object dato) {
	pila.add(dato);
	tope++;
}
@Override
public T popPila() {
	T dato=(T)pila.get(tope);
	tope--;
	return dato;
}
@Override
public T peekPila() {
	return (T)pila.get(tope);
}
@Override
public String toString() {
	return toString(tope);}
private String toString(int i) {
	return (i>=0)?"tope==>"+"["+pila.get(i)+"]\n"+toString(i-1):"";
}

}

