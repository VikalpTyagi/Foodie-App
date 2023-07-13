import { Component, OnInit, Output } from '@angular/core';
import { AppServiceService } from '../services/app-service.service';
import { Restaurant } from '../Restaurant';
import { User } from '../User';

@Component({
  selector: 'app-location-page',
  templateUrl: './location-page.component.html',
  styleUrls: ['./location-page.component.css']
})
export class LocationPageComponent implements OnInit {
  restaurant: any;
  location!: string;
  user:User;
  emailid = sessionStorage.getItem('email');

  constructor(private service: AppServiceService) {
    this.user=new User();
   }
  loggedIn() {
    return localStorage.getItem('token');
  }

  onSearch() {
    this.service.searchtext = this.location;  
    sessionStorage.setItem('location',this.service.searchtext);
  }

  ngOnInit(): void {
    this.service.getAllRest().subscribe(data => {
      this.restaurant = data;
    });
    const data= this.service.getUser(this.emailid).subscribe(data=>{
      this.user=data;
      console.log(data)
     });
  }
}
