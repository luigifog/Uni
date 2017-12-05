package model;
/**
 * Clase Plane 
 */
public class Plane
{
    public static final char DEFAULT_IDENTIFIER = 'A';
    public static final int DEFAULT_FUEL = 0;
    public static final int MIN_FUEL = 0;
    
    public static final char MIN_IDENTIFIER = 'A';
    public static final char MAX_IDENTIFIER = 'Z';
          
    private Person pilot;       // piloto del avión
    private char identifier;    // Identificación del avión, una letra mayúscula
    private int fuel;           // cantidad actual de combustible que lleva el avión >= 0

    /**
     * Constructor sin parámetros
     */
    public Plane()
    {
       setIdentifier(DEFAULT_IDENTIFIER);
       setFuel(DEFAULT_FUEL);
    }
    
     /**
     * Constructor con tres parametros
     */
    public Plane (Person pilot, char identifier, int fuel)
    {
       this();
       setPilot(pilot);
       setIdentifier(identifier);
       setFuel(fuel);
    }
    
    /**
     * Método de modificación de la propiedad pilot
     * 
     * @param pilot el piloto asignado al avión
     * 
     */   
    private void setPilot(Person pilot)
    {
        if (pilot != null)
            this.pilot = pilot;
    }
    
    /**
     * Método de modificación de la propiedad identifier
     *
     * @param identifier el nuevo identificador para el avión
     */
    private void setIdentifier(char identifier)
    {
        if ((identifier >= MIN_IDENTIFIER) && (identifier <= MAX_IDENTIFIER))
            this.identifier = identifier;
    }
    
    /**
     * Método de modificación de la propiedad fuel
     * 
     * @param fuel cantidad de compustible para el avión
     */
    private void setFuel(int fuel)
    {
        if (fuel >= MIN_FUEL)
            this.fuel = fuel;
    }
    
    /**
     * Método de acceso de la propiedad pilot
     * 
     * @return  Person el piloto del avión (es un objeto de tipo Person)
     */
    public Person getPilot()
    {
        return pilot;
    }
    
    /**
     * Método de acceso de la propiedad identifier
     * 
     * @return  char el identificador del avión
     */
    public char getIdentifier()
    {        
        return identifier;
    }

    /**
     * Método de acceso de la propiedad fuel
     * 
     * @return  int el combustible del avión
     */
    public int getFuel()
    {
         return fuel;
    }
    
    /**
     * Método que devuelve una cadena con el valor de las propiedades del avión
     * 
     * @return    cadena con el valor de las propiedades del avión
     */
    public String toString()
    {
        String stringToReturn = "" + getIdentifier() + " "+ this.getFuel() + "   " ;
        if ( getPilot() == null)
             stringToReturn += " NO PILOT";
        else
             stringToReturn += getPilot().toString();
        return  stringToReturn;
    }
	
	/**
     * Método que devuelve false si no hay SUFICIENTE combustible, si lo hay reduce el combustible en 1 unidad y devuelve true
     * @return boolean true si puede volar y false si no tiene combustible
     */
    public boolean fly()
    {
        if (getFuel() == MIN_FUEL)
            return false;
        else
        {
            setFuel(getFuel() - 1);
            return true;
        }
    }    
       
}
