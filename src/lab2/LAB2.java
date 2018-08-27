package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author mrjones4
 */
public class LAB2 {


    public static void main(String[] args) {
        
        String[] records = new String[100];
        
        try {
            Scanner reader = new Scanner(new File(args[0]));
            int currentIndex = 0;
            
            while(reader.hasNext()) {
                
                String[] line = reader.nextLine().split(",");
                
                String firstName = line[0];
                String lastName = line[1];
                String male = line[2];
                String age = line[3];
                String phoneNumber = line[4];
                String email = line[5];
                
                records[currentIndex] = String.format("%-20s %-20s %-10s %10d %10s %20s", firstName, lastName, male, age, phoneNumber, email);
                currentIndex++;
                
            }
       
        }
        catch(FileNotFoundException ex) {
            System.err.println("Could not find input file");
        }
        
    }
    
}
