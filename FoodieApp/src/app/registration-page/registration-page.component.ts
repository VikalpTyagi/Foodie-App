import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { filter, Subject, take, takeUntil } from 'rxjs';
import { User } from '../User';
import { AppServiceService } from '../services/app-service.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-registration-page',
  templateUrl: './registration-page.component.html',
  styleUrls: ['./registration-page.component.css']
})
export class RegistrationPageComponent implements OnInit {
  
  user:User;

  constructor(
    private route: ActivatedRoute,private router: Router,private logs: AppServiceService) {
    this.user = new User();
  } 
 
  ngOnInit(): void {
  }


  public onSubmit(): void {
    
    this.logs.registerUser(this.user).subscribe();
    
  }
  selectFile(file:any) {
    if (file.target.files) {
      var reader = new FileReader()
      reader.readAsDataURL(file.target.files[0])
      reader.onload = (file:any) => {this.user.userImg= file.target.result}
    }
  }
}
