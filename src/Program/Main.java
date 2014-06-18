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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
   public static void main(String args[]) {
		Database db = null;
		Connection c = null;
		Scanner in = new Scanner(System.in);
		String kotaSekarang = null;
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
			//db.executeUpdate(sql);
			
			//titik
			String sqlKota = "SELECT kota.namakota FROM kota WHERE ST_contains(kota.koordinat, 'POINT("+ coordinate.x+" " + coordinate.y + ")')";
			ResultSet rs = db.executeQuery(sqlKota);
			if (rs != null) {
				boolean perbatasan = true;
				while(rs.next()) {
					perbatasan = false;
					kotaSekarang = rs.getString(1);
					System.out.println("Virus tersebut berada di kota " + kotaSekarang);
				}
				
				
				if(perbatasan) {
					String sqlPinggiranKota = "SELECT kota.namakota FROM kota WHERE ST_TOUCHES(kota.koordinat, 'POINT("+ coordinate.x+" " + coordinate.y + ")')";
					rs = db.executeQuery(sqlPinggiranKota);
					String[] sarr = new String[4];
					int i = 0;
					while(rs.next()) {
						sarr[i] = rs.getString(1);
						++i;
					}
					if (sarr[3] == null)
						System.out.println("Virus tersebut berada di perbatasan kota " + sarr[0] + " dan " + sarr[1]);
					else
						System.out.println("Virus tersebut berada di perbatasan kota " + sarr[0] + ", " + sarr[1] + ", " + sarr[2] + ", dan " + sarr[3]);
				}
			}
			
			//line
			String sqlGaris = "SELECT kota.namakota FROM kota WHERE ST_CROSSES(kota.koordinat, 'LINESTRING("+ coordinate.x+" " + coordinate.y + ", " + coordinate.xEnd + " " + coordinate.yEnd + ")')";
			rs = db.executeQuery(sqlGaris);
			if (rs!= null) {
				List<String> town = new ArrayList<String>();
				while(rs.next()) {
					town.add(rs.getString(1));
				}
				if(town.contains(kotaSekarang)) town.remove(kotaSekarang);
				if(town.size() > 0) System.out.println("Virus berpotensi bergerak ke kota " + town.get(0));
			}
			
			//line
			String sqlArea = "SELECT kota.namakota FROM kota WHERE ST_OVERLAPS(kota.koordinat, 'POLYGON((" + polygon.titik[0].x + " " + polygon.titik[0].y + ", " + polygon.titik[1].x + " " + polygon.titik[1].y + ", " + polygon.titik[2].x + " " + polygon.titik[2].y + ", " + polygon.titik[3].x + " " + polygon.titik[3].y + ", " + polygon.titik[0].x + " " + polygon.titik[0].y + "))')";
			rs = db.executeQuery(sqlArea);
			if (rs!= null) {
				List<String> town = new ArrayList<String>();
				while(rs.next()) {
					town.add(rs.getString(1));
				}
				if(town.contains(kotaSekarang)) town.remove(kotaSekarang);
				if(town.size() > 0) {
					System.out.println("Virus berpotensi menyebar ke kota: ");
					for(String s : town) {
						System.out.println(s);
					}
				}
			}
			
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
