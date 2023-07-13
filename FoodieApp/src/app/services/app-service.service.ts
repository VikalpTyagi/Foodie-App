import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../User';
import { Restaurant } from '../Restaurant';
import { Observable } from 'rxjs/internal/Observable';
import { Cuisines } from '../Cuisines';
import { Order } from '../order';


@Injectable({
  providedIn: 'root'
})
export class AppServiceService {
  public tokendata!: User;
  public searchtext!: string;



  private usersUrl: string;
  private registerUrl1: string;
  private usersUrl2: string;
  private restauranturl: string;
  private restauranturl2: string;
  private restauranturl3: string;
  private restauranturl4: string;
  private restauranturl5: string;
  private restauranturl6: string;
  private restauranturl7: string;
  private restauranturl8: string;
  private restauranturl9: string;
  private favouritesurl: string;
  private favouritesurl1: string;
  private favouritesurl2: string;
  private carturl: string;
  private carturl1: string;
  private carturl2: string;
  private carturl3: string;
  private carturl4: string;
  private carturl5: string;
  private carturl6: string;
  private carturl7: string;
  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8081/api/v1/login';
    this.registerUrl1 = 'http://localhost:8086/api/v5/user/register';
    this.usersUrl2 = 'http://localhost:8086/api/v5/user';
    this.restauranturl = 'http://localhost:8088/api/v2/restaurant/register';
    this.restauranturl2 = 'http://localhost:8088/api/v2/restaurant/login';
    this.restauranturl3 = 'http://localhost:8088/api/v2/restaurant/get';
    this.restauranturl4 = 'http://localhost:8088/api/v2/restaurant';
    this.restauranturl5 = 'http://localhost:8088/api/v2/cuisines/dish';
    this.restauranturl6 = 'http://localhost:8088/api/v2/rest';
    this.restauranturl7 = 'http://localhost:8088/api/v2/restaurant/name';
    this.restauranturl8 = 'http://localhost:8088/api/v2/restaurant/delete';
    this.restauranturl9 = 'http://localhost:8088/api/v2/restaurant/listCities';
    this.favouritesurl = 'http://localhost:8666/api/v3/favourite/add';
    this.favouritesurl1 = 'http://localhost:8666/api/v3/favourite/fetch'
    this.favouritesurl2 = 'http://localhost:8666/api/v3/favourite/delete'
    this.carturl = 'http://localhost:8888/api/v4/cart/add'
    this.carturl1 = 'http://localhost:8888/api/v4/cart/get'
    this.carturl2 = 'http://localhost:8888/api/v4/cart/delete'
    this.carturl3 = 'http://localhost:8888/api/v4/cart/total'
    this.carturl4 = 'http://localhost:8888/api/v4/cart/bill'
    this.carturl5 = 'http://localhost:8888/api/v4/cart/order'
    this.carturl6 = 'http://localhost:8888/api/v4/cart/number'
    this.carturl7 = 'http://localhost:8888/api/v4/cart/plus'
  }



  loginUser(token: any) {
    localStorage.setItem("token", token)
    return true;
  }
  logout() {
    localStorage.removeItem('token')
    return true;
  }

  public login(user: User) {
    return this.http.post<User>(this.usersUrl, user)
  }
  public getUser(email: any): Observable<User> {

    return this.http.get<User>(`${this.usersUrl2}/${email}`)
  }

  public registerUser(user: User) {
    return this.http.post<User>(this.registerUrl1, user);
  }

  public registerRestaurant(restaurant: Restaurant) {
    return this.http.post<Restaurant>(this.restauranturl, restaurant);
  }
  public loginRestaurant(restaurant: Restaurant) {
    return this.http.post<Restaurant>(this.restauranturl2, restaurant);
  }
  public getAllRest(): Observable<Restaurant[]> {
    return this.http.get<Restaurant[]>(this.restauranturl3);
  }
  getRestaurantById(id: any): Observable<Restaurant> {
    return this.http.get<Restaurant>(`${this.restauranturl4}/${id}`);
  }
  addDishes(id: any, cuisines: Cuisines) {
    return this.http.post<Cuisines>(`${this.restauranturl5}/${id}`, cuisines);
  }
  filterByLocation(location: string): Observable<Restaurant[]> {
    return this.http.get<Restaurant[]>(`${this.restauranturl6}/${location}`)
  }
  filterByRestaurantName(name: string): Observable<Restaurant> {
    return this.http.get<Restaurant>(`${this.restauranturl7}/${name}`)
  }
  deleteCuisines(name: string, id: any) {
    return this.http.delete(`${this.restauranturl8}/${id}/${name}`)
  }

  addfavourites(email: any, restaurant: Restaurant) {

    return this.http.post<Restaurant>(`${this.favouritesurl}/${email}`, restaurant);
  }

  getfavourities(email: any): Observable<Restaurant> {
    return this.http.get<Restaurant>(`${this.favouritesurl1}/${email}`)
  }
  deletefavourities(email: any, id: any) {
    return this.http.delete(`${this.favouritesurl2}/${id}/${email}`)
  }

  getlocation() {
    return this.http.get(this.restauranturl9);
  }

  addtocart(email: any, cuisines: any, restName: any) {
    return this.http.post<Cuisines[]>(`${this.carturl}/${email}/${restName}`, cuisines);
  }

  getcart(email: any): Observable<Cuisines> {
    return this.http.get<Cuisines>(`${this.carturl1}/${email}`)
  }

  deletecart(email: any, foodName: any) {
    return this.http.delete(`${this.carturl2}/${email}/${foodName}`)
  }

  gettotalprice(email: any) {
    return this.http.get(`${this.carturl3}/${email}`)
  }
  getbillprice(email: any) {
    return this.http.get(`${this.carturl4}/${email}`)
  }

  addorderDetails(email: any, order: Order) {
    console.log(email, order);
    return this.http.post<Order>(`${this.carturl5}/${email}`, order);
  }
  getnumberofquantity(email: any,foodName: any) {
    return this.http.get(`${this.carturl6}/${email}/${foodName}`)
  }
  addorder(email: any,foodName: any) {
    return this.http.post(`${this.carturl7}/${email}/${foodName}`,null)
  }

}
