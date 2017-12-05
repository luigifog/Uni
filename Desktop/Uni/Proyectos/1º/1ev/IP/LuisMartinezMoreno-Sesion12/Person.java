import java.util.Random;
/**
 *Esta es la clase Person de la 3ª clase.
 * 
 * @author Luis 
 * @version Septiembre de 2016
 */
public class Person
{
    // instance variables - replace the example below with your own
    public String name;
    public int age;
    public String surname;
    public boolean gender;
    public int years;
    
    private final static String femaleNames[]={"Ana", "Laura", "Maria", "Bea"}; 
    private final static String maleNames[]={"Juan","Lucas","Alberto","Carlos"};
    private final static String surnames[]={"Martinez","Moreno","Fernandez","Garcia"};
   
    public final static String CHILD= "CHILD";
    public final static String ADULT= "ADULT";
    public final static String RETIRED= "RETIRED"; 
    
    public final static int CURRENT_YEAR =2016;
    public final static int MIN_AGE=0;
    public final static int MAX_AGE=120;
    public final static int ADULTHOOD_AGE=18;
    public final static int RETIREMENT_AGE=65;
    public final static boolean GENDER_FEMALE=false;
    public final static boolean GENDER_MALE=true;
    
public Person()
{}
/**
* Constructor for objects of class Person
*/
public Person(int ranAge)
{
        // initialise instance variables
       if(ranAge>=MIN_AGE && ranAge<=MAX_AGE)
       {
       //age = 18; //ojo la edad ha sido considerada como el numero de años desde el nacimiento
       Random random =new Random();
       setAge(random.nextInt(ranAge));
       //setSurname(random.;
       setGender (random.nextBoolean());
//        if(getGender=false)
//        {
//         setName(random.femaleNames[]);
//         }
    }
    else
    {
    throw new RuntimeException("la edad tiene que estar comprendida entre 0 y 120");
    }
}


private void setFemaleNames(int number)
{
    if(number>= femaleNames.length)
    throw new RuntimeException("posicion no valida");
    
}


/**
 *El metodo consiste en un viaje al futuro el cual suma los años viajados a la edad de Person y el año en el que supone que se ha viajado
 * si el parametro es negativo, o la edad es mayor a 120, el metodo debera devolver el valor -1
 *
 *@param de tipo int
 */
public int goToTheFuture( int numberOfYears)
{
    if (numberOfYears>0 
    ){
    setAge(getAge() + numberOfYears);
    return (numberOfYears+CURRENT_YEAR);}
    else if( numberOfYears<=0 )
    return -1;
    else if ((getAge()+ numberOfYears) > MAX_AGE)
    return -1;
    return numberOfYears;
    
}
// /**
//  * constructor con la edad cambiable
//  * 
//  */
// public Person(int age) 
// {
//   this();  // Invocar al constructor por defecto
//   setAge(age);
// }
// Person(String name, String surname, int age, boolean gender)
// {
//     this();
//     setName(name);
//     setSurname(surname);
//     setAge(age);
//     setGender(gender);
// }

/**
 * Modifica el atributo del nombre de la persona
 * 
 * @param de tipo String
 */
public void setName (String newName)
{
    name=newName;
}

    
    /**
     * Este metodo permite modificar el atributo edad de la persona
     *
     * @param newAge la nueva edad de la persona. Solo se tendrán en cuenta edades mayores o iguales que 0
     */
    public void setAge (int newAge){
    if (newAge>=MIN_AGE) 
    {
        if (newAge<MAX_AGE) 
            age=newAge;//no se permiten edades negativas
    }
}


/**
 * Modifica el atributo del apellido de la persona
 * 
 * @param de tipo String
 */
public void setSurname (String newSurname)
{
    surname=newSurname;
}


/**
 * Modifica el atributo del genero de la persona
 * true= genero masculino
 * false= genero femenino
 * 
 * @param de  tipo boolean
 */
public void setGender (boolean newGender)
{
    gender=newGender;
}


/**
 *Este atributo retorna el nombre actual de la persona
 * 
 * @param de tipo String
 */
public String getName()
{
    return name;
}

/**
 * Este metodo retorna el valor actual de la edad de la persona
 *
 * @return La edad actual de la persona medida en numero de dias
 */
public int getAge()
{
    return age;
}


/**
 * Este metodo retorna el valor actual del apellido de la persona
 * 
 * @param de tipo String
 */
public String getSurname()
{
    return surname;
}


/**
 * Este metodo retorna el valor del género de la persona
 * 
 * @param de tipo booolean
 */
public boolean getGender()
{
    return gender;
}


/**
 * Este método muestra en la consola el valor que le pedimos
 * 
 * @param de tipo void
 */
public void print()
{
    System.out.println("Mi edad es " + getAge() + " pero el año que viene tendré "+ (getAge()+ 1) + " años");
    System.out.println(toString());
 }

 
/**
 * Este metodo nos devuelve una cadena con el nombre en mayusculas, el apellido en mayusculas,
 * su edad y su genero.
 * 
 * @param de tipo String
 */
public String toString()
{
    return getName().toUpperCase()+"-"+getSurname()+"-"+getAge()+"-"+getGender();
}

/**
 * Este metodo devuelve un dato dependiendo de la edad que tenga
 * 
 * @param de tipo String
 */
private String getAgeAsString()
 {
     if (age<ADULTHOOD_AGE){
       return CHILD;
    } 
    {
        if (age<RETIREMENT_AGE) return ADULT; 
      
       return RETIRED;
    }
    
    }
   
/**
 * Este metodo devuelve una cadena con la edad las dos primeras letras del nombre en mayusculas y las cuatro primeras letras del apellido
 * en mayusculas tambien.(todo esto refiriendose a la clase person)
 * 
 * @param de tipo String
 */
public String getHashCode()
{
    //return getAge()+"-"+getName().toUpperCase()+"-"+getName().length()+"-"+getSurname().toUpperCase()+"-"+getSurname().length();
    return getAge()+"-"+getName().substring(0, 2).toUpperCase()+"-"+getSurname().substring(0, 4).toUpperCase()+"-"+getAgeAsString();
}
 
/**
 * Calcula los años que faltan para ser mayor de edad o los que le falta para la jubilación (si>=18 y <65)
 * o el número de años que lleva jubilado todo ello en base a la edad.
 * 
 * @param de tipo int
 */
public int getCriticalAge(){
    int years=0;
    

    if (age<ADULTHOOD_AGE){
        years=ADULTHOOD_AGE-age;
    } else {
        if (age<RETIREMENT_AGE){
            years=RETIREMENT_AGE-age; 
        } else  
            years=age-RETIREMENT_AGE;
    }
    
    return years;
    
}
}
