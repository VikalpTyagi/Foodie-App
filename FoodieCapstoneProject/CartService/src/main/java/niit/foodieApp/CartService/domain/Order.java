package niit.foodieApp.CartService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;



@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Order {
    private String name;
    private String address;
    private String pinCode;
    private String phnNumber;
}
