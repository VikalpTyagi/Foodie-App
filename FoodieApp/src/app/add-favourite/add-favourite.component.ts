import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../Restaurant';
import { AppServiceService } from '../services/app-service.service';
import { Favourite } from '../favourite';

@Component({
  selector: 'app-add-favourite',
  templateUrl: './add-favourite.component.html',
  styleUrls: ['./add-favourite.component.css']
})
export class AddFavouriteComponent implements OnInit {
  restaurant!:any;
 
  emailid = sessionStorage.getItem('email');
  constructor(private service:AppServiceService)
  {
  }
  ngOnInit(): void {
    this.service.getfavourities(this.emailid).subscribe(data=>{
      this.restaurant=data; 
    });

  }

  ondelete(id:string){
    this.service.deletefavourities(this.emailid,id).subscribe(data=>{
      console.log(data);
      window.location.reload();
    });

  }
}
