 package p2Grafos;

import java.text.DecimalFormat;

/**
 * @author Nestor
 * 
 */
public class Graph <T>{
	private T[] nodes; // Vector de nodos
	private boolean[][] edges; // matriz de aristas
	private double[][] weights; // matriz de pesos
	private int numNodes=0; // n�mero de elementos en un momento dado
	
	
	public Graph (int tam, T initialNodes[], boolean[][] initialEdges, double [][] initialWeights, double [][] initialAfloyd, int [][] initialPfloyd) {
		this(tam); 
		
		numNodes = initialNodes.length;
		
		for (int i=0;i<numNodes;i++) {
			nodes[i]=initialNodes[i];
			for (int j=0;j<numNodes;j++){
				edges[i][j]=initialEdges[i][j];
				weights[i][j]=initialWeights[i][j];
			}
		}
//		if (initialAfloyd!=null){
//			// Si la matriz A de floyd se llama de otra forma (distinto de "aFloyd"), cambiad el nombre en la linea de abajo
//			aFloyd=initialAfloyd;
//			// Si la matriz P de floyd se llama de otra forma (distinto de "pFloyd"), cambiad el nombre en la linea de abajo
//			pFloyd=initialPfloyd;
//		}

	}
	
	/**
	 * 
	 * @param tam  N�mero m�ximo de nodos del grafo
	 */
	@SuppressWarnings("unchecked")
public Graph(int tam) {
		nodes = (T[])new Object[tam];
		edges=new boolean [tam][tam];
		weights=new double[tam][tam];
		
	}

	/**
	 * Inserta un nuevo nodo que se le pasa como par�metro, en el vector de
	 * nodos, (si existe no lo inserta pero lo implementaremos m�s adelante�)
	 * 
	 * @param node
	 *            el nodo que se quiere insertar
	 * @return 0 si lo inserta, -1 si no puede insertarlo
	 */
	public int addNode(T node) {  
		if(nodes.length<=numNodes||existNode(node))
			return -1;
		else
		{
			nodes[numNodes]= node;
			++numNodes;
			return 0;
			}
	}

	/**
	 * Devuelve un String con la informaci�n del grafo
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		String cadena = "";

		cadena += "VECTOR NODOS\n";
		for (int i = 0; i < numNodes; i++) {
			cadena += nodes[i].toString() + "\t";
		}
		cadena += "\n\nMATRIZ ARISTAS\n";
		for (int i = 0; i < numNodes; i++) {
			for (int j = 0; j < numNodes; j++) {
				if (edges[i][j])
					cadena += "T\t";
				else
					cadena += "F\t";
			}
			cadena += "\n";
		}
		cadena += "\nMATRIZ PESOS\n";
		for (int i = 0; i < numNodes; i++) {
			for (int j = 0; j < numNodes; j++) {
				cadena += df.format(weights[i][j]) + "\t";
			}
			cadena += "\n";
		}


		return cadena;
	}
	
	/**
	 * Inserta una arista con el peso indicado (> 0) entre dos nodos, uno origen y
	 * otro destino. 
	 * Devuelve 0 si la inserta y -1 si no lo hace (si existe no la inserta)
	 * 
	 * @param source
	 *            nodo origen
	 * @param target
	 *            nodo destino
	 * @param edgeWeight
	 *            peso de la arista, debe ser > 0
	 * @return 0 si lo hace y -1 si no lo hace (tambi�n si el peso es <= 0)
	 */
	public int addEdge(T source, T target, double edgeWeight) {
		if(existEdge(source, target)||edgeWeight<=0||!existNode(source)||!existNode(target))
		{
			return -1;
		}
		else
		{
			edges[getNode( source)][getNode(target)]=true;
			weights[(int) source][(int) target]=edgeWeight;
			return 0;
		}
	}


	/**
	 * Obtiene el �ndice de un nodo en el vector de nodos
	 *
	 * ��� OJO que es privado porque depende de la implementaci�n !!!
	 * 
	 * @param node
	 *            el nodo que se busca
	 * @return la posici�n del nodo en el vector � -1 si no lo encuentra
	 */
	private int getNode(T node) { 
		for(int i=0;i<numNodes;i++)
		{
			if(node.equals(nodes[i]))
				return i;
		}
		return -1;
	}


