import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AppServiceService } from '../services/app-service.service';
import { User } from '../User';
import { Restaurant } from '../Restaurant';
import { JwtHelperService } from '@auth0/angular-jwt';
import { CuisinesListComponent } from '../cuisines-list/cuisines-list.component';


@Component({
  selector: 'app-resturant-login',
  templateUrl: './resturant-login.component.html',
  styleUrls: ['./resturant-login.component.css']
})
export class ResturantLoginComponent implements OnInit {
    restaurant: Restaurant;

    constructor(
      private appService: AppServiceService) {
      this.restaurant = new Restaurant();
    }

    public ngOnInit(): void {
    }

    public onSubmit(): void {
      this.appService.loginRestaurant(this.restaurant).subscribe();
      window.location.reload();
    }

    
  //     result =>{
  //       this.appService.tokendata=(result)
  //       console.log(this.appService.tokendata)
  //       if(this.appService.tokendata!=null){
  //         this.router.navigateByUrl("/food-items")

  //       }   
  //  },error=>alert("Invalid input")


}
