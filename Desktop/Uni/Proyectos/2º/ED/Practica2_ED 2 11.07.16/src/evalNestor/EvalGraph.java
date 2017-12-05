//  NO MODIFICAR NOMBRE DE ESTE PAQUETE, crear un paquete nuevo en vuestro proyecto que se llame as�: "evalNestor"
//  y meted en �l esta clase
package evalNestor;

import p2Grafos.Graph;

public class EvalGraph<T> extends Graph<T> {

	public EvalGraph(int i) {
		super(i);
	}
	
	public EvalGraph(int i,T initialNodes[], boolean[][] initialEdges, double [][] initialWeights, double [][] initialAfloyd, int [][] initialPfloyd){
		super(i,initialNodes,initialEdges,initialWeights,initialAfloyd,initialPfloyd);
	}
	
	public String getNombreFicheroAlumno(){
		// Poned vuestros apellidos, nombre y UO; sustituyendolos en el return de debajo...
		return "MartinezMorenoLuis-UO258273";
	}
}
/*  Tambi�n se debe a�adir este constructor en la clase Graph

public Graph (int tam, T initialNodes[], boolean[][] initialEdges, double [][] initialWeights, double [][] initialAfloyd, int [][] initialPfloyd) {
	// Llama al constructor original
	this(tam); 
	
	// Pero modifica los atributos con los parametros para hacer pruebas...
	numNodes = initialNodes.length;
	
	for (int i=0;i<numNodes;i++) {
		// Si el vector de nodos se llama de otra forma (distinto de "nodes"), cambiad el nombre en la linea de abajo
		nodes[i]=initialNodes[i];
		for (int j=0;j<numNodes;j++){
			// Si la matriz de aristas se llama de otra forma (distinto de "edges"), cambiad el nombre en la linea de abajo
			edges[i][j]=initialEdges[i][j];
			// Si la matriz de pesos se llama de otra forma (distinto de "weights"), cambiad el nombre en la linea de abajo
			weights[i][j]=initialWeights[i][j];
		}
	}
	if (initialAfloyd!=null){
		// Si la matriz A de floyd se llama de otra forma (distinto de "aFloyd"), cambiad el nombre en la linea de abajo
		aFloyd=initialAfloyd;
		// Si la matriz P de floyd se llama de otra forma (distinto de "pFloyd"), cambiad el nombre en la linea de abajo
		pFloyd=initialPfloyd;
	}

}

*/
