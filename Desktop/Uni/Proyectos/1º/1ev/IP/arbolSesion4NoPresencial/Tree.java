
/**
 * Tarea No Presencial de la Sesión 03, clase árbol
 * 
 * @author Luis Martinez
 * @version 25/09/2016
 */
public class Tree
{
    private String typeOfTree;
    private static int maxNumberOfFlowers;
    private int numberOfFlowers;
    private int numberOfFruits;
    
    public static String DEFAULT_TYPE_OF_TREE;
    public static int DEFAULT_NUMBER_OF_FLOWERS;
    public static int DEFAULT_NUMBER_OF_FRUITS;
    /**
     * Constructor for objects of class Tree
     */
    public Tree()
    { 
        typeOfTree = "Manzano";
        maxNumberOfFlowers = 12;
        numberOfFlowers = 7;
        numberOfFruits = 3;
        DEFAULT_TYPE_OF_TREE = "Manzano";
        DEFAULT_NUMBER_OF_FLOWERS = 12;
        DEFAULT_NUMBER_OF_FRUITS= 3;
    }
    
    /**
     * Obtiene el valor del atributo TypeOfTree     
     * @parametro de tipo String
    */
    public String getTypeOfTree(){
        return typeOfTree;
    }
    
    /**
     * Éste método es denominado "regar"y hce lo siguiente; si el número de flores es menor que el número máximo de éstas, 
     * se incrementa en una ud el número de flores.
     * Si el número de frutas es menor al máximo de flores, se incrementa una ud el número de frutas.
     @parametro de tipo void
       */
    
    public void water()
    {
        if (getNumberOfFlowers()< maxNumberOfFlowers)
        setNumberOfFlowers(getNumberOfFlowers()+1);
        else
        if (getNumberOfFruits()< maxNumberOfFlowers)
        {
        setNumberOfFlowers(getNumberOfFlowers()-1);
        setNumberOfFruits(getNumberOfFruits()+1);
       }
    }
    /**
     *Devuelva el número de frutas recogidas y pone a
     *cero el valor de la propiedad numberOfFruits. 
     *@parametro de tipo int
     */
    
    public int harvest()
    {
        System.out.println( numberOfFruits);
        numberOfFruits =0;
        return numberOfFruits;
    }
    /**
     *Disminuye el número de frutas en una unidad y devuelve las frutas que
     *quedan.
     *@parametro de tipo int
     */
    
    public int gatherFruit()
    {
        setNumberOfFruits(getNumberOfFruits()-1);
        System.out.println(getNumberOfFruits());
        return numberOfFruits;
    }
    
    /**
     * Obtiene el valor del atributo MaxNumberOfFlowers
     * @parametro de tipo int
     */
    
    public int getMaxNumberOfFlowers(){
        return maxNumberOfFlowers;
    }
    
    /**
     * Obtiene el valor del atributo NumberOfFlowers
     * @parametro de tipo int
     */
    
    public int getNumberOfFlowers(){
        return numberOfFlowers;
    }
    
    /**
     * Obtiene el valor del atributo getNumberOfFruits
     * @parametro de tipo int
     */
    
    public int getNumberOfFruits(){
        return numberOfFruits;
    }
    
    /**
     * establece el valor del atributo TypeOfTree
     * @parametro de tipo void
     */
    
    public void setTypeOfTree(String newTypeOfTree){
        typeOfTree=newTypeOfTree;
    }
    
    /**
     * establece el valor del atributo MaxNumberOfFlowers
     * @parametro de tipo void
     */
    
    public void setMaxNumberOfFlowers(int newMaxNumberOfFlowers){
        if(newMaxNumberOfFlowers>=0)
        maxNumberOfFlowers=newMaxNumberOfFlowers;
    }
    
    /**
     * establece el valor del atributo NumberOfFlowers
     * @parametro de tipo void
     */
    
    public void setNumberOfFlowers(int newNumberOfFlowers){
        if(newNumberOfFlowers<=maxNumberOfFlowers && newNumberOfFlowers>=0)
            numberOfFlowers=newNumberOfFlowers;
    }
    
    /**
     * establece el valor del atributo NumberOfFruits
     * @parametro de tipo void
     */
    
    public void setNumberOfFruits(int newNumberOfFruits){
        if(newNumberOfFruits>=0)
            numberOfFruits=newNumberOfFruits;  
    }
    
    /**
     * Este método devuelve una cadena con la información de las propiedades
     * @parametro de tipo void
     */
    
    public String toString(){
        return getTypeOfTree()+"-"+getMaxNumberOfFlowers()+"-"+getNumberOfFlowers()+"-"+getNumberOfFruits();
    }
    
    /**
     * Este método muestra en la pantalla la cadena con la información de las propiedades que se habían puesto 
     * en el método toString
     * @parametro de tipo void
     */
    
    public void print(){
        System.out.println("Valores de las propiedas del árbol: "+ toString());
    }
  }

    

