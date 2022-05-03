/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.system;

/**
 *
 * @author Brian_Gicharu
 */
abstract class Validate {
    
    // Checks if a String Object can be converted to an integer value.
    public static boolean isNumeric(String string){
        return string.matches("\\d+");
    }
    
    // Checks if a String Object can be converted to a double value.
    public static boolean isDouble(String string){
        return string.matches("\\d+.\\d+");
    }
    
    //Checks if a String Object is an email
    public static Boolean isEmail(String string){
        return string.matches("\\w+@\\w+.\\w+");
    }
}
