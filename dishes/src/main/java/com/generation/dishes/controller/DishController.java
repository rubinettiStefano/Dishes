package com.generation.dishes.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	
	// ResponseEntity<X> dove X è qualunque cosa possa mettere al suo interno
	// Fatta così si legge "crea una response a partire da un oggetto, da qualunque oggetto"
	// il corpo viene JSONIZZATO
	// Una response è costituita da una serie di header (fra cui lo status code)
	// e da un corpo
	@GetMapping("/dishes/{id}")
	ResponseEntity<Object> getAll(@PathVariable String id)
	{
		Dish res =dao.get(id);
		if(res!=null)
			return ResponseEntity.status(HttpStatus.OK).body(res);
			// Crea una response con status = ok (200) e corpo creato a partire da un DISH (res instanceof Dish)
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't find dish with ID "+id);
			// Crea una response con status = 404, e corpo creato jsonizzando una String
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
	
	//catch(Exception e)
	//{
		
	//} QUesto metodo gestisce tutte le eccezioni che si verificano in questa classe
	// la e contiene tutti i dati dell'errore
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> exceptionHandler(Exception e)
	{
		// Io sono Spring Boot, con sotto Spring MVC, con sotto le Servlet
		String exceptionClassName = e.getClass().getSimpleName();
		
		String res;
		switch(exceptionClassName)
		{
			case "HttpMessageNotReadableException":
				res = "Error creating or updating Dish entity. Could not deserialize data, could not rebuild object. Please check the value of the fields.";
			break;
			default:
				res = "Generic exception: "+e.getMessage();
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		
	}
}
