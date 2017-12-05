package taller;


public class Application {
	private Camion cam1;
	private Camion cam2;
 	private Coche coche1;
 	private Coche coche2;
	private Moto moto1;
	private Moto moto2;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Application().run();

	}
	public void run(){
		
		//1- Ingresar varios vehiculos
		
		cam1=new Camion("UO258273",false,500);
		cam2=new Camion("ih423hkk",true,672685);
		coche1=new Coche("h2bk343",false);
		coche2=new Coche("hv42bu234",true);
		moto1=new Moto("ugy423",false);
		moto2=new Moto("gbyi354byuk",true);

		
		//2- Listar Vehiculos no reparados  (serán todos)
		System.out.println("Lista de vehículos no reparados");
				
		
		
		// 3- Encerar los reparados
		System.out.println("Encerado de todos los reparados");
		
		
			
		// Repararlos un vehículo
		System.out.println("Reparación de un vehiculo");
		
		
	}

}
