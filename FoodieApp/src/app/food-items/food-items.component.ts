import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../Restaurant';
import { AppServiceService } from '../services/app-service.service';

@Component({
  selector: 'app-food-items',
  templateUrl: './food-items.component.html',
  styleUrls: ['./food-items.component.css']
})
export class FoodItemsComponent implements OnInit {
  restaurant!: any;
  restaurantName!:string;

  constructor(private appService: AppServiceService) {
  }


  ngOnInit() {
    if(this.appService.searchtext==null){
    this.appService.getAllRest().subscribe(data => {
      this.restaurant = data;
    });
  }
    else{
    this.appService.filterByLocation(this.appService.searchtext).subscribe(data =>
      this.restaurant = data
    );
    }
  }

  clickOn(){
    this.appService.filterByRestaurantName(this.restaurantName).subscribe(data=>
      {
        this.restaurant=data;
      }
      );
  }
 
}
