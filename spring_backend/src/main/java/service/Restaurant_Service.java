package service;

import java.util.List;

import model.Restaurant;

public interface Restaurant_Service {

	public boolean saveRestaurant(Restaurant restaurant);
	public List<Restaurant> getRestaurants();
	public boolean deleteRestaurant(Restaurant restaurant);
	public List<Restaurant> getRestaurantByID(Restaurant restaurant);
	public boolean updateRestaurant(Restaurant restaurant);
}
