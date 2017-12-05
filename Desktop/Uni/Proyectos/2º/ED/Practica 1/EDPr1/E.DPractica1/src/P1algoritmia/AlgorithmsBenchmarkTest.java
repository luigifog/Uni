package P1algoritmia;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlgorithmsBenchmarkTest {

	

	@Test
	public void test() {
		AlgorithmsBenchmark ab=new AlgorithmsBenchmark();
		//No se como llamar a la clase con el getClass()
//		ab.test3("pruebaCuad.csv", 100, 201, "EDpractica1/src/P1algoritmia/Algorithms.java", "pow2Iter");
		ab.testFinal("pruebaLinear", 100, 200, 3, "/E.DPractica1/src/P1algoritmia/Algorithms.java", "linear");
		
//		ab.test0("prueba1.csv");
//		ab.test1("test2.csv", 100, 200);
//		ab.test3("prueba3.csv", 50, 100, "Algorithms", "linear");
//		ab.testAlgorithm("Algorithms", "pow2Iter", 20);
//		ab.test3("pruebaPows.csv", 100, 200, "EDpractica1/src/P1algoritmia/Algorithms.java", "pow2Iter");		
	}

}
