import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../Restaurant';
import { Cuisines } from '../Cuisines';
import { ActivatedRoute } from '@angular/router';
import { AppServiceService } from '../services/app-service.service';

@Component({
  selector: 'app-add-cuisines',
  templateUrl: './add-cuisines.component.html',
  styleUrls: ['./add-cuisines.component.css']
})
export class AddCuisinesComponent implements OnInit {
  restaurant: Restaurant;
  cuisines:Cuisines;
  dishes:any;
  starRating = 0; 
  constructor(private activatedRoute: ActivatedRoute,
    public service: AppServiceService) {
    this.cuisines = new Cuisines();
    this.restaurant = new Restaurant();
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params => {
      let id = params.get("id") ?? 0;
      this.service.getRestaurantById(+id).subscribe(data => {
        this.restaurant = data;
        this.dishes=data.dishes;
        console.log(this.restaurant)
      }
      )
    });
  }

  public onSubmit(): void {
    console.log(this.cuisines)
    this.service.addDishes(this.restaurant.restaurantId,this.cuisines).subscribe();
    window.location.reload();
  }
  selectFile(file: any) {
    if (file.target.files) {
      var reader = new FileReader()
      reader.readAsDataURL(file.target.files[0])
      reader.onload = (file: any) => { this.cuisines.foodImg = file.target.result }
    }
  }


  loggedIn() {
    return localStorage.getItem('token');
  }
  logOut() {
    return localStorage.removeItem('token');
  }
  OnDelete(name:string){
    this.service.deleteCuisines(name,this.restaurant.restaurantId).subscribe()
    console.log(this.restaurant.restaurantId);
    
  }

}
