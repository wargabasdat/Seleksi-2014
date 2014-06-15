/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exception;

/**
 *
 * @author WILLY
 */
public class ConnectionNotStartedException extends Exception {
	public ConnectionNotStartedException() {
		super("Connection have not started yet");
	}
}
