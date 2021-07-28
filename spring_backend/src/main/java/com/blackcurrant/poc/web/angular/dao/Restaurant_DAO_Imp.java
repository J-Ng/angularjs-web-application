package com.blackcurrant.poc.web.angular.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.blackcurrant.poc.web.angular.model.Restaurant;

@Repository
public class Restaurant_DAO_Imp  implements Restaurant_DAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveRestaurant(Restaurant restaurant) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(restaurant);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Restaurant> getRestaurants() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Restaurant> query=currentSession.createQuery("from Restaurant", Restaurant.class);
		List<Restaurant> list=query.getResultList();
		return list;
	}

	@Override
	public boolean deleteRestaurant(Restaurant restaurant) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().delete(restaurant);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Restaurant> getRestaurantByID(Restaurant restaurant) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Restaurant> query=currentSession.createQuery("from Restaurant where restaurant_id=:restaurant_id", Restaurant.class);
		query.setParameter("restaurant_id", restaurant.getRestaurant_id());
		List<Restaurant> list=query.getResultList();
		return list;
	}

	@Override
	public boolean updateRestaurant(Restaurant restaurant) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().update(restaurant);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	

}
