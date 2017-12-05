
/**
 * Write a description of class nunchuk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nunchuk
{   private Weapon arma;
    private Figure personaje;
    public final static int ADVANCE= 1;
    public final static int MIDDLE_ADVANCE=2;
    public final static int MUCH_ADVANCE=5;
    
    /**
     * Nunchuk Constructor
     *
     * @param personaje A parameter
     * @param g17 A parameter
     */
    public Nunchuk(Figure personaje,Weapon g17)
    {}
    
    /**
     * Nunchuk Constructor con parametros
     *
     */
    public Nunchuk()
    {
        arma=new Weapon();
        personaje= new Figure();
        }
    
    /**
     * Method setPersonaje
     *Setter para los personajes
     * @param newPersonaje A parameter
     */
    private void setPersonaje(Figure newPersonaje)
    {
        personaje=newPersonaje;
    }
    
    /**
     * Method getPersonaje
     *Getter para los personajes
     * @return The return value
     */
    public Figure getPersonaje()
    {
        return personaje;
    }
    
    /**
     * Method setArma
     *Setter pata el arma
     * @param newArma A parameter
     */
    private void setArma(Weapon newArma)
    {
        arma=newArma;
    }
    /**
     * Method getArma
     *Getter pata el arma
     * @return The return value
     */
    public Weapon getArma()
    {
        return arma;
    }
    
    /**
     * Method advance
     *Avanza solo un paso
     * @param direction A parameter
     */
    public void advance(char direction)
    {
        personaje.move(direction);
    }
    
    /**
     * Method middleAdvance
     *Avanza 2 pasos
     * @param direction A parameter
     */
    public void middleAdvance(char direction)
    {
        advance(direction);
        advance(direction);
    }
    
    /**
     * Method muchAdvance
     *Avanza 5 pasos
     * @param direction A parameter
     */
    public void muchAdvance(char direction)
    {
        advance(direction);
        advance(direction);
        advance(direction);
        advance(direction);
        advance(direction);
    }
    
    /**
     * Method shootWeapon
     *Dispara el arma en una rafaga de 5 disparos
     * @param burst A parameter
     */
    public void shootWeapon(boolean burst)
    {
        if(burst)
        arma.Shoot();
        else{
            arma.Shoot();
            arma.Shoot();
            arma.Shoot();
            arma.Shoot();
            arma.Shoot();
        }
    }
    
    /**
     * Method shootForward
     *Metodo que le permite caminar y disparar a la vez
     * @param direction A parameter
     */
    public void shootForward(char direction)
    {
        personaje.move(direction);
        arma.Shoot();
    }
    
    /**
     * Method print
     *
     */
    public void print()
    {
        System.out.println(arma.toString());
        System.out.println(personaje.toString());
    }
}
