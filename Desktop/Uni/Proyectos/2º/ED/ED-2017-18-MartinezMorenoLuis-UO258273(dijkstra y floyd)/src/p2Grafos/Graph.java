 package p2Grafos;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * @author Nestor
 * 
 */
public class Graph <T>{
	private T[] nodes; // Vector de nodos
	private boolean[][] edges; // matriz de aristas
	private double[][] weights; // matriz de pesos
	private double [][] aFloyd;
	private int [][] pFloyd;
	private int numNodes=0; // n�mero de elementos en un momento dado
	
	
	public Graph (int tam, T initialNodes[], boolean[][] initialEdges, double [][] initialWeights, double [][] initialAfloyd, int [][] initialPfloyd) {
		if(tam>=0)
		{
			numNodes = initialNodes.length;
			nodes=(T[]) new Object[tam];
			edges=new boolean [tam][tam];
			weights=new double[tam][tam];

				aFloyd=new double [tam][tam];

				pFloyd=new int[tam][tam];
			
		}
		
		for (int i=0;i<numNodes;i++) {
			
			nodes[i]=initialNodes[i];
			for (int j=0;j<numNodes;j++){
				if(initialEdges!=null)
				{
					edges[i][j]=initialEdges[i][j];
				}
				if(initialWeights!=null)
				{
					weights[i][j]=initialWeights[i][j];
				}
				if(initialAfloyd!=null)
				{
					aFloyd[i][j]=initialAfloyd[i][j];
				}
				if(initialPfloyd!=null)
				{
					pFloyd[i][j]=initialPfloyd[i][j];
				}
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
	if(tam>=0)
		{
			nodes = (T[])new Object[tam];
			edges=new boolean [tam][tam];
			weights=new double[tam][tam];
			aFloyd=new double [tam][tam];
			pFloyd=new int[tam][tam];
		}
		
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
		if(nodes.length<=numNodes||existNode(node)||node==null)
			return -1;
		else
		{
			nodes[numNodes]= node;
			++numNodes;
			return 0;
			}
	}

    /** 
     * Devuelve un String con la informacion del grafo (incluyendo matrices de Floyd) 
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
  
                cadena += (edges[i][j]?df.format(weights[i][j]):"-") + "\t"; 
            } 
            cadena += "\n"; 
        } 
  
//        double[][] aFloyd = getAFloyd(); 
//        if (aFloyd != null) { 
//            cadena += "\nMATRIZ AFloyd\n"; 
//            for (int i = 0; i < numNodes; i++) { 
//                for (int j = 0; j < numNodes; j++) { 
//                    cadena += df.format(aFloyd[i][j]) + "\t"; 
//                } 
//                cadena += "\n"; 
//            } 
//        } 
//  
//        int[][] pFloyd = getPFloyd(); 
//        if (pFloyd != null) { 
//                cadena += "\nMATRIZ PFloyd\n"; 
//            for (int i = 0; i < numNodes; i++) { 
//                for (int j = 0; j < numNodes; j++) { 
//                    cadena += (pFloyd[i][j]>=0?df.format(pFloyd[i][j]):"-") + "\t"; 
//                } 
//                cadena += "\n"; 
//            } 
//        } 
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
	private T getIndice(int indice)
	{
		return nodes[indice];
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
			int aux=getNode(node);
			numNodes--;
				if(aux!=numNodes+1)
				{
					for(int j=0;j<numNodes;j++)
					{
						edges[j][aux]=edges[j][numNodes];
						edges[aux][j]=edges[numNodes][j];
						weights[aux][j]=weights[numNodes][j];
						weights[j][aux]=weights[j][numNodes];		
					}	
					nodes[aux]=nodes[numNodes];
					edges[aux][aux]=edges[numNodes][numNodes];
					weights[aux][aux]=weights[numNodes][numNodes];
				}
				
			return 0;
		}else
		
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
				vecD[i]=Double.POSITIVE_INFINITY;
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
	/** 
	* Aplica el algoritmo de Floyd al grafo 
	* 
	* @return 0 si lo aplica y genera matrices A y P; y �1 si no lo hace 
	*/ 
	public int floyd() {
		copiar();
		for (int k=0; k<numNodes; k++) 
		{
			for (int i=0; i<numNodes; i++)
			{
				for (int j=0; j<numNodes; j++) 
				{
					
					if(aFloyd[i][k] + aFloyd[k][j] < aFloyd[i][j]) 
					{
						
						aFloyd[i][j] = aFloyd[i][k] + aFloyd[k][j];
						pFloyd[i][j] = k; 
					}
				}
			}
		}
		if(aFloyd!=null)
		{
			return 0;
		}
		return -1;
	}
	
	
	private void copiar()
	{
		for (int i=0; i<numNodes; i++) 
		{
			for (int j=0; j<numNodes; j++)
			{
				if(i==j)
				{
					aFloyd[i][j]=0;
				}
				else {
					if (edges[i][j]) {
						aFloyd[i][j] = weights[i][j];
					}
					else {
						aFloyd[i][j] = Double.POSITIVE_INFINITY;
 					}
				}
			}
		}
	}
	  /**  
	* Devuelve la matriz A de Floyd, con infinito si no hay camino  
	* Si no se ha invocado a Floyd debe devolver null  
	*   
	* @return la matriz P de Floyd  
	*/  
	protected double[][] getAFloyd() {
		if(floyd()==0)
		{
			return aFloyd;
		}
		return null;
	}

	/**  
	* Devuelve la matriz P de Floyd, con -1 en las posiciones en las que no hay nodo intermedio  
	* Si no se ha invocado a Floyd debe devolver null  
	*   
	* @return la matriz P de Floyd   
	*/  
	protected int[][] getPFloyd() {
		if(floyd()==0)
		{
			return pFloyd;
		}
		return null;
	}
	 
	/** 
	* Indica el camino entre los nodos que se le pasan como par�metros de esta forma: 
	* Origen<tab>(coste0)<tab>Intermedio1<tab>(coste1)�.IntermedioN<tab>(costeN) Destino 
	* Si no hay camino muestra: Origen<tab>(Infinity)<tab>Destino 
	* Si Origen y Destino coinciden muestra: Origen 
	* 
	* @param origen 
	* @param destino 
	* @return El String indicado 
	*/ 
	public String path(T origen, T destino) 
	{
		if(existNode(origen)&&existNode(destino))
		{
			String cad="";
			if(origen.equals(destino))
			{
				cad+= "Origen";
			}
			else 
			{
				cad+=generaCamino(origen,destino);
			
			}
			return cad;
		}return "";
	}
	
	private String generaCamino(T origen, T destino) 
	{
		String cad="";
		if(existEdge(origen, destino))
		{
			cad+= String.valueOf(getNode(origen)+"\t"+"("+"infinity"+"\t"+getNode(destino));
		}
		else
		{
			int intermedio=pFloyd[getNode(origen)][getNode(destino)];
			return generaCamino(origen,getIndice(intermedio))+generaCamino(getIndice(intermedio), destino);
		}
		return cad;
	}
	/** 
	* Devuelve el coste del camino de coste m�nimo entre origen y destino seg�n Floyd 
	* Si no est�n generadas las matrices de floyd, las genera. 
	* Si no puede obtener el valor por alguna raz�n, devuelve �1 (OJO que es distinto de infinito) 
	**/ 
	public double minCostPath(T origen, T destino) {
		if(existNode(origen)&&existNode(destino))
			{
			if(aFloyd==null)
			{
				floyd();
			}
			if (aFloyd[getNode(origen)][getNode(destino)] == Double.POSITIVE_INFINITY)
			{
				return -1;
			}
			return aFloyd[getNode(origen)][getNode(destino)];
			}else
				return -1;
	}
	
	
	
	/** 
	 * Lanza el recorrido en profundidad de un grafo desde un nodo determinado, 
	 * No necesariamente recorre todos los nodos. 
	 * Al recorrer cada nodo a�ade el toString del nodo 
	 * Usa un m�todo privado recursivo 
	 * Que recorran vecinos empezando por el principio del vector de nodos (antes �ndices bajos)  
	 *  
	 * @param nodo 
	 *            El nodo por el que se quiere empezar el recorrido en 
	 *            profundidad 
	 * @return un String con el  toString de los nodos del recorrido separados por tabulaciones 
	 *            Si no existe el nodo devuelve un String vacio 
	 */ 
	public String recorridoProfundidad(T nodo) {
		if(existNode(nodo))
		{
			boolean [] visitados = new boolean[numNodes];
			Arrays.fill(visitados, false);
			return recorridoProfunidadInt(getNode(nodo), visitados);
		}else
			return "";
	}
	
	private String recorridoProfunidadInt(int nodo, boolean [] visitados)
	{
		if(visitados!=null)
		{
		String resultado = nodes[nodo].toString();
		visitados[nodo] = true;
		
		for (int hijo = 0; hijo < numNodes; hijo++) {
			if (edges[nodo][hijo]) {
				if (!visitados[hijo]) {
					resultado += recorridoProfunidadInt(hijo, visitados);
				}
			}
		}
		
		return resultado;
		}else
			return "";
	}
	
}


