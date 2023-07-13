import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageNotFoundComponentComponent } from './page-not-found-component/page-not-found-component.component';
import { RegistrationPageComponent } from './registration-page/registration-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { LocationPageComponent } from './location-page/location-page.component';
import { FoodItemsComponent } from './food-items/food-items.component';
import { AddRestaurantComponent } from './add-restaurant/add-restaurant.component';
import { RegisterResturantComponent } from './register-resturant/register-resturant.component';
import { ResturantLoginComponent } from './resturant-login/resturant-login.component';
import { CuisinesListComponent } from './cuisines-list/cuisines-list.component';
import { AddCuisinesComponent } from './add-cuisines/add-cuisines.component';
import { AddFavouriteComponent } from './add-favourite/add-favourite.component';
import { AddToCartComponent } from './add-to-cart/add-to-cart.component';
import { CanActivateGuard } from './can-activate.guard';
import { ThankYouPageComponent } from './thank-you-page/thank-you-page.component';

const routes: Routes = [
  {
    path:"home-page",
    component:LocationPageComponent
  },
  {
    path:"",
    redirectTo:"/home-page",
    pathMatch:'full'
  },
  // {
  //   path:"login",
  //   component:LoginPageComponent
  // },
  // {
  //   path:"sign-up",
  //   component:RegistrationPageComponent
  // },
  {
    path:"food-items",
    component:FoodItemsComponent
  },
  {
    path:"cuisines-list/:id",
    component:CuisinesListComponent
  },
  {
    path:"food-items/:location",
    component:FoodItemsComponent
  },
  {
    path:"Add-Restaurant",
    component:AddRestaurantComponent,
    canActivate:[CanActivateGuard]
  },
  // {
  //   path:"register-resturant",
  //   component:RegisterResturantComponent
  // },
  // {
  //   path:"resturant-login",
  //   component:ResturantLoginComponent
  // },
  {
    path:"add-cuisines/:id",
    component:AddCuisinesComponent,
    canActivate:[CanActivateGuard]
  },
  // {
  //   path:"add-favourite",
  //   component:AddFavouriteComponent
  // },
  {
    path:"add-to-cart",
    component:AddToCartComponent,
    canActivate:[CanActivateGuard]
  },
  {
    path:"thank-you",
    component:ThankYouPageComponent,
    canActivate:[CanActivateGuard]
  },
  {
    path:"**",
    component:PageNotFoundComponentComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
