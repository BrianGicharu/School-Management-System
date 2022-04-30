/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.system;

//import com.mysql.jdbc.Driver;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;


public class MainClass extends JFrame{
    
    // My variables
    public static SignUpForm sign;
    
    static boolean setup_ = false;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static Connection con;
    
    public static void main(String[] arg0){
        setup("SCHOOL");
        logInForm();
    }
    
    public static void setup(String database){
        try{
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            createDB(database,con);
        }catch(SQLException e){System.err.println(e+"001");}
    }
    
    private static void createDB(String database, Connection conn){
        try{
            conn.prepareStatement("CREATE DATABASE IF NOT EXISTS "+database).execute();
        }catch(SQLException e){System.err.println(e);}
    }
    
    // Creates a table on the current database. Takes 'Table Name', 'Columns[]', 'Connection Object' as parameters.
    private static void createTable(String table, String[] columns, Connection conn) {
        try{
            conn.prepareStatement("USE SCHOOL;CREATE TABLE IF NOT EXISTS "+table+
                "("+String.join(", ",columns)+");").execute();
        }catch(SQLException e){System.err.println(e);}
    }
    
    // Deletes a table from the current database. Takes 'Table Name', 'Connection Object as the parameters'.
    private static void dropTable(String table, Connection conn) {
        try{
            conn.prepareStatement("USE SCHOOL;DROP TABLE "+table).execute();
        }catch(SQLException e){System.err.println(e);}
    }
    
    // Modifies the table schema/columns. Takes 'Table Name', 'Columns[]', 'Connection Object' as the parameters.
    private static void alterTable(String table, String[] columns, Connection conn){
        try{
            conn.prepareStatement("USE SCHOOL;ALTER TABLE "+table+"("+String.join(", ", columns)).execute();
        }catch(SQLException e){System.err.println(e);}
    }
    
    // Creates a new User to the database. User privilieges to be added later
    private static void createUser(String uname, String pwd, Connection conn){
        System.out.println("Do nothing!@");
    }
    
    // Deletes a record from a table created in the current database.
    private static void deleteRecord(String userId, String table, Connection conn){
        try{
            conn.prepareStatement("USE SCHOOL;DELETE "+userId+" FROM "+table);
        }catch(SQLException e){System.err.println(e);}
    }
    
    // Adds records into a table from the current database.
    private static void addRecord(String table, String[] values, Connection conn){     
        String qMarks = "";
        PreparedStatement ps;
        for(String str:values)qMarks+="?,";
        try{
            ps = conn.prepareStatement("USE SCHOOL;INSERT INTO "+table+" VALUES("+qMarks+");");            
            for(int i=1;i<=values.length;i++){
                if(isNumeric(values[i])){
                    ps.setInt(i, Integer.parseInt(values[i]));
                }else if(isDouble(values[i])){
                    ps.setDouble(i, Double.parseDouble(values[i]));
                }else{
                    ps.setString(i, values[i]);
                }
            }
            ps.execute();
        }catch(SQLException e){System.err.println(e);}
    }
    
    // Checks if a String Object can be converted to an integer value.
    private static boolean isNumeric(String string){
        return string.matches("\\d+");
    }
    
    // Checks if a String Object can be converted to a double value.
    private static boolean isDouble(String string){
        return string.matches("\\d+.\\d+");
    }
    
    /* 
    * The deleteDB method deletes a database from the workspace. Attention should be paid
    * to the usage of this method as its critical to the entire database infrastructure*/
    private static void deleteDB(String database, Connection conn){
        try{
            conn.prepareStatement("DROP DATABASE "+database).execute();
        }catch(SQLException e){System.err.println(e);}
    }
    
    // Creates the login form JFrame. To be called at startup
    public static void logInForm(){
        LoginWindow login = new LoginWindow();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setLocation(500, 200);
        login.setVisible(true);
    }
    
    // Called after successful login.
    public static void logIn(String user){
        if(user.equalsIgnoreCase("teacher")){
            String q = "SELECT "+user+" FROM TEACHERS";
            
        }else if(user.equalsIgnoreCase("student")){
            
        }else if(user.equalsIgnoreCase("principal")){
            
        }else if(user.equalsIgnoreCase("admin")){
            
        }
    }
    
    // Calls the Registration form
    public static void signUpForm(){
        sign = new SignUpForm();
        sign.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sign.setVisible(true);
    }
    
    public static void destroySignUp(){
        sign.dispose();
    }
}
