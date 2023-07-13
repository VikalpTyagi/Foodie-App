import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, AbstractControl } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { AppServiceService } from '../services/app-service.service';
import { Restaurant } from '../Restaurant';


@Component({
  selector: 'app-register-resturant',
  templateUrl: './register-resturant.component.html',
  styleUrls: ['./register-resturant.component.css']
})
export class RegisterResturantComponent implements OnInit {

  restaurant:Restaurant;

  constructor(
    private route: ActivatedRoute,private router: Router,private logs: AppServiceService) {
    this.restaurant = new Restaurant();
  } 

 
  ngOnInit(): void {
  }


  public onSubmit(): void {
    this.logs.registerRestaurant(this.restaurant).subscribe();
    // window.location.reload();
  }
  selectFile(file:any) {
    if (file.target.files) {
      var reader = new FileReader()
      reader.readAsDataURL(file.target.files[0])
      reader.onload = (file:any) => {this.restaurant.restaurantImg= file.target.result}
    }
  }

}
