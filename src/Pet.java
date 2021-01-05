import java.util.Random;

/**
 * @author Marissa Gonçalves
 * Date: March 2, 2018
 * Purpose: To run variables and methods that the other subclasses possess.
 */

public abstract class Pet extends Object
{
    /**
     * Allows the gender to be selected randomly.
     */
    private static Random rand = new Random();
    
    /**
     * Allows the name to have type String.
     */
    private String name;
    
    /**
     * Allows the age to have type integer.
     */
    private int age;
    
    /**
     * Allows the gender to have type boolean.
     */
    private char gender;
    
    /**
     * Initializes the name from the called method, sets the age to 1 and allows the gender to be random.
     * @param name The called name of the pet from the driver class.
     * @param age The called name of the pet from the driver class.
     * @param gender The called name of the pet from the driver class.
     */
    public Pet (String name, int age, char gender)
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    
     /**
     * Returns the name of the pet, whether it is a dog, cat or duck.
     * @return The name of the pet.
     */
    public String getName()
    {
       return this.name;  
    }
    
    /**
     * Returns the age of the pet, whether it is a dog, cat or duck.
     * @return The age of the pet.
     */
    public int getAge()
    {
        return this.age;
    }
    
    /**
     * Returns the gender of the pet, whether it is a dog, cat or duck.
     * @return The gender of the pet.
     */
    public char getGender()
    {
        return this.gender;
    }
    
    /**
     * Increments the age by 1.
     */
    public void growUp()
    {
        this.age++;
    }
    
    /**
     * Prints out the repeated statements from the other subclasses.
     * @return The statement to state the information about the pet.
     */
    @Override
    public String toString()
    { 
       String result = "";
       
       switch (this.gender)
       {
           case 'M': result += "I'm " + getName() + ", a " + getAge() + "-year old male pet"; break;
           case 'm': result += "I'm " + getName() + ", a " + getAge() + "-year old male pet"; break;
           case 'F': result += "I'm " + getName() + ", a " + getAge() + "-year old female pet"; break;
           case 'f': result += "I'm " + getName() + ", a " + getAge() + "-year old female pet"; break;
       }
       
       return result;   
    }
    
    /**
     * Returns true if the variables name, age and gender are all equal to the other variables.
     * @param other The other Pet object.
     * @return True, if all the instance variables in this super is class are equal to the other variables.
     */
    @Override
    public boolean equals(Object other)
    { 
        if (other == null)
        {
            return false;
        }
        
        if(! (other instanceof Pet))
        {
            return false;
        }
        
        Pet p = (Pet) other;
        
        return this.age == p.age
               && this.gender == p.gender
               && this.name.equals(p.name);
    }
    
    /**
     * Prints the repeated statement, to determine which pet is about to talk.
     */
    public void talk()
    {
        System.out.print("Hi there, this is " + getName() + " talking: ");
    }
    
    /**
     * Allows the Pet class, not being able to speak, implement the representation in the other subclasses.
     * @return An empty String method, since it is already abstract.
     */
    public abstract String speak();

   
}
