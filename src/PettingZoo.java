import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Marissa Gonçalves
 * Date: March 19, 2018
 * Purpose: To model a petting zoo hosting the objects/pets: dog, cat and duck.
 */

public class PettingZoo extends Object
{ 
    /**
     * Names the specified zoo in a String of characters.
     */
    private String zooName;
     
    /**
     * Lists the names of pet objects in the zoo, from class Pet.
     */
    private ArrayList<Pet> petList;
    
    /**
     * Lists the types of pet objects in the zoo, from class Pet.
     */
    private ArrayList<String> petTypes;
    
    /**
     * Sets the zoo name from the driver call and initializes both ArrayLists as empty.
     * @param zooName The called name of the zoo from the driver class.
     */
    public PettingZoo (String zooName)
    {
        this.zooName = zooName;
        this.petList = new ArrayList<>();
        this.petTypes = new ArrayList<>();
    }
    
    /**
     * Sets the zoo name from the driver call and delegates the loadPetListFromCSV() method, from the called text file.
     * @param zooName The called name of the zoo, from the driver class.
     * @param csvPetFile The called name of the text file, for processing.
     * @throws FileNotFoundException: An error message indicating an non-existing file.
     */
    public PettingZoo (String zooName, String csvPetFile) throws FileNotFoundException
    {
        this.zooName = zooName;
        this.petList = new ArrayList<>();
        this.petTypes = new ArrayList<>();
        loadPetListFromCSVfile(csvPetFile);
    }

    /**
     * Reads every line from the CSV-formatted records in the text file and delegates the addPetInCSVformat() method, from the called text file.
     * @param csvPetFile The called name of the text file, for processing.
     * @throws FileNotFoundException: An error message indicating an non-existing file.
     */
    private void loadPetListFromCSVfile(String csvPetFile) throws FileNotFoundException 
    {
       File inputFile = new File(csvPetFile);
       
       if (!inputFile.exists())
       {
           System.out.println("Cannot open " + csvPetFile);
           System.out.println("The list of pets in the zoo remains unchanged!");
       }
       
       //create a Scanner object to read from inputFile
       Scanner fileScanner = new Scanner(inputFile);
       
       //read and process all the lines in the input file, if any
       while (fileScanner.hasNextLine())
       {
           String csvRecord = fileScanner.nextLine(); //read a CSV line
           
           //dissect the CSV line into values
           //create a pet object object, add it to this zoo's pet list
           addPetInCSVformat(csvRecord);
       } 
    }

    /**
     * Dissects the extracted record into five values and creates Pet objects that are added to the petList.
     * @param cvsPetRecord An extracted record from the called text file.
     */
    public void addPetInCSVformat(String cvsPetRecord)
    {
        cvsPetRecord = cvsPetRecord.trim();
        //split the line using delimiters defined by the pattern "\\s*, \\s*", which means
        //zero or more whitespace followed by a comma, followed by zero or more whitespace
        String[] values = cvsPetRecord.split("\\s*, \\s*"); //extract values separated by commas
        
        
        //interpret the extracted values
        String petType = values[0].trim().toLowerCase();
        String petName = values[1].trim();
        int petAge = Integer.parseInt(values[2].trim());
        char petGender = values[3].trim().charAt(0);
        String lastValue = values[4].trim();
        
        
            //if the pet type has not been encountered already, add it to the petType list
            if (! this.petTypes.contains(petType))
            {  
                this.petTypes.add(petType);      
            } 
            
            
           //create a Pet object according to the pet type and add it to the petList
           if (petType.equalsIgnoreCase("dog"))
           { 
               Pet p = new Dog(petName, petAge, petGender, lastValue);
               this.petList.add(p);
           }
            
           else if (petType.equalsIgnoreCase("cat"))
           {   
               boolean neutered = Boolean.valueOf(lastValue);
               Pet p = new Cat(petName, petAge, petGender, neutered);
               this.petList.add(p);
           }
           
           else if (petType.equalsIgnoreCase("duck"))
           {
                int eggs = Integer.parseInt(lastValue);
                Pet p = new Duck(petName, petAge, petGender, eggs);
                this.petList.add(p);
           }
        
    }

    /**
     * Returns the called name of the zoo.
     * @return The name of the zoo.
     */
    public String getName()
    {
        return this.zooName;
    }
    
    /**
     * Sets the zoo name, according to its called value.
     * @param name The name of the zoo.
     */
    public void setName (String name)
    {
        this.zooName = name;
    }

    /**
     * Returns the number of pet types from the petting zoo.
     * @return The number of pet types.
     */
    public int howManyPetTypes() 
    {
        return this.petTypes.size();
    }

    /**
     * Returns the total sum of the pets found in the given pet type.
     * @param petType The called name of the pet type.
     * @return The total number of pets from the specified pet type.
     */
    public int howMany(String petType) 
    {   
        int petSum = 0;
        
        for (Pet p : this.petList)
        {
            if (petType.equalsIgnoreCase("dog") && p instanceof Dog)
            {
               ++petSum;
            }
            
            else if (petType.equalsIgnoreCase("cat") && p instanceof Cat) 
            {
                ++petSum;
            }
            
            else if (petType.equalsIgnoreCase("duck") && p instanceof Duck) 
            {
                ++petSum;
            }    
        }
        
        return petSum;
    }
     
    /**
     * Returns the total number of pets in the entire Pet class.
     * @return The total number of pets in class Pet.
     */
    public int howManyPets() 
    {
         return this.petList.size();
    }

