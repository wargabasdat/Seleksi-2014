/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package petaitb;
import java.lang.Exception.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.swing.UIManager.getString;
import org.postgresql.*;
/**
 *
 * @author Gifari Kautsar
 */
public class PetaITB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.sql.Connection conn; 
        try { 
          /* 
          * Load the JDBC driver and establish a connection. 
          */
          Class.forName("org.postgresql.Driver"); 
          String url = "jdbc:postgresql://localhost:5432/Peta_ITB"; 
          conn = DriverManager.getConnection(url, "postgres", "basdat"); 
           int i = 0;
           String loc1 ="null";
           String loc2 = "null";
            try (Statement s = conn.createStatement()) {
                ResultSet r = s.executeQuery("SELECT ST_AsText(geom) FROM gedung WHERE nama = 'Labtek_8'");
                while( r.next() ) {
                    loc1 = r.getString("st_astext");
                    System.out.println(loc1);
                }
                r = s.executeQuery("SELECT ST_AsText(geom) FROM gedung WHERE nama = 'GKU_Timur'");
                while( r.next() ) {
                    loc2  = r.getString("st_astext");
                    System.out.println(loc2);
                }
               r = s.executeQuery( "SELECT ST_Distance(ST_GeometryFromText('" + loc1 + "'),ST_GeometryFromText('" + loc2 + "'))");
               while( r.next() ) {
                    System.out.println(r.getString("st_distance"));
                }
            } 
            
            
            
          conn.close(); 
          
        } 
      catch( ClassNotFoundException | SQLException e ) { 
      }
    }
}