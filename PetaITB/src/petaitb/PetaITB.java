/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package petaitb;
import java.io.IOException;
import java.lang.Exception.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import static javax.swing.UIManager.getString;
import org.postgresql.*;
import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FeatureSource;
import org.geotools.data.Query;
/**
 *
 * @author Gifari Kautsar
 */
public class PetaITB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Map params = new HashMap();
        params.put("dbtype", "postgis");        //must be postgis
        params.put("host", "localhost");        //the name or ip address of the machine running PostGIS
        params.put("port", new Integer(5432));  //the port that PostGIS is running on (generally 5432)
        params.put("database", "Peta_ITB");      //the name of the database to connect to.
        params.put("user", "postgres");         //the user to connect with
        params.put("passwd", "basdat");               //the password of the user.

        DataStore pgDatastore = DataStoreFinder.getDataStore(params);
        FeatureSource fsBC = pgDatastore.getFeatureSource("geom");

        System.out.println("bc count: " + fsBC.getCount(Query.ALL));
        
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