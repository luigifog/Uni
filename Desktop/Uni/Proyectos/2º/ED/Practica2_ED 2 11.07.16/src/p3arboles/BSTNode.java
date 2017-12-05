package p3arboles;


/** 
* @author N�stor 
* @version 2017-18 
*/ 
public class BSTNode <T extends Comparable<T>>{ 
private T info; 
private BSTNode<T> left; 
private BSTNode<T> right; 


/** 
* @param info Un objeto comparable 
*/ 
public BSTNode (T info) {} 
/** 
* @param info La informaci�n que se quiere meter en el nodo 
*/ 
protected void setInfo(T info) {
	this.info=info;
} 



/** 
* @return La informaci�n que almacena el nodo 
*/ 
public T getInfo() {
	return info;
} 
/** 
* @param x El nodo que se quiere enlazar en el sub�rbol izquierdo 
*/ 
protected void setLeft(BSTNode<T> x){
	left=x;
} 


/** 
* @param x El nodo que se quiere enlazar en el sub�rbol derecho 
*/ 
protected void setRight(BSTNode<T> x) {
	right=x;
} 
/** 
* @return El sub�rbol izquierdo 
*/ 
protected BSTNode<T> getLeft () {
	return left;
} 


/** 
* @return El sub�rbol derecho 
*/ 
protected BSTNode<T> getRight () {
return right;} 


/* (non-Javadoc) 
* @see java.lang.Object#toString() 
*/ 
public String toString() { 
return info.toString(); 
}  
} 