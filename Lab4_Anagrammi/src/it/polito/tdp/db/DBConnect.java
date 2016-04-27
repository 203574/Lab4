package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect 
{
	private static final String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root&password=root";
	public static Connection getConnection()
	{
		try
		{
			Connection conn = DriverManager.getConnection(jdbcURL);
			return conn;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("Errore nella connessione", e);
		}
	}
}
