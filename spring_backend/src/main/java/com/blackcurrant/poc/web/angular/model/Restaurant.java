package com.blackcurrant.poc.web.angular.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int restaurant_id;
    private String restaurant_name;
    private String restaurant_email;
    private String restaurant_address;
    private String restaurant_contact_no;
    private String restaurant_pic;

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getRestaurant_email() {
        return restaurant_email;
    }

    public void setRestaurant_email(String restaurant_email) {
        this.restaurant_email = restaurant_email;
    }

    public String getRestaurant_address() {
        return restaurant_address;
    }

    public void setRestaurant_address(String restaurant_address) {
        this.restaurant_address = restaurant_address;
    }

    public String getRestaurant_contact_no() {
        return restaurant_contact_no;
    }

    public void setRestaurant_contact_no(String restaurant_contact_no) {
        this.restaurant_contact_no = restaurant_contact_no;
    }

    public String getRestaurant_pic() {
        return restaurant_pic;
    }

    public void setRestaurant_pic(String restaurant_pic) {
        this.restaurant_pic = restaurant_pic;
    }


}
