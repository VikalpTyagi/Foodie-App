import { Component } from '@angular/core';
import { AppServiceService } from '../services/app-service.service';

@Component({
  selector: 'app-add-restaurant',
  templateUrl: './add-restaurant.component.html',
  styleUrls: ['./add-restaurant.component.css']
})
export class AddRestaurantComponent {

constructor(public service:AppServiceService){

}
  loggedIn() {
    return localStorage.getItem('token');
  }
  logOut() {
    return localStorage.removeItem('token');
  }
  
}
