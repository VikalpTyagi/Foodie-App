import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { AppServiceService } from '../services/app-service.service';
import { Cuisines } from '../Cuisines';
import { Order } from '../order';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-to-cart',
  templateUrl: './add-to-cart.component.html',
  styleUrls: ['./add-to-cart.component.css']
})
export class AddToCartComponent implements OnInit {

  cuisines:any;
  user:User;
  emailid = sessionStorage.getItem('email');
  public totalPrice!:any;
  public billPrice!:any;
  public quantity:any;
  public foodName:any;
  

  cartForm: FormGroup = this.fb.group({
    'name': new FormControl(null, [Validators.required]),
    'address': new FormControl(null, [Validators.required]),
    'pinCode': new FormControl(null, [Validators.required]),
    'phnNumber': new FormControl(null, [Validators.required])
  })

  constructor(private service : AppServiceService,private fb: FormBuilder,private snakbar:MatSnackBar,private router:Router){
    this.user=new User();

  }
  ngOnInit(): void {
    this.service.getUser(this.emailid).subscribe(data=>{
      this.user=data;
     });
     this.service.getcart(this.emailid).subscribe(data=>{
      this.cuisines=data;
      console.log(this.cuisines)
     });
     this.service.gettotalprice(this.emailid).subscribe(data=>{
        console.log(data)
        this.totalPrice=data;
      });

      this.service.getbillprice(this.emailid).subscribe(data=>{
        console.log(data)
        this.billPrice=data;
      });

      this.service.getnumberofquantity(this.emailid,this.foodName).subscribe(data=>{
        console.log(this.foodName);
        this.quantity=data;
      })
  }
  
  

  loggedIn() {
    return localStorage.getItem('token');
  }
  logOut() {
    return localStorage.removeItem('token');
  }

  ondelete(name:string){
    this.foodName=name;
    console.log(name,this.emailid)
    this.service.deletecart(this.emailid,name).subscribe()
    window.location.reload();
  }
  onadd(name:string){
    console.log(name,this.emailid)
    this.service.addorder(this.emailid,name).subscribe()
    window.location.reload();
  }

  onSubmit(){

    this.service.addorderDetails(this.emailid,this.cartForm.value).subscribe()
    console.log(this.cartForm.value)
    
    this.snakbar.open('Order Placed!!', 'Thank you!', {
      duration: 5000,
      panelClass: ['mat-toolbar', 'mat-primary']
    });

    this.router.navigateByUrl("/thank-you")
  }
}
