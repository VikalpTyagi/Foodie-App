import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AppServiceService } from '../services/app-service.service';
import { Cuisines } from '../Cuisines';
import { Restaurant } from '../Restaurant';
import { MatSnackBar } from '@angular/material/snack-bar';
import { User } from '../User';

@Component({
  selector: 'app-cuisines-list',
  templateUrl: './cuisines-list.component.html',
  styleUrls: ['./cuisines-list.component.css']
})
export class CuisinesListComponent implements OnInit {


  restaurant: Restaurant;
  cuisines: Cuisines;
  dishes: any;
  user: User;


  emailid = sessionStorage.getItem('email');

  constructor(private activatedRoute: ActivatedRoute, private snakbar: MatSnackBar,
    public service: AppServiceService) {
    this.cuisines = new Cuisines();
    this.restaurant = new Restaurant();
    this.user = new User();
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params => {
      let id = params.get("id") ?? 0;
      this.service.getRestaurantById(+id).subscribe(data => {
        this.restaurant = data;
        this.dishes = data.dishes;
      }
      )
    });
    this.service.getUser(this.emailid).subscribe(data => {
      this.user = data;
    });
  }

  public onSubmit(): void {
    console.log(this.cuisines)
    this.service.addDishes(this.restaurant.restaurantId, this.cuisines).subscribe();
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
  addfav() {
    this.service.addfavourites(this.emailid, this.restaurant).subscribe(data => {
      console.log(data)
      window.location.reload();
    });
    this.snakbar.open('Favourites added!!', 'Check it!', {
      duration: 5000,
      panelClass: ['mat-toolbar', 'mat-primary']
    });
    console.log(this.emailid, this.restaurant)
  }

  addtocart(name: string) {
    console.log(name, this.dishes, this.emailid);
    this.service.addtocart(this.emailid, this.dishes, name).subscribe()
    this.snakbar.open('Added to your cart!!', 'Check it!', {
      duration: 5000,
      panelClass: ['mat-toolbar', 'mat-primary']
    });
  }
}
