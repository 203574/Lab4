package it.polito.tdp.model;

public class Parola
{
	private String parola;
	private int id;
	
	public Parola(String parola, int id) 
	{
		this.parola = parola;
		this.id = id;
	}

	public String getParola() 
	{
		return parola;
	}

	public void setParola(String parola) 
	{
		this.parola = parola;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parola other = (Parola) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
