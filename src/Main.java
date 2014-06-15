/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WILLY
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import Database.Database;

public class Main {
   public static void main(String args[]) {
      try {
		  Database db = new Database();
		  Connection c = db.openConnection();
	  } catch (Exception e) {
		  
	  }
   }
}
