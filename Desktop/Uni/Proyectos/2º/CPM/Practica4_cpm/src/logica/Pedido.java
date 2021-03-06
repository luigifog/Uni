package logica;
import java.io.*;
import java.util.*;

import igu.VentanaRegistro;

public class Pedido {
	
	private List<Articulo> articulosPedido = null;
	
	public Pedido(){
		articulosPedido = new ArrayList<Articulo>();
	}
	
	public void add(Articulo articulo, int unidades){
		Articulo articuloEnPedido = null;
	
		for (Articulo a : articulosPedido){
			if (a.getCodigo().equals(articulo.getCodigo()))
				articuloEnPedido = a;
		}
		
		if (articuloEnPedido == null){
			articulo.setUnidades(unidades);
			articulosPedido.add(articulo);
		}
		else{
			int totalUnidades = articuloEnPedido.getUnidades() + unidades;
			articuloEnPedido.setUnidades(totalUnidades);
		}
	}
	
	public float calcularTotalSinIva(){
		float total = 0.0f;
		
		for (Articulo a : articulosPedido){
			if(a.getUnidades()>=10)
			{
				float descuento=a.getPrecio()*a.getUnidades()*0.15f;
				float p=a.getPrecio()*a.getUnidades()-descuento;
				total += p;
			}else{
			total += a.getPrecio()* a.getUnidades();
			}
		}
		return total;
	}
	
	public void grabarPedido(String nombreFichero){
		try {
			VentanaRegistro vr=new VentanaRegistro();
		        BufferedWriter fichero = new BufferedWriter(new FileWriter("files/" + nombreFichero + ".dat"));
		        String linea = articulosPedido.toString();
		        String linea2=vr.datos();
		        fichero.write(linea);
		        fichero.write(linea2);
		        fichero.close();
			}

		catch (FileNotFoundException fnfe) {
		      System.out.println("El archivo no se ha podido guardar");
		    }
		catch (IOException ioe) {
		      new RuntimeException("Error de entrada/salida");
		}
	  }

	public void inicializar(){
		articulosPedido.clear();
	}
	
	
}

