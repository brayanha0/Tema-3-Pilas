package estructuraslineales;

public interface pilaTDA <T>{
	public boolean isEmptyPila();//regresa true si la pila esta VACIA
	public void pushPila(T dato);//inserta el dato en el tope de la apila
	public T popPila();//elimina el elemento que esta en el tope de la pila
	public T peekPila();//regresa el elemento que esta en el tope, sin quitarlo

}
