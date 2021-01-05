/**
 * @author Marissa Gonçalves
 * Date: March 2, 2018
 * Purpose: To extend the super class Pet and to introduce unique methods for the pet duck.
 */

public class Duck extends Pet
{
    
    /**
     * Allows the number of eggs to have type integer.
     */
    private int eggs;
    
    /**
     * Calls the super class to set the name of duck.
     * @param name The called name of the pet duck.
     * @param age The called age of the pet duck.
     * @param gender The called gender of the pet duck.
     * @param eggs The called number of eggs laid by the duck.
     */
    public Duck (String name, int age, char gender, int eggs)
    {
        super(name, age, gender);
        this.eggs = eggs;
    }
    
    /**
     * Returns the number of eggs laid by the pet duck.
     * @return The number of laid eggs from the pet duck.
     */
    public int getEggs()
    {
        return this.eggs;
    }
    
    /**
     * Increments the number of laid eggs by 1.
     */
    public void layAnEgg()
    {
        this.eggs++;
    }
    
    /**
     * Prints out a statement that the pet duck is swimming.
     */
    public void swim()
    {
        System.out.println(getName() + " is swimming ...");
    }
    
    /**
     * Prints out a statement that the pet duck is flying.
     */
    public void fly()
    {
        System.out.println(getName() + " is flying ...");
    }
    
    /**
     * Calls the toString() method from the super class Pet and completes the statement adding more information about the pet duck.
     * @return The completed statement, mentioning extra information about the pet duck.
     */
    @Override
    public String toString()
    {
        return super.toString() + " duck, with " + getEggs() + " eggs.";        
    }
    
    /**
     * Returns true if the variables name, age, gender and number of eggs are all equal to the other variables.
     * @param other The other Duck object.
     * @return True, if the super class variables and the number of eggs are all equal to the other variables.
     */
    public boolean equals (Object other)
    {
        if (other == null)
        {
            return false;
        }
        
        if(! (other instanceof Duck))
        {
            return false;
        }
        
        Duck duck = (Duck) other;
        
        return super.equals(other) && this.eggs == duck.eggs;
              
    }
    
    /**
     * Completes the statement from the super class method talk(), which the pet duck speaks.
     */
    @Override
    public void talk()
    {
        super.talk();
        System.out.println("Quack-Quack-Quack!");
    }
    
    /**
     * Allows the String result to return the speech of the duck. 
     * @return The String result, pertaining to the words of the duck.
     */
    @Override
    public String speak()
    {
        return ("Quack!");
    }
    
}
