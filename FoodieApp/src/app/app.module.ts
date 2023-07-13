import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {ReactiveFormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import { LocationPageComponent } from './location-page/location-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegistrationPageComponent } from './registration-page/registration-page.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import {MatGridListModule} from '@angular/material/grid-list';
import { PageNotFoundComponentComponent } from './page-not-found-component/page-not-found-component.component';
import { FoodItemsComponent } from './food-items/food-items.component';
import {HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatRadioModule} from '@angular/material/radio';
import { AddRestaurantComponent } from './add-restaurant/add-restaurant.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import {MatChipsModule} from '@angular/material/chips';
import {MatRippleModule} from '@angular/material/core';
import { RegisterResturantComponent } from './register-resturant/register-resturant.component';
import { ResturantLoginComponent } from './resturant-login/resturant-login.component';
import { CuisinesListComponent } from './cuisines-list/cuisines-list.component';
// import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AddCuisinesComponent } from './add-cuisines/add-cuisines.component';
import { AddFavouriteComponent } from './add-favourite/add-favourite.component';
import { AddToCartComponent } from './add-to-cart/add-to-cart.component';
import { ThankYouPageComponent } from './thank-you-page/thank-you-page.component';


@NgModule({
  declarations: [
    AppComponent,
    LocationPageComponent,
    LoginPageComponent,
    RegistrationPageComponent,
    HeaderComponent,
    FooterComponent,
    PageNotFoundComponentComponent,
    FoodItemsComponent,
    AddRestaurantComponent,
    RegisterResturantComponent,
    ResturantLoginComponent,
    CuisinesListComponent,
    AddCuisinesComponent,
    AddFavouriteComponent,
    AddToCartComponent,
    ThankYouPageComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    MatSelectModule,
    ReactiveFormsModule,
    MatInputModule,
    MatGridListModule,
    FormsModule,
    HttpClientModule,
    MatSnackBarModule,
    MatRadioModule,
    LayoutModule,
    MatSidenavModule,
    MatListModule,
    MatRippleModule,
    MatChipsModule,
    // NgbModule    ,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
