import { Component, OnInit } from '@angular/core';
import { RestaurantService } from '../restaurant.service';
import {FormControl,FormGroup,Validators} from '@angular/forms';
import { Restaurant } from '../restaurant';
@Component({
  selector: 'app-add-restaurant',
  templateUrl: './add-restaurant.component.html',
  styleUrls: ['./add-restaurant.component.css']
})
export class AddRestaurantComponent implements OnInit {

  constructor(private restaurantservice:RestaurantService) { }

  restaurant : Restaurant=new Restaurant();
  submitted = false;

  ngOnInit() {
    this.submitted=false;
  }

  restaurantsaveform=new FormGroup({
    restaurant_name:new FormControl('' , [Validators.required , Validators.minLength(5) ] ),
    restaurant_email:new FormControl('',[Validators.required,Validators.email]),
    restaurant_address:new FormControl(),
    restaurant_contact_no:new FormControl()
  });

  saveRestaurant(saveRestaurant){
    this.restaurant=new Restaurant();
    this.restaurant.restaurant_name=this.RestaurantName.value;
    this.restaurant.restaurant_email=this.RestaurantEmail.value;
    this.restaurant.restaurant_address=this.RestaurantAddress.value;
    this.restaurant.restaurant_contact_no=this.RestaurantContactNo.value;
    this.submitted = true;
    this.save();
  }

  save() {
    this.restaurantservice.createRestaurant(this.restaurant)
      .subscribe(data => console.log(data), error => console.log(error));
    this.restaurant = new Restaurant();
  }

  get RestaurantName(){
    return this.restaurantsaveform.get('restaurant_name');
  }

  get RestaurantEmail(){
    return this.restaurantsaveform.get('restaurant_email');
  }

  get RestaurantAddress(){
    return this.restaurantsaveform.get('restaurant_address');
  }

  get RestaurantContactNo(){
    return this.restaurantsaveform.get('restaurant_contact_no');
  }

  addRestaurantForm(){
    this.submitted=false;
    this.restaurantsaveform.reset();
  }
}
