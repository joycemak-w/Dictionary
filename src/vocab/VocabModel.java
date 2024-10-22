/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocab;

import java.sql.*;
import java.sql.Statement;

/**
 *
 * @author joyce
 */
public class VocabModel {
    
    VocabController control;
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
	
	public void setController(VocabController c) {
        this.control = c;
    }

       
    public boolean add(String word, String meaning, String word_class) {
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT into vocab_table values (?,?,?)");
            stmt.setString(1, word);
            stmt.setString(2, meaning);
            stmt.setString(3, word_class);
            stmt.execute();
            return true;
//            System.out.println("Record added: " + word + " : " + meaning);

        } catch (Exception sqlex) {
//            System.out.println(sqlex.getMessage());
//            System.out.println("Add Command not successful:" + word + " " + meaning + " " + word_class);
            return false;

        }
    }

    public boolean delete(String word) {
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE from vocab_table where entry = ?");
            stmt.setString(1, word);
            stmt.execute();
//            System.out.println("Record deleted: " + word);
            return true;

        } catch (Exception sqlex) {
//            System.out.println("Delete Command not successful");
            return false;
        }
    }

//    public String lookup(String word) {
//        return dict.get(word);
//    
        public VocabData lookup(String word) {

        try {

            PreparedStatement stmt = connection.prepareStatement("SELECT meaning, word_class FROM vocab_table where entry = ?");

            stmt.setString(1, word);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String meaning = rs.getString(1);
                String word_class = rs.getString(2);
                VocabData vd = new VocabData(word, meaning, word_class);
 //               return (meaning); //改做return vd
                return vd;
            } else {
                return null;
            }
            
        } catch (Exception sqlex) {
            sqlex.printStackTrace();
            System.exit(1);
        }
        return null;
    }
        
    void setupDBConnection() {

        // Step 1: Load Database Driver CLass        
        try {
            Class.forName("org.sqlite.JDBC"); //SQLite
        } catch (ClassNotFoundException cnfex) {
            System.out.println("Problem in loading or registering SQLite JDBC driver");
            cnfex.printStackTrace();
        }

        // Step 2: Opening database connection
        try {
            String dbURL = "jdbc:sqlite:vocab.db";

            // Step 2.A: Create and get connection using DriverManager class
            connection = DriverManager.getConnection(dbURL);

            // Step 2.B: Creating JDBC Statement 
            statement = connection.createStatement();

        // Step 3: Creating a table for holding the data *if it does not exist already*
            String sql = "CREATE TABLE IF NOT EXISTS vocab_table (\n"
                    + "	entry text PRIMARY KEY,\n"
                    + "	meaning text,\n"
                    + " word_class text\n"
                    + ");";

            statement.execute(sql);

        } catch (Exception sqlex) {
            sqlex.printStackTrace();
            System.out.println("Open database error");
        }
    }
        
    void closeDB() {
        try {
            connection.close();
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }

}
