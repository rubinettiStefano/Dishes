package com.generation.dishes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.dishes.model.dao.MockDishDAO;
import com.generation.dishes.model.entities.Dish;

@RestController
public class DishController
{
	@Autowired
	MockDishDAO dao;
	
	@GetMapping("/dishes")
	List<Dish> getAll()
	{
		return dao.getAll();
	}
	
	@GetMapping("/dishes/{id}")
	Dish getAll(@PathVariable String id)
	{
		return dao.get(id);
	}
	
	@PostMapping("/dishes")
	Dish insert(@RequestBody Dish dish)
	{
		dao.insert(dish);
		return dish;
	}
	
	@DeleteMapping("/dishes/{id}")
	Dish delete(@PathVariable String id)
	{
		return dao.delete(id);
	}
	
	@PutMapping("/dishes/{id}")
	Dish update(@PathVariable String id, @RequestBody Dish newVersion)
	{
		return dao.update(id,newVersion);
	}
}
