package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
//      User user3 = new User("User3", "Lastname3", "user1@mail.ru");
//
//      Car car3 = new Car("bmw", 3);
//      user3.setCar(car3);
//      car3.setUser(user3);
//
//      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
//      Car car2 = new Car("mer", 3);
//      user2.setCar(car2);
//      car2.setUser(user2);
//
//      userService.add(user1);
//      userService.add(user3);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      User user = userService.getUserByCarModel("bmw", 3);
      System.out.println(user);
      context.close();
   }
}
