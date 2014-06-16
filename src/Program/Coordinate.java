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
public class Coordinate {
	public double x;
	public double y;
	public double xEnd;
	public double yEnd;
	public static final int DELTA = 1;
	public Coordinate (double x, double y) {
		this.x = x;
		this.y = y;
		this.xEnd = x + DELTA;
		this.yEnd = y + DELTA;
		
	}
}
