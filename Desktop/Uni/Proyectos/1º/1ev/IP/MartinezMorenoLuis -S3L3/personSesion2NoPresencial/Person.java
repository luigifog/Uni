
/**
 *Esta es la clase Person de la 3ª clase.
 * 
 * @author Luis 
 * @version Septiembre de 2016
 */
public class Person
{
    // instance variables - replace the example below with your own
    private String setname;
    private int setage;
    public String setsurname;
    private boolean setgender;
    
    public final static int MIN_AGE=0;
    public final static int MAX_AGE=120;
    public final static int ADULTHOOD_AGE=18;
    public final static int RETIREMENT_AGE=65;
    public final static boolean GENDER_FEMALE=false;
    public final static boolean GENDER_MALE=true;
    
    /**
     * Constructor for objects of class Person
     */
    public Person()
    {
        // initialise instance variables
       setname = "Luis";
       setage = 18; //ojo la edad ha sido considerada como el numero de dias desde el nacimiento
       setsurname = "Martinez";
       setgender = GENDER_MALE;
    }


public void setName (String newName){
    setname=newName;
}

    
    /**
     * Este metodo permite modificar el atributo edad de la persona
     *
     * @param newAge la nueva edad de la persona. Solo se tendrán en cuenta edade3s mayores o iguales que 0
     */
    public void setAge (int newAge){
    if (newAge>=MIN_AGE) {
        if (newAge<MAX_AGE) 
            setage=newAge;//no se permiten edades negativas
    }
}


public void setSurname (String newSurname){
    setsurname=newSurname;
}


public void setGender (boolean newGender){
    setgender=newGender;
}


    public String getName(){
    return setname;
}


    /**
     * Este metodo retorna el valor actual de la edad de la persona
     *
     * @return La edad actual de la persona medida en numero de dias
     */
    public int getAge(){
    return setage;
}


public String getSurname(){
    return setsurname;
}


public boolean getGender(){
    return setgender;
}


public void print(){
    System.out.println("Mi edad es " + getAge() + " pero el año que viene tendré "+ (getAge()+ 1) + " años");
    System.out.println(toString());
 }

 
public String toString(){
    return getName().toUpperCase()+"-"+getSurname()+"-"+getAge()+"-"+getGender();
}

   
public String getHashCode()
{
    return getAge()+"-"+getName().toUpperCase()+"-"+getName().length()+"-"+getSurname().toUpperCase()+"-"+getSurname().length();
}

/**
 * Calcula los años que faltan para ser mayor de edad o los que le falta para la jubilación (si>=18 y <65)
 * o el número de años que lleva jubilado todo ello en base a la edad.
 */
public int getCriticalAge(){
    int years=0;
    
//     if (age<ADULTHOOD_AGE){
//         years=ADULTHOOD_AGE-age;
//     }
//     if (age>=ADULTHOOD_AGE && age<RETIREMENT_AGE){
//        years=RETIREMENT_AGE-age; 
//     }
//     if (age>=RETIREMENT_AGE){
//         years=age-RETIREMENT_AGE;
//     }
//     
    if (setage<ADULTHOOD_AGE){
        years=ADULTHOOD_AGE-setage;
    } else {
        if (setage<RETIREMENT_AGE){
            years=RETIREMENT_AGE-setage; 
        } else  
            years=setage-RETIREMENT_AGE;
    }
    
    return years;
    
}
}
