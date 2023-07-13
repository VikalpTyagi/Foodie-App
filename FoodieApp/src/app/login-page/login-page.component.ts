import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../User';
import { AppServiceService } from '../services/app-service.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { JwtHelperService } from '@auth0/angular-jwt';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  user!: User;
  credential = {
    email: '',
    password: ''
  }

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private appService: AppServiceService) {
    this.user = new User();
  }

  logForm!: FormGroup
  successMessage: string = "";
  role: string = "";
  helper = new JwtHelperService();
  email: string = "";
  alertify: any;
  ngOnInit(): void {
    this.logForm = this.fb.group({
      'email': new FormControl(null, [Validators.required, Validators.email]),
      'password': new FormControl(null, [Validators.required]),
    })
  }

  // public onSubmit() {
  //   this.credential.email = this.logForm.value.email;
  //   this.credential.password = this.logForm.value.password;
  //   sessionStorage.setItem('email', this.credential.email);
  //   this.appService.login(this.logForm.value)
  //     .subscribe(result => {
  //       this.appService.tokendata = (result)
  //       console.log(this.appService.tokendata)
  //       if (this.appService.tokendata != null) {
  //         this.router.navigateByUrl("/food-items")
  //       }
  //     }, error => alert("Invalid input"));

  // }
  public onSubmit() {
    this.credential.email = this.logForm.value.email;
    this.credential.password = this.logForm.value.password;
    sessionStorage.setItem('email', this.credential.email);
    this.appService.login(this.credential)
      .subscribe((response: any) => {
        this.appService.loginUser(response.token);
        console.log(response.token);
       window.location.reload()
        
      },error=>alert("invalid input"))
  }

}
