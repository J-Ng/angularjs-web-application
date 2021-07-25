package com.blackcurrant.poc.web.angular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blackcurrant.poc.web.angular.model.Restaurant;
import com.blackcurrant.poc.web.angular.service.Restaurant_Service;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class Controller {
	
	@Autowired
	private Restaurant_Service restaurantservice;

	private static final Logger logger = LoggerFactory.getLogger(Controller.class);
	
	@PostMapping("save-restaurant")
	public boolean saveRestaurant(@RequestBody Restaurant restaurant) {
		 return restaurantservice.saveRestaurant(restaurant);
		
	}
	
	@GetMapping("restaurants-list")
	public List<Restaurant> allrestaurants() {
		logger.info("Received request to load all resturants");
		 return restaurantservice.getRestaurants();
	}
	
	
	@DeleteMapping("delete-restaurant/{restaurant_id}")
	public boolean deleteRestaurant(@PathVariable("restaurant_id") int restaurant_id,Restaurant restaurant) {
		restaurant.setRestaurant_id(restaurant_id);
		return restaurantservice.deleteRestaurant(restaurant);
	}

	@GetMapping("restaurant/{restaurant_id}")
	public List<Restaurant> allrestaurantByID(@PathVariable("restaurant_id") int restaurant_id,Restaurant restaurant) {
		restaurant.setRestaurant_id(restaurant_id);
		 return restaurantservice.getRestaurantByID(restaurant);
		
	}
	
	@PostMapping("update-restaurant/{restaurant_id}")
	public boolean updateRestaurant(@RequestBody Restaurant restaurant,@PathVariable("restaurant_id") int restaurant_id) {
		restaurant.setRestaurant_id(restaurant_id);
		return restaurantservice.updateRestaurant(restaurant);
	}
}
