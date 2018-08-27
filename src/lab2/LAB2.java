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
                String gender = line[2];
                String age = line[3];
                String phoneNumber = line[4];
                String email = line[5];
                
                
                if(validateName(firstName) == false) {
                    System.out.println("ERROR UNVALID FIRST NAME: " + firstName );
                    continue;
                }
                else if(validateName(lastName) == false) {
                    System.out.println("ERROR UNVALID LAST NAME: " + lastName );
                    continue;
                }
                 else if(validateGender(gender) == false) {
                    System.out.println("ERROR UNVALID GENDER: " + gender );
                    continue;
                }
                 else if(validateName(age) == false) {
                    System.out.println("ERROR UNVALID AGE: " + age );
                    continue;
                }
                else if(validateName(phoneNumber) == false) {
                    System.out.println("ERROR UNVALID PHONENUMBER: " + phoneNumber );
                    continue;
                }
                
                records[currentIndex] = String.format("%-20s%-20s%-10s%-4s%-15s%-20s", firstName, lastName, gender, age, phoneNumber, email);
                currentIndex++;
                
            }
       
        }
        catch(FileNotFoundException ex) {
            System.err.println("Could not find input file");
        }
        
        
       
       
        for(int i = 0; i < records.length; i++) {
            System.out.println(records[i]);
        }
        
        return;
        
    }
    
    public static boolean validateName(String name) {
        
        char[] nameArr = name.toCharArray();
        for(int i = 0; i < name.length(); i++ ) {
            if(Character.isDigit(nameArr[i])) {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean validateGender(String gender) {
        if(gender.equalsIgnoreCase("male") == true || gender.equalsIgnoreCase("female") == true) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public static boolean validateAge(String age) {
        
        int ageInt = Integer.parseInt(age);
        
        return 1 <= ageInt && ageInt <= 130;
      
    }
    
    public static boolean validatePhoneNumber(String phoneNumber) {
        
     
   
        char[] phoneNumberArr = phoneNumber.toCharArray();
        int countDigits = 0;
        
        for(int i = 0; i < phoneNumberArr.length; i++) {
            if(Character.isDigit(phoneNumberArr[i])) {
                countDigits += 1;
            }
        }
        
        return countDigits == 10;
    }
    
    public static boolean validateEmail(String email) {
        //FINISH LATER.
        return true;
    }
}
