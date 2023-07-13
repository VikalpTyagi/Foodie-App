package niit.foodieApp.CartService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cuisines {

    @Id
    private String foodName;
    private double foodRating;
    private String foodType;
    private String foodDescription;
    private double foodPrice;
    private int quantity=1;
    private String foodImg;
}