    /**
     * Counts and returns the number of female pets, from the entire petList.
     * @return The number of female pets in petList.
     */
    public int howManyFemalePets() 
    {
       int femalePets = 0;
       
        for (Pet p : this.petList) 
        {
            if (p.getGender() == 'F'|| p.getGender() == 'f')
            {
                femalePets++;
            }
        }
       
       return femalePets;
    }

    /**
     * Counts and returns the number of male pets, from the entire petList.
     * @return The number of male pets in petList.
     */
    public int howManyMalePets() 
    {
       int malePets = 0;
       
        for (Pet p : this.petList)
        {
            if (p.getGender() == 'M'|| p.getGender() == 'm')
            {
                malePets++;
            }
        }
       
       return malePets;
    }

    /**
     * Increments the age of every pet in the petList, by the called value in the driver class.
     * @param n The called value, to add to the original age of the pet.
     */
    public void growOlder(int n) 
    {
        if (n < 0)
        {
            System.out.println("Error: invalid incrementation value.");
        }   
         
        for (Pet p : this.petList)
        {
             for (int grow = 1; grow <= n; grow++) 
             {
                 p.growUp();
             }  
        }
    }
    
    /**
     * Removes all pet objects that are older than the called age in the method.
     * @param age The called retired age of every pet.
     * @return The ArrayList of the pets that are chosen to be removed.
     */
    public ArrayList<Pet> retire(int age) 
    {
       ArrayList<Pet> retiredPets = new ArrayList<>(this.petList);
       ArrayList<Pet> youngPets = new ArrayList<>(this.petList);
       
       for (Pet p : this.petList)
       { 
           if (p.getAge() < age)
           { 
               retiredPets.remove(p);
           }   
           
           else if (p.getAge() >= age)
           {
               youngPets.remove(p);
           }
       }
       
       this.petList = youngPets;
       
       return retiredPets;
    }

    /**
     * Writes all the pets located in petList, to a called file name.
     * @param fileName The called name of a specific file.
     * @throws java.io.FileNotFoundException: An error message indicating an non-existing file.
     */
    public void outputCSV(String fileName) throws IOException 
    {
        
        FileOutputStream fos = new FileOutputStream(fileName);
        PrintWriter pw = new PrintWriter(fos);
        
        for (Pet p : this.petList)
        { 
            if (p instanceof Dog)
            {
                if (p.getGender() == 'F' || p.getGender() == 'f')
                {
                    pw.printf("%s, %s, %d, %s, %s", "dog", p.getName(), p.getAge(), "female", ((Dog)p).getSize());
                    pw.println();
                }
                
                else
                {
                    pw.printf("%s, %s, %d, %s, %s", "dog", p.getName(), p.getAge(), "male", ((Dog)p).getSize());
                    pw.println();
                }              
            }
            
            else if (p instanceof Cat)
            {
                if (p.getGender() == 'F' || p.getGender() == 'f')
                {
                    pw.printf("%s, %s, %d, %s, %b", "cat", p.getName(), p.getAge(), "female", ((Cat)p).isNeutered());
                    pw.println();
                }
                
                else
                {
                    pw.printf("%s, %s, %d, %s, %b", "cat", p.getName(), p.getAge(), "male", ((Cat)p).isNeutered());
                    pw.println();
                }
            }
            
            else if (p instanceof Duck)
            {
                if (p.getGender() == 'F' || p.getGender() == 'f')
                {
                    pw.printf("%s, %s, %d, %s, %d", "duck", p.getName(), p.getAge(), "female", ((Duck)p).getEggs());
                    pw.println();
                }
                
                else
                {
                    pw.printf("%s, %s, %d, %s, %d", "duck", p.getName(), p.getAge(), "male", ((Duck)p).getEggs());
                    pw.println();
                }
            }
        }
            
        pw.flush();
        pw.close();
        
       
       System.out.println("Successfully created the file: " + fileName);
       
    }
    
     /**
     * Prints the informational representations of all pets in the petting zoo, one pet per line.
     * @return The informational statements about each pet in the list.
     */
    @Override
    public String toString()
    { 
       String result = "";
       
       if (this.petList.isEmpty())
       {
          result += "List of pets at " + getName() + ". \n";
          result += "\n";
          result += getName() + " is empty." + "\n";    
       }
       
       else
       {
            for (int symbol = 1; symbol < 75; symbol++)
            {
                result += "=";
            }
       
            result += "\n";
       
            
            result += "List of pets at " + getName() + "\n";
            
            
            for (int symbol = 1; symbol < 75; symbol++)
            {
                result += ".";
            }
       
            
            result += "\n";
       
       
            int petNumber = 1;
            
             for (Pet p : this.petList)
             {
                result += petNumber++ + " " + p.toString() + "\n";
             }  
         
       
             for (int symbol = 1; symbol < 75; symbol++)
             {
                 result += "=";
             }
       
       }
       
          return result;
    }
    
    /**
     * Returns true if the variables name, age, gender, zooName, petList and petTypes are all equal to the other variables.
     * @param other The other PettingZoo object.
     * @return True, if all the instance variables in the super class and PettingZoo class are equal to the other variables.
     */
    @Override
    public boolean equals(Object other)
    {
        if (other == null)
        {
            return false;
        }
        
        if(! (other instanceof PettingZoo))
        {
            return false;
        }
        
        PettingZoo zoo = (PettingZoo) other;
        
        return this.zooName.equals(zoo.zooName)
               && this.petList.size() == zoo.petList.size() 
               && this.petTypes.size() == zoo.petTypes.size(); 
    }
    
    
}
