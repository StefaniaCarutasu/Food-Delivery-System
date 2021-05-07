import controllers.*;
import database.CsvManipulator;
import database.Database;
import drivers.Driver;
import orders.Order;
import restaurant.*;
import users.User;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Database database = new Database();
        FileWriter auditCsv = new FileWriter("audit.csv");

        //incarcare din csv in liste
        CsvManipulator.read("drivers");
        CsvManipulator.read("orders");
        CsvManipulator.read("restaurants");
        CsvManipulator.read("users");
        /*
        //Add user to database
        UsersController.createUser("User1", "parolauser1", "user1@email.com");
        UsersController.createUser("User2", "parolauser2", "user2@email.com");

        //Retrieve user from database
        User User1 = Database.getUserByUsername("User1");
        User User2 = Database.getUserByUsername("User2");

        //Show user
        System.out.println("Show users");
        UsersController.showUser(User1.getId());
        UsersController.showUser(User2.getId());
        System.out.println();

        //Delete user
        System.out.println("Delete user User2");
        UsersController.deleteUser(User2.getId());

        //Show user that is not in database
        System.out.println("Search for User2 in database");
        UsersController.showUser(User2.getId());
        System.out.println();


        //Update user
        System.out.println("Update User1");
        UsersController.updateUser(User1.getId(), "Age", "20");
        System.out.println("Username: " + User1.getUserName() + "\t\tAge: " + User2.getAge());
        UsersController.updateUser(User1.getId(), "Username", "User1Updated");
        UsersController.showUser(User1.getId());
        System.out.println();


        //Create driver
        System.out.println("Create drivers");
        DriversController.createDriver("Driver1", "driver1@gmailcom", "driver1pass", "car", "B54JBN");
        Driver driver1 = Database.getDriverByUsername("Driver1");
        DriversController.showDriver(driver1.getId());
        DriversController.createDriver("Driver2", "driver2@gmailcom", "driver2pass", "car", "B54JBN");
        Driver driver2 = Database.getDriverByUsername("Driver2");
        System.out.println();

        System.out.println("Delete driver and try to retrieve from database");
        DriversController.deleteDriver(driver2.getId());
        DriversController.showDriver(driver2.getId());
        System.out.println();

        //Create restaurant
        System.out.println("Create and update restautant");
        RestaurantsController.createRestaurant("A la Stefi", "Stefi");
        Restaurant restaurant1 = Database.getRestaurantByName("A la Stefi");
        restaurant1.setPhoneNumber("07restaurant1");
        restaurant1.setEmail("restaurant1@gmail.com");
        RestaurantsController.showAllRestaurants();

        System.out.println("Add to restaurant menu");
        FoodItem f1 = new FoodItem("Pizza", 20), f2 = new FoodItem("Soup", 15);
        List<MenuItem> menuFoodR1 = new ArrayList<>();
        menuFoodR1.add(f1); menuFoodR1.add(f2);
        RestaurantsController.updateRestaurantMenu(restaurant1.getId(), "add", menuFoodR1);

        DrinkItem d1 = new DrinkItem("Water", 2), d2 = new DrinkItem("Cola", 7);
        List<MenuItem> menuDrinksR1 = new ArrayList<>();
        menuDrinksR1.add(d1); menuDrinksR1.add(d2);
        RestaurantsController.updateRestaurantMenu(restaurant1.getId(), "add", menuDrinksR1);

        RestaurantsController.showAllRestaurants();

        System.out.println("Delete from restaurant menu");
        List<MenuItem> toDeleteFromMenu = new ArrayList<>();
        toDeleteFromMenu.add(f1); toDeleteFromMenu.add(d2);
        RestaurantsController.updateRestaurantMenu(restaurant1.getId(), "delete", toDeleteFromMenu);
        RestaurantsController.showAllRestaurants();
        RestaurantsController.updateRestaurantMenu(restaurant1.getId(), "add", toDeleteFromMenu);

        System.out.println("Update restaurant info");
        RestaurantsController.updateRestaurant(restaurant1.getId(), "Email", "res1@gamil.com");
        RestaurantsController.showAllRestaurants();

        //Create order
        List<String> toOrder = new ArrayList<>();
        toOrder.add(d1.getId()); toOrder.add(f1.getId());
        OrdersController.newOrder(User1.getId(), restaurant1.getId(), "Cash", toOrder);
        Order order1 = OrdersController.getOrder(Database.getOrders().get("active").get(0).getId(), "active");
        System.out.println("Show active orders");
        OrdersController.displayActiveOrder(order1.getId());
        System.out.println("Mark an order as delivered");
        DriversController.markAsDeliveredByDriver(order1.getId(), driver1.getId());
        System.out.println("Show order history for driver");
        DriversController.showOrderHistory(driver1.getId());
        */
        auditCsv.flush();
        auditCsv.close();
    }
}