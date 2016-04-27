package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

import it.polito.tdp.model.Parola;

public class ParolaDAO 
{
	public List<Parola> getParole(List<String> anagrammi)
	{
		List<Parola> parole = new ArrayList<Parola>();
		Connection conn = DBConnect.getConnection();
		try
		{
			for (String string : anagrammi)
			{
				String sql = "select * from parola where nome = ?";
				PreparedStatement ps;
				ps = conn.prepareStatement(sql);
				ps.setString(1, string);
				ResultSet res = ps.executeQuery();
				if(res.next())
				{
					int id = Integer.parseInt(res.getString("id"));
					String parola = res.getString("nome");
					parole.add(new Parola(parola, id));
					res.close();
				}	
			}
			conn.close();
			return parole;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
			
		
	}
}
