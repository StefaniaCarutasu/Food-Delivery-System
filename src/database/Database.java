package database;

import orders.Order;
import drivers.Driver;
import users.User;
import restaurant.Restaurant;

import java.util.*;

public class Database {
    static TreeMap<String, List<Order>> Orders = new TreeMap<String, List<Order>>();
    static List<User> Users = new ArrayList<>();
    static List<Driver> Drivers = new ArrayList<>();
    static List<Restaurant> Restaurants = new ArrayList<>();

    public Database(){
        Orders.put("active", new ArrayList<Order>());
        Orders.put("resolved", new ArrayList<Order>());
        Orders.put("cancelled", new ArrayList<Order>());
    }

    public static TreeMap<String, List<Order>> getOrders() {
        return Orders;
    }

    public static void setOrders(TreeMap<String, List<Order>> orders) {
        Orders = orders;
    }

    public static List<User> getUsers() {
        return Users;
    }

    public static void setUsers(List<User> users) {
        Users = users;
    }

    public static List<Driver> getDrivers() {
        return Drivers;
    }

    public static void setDrivers(List<Driver> drivers) {
        Drivers = drivers;
    }

    public static List<Restaurant> getRestaurants() {
        return Restaurants;
    }

    public static void setRestaurants(List<Restaurant> restaurants) {
        Restaurants = restaurants;
    }

    public static void addUser(User usr) { Users.add(usr); }
    public static User getUserById(String id){
        for (User user : Users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
    public static User getUserByUsername(String username){
        for (User user : Users) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static void addDriver(Driver driver) { Drivers.add(driver); }
    public static Driver getDriverById(String id){
        for (Driver driver: Drivers) {
            if (driver.getId().equals(id)) {
                return driver;
            }
        }
        return null;
    }
    public static Driver getDriverByUsername(String username){
        for (Driver driver: Drivers) {
            if (driver.getUserName().equals(username)) {
                return driver;
            }
        }
        return null;
    }

    public static void addRestaurant(Restaurant res) { Restaurants.add(res); }

    public static Restaurant getRestaurantById(String id){
        for(Restaurant res: Restaurants){
            if(res.getId().equals(id)){
                return res;
            }
        }
        return null;
    }
    public static Restaurant getRestaurantByName(String name){
        for(Restaurant res: Restaurants){
            if(res.getName().equals(name)){
                return res;
            }
        }
        return null;
    }

    public static void addOrder(Order order) { Orders.get("active").add(order); }

}
