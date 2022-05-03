/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Brian_Gicharu
 */
public class Query {
    private static String uname, pwd, url;
    private static Connection con;
    public Query(String uname, String pwd, String url){
        this.uname = uname;
        this.pwd = pwd;
        this.url = url;
    }
    /* 
    * The deleteDB method deletes a database from the workspace. Attention should be paid
    * to the usage of this method as its critical to the entire database infrastructure*/
    private static void deleteDB(String database, Connection conn){
        try{
            conn.prepareStatement("DROP DATABASE "+database).execute();
        }catch(SQLException e){System.err.println(e);}
    }
    
    // Fires up the database connection
    public static void setup(String database){
        try{
            con = DriverManager.getConnection(url,uname,pwd);
            createDB(database,con);
        }catch(SQLException e){System.err.println(e);}
    }
    
    // Creates a new database
    public static void createDB(String database, Connection conn){
        try{
            conn.prepareStatement("CREATE DATABASE IF NOT EXISTS "+database+";").execute();
        }catch(SQLException e){System.err.println(e);}
    }
    
    // Creates a table on the current database. Takes 'Table Name', 'Columns[]', 'Connection Object' as parameters.
    public static void createTable(String table, String[] columns, Connection conn) {
        try{
            conn.prepareStatement("USE SCHOOL;CREATE TABLE IF NOT EXISTS "+table+
                "("+String.join(", ",columns)+");").execute();
        }catch(SQLException e){System.err.println(e);}
    }
    
    // Deletes a table from the current database. Takes 'Table Name', 'Connection Object as the parameters'.
    public static void dropTable(String table, Connection conn) {
        try{
            conn.prepareStatement("USE SCHOOL;DROP TABLE "+table+";").execute();
        }catch(SQLException e){System.err.println(e);}
    }
    
    // Modifies the table schema/columns. Takes 'Table Name', 'Columns[]', 'Connection Object' as the parameters.
    public static void alterTable(String table, String[] columns, Connection conn){
        try{
            conn.prepareStatement("USE SCHOOL;ALTER TABLE "+table+"("+String.join(", ", columns)+";").execute();
        }catch(SQLException e){System.err.println(e);}
    }
    
    // Creates a new User to the database. User privilieges to be added later
    public static void createUser(String uname, String pwd, Connection conn){
        System.out.println("Do nothing!@");
    }
    
    // Deletes a record from a table created in the current database.
    public static void deleteRecord(String userId, String table, Connection conn){
        try{
            conn.prepareStatement("USE SCHOOL;DELETE "+userId+" FROM "+table+";");
        }catch(SQLException e){System.err.println(e);}
    }
    
    // Removes all records from a table
    public static void truncateTable(String table, Connection conn){
        try{
            conn.prepareStatement("USE SCHOOL;TRUNCATE TABLE "+table+";").execute();
        }catch(SQLException e){System.err.println(e);}
    }
    
    // Adds records into a table from the current database.
    public static void addRecord(String table, String[] values, Connection conn){     
        String qMarks = "";
        PreparedStatement ps;
        for(String str:values)qMarks+="?,";
        try{
            ps = conn.prepareStatement("USE SCHOOL;INSERT INTO "+table+" VALUES("+qMarks+");");            
            for(int i=1;i<=values.length;i++){
                if(Validate.isNumeric(values[i])){
                    ps.setInt(i, Integer.parseInt(values[i]));
                }else if(Validate.isDouble(values[i])){
                    ps.setDouble(i, Double.parseDouble(values[i]));
                }else{
                    ps.setString(i, values[i]);
                }
            }
            ps.execute();
        }catch(SQLException e){System.err.println(e);}
    }    
}
