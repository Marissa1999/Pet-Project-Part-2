/**
 * @author Marissa Gonçalves
 * Date: March 2, 2018
 * Purpose: To extend the super class Pet and to introduce unique methods for the pet dog.
 */

public class Dog extends Pet
{
    /**
     * Allows the size to have type String.
     */
    private String size;
    
    /**
     * Calls the super class to set the dog's name and initializes the size of the dog from the called method.
     * @param name The called name of the pet dog.
     * @param age The called age of the pet dog.
     * @param gender The called gender of the pet dog.
     * @param size The called size of the pet dog.
     */
    public Dog (String name, int age, char gender, String size)
    {
        super(name, age, gender);
        this.size = size;
    }
    
    /**
     * Returns the size of the pet dog.
     * @return The size of the pet dog.
     */
    public String getSize()
    {
        return this.size;
    }
    
    /**
     * Prints out a statement that the pet dog is guarding home.
     */
    public void guardHome()
    {
        System.out.println(getName() + " is guarding home ...");
    }
    
    /**
     * Prints out a statement that the pet dog is panting.
     */
    public void pant()
    {
        System.out.println(getName() + " is panting as usual ...");
    }
    
    /**
     * Calls the toString() method from the super class Pet and completes the statement adding more information about the pet dog.
     * @return The completed statement, mentioning extra information about the pet dog.
     */
    @Override
    public String toString()
    {
        return super.toString() + " dog, a " + getSize() + " dog.";
    }
    
    /**
     * Returns true if the variables name, age, gender and size are all equal to the other variables.
     * @param other The other Dog object.
     * @return True, if the super class variables and the size variable are all equal to the other variables.
     */
    public boolean equals(Object other)
    {
        if (other == null)
        {
            return false;
        }
        
        if(! (other instanceof Dog))
        {
            return false;
        }
        
        Dog dog = (Dog) other;
        
        return super.equals(other) && this.size.equals(dog.size);
    }
    
    /**
     * Completes the statement from the super class method talk(), which the pet dog speaks.
     */
    @Override
    public void talk()
    { 
        super.talk();
        System.out.println("Woof-Woof-Woof!");
    }
    
    /**
     * Allows the String result to return the pet dog's words. 
     * @return The String result, pertaining to the dog's speech.
     */
    @Override
    public String speak()
    {
        return ("Woof!");
    }
    
    
}
