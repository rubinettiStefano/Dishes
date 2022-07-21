package com.generation.dishes.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.generation.dishes.model.entities.Dish;

//Specializzazione di @Component, ""EREDITA"" Component
//Lo offre direttamente come BEAN
//CI SONO MOLTI MODI
@Repository
public class MockDishDAO
{

	private List<Dish> dishes = new ArrayList<Dish>();
	
	public MockDishDAO()
	{
		Dish kebab = new Dish();
		kebab.setID("DISH01");
		kebab.setName("Kebab");
		kebab.setCarbs(50);
		kebab.setProteins(60);
		kebab.setFats(30);
		dishes.add(kebab);
		
		Dish amatriciana = new Dish();
		amatriciana.setID("DISH02");
		amatriciana.setName("Amatriciana");
		amatriciana.setCarbs(80);
		amatriciana.setProteins(20);
		amatriciana.setFats(10);
		dishes.add(amatriciana);
		
		Dish insalata = new Dish();
		insalata.setID("DISH03");
		insalata.setName("Insalata");
		insalata.setCarbs(0);
		insalata.setProteins(0);
		insalata.setFats(5);
		dishes.add(insalata);
	}
	
	public Dish get(String ID)
	{
		for(Dish d : dishes)
			if(d.getID().equals(ID))
				return d;
		return null;
	}
	
	public List<Dish> getAll()
	{
		return dishes;
	}
	
	public void insert(Dish dish)
	{
		dishes.add(dish);
	}
	
	public Dish delete(String ID)
	{
		Dish toDelete = get(ID);
		dishes.remove(toDelete);
		return toDelete;
	}

	public Dish update(String id, Dish newVersion)
	{
		newVersion.setID(id);
		delete(id);
		insert(newVersion);
		return newVersion;
	}
}
