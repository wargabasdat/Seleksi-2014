/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import Exception.ConnectionNotStartedException;
import Exception.NullSqlStatementException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author WILLY
 */
public class Database {
	private Connection connection;
	private Statement statement;
	private final String USERNAME = "postgres";
	private final String PASSWORD = "123456";
	public Database() {
		connection = null;
		statement = null;
	}
	
	public Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",USERNAME, PASSWORD);
		statement = connection.createStatement();
		return connection;
//			String sql = "CREATE TABLE IF NOT EXISTS COMPANY " +
//                      "(ID INT PRIMARY KEY     NOT NULL," +
//                      " NAME           GEOMETRY    NOT NULL)";
	}
	
	public int executeQuery(String query) throws ConnectionNotStartedException, NullSqlStatementException, SQLException{
		if (connection == null) throw new ConnectionNotStartedException();
		if (statement == null) throw new NullSqlStatementException();
		//else
		return statement.executeUpdate(query);
	}
	
	public void closeConnection() throws ConnectionNotStartedException, NullSqlStatementException, SQLException {
		if (connection == null) throw new ConnectionNotStartedException();
		if (statement == null) throw new NullSqlStatementException();
		statement.close();
		connection.close();
	}
}
