package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.Restaurant_DAO;
import model.Restaurant;

@Service
@Transactional
public class Restaurant_Service_Imp implements Restaurant_Service {

    @Autowired
    private Restaurant_DAO restaurantdao;

    @Override
    public boolean saveRestaurant(Restaurant restaurant) {
        return restaurantdao.saveRestaurant(restaurant);
    }

    @Override
    public List<Restaurant> getRestaurants() {
        return restaurantdao.getRestaurants();
    }

    @Override
    public boolean deleteRestaurant(Restaurant restaurant) {
        return restaurantdao.deleteRestaurant(restaurant);
    }

    @Override
    public List<Restaurant> getRestaurantByID(Restaurant restaurant) {
        return restaurantdao.getRestaurantByID(restaurant);
    }

    @Override
    public boolean updateRestaurant(Restaurant restaurant) {
        return restaurantdao.updateRestaurant(restaurant);
    }

}
