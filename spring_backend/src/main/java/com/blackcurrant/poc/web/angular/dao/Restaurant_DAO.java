package com.blackcurrant.poc.web.angular.dao;

import java.util.List;

import com.blackcurrant.poc.web.angular.model.Restaurant;

public interface Restaurant_DAO {

	public boolean saveRestaurant(Restaurant restaurant);
	public List<Restaurant> getRestaurants();
	public boolean deleteRestaurant(Restaurant restaurant);
	public List<Restaurant> getRestaurantByID(Restaurant restaurant);
	public boolean updateRestaurant(Restaurant restaurant);
}
