package niit.foodieApp.CartService.controller;

import niit.foodieApp.CartService.domain.Cuisines;
import niit.foodieApp.CartService.domain.Order;
import niit.foodieApp.CartService.service.ICartService;
import org.json.simple.JSONObject;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/api/v4")
public class CartController {

    @Autowired
    ICartService service;
    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostMapping("/cart/add/{email}/{foodName}")
    ResponseEntity<?> addToCart (@RequestBody List<Cuisines> cuisines,@PathVariable String email,@PathVariable String foodName)
    {
        Cuisines dish=new Cuisines();
        for(Cuisines c : cuisines)
        {
            if (c.getFoodName().equals(foodName)){
                dish=c;
            }
        }

        return new ResponseEntity<>(service.addToCart(dish,email), HttpStatus.CREATED);
    }

    @GetMapping("/cart/total/{email}")
    ResponseEntity<?> totalBill(@PathVariable String email)
    {
        return new ResponseEntity<>(service.totalBill(email),HttpStatus.OK);
    }
    @GetMapping("/cart/bill/{email}")
    ResponseEntity<?> billWithCharges(@PathVariable String email)
    {
        return new ResponseEntity<>(service.BillWithCharges(email),HttpStatus.OK);
    }

    @PostMapping("/cart/order/{email}")
    ResponseEntity<?> saveOrder(@PathVariable String email,@RequestBody Order order)
    {
        System.out.println(email+order);

        rabbitTemplate.convertAndSend("order-exchange", "order-routing",email);
        return new ResponseEntity<>(service.orderDetails(email,order),HttpStatus.OK);
    }

    // for display of cards
    @GetMapping("/cart/get/{email}")
    ResponseEntity<?> getOrderedFood(@PathVariable String email)
    {
        return new ResponseEntity<>(service.getOrderedFood(email),HttpStatus.OK);
    }

    // for number of items display
    @GetMapping("/cart/number/{email}/{foodName}")
    ResponseEntity<?> displayQnty(@PathVariable String email,@PathVariable String foodName)
    {
        return new ResponseEntity<>(service.dishQuantity(email,foodName),HttpStatus.OK);
    }

    // for '-' / delete button
    @DeleteMapping("/cart/delete/{email}/{foodName}")
    ResponseEntity<?> deleteDish(@PathVariable String email,@PathVariable String foodName)
    {
        return new ResponseEntity<>(service.deleteCuisine(foodName,email),HttpStatus.OK);
    }

    // for '+'  button
    @PostMapping("/cart/plus/{email}/{foodName}")
    ResponseEntity<?> plusDish(@PathVariable String email,@PathVariable String foodName)
    {
        return new ResponseEntity<>(service.addCuisine(foodName,email),HttpStatus.OK);
    }

}
