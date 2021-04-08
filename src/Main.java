import controllers.*;
import database.Database;
import drivers.Driver;
import restaurant.*;
import users.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();

        //Add user to database
        UsersController.createUser("StefiC", "parolaStefi", "stefi@email.com");
        UsersController.createUser("Claudia", "parolaClaudia", "claudia@email.com");
        UsersController.createUser("Friptura", "parolaFriptura", "friptura@email.com");

        //Retrieve user from database
        User Stefi = Database.getUserByUsername("StefiC");
        User Claudia = Database.getUserByUsername("Claudia");
        User Friptura = Database.getUserByUsername("Friptura");

        //Show user
        UsersController.showUser(Stefi.getId());
        UsersController.showUser(Claudia.getId());
        UsersController.showUser(Friptura.getId());

        //Delete user
        UsersController.deleteUser(Claudia.getId());

        //Show user that is not in database
        UsersController.showUser(Claudia.getId());

        //Update user
        UsersController.updateUser(Stefi.getId(), "Age", "20");
        System.out.println("Username: " + Stefi.getUserName() + "\t\tAge: " + Stefi.getAge());
        UsersController.updateUser(Stefi.getId(), "Username", "Stefania");
        UsersController.showUser(Stefi.getId());

        //Create driver
        DriversController.createDriver("Driver1", "driver1@gmailcom", "driver1pass", "car", "B54JBN");
        Driver driver1 = Database.getDriverByUsername("Driver1");
        DriversController.showDriver(driver1.getId());
        DriversController.createDriver("Driver2", "driver2@gmailcom", "driver2pass", "car", "B54JBN");
        Driver driver2 = Database.getDriverByUsername("Driver2");
        DriversController.deleteDriver(driver2.getId());
        DriversController.showDriver(driver2.getId());

        //Create restaurant
        RestaurantsController.createRestaurant("A la Stefi", "Stefi");
        Restaurant restaurant1 = Database.getRestaurantByName("A la Stefi");
        restaurant1.setPhoneNumber("07restaurant1");
        restaurant1.setEmail("restaurant1@gmail.com");
        RestaurantsController.showAllRestaurants();
        FoodItem f1 = new FoodItem("Pizza", 20), f2 = new FoodItem("Soup", 15);
        DrinkItem d1 = new DrinkItem("Water", 2), d2 = new DrinkItem("Cola", 7);
        List<MenuItem> menuR1 = new ArrayList<>();
        menuR1.add(f1);
        menuR1.add(f2);
        RestaurantsController.updateRestaurantMenu(restaurant1.getId(), "add", menuR1);
        RestaurantsController.showAllRestaurants();

    }
}