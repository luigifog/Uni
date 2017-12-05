package p3arboles;

/** 
* @author Néstor 
* @version 2017-18 
*/ 
public class BSTree <T extends Comparable<T>>{ 
 
 
private BSTNode<T> raiz; 
 
 
/** 
* @param node 
* El objeto comparable que tiene que insertar 
* 
* @return verdadero cuando lo inserta, falso cuando no lo hace (ya existía u otra causa) 
*/ 
public boolean addNode(T node) {
	if(raiz==null)
	{
		BSTNode nuevo=new BSTNode(node);
		raiz=nuevo;
		raiz.setInfo(node);
		
	}
	else if(raiz.getInfo().compareTo(node)<0)
	{
		cambiarRaizIzq(raiz, node);
	}
	else if(raiz.getInfo().compareTo(node)>0)
		{
			cambiarRaizDrcha(raiz, node);
		}
	return true;
} 

private void cambiarRaizIzq(BSTNode<T> raiz,T node)
{
		BSTNode<T> posibleIzq=raiz.getLeft();
		if(posibleIzq!=null)
		{
			raiz=posibleIzq;
			if(raiz.getInfo().compareTo(node)<0)
			{
				cambiarRaizIzq(raiz,node);
				
			}
			
		}
		else
			raiz.setLeft(posibleIzq);
	
}

private void cambiarRaizDrcha(BSTNode<T> raiz,T node)
{

		BSTNode<T> posibleDrc=raiz.getRight();
		if(posibleDrc!=null)
		{
			raiz=posibleDrc;
			if(posibleDrc.getInfo().compareTo(node)>0)
			{
				cambiarRaizDrcha(raiz,node);
			}
			else
				raiz.setRight(posibleDrc);
		}	
}
///** 
//* @param node 
//* El objeto comparable que se busca 
//* @return El objeto que se busca (completo) si lo encuentra. (null) si no 
//* lo encuentra 
//*/ 
//public T searchNode(T node) {
//	if(raiz==null)
//	{
//		return null;
//	}
//	else if(raiz.getInfo().compareTo(node)<0)
//	{
//		
//	}
//} 
///** 
//* Muestra por pantalla el recorrido en pre-orden (izquierda-derecha) y lo devuelve en un String (separados por tabuladores) 
//*/ 
//public String preOrder() {...} 
///** 
//* Muestra por pantalla el recorrido en post-orden (izquierda-derecha) y lo devuelve en un String (separados por tabuladores) 
//*/ 
//public String postOrder() {...} 
///** 
//* Muestra por pantalla el recorrido en in-orden (izquierda-derecha) y lo devuelve en un String (separados por tabuladores) 
//*/ 
//public String inOrder() {...} 
///** 
//* @param node El objeto que se quiere borrar 
//* @return true si lo ha borrado, false en caso contrario (no existía) 
//*/ 
//public boolean removeNode (T node){...} 
// 
// 
// 
// 
public String toString() { 
return tumbarArbol(raiz, 0); 
} 
 
 
 
/** 
* Genera un String con el árbol "tumbado" (la raíz a la izquierda y las ramas hacia la derecha) 
* Es un recorrido InOrden-derecha-izquierda, tabulando para mostrar los distintos niveles 
* Utiliza el toString de la información almacenada 
*   
* @param p La raíz del árbol a mostrar tumbado 
* @param esp El espaciado en número de tabulaciones para indicar la profundidad 
* @return El String generado 
*/ 
protected String tumbarArbol(BSTNode<T> p, int esp) { 
StringBuilder cadena = new StringBuilder(); 
 
 
if (p != null) { 
cadena.append(tumbarArbol(p.getRight(), esp + 1)); 
for (int i = 0; i < esp; i++) 
cadena.append("\t"); 
cadena.append(p + "\n"); 
cadena.append(tumbarArbol(p.getLeft(), esp + 1)); 
} 
return cadena.toString(); 
} 
 
 
} 