import { Component } from '@angular/core';
import { AppServiceService } from '../services/app-service.service';
import { User } from '../User';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  loggedIn() {
    return localStorage.getItem('token');
  }
  logOut() {
    return localStorage.removeItem('token');
  }

  user:User;
  emailid = sessionStorage.getItem('email');

  constructor(
   private service: AppServiceService) {
    this.user = new User();
  } 
 
  ngOnInit(): void {
    
   const data= this.service.getUser(this.emailid).subscribe(data=>{
    this.user=data;
    console.log(data)
   });
    console.log(this.emailid)  
  }

  selectFile(file:any) {
    if (file.target.files) {
      var reader = new FileReader()
      reader.readAsDataURL(file.target.files[0])
      reader.onload = (file:any) => {this.user.userImg= file.target.result}
    }
  }
}
