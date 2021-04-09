package controllers;

import drivers.Driver;
import orders.Order;
import restaurant.MenuItem;
import database.Database;
import restaurant.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OrdersController {
    public static List<MenuItem> orderedProducts(String restaurantId, List<String> prodIds){
        Restaurant res = Database.getRestaurantById(restaurantId);
        List<MenuItem> orderList = new ArrayList<>();
        if(res.getMenu().getMenuList() != null){
            for(MenuItem item: res.getMenu().getMenuList().get("Food")){
                if(prodIds.contains(item.getId())){
                    orderList.add(item);
                }
            }
            for(MenuItem item: res.getMenu().getMenuList().get("Drinks")){
                if(prodIds.contains(item.getId())){
                    orderList.add(item);
                }
            }
            return orderList;
        }

        return null;
    }

    public static String findAvailableDriver(){
        for(Driver d: Database.getDrivers()){
            if(d.getAvailability()){
                d.setAvailability(false);
                return d.getId();
            }
        }
        return null;
    }

    public static void newOrder(String userId, String restaurantId, String payment, List<String> products){
        String driver = findAvailableDriver();
        Order order = new Order(userId, restaurantId,payment,driver);
        List<MenuItem> orderList = (orderedProducts(restaurantId, products));
        int price = 0;
        for(MenuItem item: orderList){
            price += item.getPrice();
        }
        order.setStatus("active");
        order.setOrderedItems(orderList);
        order.setTotalPrice(price);
        Database.addOrder(order);
    }

    //Get an order based on its id and status
    public static Order getOrder(String id, String status){
        List<Order> ordersSearchList = Database.getOrders().get(status);
        int i = 0;
        while(i < ordersSearchList.size()) {
            if (ordersSearchList.get(i).getId().equals(id)) {
                return ordersSearchList.get(i);
            }
            i++;
        }
        return null;
    }

    //Changes the order status from active to either cancelled or resolved
    public void changeOrderStatus(String id, String statusToChangeInto){
        List<Order> ordersSearchList = Database.getOrders().get("active");
        int i = 0;
        while(i < ordersSearchList.size()) {
            if (ordersSearchList.get(i).getId().equals(id)) {
                ordersSearchList.get(i).setStatus(statusToChangeInto);
                break;
            }
            i++;
        }
    }

    //Moves an order from active list to either cancelled or resolved
    private static void moveOrder(String id, String statusCategory){
        List<Order> ordersSearchList = Database.getOrders().get("active");
        int i = 0;
        while(i < ordersSearchList.size()) {
            if (ordersSearchList.get(i).getId().equals(id)) {
                Order orderToMove = ordersSearchList.get(i);        //i keep the order i want to move
                ordersSearchList.remove(i);     //i remove from the list of active orders
                //i perform the necessary changes to the list in the database
                orderToMove.setStatus(statusCategory);
                TreeMap<String, List<Order>> ordersMap = Database.getOrders();
                ordersMap.get("active").clear();
                ordersMap.get("active").addAll(ordersSearchList);
                ordersMap.get(statusCategory).add(orderToMove);     //add the order I remove to the category asked for
                Database.setOrders(ordersMap);
                break;
            }
            i ++;
        }
    }

    //Cancels order
    public static void markAsCancelled(String id){
        moveOrder(id, "cancelled");
    }

    public static void markAsDelivered(String id){
        moveOrder(id, "resolved");
    }

    //Display order
    public static void displayActiveOrder(String id){
        String user = "";
        int i = 0;
        List<Order> orders = Database.getOrders().get("active");
        while (i < Database.getOrders().get("active").size()) {
            if (Database.getOrders().get("active").get(i).getId().equals(id)){
                int j = 0;
                while (j < Database.getUsers().size()){
                    if (Database.getUsers().get(j).getId().equals(Database.getOrders().get("active").get(i).getUserId())){
                        user = Database.getUsers().get(j).getUserName();
                    }
                    j++;
                }
            }
            i++;
        }

        String order = getOrder(id, "active").toString();
        String toDisplay = "User: " + user + " has ordered " + order;
        System.out.println(toDisplay);
    }
}