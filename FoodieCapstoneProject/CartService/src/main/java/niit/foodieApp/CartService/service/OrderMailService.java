package niit.foodieApp.CartService.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import static niit.foodieApp.CartService.service.CartServiceImpl.userName;


@Service
public class OrderMailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @RabbitListener(queues = "order-queue")
    public void sendForgotMail(String email) {

        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("deliciousfoodieapp@gmail.com");
        message.setTo(email);
        String body="Dear "+ userName +"," +"\n"
//                +"\n"+"Total bill inclusive of tax and charges = " + totalPrice
                +"\n"
                +"We have received your order."+"\n"
                +"Your order will be successfully deliver in 30 minutes......"+"\n"
                +"\n"+"\n"
                +"Regards" +"\n"
                +"Team Delicious"  +"\n";

        message.setText(body);
        String subject="Regarding your order";
        message.setSubject(subject);
        javaMailSender.send(message);
        System.out.println("mail sent successfully");
    }
}
