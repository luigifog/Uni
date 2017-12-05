import java.util.ArrayList;
/**
 * Simula la existencia de aviones en un radar que vuela
 * 
 * @author Luis MArtinez
 * @version 1.0
 */
public class flightSimulator
{
    private ArrayList<Plane> planes;
    private char[][] radar;

    /**
     * Constructor sin parametros
     */
    public flightSimulator()
    {
        planes=new ArrayList<Plane>();
        radar=new char[Plane.MAX_X+1][Plane.MAX_Y+1];
        for(int i=0;i<Plane.MAX_X+1;i++)
        for(int j=0;j<Plane.MAX_Y+1;j++)
            radar[i][j]='~';
    }

    /**
     * Añade un avion a la simulacion
     * 
     * @param Plane, avion a añadir, de tipo Plane
     * @return true si lo ha podido añadir y alse si ya habia uno en la misma posicion
     */
    public boolean addPlane(Plane planeToAdd)
    {
        checkPlane(planeToAdd);
        if(radar[planeToAdd.getXPos()][planeToAdd.getYPos()]=='~')
        {
            planes.add(planeToAdd);
            radar[planeToAdd.getXPos()][planeToAdd.getYPos()]=planeToAdd.getIdentifier();
            return true;
        }
        return false;
    }
    
    private void checkPlane(Plane planeToCheck)
    {
        if(planeToCheck==null)
            throw new RuntimeException("error en el avion que es null");
    }
    
    /**
     * Imprime el radar con todos los aviones imprimiendo virgulilla o bien el identificador
     * del avion en la posicion correspondiente
     */
    public void paint()
    {
        for(int i=0;i<radar.length;i++)
        {
            for(int j=0;j<radar[i].length;j++)
            
                System.out.print(radar[i][j]+ " ");
                System.out.println();
    }
   }
   
   /**
    * Metodo que simula el vuelo de todos los aviones, 
    * si hay colisiones, debe imprimir la colision y eliminar los aviones colisionados
    * Finalmente se imprime el radar
    */
   public void simulate()
   {
       for(Plane planeToFly: planes)
       {
           radar[planeToFly.getXPos()][planeToFly.getYPos()]='~';
           planeToFly.fly();
           if(radar[planeToFly.getXPos()][planeToFly.getYPos()]=='~')
                radar[planeToFly.getXPos()][planeToFly.getYPos()]=planeToFly.getIdentifier();
                else
                {
                  System.out.println("colision entre el avion"+planeToFly.getIdentifier()
                  +"y el avion "+radar[planeToFly.getXPos()][planeToFly.getYPos()]);
                    radar[planeToFly.getXPos()][planeToFly.getYPos()]='%';
                }
           //planes.get(i).fly();  si tuvieramos un for i
           //planes[i].fly();      si tuvieramos un array
          
       }
        removeCollisions();
        paint();
   }
   /**
    * Elimina de la lista de aviones todos los aviones situados en una posicion en
    * la que haya colisionado
    */
   private void removeCollisions()
   {
       for(int i=0;i<Plane.MAX_X+1;i++)
            for(int j=0;j<Plane.MAX_Y+1;j++)
                if(radar[i][j]=='%')
                    removePlanesInPosition(i,j);
       
    }
    
    /**
     *Elimina de la lista de aviones todos los aviones situados en una posicion en la que haya colisionado 
     * 
     * @param row fila
     * @param column columna
     */
    private void removePlanesInPosition(int x, int y)
    {
        for(int i=0;i<planes.size();i++)
            if(planes.get(i).getXPos()==x &&
                planes.get(i).getYPos()==y)
                {
                    planes.remove(i);
                    i--;
                }
 
   }
   /**
    * metodo que devuelve una lista con todos los aviones que esten en una determinada posicion
    * 
    * @paran x
    * @param y
    */
   public Plane getPlanesInPosition(int x,int y)
   {
       for(int i=0;i<planes.size();i++)
       if(planes.get(i).getXPos()==x &&
            planes.get(i).getYPos()==y)
        {
            return planes.get(i);
        }
        return null;
   }
}
