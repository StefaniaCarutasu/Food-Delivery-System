package database;

import orders.Order;
import drivers.Driver;
import users.User;
import restaurant.Restaurant;

import java.util.*;

public class Database {
    static Map<String, List<Order>> Orders = new Map<String, List<Order>>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public List<Order> get(Object key) {
            return null;
        }

        @Override
        public List<Order> put(String key, List<Order> value) {
            return null;
        }

        @Override
        public List<Order> remove(Object key) {
            return null;
        }

        @Override
        public void putAll(Map<? extends String, ? extends List<Order>> m) {

        }

        @Override
        public void clear() {

        }

        @Override
        public Set<String> keySet() {
            return null;
        }

        @Override
        public Collection<List<Order>> values() {
            return null;
        }

        @Override
        public Set<Entry<String, List<Order>>> entrySet() {
            return null;
        }
    };
    static List<User> Users = new ArrayList<>();
    static List<Driver> Drivers = new ArrayList<>();
    static List<Restaurant> Restaurants = new ArrayList<>();


    public static Map<String, List<Order>> getOrders() {
        return Orders;
    }

    public static void setOrders(Map<String, List<Order>> orders) {
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
