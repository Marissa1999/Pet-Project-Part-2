import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Marissa Gonçalves
 * Date: March 19, 2018
 * Purpose: To run the PettingZoo class, as well as the other subclasses.
 */

public class PettingZooApplication extends Object
{
    
    /**
     * Compiles and runs the PettingZoo class, as its other classes in the Pet inheritance hierarchy.
     * @param args The classic name indicating the name of an array of String values in a program.
     * @throws FileNotFoundException: An error message indicating an non-existing file.
     */
    public static void main(String[] args) throws FileNotFoundException, IOException
   {  
       
      PettingZoo cavendishZoo = new PettingZoo("Quartier Cavendish Petting Zoo");
      System.out.println(cavendishZoo);
      cavendishZoo.addPetInCSVformat("dog, Fido, 5, male, small");
      cavendishZoo.addPetInCSVformat("cat, Garfield, 3, female, true");
      cavendishZoo.addPetInCSVformat("duck, Donald, 7, female, 9");
      System.out.println(cavendishZoo);
      cavendishZoo.growOlder(1);
      System.out.println(cavendishZoo);

      PettingZoo granbyZoo = new PettingZoo("Granby Zoo", "./pet_data.txt");
      System.out.println(granbyZoo);

      String dashes = "";
      for (int k = 0; k < ("Summary Report for " + granbyZoo.getName()).length(); ++k)
      {
         dashes += "-";
      }
      System.out.println(dashes);
      System.out.println("Summary Report for " + granbyZoo.getName());
      System.out.println(dashes);
      System.out.println("Number of types of pets: " + granbyZoo.howManyPetTypes());
      System.out.println("Number of pets         : " + granbyZoo.howManyPets());
      System.out.println("Number of male pets    : " + granbyZoo.howManyMalePets());
      System.out.println("Number of female pets  : " + granbyZoo.howManyFemalePets());
      System.out.println("Number of pet dogs     : " + granbyZoo.howMany("dog"));
      System.out.println("Number of pet cats     : " + granbyZoo.howMany("cat"));
      System.out.println("Number of pet ducks    : " + granbyZoo.howMany("duck"));
      System.out.println(dashes);

      ArrayList<Pet> retiredPetList = granbyZoo.retire(5); // retire pets older that
      System.out.println("\nList of retired pets:");
      for (int k = 0; k < retiredPetList.size(); ++k)
      {
         System.out.printf("%2d %s (%s)\n", k + 1, retiredPetList.get(k),
                 retiredPetList.get(k).speak());
      }
      System.out.println("End list of retired pets.\n");

      System.out.println(granbyZoo); // print current pets in the zoo

      String outputFileName = "./output.txt"; // too rigid; must allow user to specify file name
      granbyZoo.outputCSV(outputFileName); // write pet list to outputFileName
   }
   
    /**
     * Prints out the repeated statements from the other classes in the Pet hierarchy.
     * @return The statement to state the information about the pet.
     */
    @Override
    public String toString()
    { 
        return super.toString();
    }
    
    /**
     * Returns true if the variables name, age and gender are all equal to the other variables.
     * @param other The other Pet object.
     * @return True, if all the instance variables in this super is class are equal to the other variables.
     */
    @Override
    public boolean equals(Object other)
    {
        return super.equals(other);
    }
    
}
