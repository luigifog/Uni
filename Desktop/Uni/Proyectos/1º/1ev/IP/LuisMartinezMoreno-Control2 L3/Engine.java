/**
 *Motor para poner a un avión
 * 
 * @author Marián
 * @version (a version number or a date)
 */
public class Engine
{
    public static final double MIN_REVOLUTIONS = 0;
    public static final double MAX_REVOLUTIONS = 45000;
    
    public static final double DEFAULT_REVOLUTIONS = 100;
    
    
    // instance variables - replace the example below with your own
    private double revolutions;

    /**
     * Constructor for objects of class Engine
     */
    public Engine()
    {
        setRevolutions(DEFAULT_REVOLUTIONS); 
    }
    
     /**
     * Constructor for objects of class Engine
     */
    public Engine(double revolutions)
    {
        this();
        setRevolutions(revolutions); 
    }

    /**
     * modifica las revoluciones
     * 
     * @param  revolutions, nuevo valor, de tipo doble
     * 
     */
    private void setRevolutions(double newRevolutions)
    {
        if (newRevolutions >= MIN_REVOLUTIONS && newRevolutions <= MAX_REVOLUTIONS)
            revolutions = newRevolutions;
    }
    
    /**
     * Devuelve las revoluciones
     * @return revolutions de tipo doble
     */
    public double getRevolutions()
    {
        return revolutions;
    }
    
    /**
     * Cambia las revoluciones a las recibidas y devuelve true si las ha podido cambiar
     * @param newRevolutions nuevo valor para las revoluciones, de tipo doble
     * @return true si las ha podido cambiar, false si no, (por estar fuera de límites)
     */
    public boolean changeRevolutions(double newRevolutions)
    {
        double oldRevolutions = getRevolutions();
        setRevolutions(newRevolutions);
        if ( getRevolutions() == oldRevolutions )
            return false;
        else
            return true;
    }
}
