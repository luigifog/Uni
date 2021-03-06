package sesion08.collections;

import java.util.Iterator;

/**
 * @author UO257275
 *
 */
public class LinkedList implements List {
	private Node head;
	private int numberOfElements;
	
	/* (non-Javadoc)
	 * @see sesion08.collections.Collection#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object o) {
		if(o==null){
			throw new RuntimeException("parametros incorrectos");
		}
		int pos=indexOf(o);
		{
			if(pos!=-1){
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see sesion08.collections.Collection#size()
	 */
	@Override
	public int size() {
		
		return numberOfElements;
	}

	/* (non-Javadoc)
	 * @see sesion08.collections.Collection#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		
		return size()==0;
	}

	/* añade el obj al final
	 * @see sesion08.collections.Collection#add(java.lang.Object)
	 * a�ade al principio
	 */
	@Override
	public void add(Object element) {
		if(element==null){
			throw new RuntimeException("Parametro incorrecto");
		}
		if(size()==0){
			head=new Node(element,null);
		}
		else{
			Node lastNode=getNode(size()-1);
			lastNode.next=new Node(element,null);
			}
		numberOfElements++;
		}
	

	/* (non-Javadoc)
	 * @see sesion08.collections.Collection#remove(java.lang.Object)
	 */
	@Override
	public Object remove(Object element) {
		if(element==null){
			throw new RuntimeException("parametros incorrectos");
		}
		int posicion=indexOf(element);
		if(posicion>-1){
			remove(posicion);
			return element;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see sesion08.collections.Collection#clear()
	 */
	@Override
	public void clear() {
		head=null;

	}

	/* (non-Javadoc)
	 * @see sesion08.collections.List#add(int, java.lang.Object)
	 */
	@Override
	public void add(int index, Object element) {
		if(index<0){
			throw new RuntimeException("parametros incorrectos");
		}
		if(element==null){
			throw new RuntimeException("parametros incorrectos");
		}
		if(numberOfElements==0){
			head=new Node(element,null);
			numberOfElements++;
		}
		else {
			Node previous = getNode(index-1);
			previous.next = new Node(element, previous.next);
			numberOfElements++;}
	}

	/* (non-Javadoc)
	 * @see sesion08.collections.List#remove(int)
	 */
	@Override
	public Object remove(int index) {
		if(index<0 || index>numberOfElements){
			throw new RuntimeException("parametros incorrectos");
		}
		if(isEmpty()) return null;
		Object value;
		if(index==0){
			value=head.element;
			head=head.next;
		}
		else{
			Node previous = getNode(index - 1);
			value = previous.next.element;
			previous.next = previous.next.next;
			}
			numberOfElements--;
			return value; 
		}

	/* (non-Javadoc)
	 * @see sesion08.collections.List#indexOf(java.lang.Object)
	 */
	@Override
	public int indexOf(Object o) {
		if(o==null){
			throw new RuntimeException("parametros incorrectos");
		}
		Node nodeToFind=head;
		for (int i = 0; i < size(); i++) {
			if(nodeToFind.element.equals(o)){
				return i;
			}
			else{
				nodeToFind=nodeToFind.next;
			}
		}
		return -1;
	}
	public Node getNode(int index) {
		if(index<0 || index >numberOfElements){
			throw new RuntimeException("parametros incorrectos");
		}
		int position = 0;
		Node node = head;
		if(index>=0){
		while (position < index) {
		node = node.next;
		position++;
		}
		}
		return node;
	}
	/* (non-Javadoc)
	 * @see sesion08.collections.List#get(int)
	 */
	@Override                                    
	public Object get(int index) {
		if(index<0 || index>numberOfElements){
			throw  new RuntimeException("parametros incorrectos");
		}
		return getNode(index).element;

	}

	/* (non-Javadoc)
	 * @see sesion08.collections.List#set(int, java.lang.Object)
	 */
	@Override
	public Object set(int index, Object element) {
		if(index<0 || index>numberOfElements){
			throw new RuntimeException("parametros incorrectos");
		}
		if(element==null){
			throw new RuntimeException("parametros incorrectos");
		}
		return getNode(index).element = element;
	}
	@Override
	public String toString(){
		String cad="";
	
		for (int i = 0; i < size(); i++) {
			cad+=get(i)+",";
		}
		return cad;
	}

	@Override
	public Iterator<Object> iterator() {
		return new IteradorLinkedList(this);
	}
}
	
