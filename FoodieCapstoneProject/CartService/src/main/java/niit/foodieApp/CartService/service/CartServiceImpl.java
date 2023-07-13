package niit.foodieApp.CartService.service;

import niit.foodieApp.CartService.domain.Cuisines;
import niit.foodieApp.CartService.domain.Order;
import niit.foodieApp.CartService.domain.User;
import niit.foodieApp.CartService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartServiceImpl implements ICartService{

    @Autowired
    UserRepository repos;
    static String userName;
//    public static Map<String,Double> order;
//    public static double totalPrice;
//    public static double total=50;
    @Override
    public User addToCart(Cuisines cuisines, String email)
    {
        if (repos.findById(email).isEmpty())
        {
            User user = new User();
            user.setEmail(email);
            repos.save(user);
        }
        User user = repos.findById(email).get();
        if (user.getCuisines()==null || user.getCuisines().isEmpty() )
        {
            List<Cuisines> cuisinesList =new ArrayList<>();

            cuisinesList.add(cuisines);
            user.setCuisines(cuisinesList);
            repos.save(user);
            return user;
        }
        else
        {
            List<Cuisines> existList = user.getCuisines();
            for (Cuisines dish: existList)
            {
                if (dish.getFoodName().equals(cuisines.getFoodName()))
                {
                    dish.setQuantity(dish.getQuantity()+1);
                    user.setCuisines(existList);
                    repos.save(user);
                    return user;
                }
            }

            for (Cuisines dish: existList)
            {
                if (!dish.getFoodName().equals(cuisines.getFoodName()))
                {
                    existList.add(cuisines);
                    break;
                }
            }
            user.setCuisines(existList);
            repos.save(user);
            return user;
        }
    }

    @Override
    public double totalBill (String email)
    {
        double total=0;
        User user = repos.findById(email).get();
        List<Cuisines> foodList= user.getCuisines();
        for(Cuisines c : foodList)
        {
            double num= c.getFoodPrice();
            total=c.getQuantity()*num;
        }
       return total;
    }

    @Override
    public double BillWithCharges(String email)
    {
        double total=50;
        User user = repos.findById(email).get();
        List<Cuisines> foodList= user.getCuisines();
        for(Cuisines c : foodList)
        {
            double num= c.getFoodPrice();
            total=c.getQuantity()*num+total;
        }
        return total;
    }
//    @Override
//    public String orderDetails (String email, Order details)
//    {
//
//        if (repos.findById(email).isEmpty())
//        {
//            return "User Not Found !!";
//        }
//        else
//        {
//            User user = repos.findById(email).get();
//            user.setOrderDetails(details);
////            List<Cuisines> presentList= user.getCuisines();
////            for(Cuisines c: presentList) {
////                order.put(c.getFoodName(), c.getFoodPrice());
////                totalPrice = totalPrice + c.getFoodPrice();
////            }
//            repos.save(user);
//        }
//        return "Order Placed Successfully !!";
//    }
    public String orderDetails (String email, Order details)
    {
        if (repos.findById(email).isEmpty())
        {
        return "User Not Found !!";
        }
        else
        {
            User user = repos.findById(email).get();
            user.setOrderDetails(details);
            repos.save(user);
        }
        userName=details.getName();
    return "Order Placed Successfully !!";
}

    // for delete button as well as for '-' button
    @Override
    public User deleteCuisine(String foodName, String email)
    {
        User userRepo ;
        if (repos.findById(email).isEmpty())
        {
            return null;
        }
        User user= repos.findById(email).get();
        List<Cuisines> cuisinesList = user.getCuisines();
        for (Cuisines dish: cuisinesList)
        {
            if (dish.getFoodName().equals(foodName))
            {
                if(dish.getQuantity()==1)
                {
                    cuisinesList.remove(dish);
                    break;
                }
                else{
                    dish.setQuantity(dish.getQuantity()-1);
                }
                break;
            }

        }
        user.setCuisines(cuisinesList);
        userRepo = repos.save(user);
        return userRepo;
    }

    // for display of food cards
//    @Override
//    public Set<Cuisines> getOrderedFood (String email)
//    {
//        User user = repos.findById(email).get();
//        Set<Cuisines> cartList = new HashSet<>();
//        for (Cuisines dish: user.getCuisines())
//        {
//            cartList.add(dish);
//        }
//        return cartList;
//    }
    @Override
    public List<Cuisines> getOrderedFood (String email)
    {
        User user = repos.findById(email).get();
        List<Cuisines> cartList = user.getCuisines();
        return cartList;
    }

    //for display of quantity of dishes
    @Override
    public int dishQuantity (String email, String foodName)
    {
        int number=0;
        User user = repos.findById(email).get();
        List<Cuisines> list = user.getCuisines();
        List<Cuisines> similarFood= new ArrayList<>();
        for (Cuisines dish : list)
        {
            if (dish.getFoodName().equals(foodName))
            {
                similarFood.add(dish);
                number=similarFood.size();
            }
        }
        return number;
    }

    //for '+' button that will add same dish
    @Override
    public User addCuisine(String foodName, String email)
    {
        User userRepo ;
        if (repos.findById(email).isEmpty())
        {
            return null;
        }
        User user= repos.findById(email).get();
        List<Cuisines> cuisinesList = user.getCuisines();
        for (Cuisines dish: cuisinesList)
        {
            if (dish.getFoodName().equals(foodName)) {
                dish.setQuantity(dish.getQuantity() + 1);
            }
        }
        user.setCuisines(cuisinesList);
        userRepo = repos.save(user);
        return userRepo;
    }
}
