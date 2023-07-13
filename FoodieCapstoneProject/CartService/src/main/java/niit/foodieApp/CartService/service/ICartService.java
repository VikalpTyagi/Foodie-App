package niit.foodieApp.CartService.service;

import niit.foodieApp.CartService.domain.Cuisines;
import niit.foodieApp.CartService.domain.Order;
import niit.foodieApp.CartService.domain.User;


import java.util.List;
import java.util.Set;

public interface ICartService {

    public User addToCart(Cuisines cuisines, String email);

    public User deleteCuisine(String foodName, String email);

    public List<Cuisines> getOrderedFood (String email);

    public double totalBill (String email);

    double BillWithCharges(String email);

    String orderDetails (String email, Order details);

    //for display of quantity of dishes
    int dishQuantity(String email, String foodName);

    //for '+' button that will add same dish
    User addCuisine(String foodName, String email);
}
