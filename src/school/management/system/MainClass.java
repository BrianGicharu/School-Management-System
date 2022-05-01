/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.system;

import java.sql.Connection;

import javax.swing.JFrame;


public class MainClass extends JFrame{
    
    // My variables
    public static SignUpForm sign;
    public static LoginWindow login;
    
    static boolean setup_ = false;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static Connection con;
    
    public static void main(String[] arg0){
        logInForm();
    }
    
    // Creates the login form JFrame. To be called at startup
    public static void logInForm(){
        login = new LoginWindow();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setLocation(500, 200);
        login.setVisible(true);
    }
    
    // Called after successful login.
    public static void logIn(String user){
        if(user.equalsIgnoreCase("teacher")){
            
        }else if(user.equalsIgnoreCase("student")){
            
        }else if(user.equalsIgnoreCase("principal")){
            
        }else if(user.equalsIgnoreCase("admin")){
            
        }
    }
    
    // Calls the Registration form
    public static void signUpForm(){
        sign = new SignUpForm();
        sign.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sign.setLocation(login.getX(),login.getY());
        sign.setVisible(true);
    }
    
    public static JFrame killFrame(){
        System.out.println("I was summoned to destroy a frame");
        return sign;
    }
}
