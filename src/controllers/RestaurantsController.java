package controllers;

import database.Database;
import restaurant.MenuItem;
import restaurant.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//new restaurant
//delete restaurant
//display menu
//change restaurant info
//update menu


public class RestaurantsController {

    public static void createRestaurant(String name, String owner) {
        Restaurant restaurant = new Restaurant(name, owner);
        Database.addRestaurant(restaurant);
    }

    public static void deleteRestaurant(String id) {
        int i = 0;
        while (i < Database.getRestaurants().size()) {
            if (Database.getRestaurants().get(i).getId().equals(id)) {
                Database.getRestaurants().remove(i);
                break;
            }
            i++;
        }
    }

    public static void showMenu(String id, String itemType) {
        List<MenuItem> itemsToShow = new ArrayList<>();
        //selectez tot meniul
        Map<String, List<MenuItem>> allMenu = Database.getRestaurantById(id).getMenu().getMenuList();
        switch (itemType) {
            case "Food":
                for (MenuItem item : allMenu.get("Food")) {
                    if (item.getClass().getName().contains("FoodItem")) {
                        itemsToShow.add(item);
                    }
                }

                break;
            case "Drinks":
                for (MenuItem item : allMenu.get("Drinks")) {
                    if (item.getClass().getName().contains("DrinkItem")) {
                        itemsToShow.add(item);
                    }
                }
            default:
                break;
        }
        System.out.println(itemType + " menu");
        for (MenuItem item : itemsToShow) {
            System.out.println(item.getName() + "\t\t" + item.getPrice());
        }

    }

    public static void updateRestaurant(String id, String fieldToUpdate, String updatedValue) {
        int i = 0;
        while (i < Database.getRestaurants().size()) {
            if (Database.getRestaurants().get(i).getId().equals(id)) {
                switch (fieldToUpdate) {
                    case "Name":
                        Database.getRestaurants().get(i).setName(updatedValue);
                        break;
                    case "OwnerName":
                        Database.getRestaurants().get(i).setOwnerName(updatedValue);
                        break;
                    case "PhoneNumber":
                        Database.getRestaurants().get(i).setPhoneNumber(updatedValue);
                        break;
                    case "Email":
                        Database.getRestaurants().get(i).setEmail(updatedValue);
                        break;
                    case "noOfEmployees":
                        Database.getRestaurants().get(i).setNoOfEmployees(Integer.parseInt(updatedValue));
                        break;
                    default:
                        break;
                }
                break;
            }
            i++;
        }
    }

    public static void updateRestaurantMenu(String id, String action, List<MenuItem> items) {
        switch (action) {
            case "add":
                for (MenuItem it : items) {
                    if (it.getClass().getName().contains("FoodItem")) {
                        Database.getRestaurantById(id).getMenu().getMenuList().get("Food").add(it);
                    } else {
                        Database.getRestaurantById(id).getMenu().getMenuList().get("Drinks").add(it);
                    }
                }
                break;
            case "delete":
                for (MenuItem it : items) {
                    if (it.getClass().getName().contains("FoodItem")) {
                        Database.getRestaurantById(id).getMenu().getMenuList().get("Food").remove(it);
                    } else {
                        Database.getRestaurantById(id).getMenu().getMenuList().get("Drinks").remove(it);
                    }
                }
                break;
            default:
                break;
        }
    }

    public static void showAllRestaurants() {
        for (Restaurant res : Database.getRestaurants()) {
            System.out.println("Restaurant name: " + res.getName());
            System.out.println("Contact:\n" + "Phone: " + res.getPhoneNumber() + ",\tEmail: " + res.getEmail() + '\n');
            showMenu(res.getId(), "Food");
            System.out.println();
            showMenu(res.getId(), "Drinks");
            System.out.println("\n\n");
        }
    }
}