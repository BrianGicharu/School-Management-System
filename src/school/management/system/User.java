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
public class User {
    
    String utype;
    public User(String utype){
        this.utype = utype;
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
}
