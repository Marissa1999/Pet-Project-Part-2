/**
 * @author Marissa Gonçalves
 * Date: March 2, 2018
 * Purpose: To extend the super class Pet and to introduce unique methods for the pet cat.
 */

public class Cat extends Pet
{
    /**
     * Allows the neutered variable to have type boolean.
     */
    private boolean neutered;
    
    /**
     * Calls the super class to set the dog's name and initializes the neutered condition of the cat from the called method.
     * @param name The called name of the pet cat.
     * @param age The called age of the pet cat.
     * @param gender The called gender of the pet cat.
     * @param neutered The neutered condition of the pet cat.
     */
    public Cat (String name, int age, char gender, boolean neutered)
    {
        super(name, age, gender);
        this.neutered = neutered;
    }
    
    /**
     * Returns true if the pet cat is neutered.
     * @return The neutered condition of the pet cat.
     */
    public boolean isNeutered()
    {
        return this.neutered;
    }
    
    /**
     * Prints out a statement that the pet cat is purring.
     */
    public void purr()
    {
        System.out.println(getName() + " is purring ...");
    }
    
    /**
     * Prints out a statement that the pet cat is catching mice.
     */
    public void catchMice()
    {
        System.out.println(getName() + " is catching mice ...");
    }
    
    /**
     * Calls the toString() method from the super class Pet and completes the statement adding more information about the pet cat.
     * @return The completed statement, mentioning extra information about the pet cat.
     */
    @Override
    public String toString()
    {
        if (isNeutered())
        {
            return super.toString() + " cat, a neutered cat.";
        }
        
        else
        {
            return super.toString() + " cat, an non-neutered cat.";
        }
    }
    
    /**
     * Returns true if the variables name, age, gender and neutered variables are all equal to the other variables.
     * @param other The other Cat object.
     * @return True, if the super class variables and the neutered variable are all equal to the other variables.
     */
    public boolean equals (Object other)
    {
       if (other == null)
        {
            return false;
        }
        
        if(! (other instanceof Cat))
        {
            return false;
        }
        
        Cat cat = (Cat) other;
        
        return super.equals(other) && this.neutered == cat.neutered;
        
        
    }
    
    /**
     * Completes the statement from the super class method talk(), which the pet cat speaks.
     */
    @Override
    public void talk()
    {
        super.talk();
        System.out.println("Meow Meow Meow!");
    }
    
    /**
     * Allows the String result to return the pet cat's words. 
     * @return The String result, pertaining to the cat's speech.
     */
    @Override
    public String speak()
    {
        return ("Meow!");
    }
   
    
}
