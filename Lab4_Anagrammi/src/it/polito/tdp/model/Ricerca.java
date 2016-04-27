package it.polito.tdp.model;

import java.util.*;

import it.polito.tdp.db.ParolaDAO;

public class Ricerca 
{
	int pos;
	List<String>soluzioni = new ArrayList<String>();
	
	
	public List<String> getSoluzioni() 
	{
		return soluzioni;
	}

	public void doPermutazioni(String parola)
	{
		pos = 0;
		cerca(parola, pos);
	}
	
	public void cerca(String p, int pos)
	{
		if(pos == p.length())
		{
			if(!soluzioni.contains(p.toString()))
			{
				soluzioni.add(p.toString());
			}
		}
		else
		{
			for (int i = pos; i < p.length(); i++)
			{
				char[] c = p.toCharArray();
				char temp = c[i];
				c[i] = c[pos];
				c[pos] = temp;
				cerca(String.copyValueOf(c), pos+1);
					
			}
		}
	}
	
	public List<Parola> getParoleDatabase(List<String> sol)
	{
		ParolaDAO pdao = new ParolaDAO();
		return pdao.getParole(sol);
	}
}
