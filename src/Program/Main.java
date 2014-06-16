package Program;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WILLY
 */
import Database.Database;
import Exception.ConnectionNotStartedException;
import Exception.NullSqlStatementException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
   public static void main(String args[]) {
		Database db = null;
		Connection c = null;
		Scanner in = new Scanner(System.in);
		try {
			db = new Database();
			c = db.openConnection();
			System.out.println("Masukkan koordinat x: ");
			double x = in.nextDouble();
			System.out.println("Masukkan koordinat y: ");
			double y = in.nextDouble();
			Coordinate coordinate = new Coordinate(x,y);
			Polygon polygon = new Polygon(coordinate);
			String sql = "INSERT INTO \"virus\" (titik, pergerakan, daerah) "
						+ "VALUES ('POINT("+coordinate.x+" "+coordinate.y+")',"
						//+ "'LINESTRING(" + coordinate.x + " " + coordinate.y +", " + coordinate.xEnd + " " + coordinate.yEnd + ")')";
					    + "'LINESTRING(" + coordinate.x + " " + coordinate.y +", " + coordinate.xEnd + " " + coordinate.yEnd + ")',"
					    + "'POLYGON((" + polygon.titik[0].x + " " + polygon.titik[0].y + ", " + polygon.titik[1].x + " " + polygon.titik[1].y + ", " + polygon.titik[2].x + " " + polygon.titik[2].y + ", " + polygon.titik[3].x + " " + polygon.titik[3].y + ", " + polygon.titik[0].x + " " + polygon.titik[0].y + "))')";
			db.executeQuery(sql);
		} catch (Exception e) {
		  System.err.println(e.getMessage());
		} finally {
		   try {
			   if (db != null) db.closeConnection();
		   } catch (ConnectionNotStartedException | NullSqlStatementException | SQLException e) {
		   //pasrah, cant do nothing
		   }
		}
   }
}
