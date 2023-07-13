import { Cuisines } from "./Cuisines"

export class Restaurant{
    restaurantId?:string
    password?:string
    restaurantOwnerName?:string
    restaurantName?:string
    location?:string
    phNo?:string
    restaurantImg?:string;
    restaurantRating?:number;
     description?:string;
     address?:string;
    // dish?:Cuisines;
    dishes?:Cuisines[];
}