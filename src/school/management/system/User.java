/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.system;

import java.util.Arrays;

/**
 *
 * @author Brian_Gicharu
 */
public class User {
    
    String utype;
    private String[] uPriviliege = {"N","N","N","N","N"}; 
    
    public User(String utype, String[] privilieges){
        this.utype = utype;
        if(Arrays.toString(privilieges).isEmpty()){
        }else{
            this.uPriviliege = privilieges;
        }
    }
    
    public User(){
        
    }
    
    public String getUserType(){
        return utype;
    }
    public void setPrivilieges(){
        if(utype.equalsIgnoreCase("student")){
            // This is a student
        }else if(utype.equalsIgnoreCase("admin")){
            // This is the admin
        }else if(utype.equalsIgnoreCase("principal")){
            // This is the principal
        }else if(utype.equalsIgnoreCase("admin")){
            // This is the admin. Grant all rights
        }else{
            // User not recognized
        }
    }
    
    public void showPriv_(){
        System.out.println(Arrays.toString(uPriviliege));
    }
}
