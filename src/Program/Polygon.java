/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Program;

/**
 *
 * @author WILLY
 */
public class Polygon {
	public Coordinate[] titik;
	private static int DELTAAREA = 5;
	public Polygon (Coordinate c) {
		titik = new Coordinate[4];
		titik[0] = new Coordinate(c.x - DELTAAREA,c.y - DELTAAREA);
		titik[1] = new Coordinate(c.x - DELTAAREA,c.y + DELTAAREA);
		titik[2] = new Coordinate(c.x + DELTAAREA,c.y + DELTAAREA);
		titik[3] = new Coordinate(c.x + DELTAAREA,c.y - DELTAAREA);
	}
}
