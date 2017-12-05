package logica;
import java.io.*;
import java.util.*;

import igu.VentanaRegistro;


public class Pedido {
	char[] elementos={'0','1','2','3','4','5','6','7','8','9' ,'a',
			'b','c','d','e','f','g','h','i','j','k','l','m','n','�','o','p','q','r','s','t',
			'u','v','w','x','y','z'};

			
			char[] conjunto = new char[8];
			String pass;

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
	public void eliminar(Articulo articulo, int unidades)
	{
		Articulo articuloEnPedido = null;
		for (Articulo a : articulosPedido){
			if (a.getCodigo().equals(articulo.getCodigo()))
				articuloEnPedido = a;
		}
		if (articuloEnPedido != null){
			if(unidades<=articulo.getUnidades())
			{
				articulosPedido.remove(articulo);
				articuloEnPedido.setUnidades(articulo.getUnidades()-unidades);
			}
		
		}
	}
	//busca el articulo en pedido y cuando lo encuentre quito uds
	public String mostrarPedido()
	{
		String cad="";
		for (Articulo articulo : articulosPedido) {
			cad+=articulo.toString()+"\n";
		}
		return cad;
	}
	public List<Articulo>getArticulos()
	{
		return articulosPedido;
	}
			public String codigoPedido(){
			for(int i=0;i<8;i++){
			int el = (int)(Math.random()*37);
			conjunto[i] = (char)elementos[el];
			}
			return pass = new String(conjunto);
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
	
	public void grabarPedido(String nombreFichero, String linea2){
		try {
		        BufferedWriter fichero = new BufferedWriter(new FileWriter("files/" + nombreFichero + ".dat"));
		        String linea = articulosPedido.toString();
		       
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

