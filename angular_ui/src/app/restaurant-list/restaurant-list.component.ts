import { Component, OnInit } from '@angular/core';
import { RestaurantService } from '../restaurant.service';
import { Restaurant } from '../restaurant';
import { Observable,Subject } from "rxjs";

import {FormControl,FormGroup,Validators} from '@angular/forms';

@Component({
  selector: 'app-restaurant-list',
  templateUrl: './restaurant-list.component.html',
  styleUrls: ['./restaurant-list.component.css']
})
export class RestaurantListComponent implements OnInit {

 constructor(private restaurantservice:RestaurantService) { }

  restaurantsArray: any[] = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any>= new Subject();


  restaurants: Observable<Restaurant[]>;
  restaurant : Restaurant=new Restaurant();
  deleteMessage=false;
  restaurantlist:any;
  isupdated = false;


  ngOnInit() {
    this.isupdated=false;
    this.dtOptions = {
      pageLength: 6,
      stateSave:true,
      lengthMenu:[[6, 16, 20, -1], [6, 16, 20, "All"]],
      processing: true
    };
    this.restaurantservice.getRestaurantList().subscribe(data =>{
    this.restaurants =data;
    this.dtTrigger.next();
    })
  }

  deleteRestaurant(id: number) {
    this.restaurantservice.deleteRestaurant(id)
      .subscribe(
        data => {
          console.log(data);
          this.deleteMessage=true;
          this.restaurantservice.getRestaurantList().subscribe(data =>{
            this.restaurants =data
            })
        },
        error => console.log(error));
  }


  updateRestaurant(id: number){
    this.restaurantservice.getRestaurant(id)
      .subscribe(
        data => {
          this.restaurantlist=data
        },
        error => console.log(error));
  }

  restaurantupdateform=new FormGroup({
    restaurant_id:new FormControl(),
    restaurant_name:new FormControl(),
    restaurant_email:new FormControl(),
    restaurant_address:new FormControl(),
    restaurant_contact_no:new FormControl()
  });

  updateRes(updres){
    this.restaurant=new Restaurant();
   this.restaurant.restaurant_id=this.RestaurantId.value;
   this.restaurant.restaurant_name=this.RestaurantName.value;
   this.restaurant.restaurant_email=this.RestaurantEmail.value;
   this.restaurant.restaurant_address=this.RestaurantAddress.value;
   this.restaurant.restaurant_contact_no=this.RestaurantContactNo.value;

   this.restaurantservice.updateRestaurant(this.restaurant.restaurant_id,this.restaurant).subscribe(
    data => {
      this.isupdated=true;
      this.restaurantservice.getRestaurantList().subscribe(data =>{
        this.restaurants =data
        })
    },
    error => console.log(error));
  }

  get RestaurantName(){
    return this.restaurantupdateform.get('restaurant_name');
  }

  get RestaurantEmail(){
    return this.restaurantupdateform.get('restaurant_email');
  }

  get RestaurantAddress(){
    return this.restaurantupdateform.get('restaurant_address');
  }

  get RestaurantId(){
    return this.restaurantupdateform.get('restaurant_id');
  }

  get RestaurantContactNo(){
    return this.restaurantupdateform.get('restaurant_contact_no');
  }

  changeisUpdate(){
    this.isupdated=false;
  }
}
