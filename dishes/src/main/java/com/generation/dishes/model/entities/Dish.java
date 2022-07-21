package com.generation.dishes.model.entities;

public class Dish
{

	private String ID,name;
	private int carbs,fats,proteins;
	
	public Dish()
	{
		
	}
	
	public String getID()
	{
		return ID;
	}
	public void setID(String ID)
	{
		this.ID = ID;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getCarbs()
	{
		return carbs;
	}
	public void setCarbs(int carbs)
	{
		this.carbs = carbs;
	}
	public int getFats()
	{
		return fats;
	}
	public void setFats(int fats)
	{
		this.fats = fats;
	}
	public int getProteins()
	{
		return proteins;
	}
	public void setProteins(int proteins)
	{
		this.proteins = proteins;
	}
	
}