	/**
	 * Borra el nodo deseado del vector de nodos as� como las aristas de las que
	 * forma parte
	 * 
	 * @param node
	 *            que se quiere borrar
	 * @return 0 si lo borra o -1 si no lo hace
	 */
	public int removeNode(T node) { 
		if(existNode(node))
		{
			if(getNode(node)<numNodes-1)
			{
				for(int i=getNode(node);i<numNodes-1;i++)
				{
					for(int j=getNode(node);j<numNodes-1;j++)
					{
					nodes[i]=nodes[i+1];
					edges[i][j]=edges[i+1][j+1];
					weights[i][j]=weights[i+1][j+1];
					numNodes--;
					}
				}
				return 0;
				
			}
			if(getNode(node)<numNodes)
			{
				numNodes--;
				return 0;
			}
		}
		
		return -1;
	}

	
	/**
	 * Borra una arista del grafo que conecta dos nodos
	 * 
	 * @param source 
	 *		nodo origen
	 * @param target
	 *		nodo destino
	 * @return 0 si la borra y -1 si no lo hace (tambi�n si no existe alguno de sus nodos)
	 */
	public int removeEdge(T source, T target) { 
		if(existEdge(source, target))
		{
				edges[getNode(source)][getNode(target)]=false;
				weights[getNode(source)][getNode(target)]=0;
				return 0;
		}
		return -1;
	}



	/**
	 * @param node  Nodo que se quiere consultar
	 * @return si existe o no el nodo
	 */
	public boolean existNode(T node) {
		if(getNode(node)!=-1)
			return true;
		
		return false;
	}

	/**
	 * Comprueba si existe una arista entre dos nodos que se pasan como par�metro
	 * 
	 * @param source
	 *            nodo origen
	 * @param target
	 *            nodo destino
	 * @return verdadero o falso si existe o no, si alguno de los nodos no
	 *         existe tambi�n falso
	 */
	public boolean existEdge(T source, T target) { 
		if(existNode(source) && existNode(target)&& edges[getNode(source)][getNode(target)]==true)
		{
				return true;
		}
		return false;
	}
	


	/**
	 * Devuelve el peso de la arista que conecta dos nodos, si no existe la
	 * arista, devuelve -1 (tambi�n si no existe alguno de los nodos)
	 * 
	 * @param source
	 * @param target
	 * @return El peso de la arista o -1 si no existe
	 */
	public double getEdge(T source, T target) {
		if(existEdge(source,target))
		{
			return weights[getNode(source)][getNode(target)];
		}
		return -1;
	}
	/**
	 * para hacer pruebas y comprobar que se me disminuye numNodes
	 * 
	 * @return numNodes
	 */
	public int devuelveNumNodes()
	{
		return numNodes;
	}
	
	/** 
	*  Algoritmo de Dijkstra para encontrar el camino de coste m�nimo desde nodoOrigen  
	*  hasta el resto de nodos 
	*   
	* @param nodoOrigen 
	* @return vector D de dijkstra para comprobar funcionamiento 
	*/ 
	public double[] dijkstra(T nodoOrigen) { 
		if(!existNode(nodoOrigen))
		{
			double[]er= {-1};
			return er;
		}
		boolean[] vecS=new boolean[numNodes];
		double [] vecD=new double[numNodes];
		double [] vecP=new double[numNodes];
		int indiceOrigen = getNode(nodoOrigen);
	
		for(int i=0;i<numNodes;i++)
		{
			if(indiceOrigen == i)
			{
				vecD[i]=0;
				vecP[i]=i;
				vecS[i]=true;
			}
			else if(edges[indiceOrigen][i]) {
				vecD[i]=weights[indiceOrigen][i];
				vecP[i]=indiceOrigen;
				vecS[i]=false;
			}
			else
			{
				vecD[i]=-1;
				vecP[i]=-1;
				vecS[i]=false;
			}
		}
		
		int siguienteNodo;
		while ((siguienteNodo = minCost(vecD, vecS)) != -1) {
			corregirCamino(siguienteNodo, vecD, vecS, vecP);
		}
		
			return vecD;
	} 
	
	/** 
	* Busca el nodo con distancia m�nima en D al resto de nodos 
	* @param dist  vector d 
	* @param v   vector con visitados (conjunto S) 
	* @return �ndice del nodo buscado o -1 si el grafo es no conexo o no quedan nodos sin visitar 
	*/ 
	private int minCost(double[] dist, boolean[] v) {
		
		double minimo = -1;
		int indiceMinimo = -1;
		
		for (int i = 0; i < numNodes; i++) {
			if (!v[i] && dist[i] != -1 && (minimo == -1 || minimo > dist[i])) {
				minimo = dist[i];
				indiceMinimo = i;
			}
		}
		
		return indiceMinimo;
		
		
	}
	
	private void corregirCamino(int indiceMedio,double[]d,boolean[]v,double[]p)
	{
		double posibleCoste;
		final double INFINITO = -1;
		v[indiceMedio]=true;
		for (int i = 0; i < numNodes; i++) {
			
			if(!v[i] && edges[indiceMedio][i])
			{
				posibleCoste=(weights[indiceMedio][i]+d[indiceMedio]);
				if(d[i]!=INFINITO)
				{
					
					if(posibleCoste<d[i])
					{
						d[i]=posibleCoste;
						p[i]=indiceMedio;
					}
				}
				else
				{
					d[i]=posibleCoste;
					p[i]=indiceMedio;
				}
			}
		}
		
		
	}
}

